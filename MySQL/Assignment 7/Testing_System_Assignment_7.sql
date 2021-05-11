-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước 
DROP TRIGGER IF EXISTS trg_acc_over_1_years;
DELIMITER $$
	CREATE TRIGGER trg_acc_over_1_years
	BEFORE INSERT ON `group`
    FOR EACH ROW
    BEGIN		      
		IF (NEW.CreateDate < DATE_SUB(CURRENT_DATE, INTERVAL 1 YEAR)) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Group có ngày tạo trước 1 năm trước';
		END IF;
    END$$    
DELIMITER ;

INSERT INTO `group` (  GroupName, CreatorID	, CreateDate)
VALUES 				(N'GroupName 1',2,'2019-01-01 00:00:00');

/* Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, 
khi thêm thì hiện ra thông báo "Department"Sale" cannot add more user */
DROP TRIGGER IF EXISTS trg_no_more_gr_sale;
DELIMITER $$
	CREATE TRIGGER trg_no_more_gr_sale
	BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN		
		DECLARE sale_id VARCHAR(50);         
        SELECT DepartmentID INTO sale_id FROM department WHERE DepartmentName = 'Sale';
		IF (NEW.DepartmentID = sale_id ) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'No more user in Department Sale';
		END IF;
    END$$    
DELIMITER ;

INSERT INTO `account`	(  Email	, Username	 , FullName,      DepartmentID, positionID, CreateDate		   )
VALUE 				    (N'emailxx' ,'username 1', 'Full Name 1', 8,            3,        '2019-03-05 00:00:00');
 
 -- Question 3: Cấu hình 1 group có nhiều nhất là 5 user 
DROP TRIGGER IF EXISTS trg_one_gr_five_user;
DELIMITER $$
	CREATE TRIGGER trg_one_gr_five_user
	BEFORE INSERT ON `groupaccount`
    FOR EACH ROW
    BEGIN
		DECLARE v_count_acc INT;
        SELECT COUNT(AccountID) INTO v_count_acc FROM groupaccount 
        WHERE	GroupID = NEW.GroupID;
		IF (v_count_acc > 5 ) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'No more than 5 user in 1 group';
		END IF;
    END$$    
DELIMITER ;


-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS trg_one_exam_ten_ques;
DELIMITER $$
	CREATE TRIGGER trg_one_exam_ten_ques
	BEFORE INSERT ON `examquestion`
    FOR EACH ROW
    BEGIN
		DECLARE v_count_ques INT;
        SELECT  COUNT(QuestionID) FROM examquestion
        WHERE   ExamID = NEW.ExamID;
		IF ( v_count_ques > 10 ) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'No more than 10 question in 1 exam';
		END IF;
    END$$    
DELIMITER ;


/* Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là 
 admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), 
 còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó */
DROP TRIGGER IF EXISTS trg_bf_del_acc;
DELIMITER $$
	CREATE TRIGGER trg_bf_del_acc
	BEFORE DELETE ON `account`
    FOR EACH ROW
    BEGIN		
		DECLARE email VARCHAR(50);         
        SELECT a.Email INTO email FROM `account` a WHERE a.AccountID = OLD.AccountID;        
         IF email = 'admin@viettel.com.vn' THEN 
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Cant Delete This Acc';
		END IF; 
    END$$    
DELIMITER ;

DELETE FROM account WHERE (AccountID = '261');

/* Question 6: Không sử dụng cấu hình default cho field DepartmentID của table 
 Account, hãy tạo trigger cho phép người dùng khi tạo account không điền 
 vào departmentID thì sẽ được phân vào phòng ban "waiting Department" */
DROP TRIGGER IF EXISTS trg_bf_del_acc;
DELIMITER $$
	CREATE TRIGGER trg_bf_del_acc
	BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN		  
    DECLARE	v_wait_room INT;
	SELECT DepartmentID INTO v_wait_room FROM department WHERE DepartmentName = 'Waiting Room';
	IF NEW.DepartmentID IS NULL THEN 
			UPDATE 	 `account`
            SET		 NEW.DepartmentID = v_wait_room
            WHERE	 AccountID = NEW.AccountID;
	END IF; 
    END$$    
DELIMITER ;

INSERT INTO `account`	(  Email	, Username	 , FullName,      DepartmentID, positionID, CreateDate		   )
VALUE 				    (N'emailxx' ,'username 1', 'Full Name 1', DEFAULT	  ,  3 		  ,'2019-03-05 00:00:00');

/* Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi 
 question, trong đó có tối đa 2 đáp án đúng */
DROP TRIGGER IF EXISTS trg_limit_in_one_exam;
DELIMITER $$
	CREATE TRIGGER trg_limit_in_one_exam
	BEFORE INSERT ON `answer`
    FOR EACH ROW
    BEGIN		
    DECLARE v_count_question TINYINT UNSIGNED;
    DECLARE v_count_correct_answer TINYINT UNSIGNED;
    
    SELECT 		COUNT(AnswerID) INTO v_count_question
    FROM 		answer 
    WHERE		QuestionID = NEW.QuestionID ;
    
	SELECT 		COUNT(AnswerID) INTO v_count_correct_answer
    FROM 		answer 
	WHERE		QuestionID = NEW.QuestionID AND isCorrect = 1;
	IF (v_count_question > 4) OR (v_count_correct_answer >2 ) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'No more than 4 answers and 2 correct answers in 1 question ';
	END IF;
    END$$    
DELIMITER ;

/* Question 8: Viết trigger sửa lại dữ liệu cho đúng: 
 Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định 
 Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database */
DROP TRIGGER IF EXISTS trg_format_gender;
DELIMITER $$
CREATE TRIGGER trg_format_gender
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN		
	IF NEW.gerder = 'nam' THEN 
    SET NEW.gerder = 'M';
	ELSEIF NEW.gerder = N'nữ' THEN 
    SET NEW.gerder = 'F';
    ELSEIF NEW.gerder = N'không xác định' THEN 
    SET NEW.gerder = 'U';
	END IF;
END $$    
DELIMITER ;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS trg_exam_till_2days;
DELIMITER $$
CREATE TRIGGER trg_exam_till_2days
BEFORE DELETE ON `exam`
FOR EACH ROW
BEGIN		
	DECLARE v_count_days DATE;
	SELECT DATE_ADD(OLD.CreateDate, INTERVAL 2 DAY ) INTO v_count_days FROM exam WHERE CreateDate = OLD.CreateDate;
	IF  v_count_days > CURRENT_DATE()   THEN 
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Cann\'t delete exam has not been 2 days';
	END IF;
END $$    
DELIMITER ;

DELETE FROM exam
WHERE		ExamID = 9;

/* Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các 
 question khi question đó chưa nằm trong exam nào */
DROP TRIGGER IF EXISTS trg_exam_till_2days;
DELIMITER $$
CREATE TRIGGER trg_exam_till_2days
BEFORE DELETE ON `question`
FOR EACH ROW
BEGIN		
	DECLARE 	v_ques_not_in_exam INT;
    SET 	    v_ques_not_in_exam = -1;
	SELECT 		COUNT(1) INTO v_ques_not_in_exam 
    FROM 		examquestion e
    WHERE		e.QuestionID = OLD.QuestionID ;
	IF  -1 != v_ques_not_in_exam THEN 
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Cann\'t delete this question';
	END IF;
END $$   
DELIMITER ;
    
DELETE FROM question
WHERE 		questionID = 1;

/* Question 12: Lấy ra thông tin exam trong đó: 
Duration <= 30 thì sẽ đổi thành giá trị "Short time"
30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
Duration > 60 thì sẽ đổi thành giá trị "Long time" */
SELECT 		ExamID, 
			CASE 
			WHEN Duration <= 30 THEN 'Short time'
            WHEN 30 < Duration AND Duration <= 60 THEN 'Medium time'
            ELSE 'Long time'
			END AS ExamDuration
FROM		exam;

/* Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên 
 là the_number_user_amount và mang giá trị được quy định như sau:2
Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher */
SELECT 		GroupID,COUNT(AccountID) AS So_luong,  
			CASE 
			WHEN COUNT(AccountID) <= 5 THEN 'few'
            WHEN 5 < COUNT(AccountID) AND COUNT(AccountID) <= 20 THEN 'normal'
            ELSE 'higher'
			END AS the_number_user_amount
FROM		groupaccount
GROUP BY	GroupID;

/* Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào 
 không có user thì sẽ thay đổi giá trị 0 thành "Không có User" */
SELECT 		d.DepartmentID, 
			CASE	
            WHEN COUNT(a.AccountID) = 0 THEN "Không có User"
            ELSE	COUNT(a.AccountID)
            END	AS So_luong
FROM		`account` a
RIGHT JOIN	department d ON a.DepartmentID= d.DepartmentID
GROUP BY	d.DepartmentID;
