/* Ques14: Bạn hãy viết 1 Procedure để lấy ra tên trụ sở mà có số lượng nhân viên đang làm 
việc nhiều nhất. */
DROP PROCEDURE IF EXISTS proc_get_name_office;
DELIMITER $$
CREATE PROCEDURE proc_get_name_office(OUT out_name_office NVARCHAR(50))
BEGIN
	DECLARE    v_office_id TINYINT UNSIGNED;
	SELECT		o.Office_id INTO v_office_id
    FROM		office o 
    INNER JOIN  staff s ON o.Office_id = s.Office_id
    GROUP BY 	o.Office_id
    ORDER BY    COUNT(s.Staff_id)
    LIMIT 		1;
    
    SELECT  Office_ID INTO out_name_office
    FROM    office
    WHERE	Office_id = v_office_id;
END $$
DELIMITER ;

SET @v_office_name = '';
CALL proc_get_name_office(@v_office_name);
SELECT @v_office_name;

/* Ques15: Bạn hãy viết 1 Function để khi nhập vào thông tin Email của nhân viên thì sẽ trả ra 
thông tin đầy đủ của nhân viên đó. */
DROP FUNCTION IF EXISTS f_get_info_staff;
DELIMITER $$
CREATE FUNCTION f_get_info_staff(p_email_staff VARCHAR(20)) RETURNS NVARCHAR(50)
READS SQL DATA
DETERMINISTIC
BEGIN
	DECLARE v_fullname NVARCHAR(50);
    SELECT  CONCAT(First_Name,' ',Last_Name) INTO v_fullname
    FROM    staff
    WHERE	Email = p_email_staff;
    RETURN  v_fullname;
END $$
DELIMITER ;

SELECT f_get_info_staff('Email 1');

/* Ques16: Bạn hãy viết 1 Trigger để khi thực hiện cập nhật thông tin về trụ sở làm việc của 
nhân viên đó thì hệ thống sẽ tự động lưu lại trụ sở cũ của nhân viên vào 1 bảng khác có tên 
Log_Office để Mark có thể xem lại khi cần thiết. */
DROP TABLE IF EXISTS Log_Office;
CREATE TABLE Log_Office (
	Staff_id TINYINT UNSIGNED,
    First_Name NVARCHAR(50),
    Last_Name NVARCHAR(50),
    Old_Office_id TINYINT UNSIGNED);

DROP TRIGGER IF EXISTS trg_log_old_office;
DELIMITER $$
CREATE TRIGGER trg_log_old_office
BEFORE UPDATE ON staff
FOR EACH ROW
BEGIN
		INSERT INTO Log_Office ( Staff_id, First_Name, Last_Name, Old_Office_id)
        VALUE				   ( OLD.Staff_id, OLD.First_Name,OLD.Last_Name, OLD.Office_id);
END $$
DELIMITER ;

/* Ques17: FB đang vướng vào 1 đạo luật hạn chế hoạt động, FB chỉ có thể hoạt động tối đa 
trên 100 quốc gia trên thế giới, hãy tạo Trigger để ngăn người nhập liệu nhập vào quốc gia 
thứ 101 (bạn có thể sử dụng số nước nhỏ hơn để Test VD 11 nước). */
DROP TRIGGER IF EXISTS trg_limit_national;
DELIMITER $$
CREATE TRIGGER trg_limit_national
BEFORE INSERT ON `national`
FOR EACH ROW
BEGIN
	DECLARE v_count_national TINYINT UNSIGNED;
    SELECT 		COUNT(National_id) INTO v_count_national
    FROM 		`national`;
	IF (v_count_national >= 10) THEN
	SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT = 'No more than 100 nationals ';
 END IF;
END $$
DELIMITER ;

INSERT INTO `facebook_db`.`national` (`National_Name`, `Language_Main`)
							  VALUES ('National 11',    'Language 11');
                              
-- Ques18: Thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân viên đang làm việc.
	SELECT	 	n.National_Name,COUNT(s.Staff_id) 
	FROM 		`national` n
	LEFT JOIN  office o ON o.National_id = n.National_id
	LEFT JOIN  staff s ON s.Office_id = o.Office_id
    GROUP BY	n.National_Name;
    
