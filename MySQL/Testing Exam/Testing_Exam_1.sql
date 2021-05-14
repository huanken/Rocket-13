/* 1. Tạo table với các ràng buộc và kiểu dữ liệu
Thêm ít nhất 5 bản ghi vào table. */
DROP DATABASE IF EXISTS TestingExam1;
CREATE DATABASE TestingExam1;
USE TestingExam1;

DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER(
	CustomerID   SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`	     NVARCHAR(50),
    Phone 	     CHAR(11) UNIQUE KEY,
    Email		 VARCHAR(20) UNIQUE KEY,
    Address		 NVARCHAR(50),
    Note		 NVARCHAR(50)
);

DROP TABLE IF EXISTS CAR;
CREATE TABLE CAR(
	CarID	     SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Maker	     ENUM('HONDA','TOYOTA','NISSAN'),
    Model 	     VARCHAR(20),
    `Year`		 CHAR(4),
    Color		 ENUM('black','white','yellow'),
    Note		 NVARCHAR(50)
);

DROP TABLE IF EXISTS CAR_ORDER;
CREATE TABLE CAR_ORDER(
	OrderID	     	 SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CustomerID 		 SMALLINT UNSIGNED,
    CarID	   		 SMALLINT UNSIGNED,
	Amount 			 TINYINT UNSIGNED DEFAULT 1,
    SalePrice		 MEDIUMINT,
    OrderDate		 DATE,
    DeliveryDate 	 DATE,
    DeliveryAddress  NVARCHAR(50),
    `Status`		 ENUM('0','1','2') DEFAULT '0' ,-- 0: đã đặt hàng, 1: đã giao, 2: đã hủy
    Note			 NVARCHAR(50)
);

INSERT INTO CUSTOMER (`Name`, 		  Phone, 		Email, 				Address,  Note	  )
VALUES				 ('Nguyen Van A', '0123456789', 'email1@gmail.com', 'Ha Noi', 'Note 1'),
					 ('Nguyen Van B', '0223456789', 'email2@gmail.com', 'Ha Noi', 'Note 2'),
                     ('Nguyen Van C', '0323456789', 'email3@gmail.com', 'Ha Noi', 'Note 3'),
                     ('Nguyen Van D', '0423456789', 'email4@gmail.com', 'Ha Noi', 'Note 4'),
                     ('Nguyen Van E', '0523456789', 'email5@gmail.com', 'Ha Noi', 'Note 2'),
                     ('Nguyen Van F', '0623456789', 'email6@gmail.com', 'Ha Noi', 'Note 1');

INSERT INTO CAR (Maker,    Model, 	`Year`,	 Color,   Note	  )
VALUES			('NISSAN', 'Model 1', '2011', 'black', 'Note 1'),
				('HONDA',  'Model 2', '2013', 'white', 'Note 2'),
                ('TOYOTA', 'Model 3', '2014', 'black', 'Note 3'),
                ('HONDA',  'Model 4', '2016', 'white', 'Note 4'),
                ('TOYOTA', 'Model 5', '2019', 'black', 'Note 5'),
                ('HONDA',  'Model 6', '2021', 'yellow', 'Note 6');

INSERT INTO CAR_ORDER (CustomerID, CarID, Amount, SalePrice, OrderDate,   DeliveryDate, DeliveryAddress,`Status`  , Note	)
VALUES				  (    1	 ,   2  ,   1   ,  10000   , '2020-01-01','2020-01-20', 'Ha Noi' 	   ,   '1'    , 'Note 1'),
					  (    2	 ,   4  ,   1   ,  30000   , '2021-02-01','2021-03-17', 'Ha Noi' 	   ,   '1'    , 'Note 1'),
                      (    3	 ,   2  ,   3   ,  50000   , '2021-02-01','2021-02-15', 'Ha Noi' 	   ,   '1'    , 'Note 3'),
                      (    1	 ,   1  ,   1   ,  50000   , '2021-04-01','2021-04-24', 'Ha Noi' 	   ,   '2'    , 'Note 1'),
                      (    2	 ,   3  ,   2   ,  20000   , '2021-01-01','2021-01-15', 'Ha Noi' 	   ,   '1'    , 'Note 3'),
                      (    1	 ,   4  ,   1   ,  60000   , '2021-05-01','2021-05-14', 'Ha Noi' 	   ,   '0'    , 'Note 2');

/* 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã 
mua và sắp sếp tăng dần theo số lượng oto đã mua. */
SELECT		c.`Name`, o.Amount
FROM 		customer c
INNER JOIN  CAR_ORDER o ON c.CustomerID = o.CustomerID
ORDER BY	o.Amount;

/* 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều 
oto nhất trong năm nay. */
DROP FUNCTION IF EXISTS f_get_maker;
DELIMITER $$
CREATE FUNCTION f_get_maker() RETURNS VARCHAR(20)
READS SQL DATA
DETERMINISTIC
BEGIN
	DECLARE    v_maker_name VARCHAR(20);
	SELECT     c.Maker INTO v_maker_name
	FROM	   CAR_ORDER o
	INNER JOIN CAR c ON c.CarID = o.CarID
	WHERE	   YEAR(o.OrderDate) = YEAR(NOW()) AND o.`Status` = '1'
	GROUP BY   c.Maker
	ORDER BY   SUM(o.Amount) DESC
	LIMIT 	   1;
    RETURN     v_maker_name;
END $$
DELIMITER ;

SELECT  f_get_maker();

/* 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của 
những năm trước. In ra số lượng bản ghi đã bị xóa. */
DROP PROCEDURE IF EXISTS proc_get_cancel_order;
DELIMITER $$
CREATE PROCEDURE proc_get_cancel_order()
BEGIN
	DECLARE    v_count_cancel_order TINYINT UNSIGNED;
    DECLARE    v_print_message VARCHAR(50);
    
	SELECT     COUNT(OrderID) INTO v_count_cancel_order
	FROM	   CAR_ORDER 
	WHERE	   YEAR(OrderDate) != YEAR(NOW()) AND `Status` = '0';
    
	DELETE FROM CAR_ORDER WHERE  YEAR(OrderDate) != YEAR(NOW()) AND `Status` = '0';
    
	SELECT CONCAT("DELETE ",v_count_cancel_order," ROW(S) IN CAR_ORDER") INTO v_print_message; 
	SIGNAL SQLSTATE '45000' 
	SET MESSAGE_TEXT = v_print_message ; 
END $$
DELIMITER ;

CALL proc_get_cancel_order();

/* 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn 
hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto 
và tên hãng sản xuất. */
DROP PROCEDURE IF EXISTS proc_get_info_order;
DELIMITER $$
CREATE PROCEDURE proc_get_info_order(IN in_customer_id SMALLINT UNSIGNED)
BEGIN
	SELECT     c.`Name`,o.OrderID,o.Amount,ca.Maker
	FROM	   CAR_ORDER o
    INNER JOIN CUSTOMER c ON c.CustomerID = o.CustomerID
    INNER JOIN CAR ca ON ca.CarID = o.CarID
	WHERE	   o.CustomerID = in_customer_id AND o.`Status`= '0';
END $$
DELIMITER ;

CALL proc_get_info_order(1);

/* 6. Viết trigger để tránh trường hợp người dùng nhập thông tin không hợp lệ 
vào database (DeliveryDate < OrderDate + 15). */
DROP TRIGGER IF EXISTS trg_format_date;
DELIMITER $$
CREATE TRIGGER trg_format_date
BEFORE INSERT ON CAR_ORDER
FOR EACH ROW
BEGIN
	DECLARE v_DeliveryDate DATE;
    DECLARE v_OrderDate DATE;
    DECLARE v_count_date DATE;
    SET v_DeliveryDate = NEW.DeliveryDate;
    SET v_OrderDate = NEW.OrderDate;
    SET v_count_date = DATE_SUB(v_DeliveryDate, INTERVAL 15 DAY);
	IF v_count_date < v_OrderDate THEN
	SIGNAL SQLSTATE '12345' 
	SET MESSAGE_TEXT = 'DeliveryDate > OrderDate + 15' ; 
    END IF;
END $$
DELIMITER ;

INSERT INTO `car_order` (`CustomerID`, `CarID`, `Amount`, `SalePrice`, `OrderDate`, `DeliveryDate`, `DeliveryAddress`, `Status`, `Note`)
VALUES				    ('1', '2', '3', '20000', '2021-05-14', '2021-05-18', 'Ha noi', '1', 'note 2');