/* Ques19: Viết Procedure để thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân 
viên đang làm việc, với đầu vào là tên nước. */
DROP PROCEDURE IF EXISTS proc_get_count_staff;
DELIMITER $$
CREATE PROCEDURE proc_get_count_staff(IN in_national_name NVARCHAR(50))
BEGIN
	SELECT	 	 n.National_Name,COUNT(s.Staff_id) AS So_luong_nv
	FROM 		 `national` n
	INNER JOIN   office o ON o.National_id = n.National_id
	INNER JOIN   staff s ON s.Office_id = o.Office_id
    WHERE	     n.National_Name = in_national_name;
END $$
DELIMITER ;
CALL proc_get_count_staff('Viet Nam');

/* Ques20: Thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu employee đang
làm việc. */
	SELECT	 	o.Office_id,COUNT(s.Staff_id) 
	FROM		office o 
	LEFT JOIN   staff s ON s.Office_id = o.Office_id
    GROUP BY	o.Office_id;

/* Ques21: Viết Procedure để thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu 
employee đang làm việc đầu vào là ID của trụ sở. */
DROP PROCEDURE IF EXISTS proc_get_count_staff_in_office;
DELIMITER $$
CREATE PROCEDURE proc_get_count_staff_in_office(IN in_office_id TINYINT)
BEGIN
	SELECT	 	o.Office_id,COUNT(s.Staff_id) AS So_luong_nv
	FROM		office o 
	LEFT JOIN   staff s ON s.Office_id = o.Office_id
    WHERE		o.Office_id = in_office_id;
END $$
DELIMITER ;
CALL proc_get_count_staff_in_office(1);

-- Ques22: Viết Procedure để lấy ra tên quốc gia đang có nhiều nhân viên nhất.
DROP PROCEDURE IF EXISTS proc_get_max_staff;
DELIMITER $$
CREATE PROCEDURE proc_get_max_staff()
BEGIN
WITH CTE_get_max_count_staff AS (
		SELECT MAX(Count_nv) FROM
				( SELECT 	 o.Office_id,COUNT(s.Staff_id) as Count_nv
				FROM	 	 staff s
                INNER JOIN   office o ON s.Office_id = o.Office_id
                GROUP BY     o.Office_id
				) AS COUNT
)
	SELECT 		 n.National_Name 
	FROM 		 `national` n 
	INNER JOIN   office o ON o.National_id = n.National_id
	INNER JOIN   staff s ON s.Office_id = o.Office_id
    GROUP BY	 n.National_id
    HAVING		 COUNT(s.Staff_id) = (SELECT * FROM CTE_get_max_count_staff);
END $$
DELIMITER ;

CALL proc_get_max_staff();

-- Ques23: Thống kê mỗi country có bao nhiêu employee đang làm việc.
	SELECT	 	n.National_Name,COUNT(s.Staff_id) AS So_luong_nv
	FROM 		`national` n
	LEFT JOIN  office o ON o.National_id = n.National_id
	LEFT JOIN  staff s ON s.Office_id = o.Office_id
    GROUP BY	n.National_Name;

/* Ques24: Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm 
việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ chuyển về Null. */
DROP TRIGGER IF EXISTS trg_set_null;
DELIMITER $$
CREATE TRIGGER trg_set_null
BEFORE DELETE ON office
FOR EACH ROW
BEGIN
	ALTER TABLE `staff` 
    DROP CONSTRAINT staff_ibfk_1 ;
	ALTER TABLE `staff` 
    ADD CONSTRAINT staff_ibfk_1
    FOREIGN KEY (Office_id) REFERENCES `Office`(Office_id) ON DELETE SET NULL ;
END $$
DELIMITER ;    

/* Ques25: Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm 
việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ bị xóa hết. */
DROP TRIGGER IF EXISTS trg_set_null;
DELIMITER $$
CREATE TRIGGER trg_set_null
BEFORE DELETE ON office
FOR EACH ROW
BEGIN
	ALTER TABLE `staff` 
    DROP CONSTRAINT staff_ibfk_1 ;
	ALTER TABLE `staff` 
    ADD CONSTRAINT staff_ibfk_1
    FOREIGN KEY (Office_id) REFERENCES `Office`(Office_id) ON DELETE CASCADE;
END $$
DELIMITER ;    



                              










