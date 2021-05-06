-- Exercise 1: Tiếp tục với Database Testing System
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS proc_infodepartment;
DELIMITER $$
CREATE PROCEDURE proc_infodepartment(in p_input_deptname nvarchar(50))
BEGIN
 SELECT		a.*	 
 FROM		`account` a
 INNER JOIN department d ON d.DepartmentID = a.DepartmentID
 WHERE		d.DepartmentName = p_input_deptname;
END$$
DELIMITER ;

CALL proc_infodepartment ('Sale');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS proc_countacc;
DELIMITER $$
CREATE PROCEDURE proc_countacc()
BEGIN
 SELECT 	ga.GroupID, g.GroupName, COUNT(AccountID) as So_Luong
 FROM 		groupaccount ga
 INNER JOIN `group`	g 	ON ga.GroupID = g.GroupID
 GROUP BY	ga.GroupID
 ORDER BY   So_luong;
END$$
DELIMITER ;

CALL proc_countacc ();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS proc_ques_in_months;
DELIMITER $$
CREATE PROCEDURE proc_ques_in_months()
BEGIN
 SELECT		q.TypeID,t.TypeName,COUNT(q.TypeID) AS So_luong
 FROM		question q
 INNER JOIN typequestion t ON q.TypeID = t.TypeID
 WHERE		MONTH(q.CreateDate) = MONTH(NOW()) AND YEAR(q.CreateDate) = YEAR(NOW())
 GROUP BY 	q.TypeID;
END$$
DELIMITER ;

CALL proc_ques_in_months ();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS proc_maxtype_id;
DELIMITER $$
CREATE PROCEDURE proc_maxtype_id(OUT v_ID TINYINT)
BEGIN
		SELECT 		TypeID INTO v_ID
		FROM		`question`
        GROUP BY 	TypeID
        ORDER BY	COUNT(1) DESC
        LIMIT		1;
END$$
DELIMITER ;

SET @ID = 0;
CALL proc_maxtype_id(@ID);
SELECT @ID;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS proc_maxtype_name;
DELIMITER $$
CREATE PROCEDURE proc_maxtype_name(OUT v_name NVARCHAR(50))
BEGIN
		SELECT 		t.TypeName INTO v_name
		FROM		`question` q
        INNER JOIN  typequestion t ON q.TypeID = t.TypeID
        GROUP BY 	q.TypeID
        ORDER BY	COUNT(QuestionID) DESC
        LIMIT		1;
END$$
DELIMITER ;

SET @type_name = '';
CALL proc_maxtype_name(@type_name);
SELECT @type_name;

/* Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi 
của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào */
-- Nhập:1 -- Trả về Group có tên chứa chuỗi
-- Nhập:2 -- Trả về User có username chứa chuỗi 
DROP PROCEDURE IF EXISTS proc_maxtype_name;
DELIMITER $$
CREATE PROCEDURE proc_maxtype_name  (IN	in_string VARCHAR(50), IN in_select TINYINT)
BEGIN
	IF in_select = 1 THEN
		SELECT 	*
        FROM	`Group`
        WHERE	GroupName LIKE in_string;
	ELSE
		SELECT 	Email, Username, FullName
        FROM	`Account`
        WHERE	Username LIKE in_string;
	END IF;
END$$
DELIMITER ;

CALL proc_maxtype_name('a',1);
CALL proc_maxtype_name('lgoodge0',2);

/* Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
	username sẽ giống email nhưng bỏ phần @..mail đi 
	positionID: sẽ có default là developer
	departmentID: sẽ được cho vào 1 phòng chờ
	Sau đó in ra kết quả tạo thành công */
DROP PROCEDURE IF EXISTS proc_info_input;
DELIMITER $$
CREATE PROCEDURE proc_info_input  (IN	in_fullname NVARCHAR(50), IN in_email VARCHAR(50))
BEGIN
		DECLARE Username VARCHAR(50) DEFAULT SUBSTRING_INDEX(in_email,'@',1);
        DECLARE PositionID TINYINT UNSIGNED DEFAULT 1;
        DECLARE DepartmentID TINYINT UNSIGNED DEFAULT NULL;
        DECLARE CreateDate DATETIME DEFAULT NOW();
        INSERT INTO `account`   (Email,		Username, FullName, 	DepartmentID, PositionID , CreateDate)
        VALUES 					(in_email,	Username, in_fullname,	DepartmentID, PositionID,  CreateDate);
        
        SELECT 	 * 
        FROM	 `account` a
        WHERE	 a.Username = Username;	
END$$
DELIMITER ;
    
CALL proc_info_input(N'Nguyễn Văn A','email2@gmail.com');

/* Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
 để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất */
DROP PROCEDURE IF EXISTS proc_input_maxtype;
DELIMITER $$
CREATE PROCEDURE proc_input_maxtype  (IN in_select ENUM('Essay','Multiple-Choice'))
BEGIN
	IF in_select = 'Essay' THEN
		SELECT 		*
        FROM		question 
        WHERE		TypeID = 1
        ORDER BY	LENGTH(Content) DESC
        LIMIT 		1;
	ELSEIF (in_select = 'Multiple-Choice') THEN
		SELECT 		*
        FROM		question 
        WHERE		TypeID = 2
        ORDER BY	LENGTH(Content) DESC
        LIMIT 		1;
	END IF;
END$$
DELIMITER ;

CALL proc_input_maxtype('Essay');
CALL proc_input_maxtype('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS proc_delete_exam;
DELIMITER $$
CREATE PROCEDURE proc_delete_exam  (IN in_id TINYINT UNSIGNED)
BEGIN
	DELETE FROM exam
    WHERE 		ExamID = in_id;
END$$
DELIMITER ;

CALL proc_delete_exam(9);

/* Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
 Sau đó in số lượng record đã remove từ các table liên quan trong khi removing */
DROP PROCEDURE IF EXISTS proc_delete_exam2;
DELIMITER $$
CREATE PROCEDURE proc_delete_exam2()
BEGIN
	DELETE FROM exam
    WHERE 		(YEAR(NOW()) - YEAR(CreateDate)) > 3;
END$$
DELIMITER ;

CALL proc_delete_exam2();
 
/*Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban 
và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc*/
DROP PROCEDURE IF EXISTS proc_delete_department;
DELIMITER $$
CREATE PROCEDURE proc_delete_department(IN in_deptname NVARCHAR(50))
BEGIN
	UPDATE 	`Account`
    SET		DepartmentID = 10
    WHERE	DepartmentID = (SELECT 	DepartmentID	
							FROM	Department
							WHERE 	DepartmentName = in_deptname);
	DELETE FROM department
    WHERE 		DepartmentName = in_deptname;
    
END$$
DELIMITER ;

CALL proc_delete_department('Legal');

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS proc_ques_per_months;
DELIMITER $$
CREATE PROCEDURE proc_ques_per_months()
BEGIN
		SELECT EachMonthInYear.MONTH, COUNT(QuestionID) AS COUNT
		FROM
		(
             SELECT 1 AS MONTH, 2021 AS YEAR
             UNION SELECT 2 AS MONTH, 2021 AS YEAR
             UNION SELECT 3 AS MONTH, 2021 AS YEAR
             UNION SELECT 4 AS MONTH, 2021 AS YEAR
             UNION SELECT 5 AS MONTH, 2021 AS YEAR
             UNION SELECT 6 AS MONTH, 2021 AS YEAR
             UNION SELECT 7 AS MONTH, 2021 AS YEAR
             UNION SELECT 8 AS MONTH, 2021 AS YEAR
             UNION SELECT 9 AS MONTH, 2021 AS YEAR
             UNION SELECT 10 AS MONTH, 2021 AS YEAR
             UNION SELECT 11 AS MONTH, 2021 AS YEAR
             UNION SELECT 12 AS MONTH, 2021 AS YEAR
        ) AS EachMonthInYear
		LEFT JOIN 	question q ON EachMonthInYear.MONTH = MONTH(q.CreateDate) AND YEAR(q.CreateDate) = YEAR(NOW())
		GROUP BY 	EachMonthInYear.MONTH
		ORDER BY 	EachMonthInYear.MONTH ASC;
END$$
DELIMITER ;

CALL proc_ques_per_months();

/* Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
 (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng") */
DROP PROCEDURE IF EXISTS proc_ques_per_6months;
DELIMITER $$
CREATE PROCEDURE proc_ques_per_6months()
BEGIN
		SELECT Previous6Month.MONTH, COUNT(QuestionID) AS So_Luong
		FROM
		(
			SELECT MONTH(NOW() - INTERVAL 5 MONTH) AS MONTH
			UNION
			SELECT MONTH(NOW() - INTERVAL 4 MONTH) AS MONTH
			UNION
			SELECT MONTH(NOW() - INTERVAL 3 MONTH) AS MONTH
			UNION
			SELECT MONTH(NOW() - INTERVAL 2 MONTH) AS MONTH
			UNION
			SELECT MONTH(NOW() - INTERVAL 1 MONTH) AS MONTH
			UNION
			SELECT MONTH(NOW() - INTERVAL 0 MONTH) AS MONTH
        ) AS Previous6Month
		LEFT JOIN Question ON Previous6Month.MONTH = MONTH(CreateDate)
		GROUP BY Previous6Month.MONTH
		ORDER BY Previous6Month.MONTH ;
END$$
DELIMITER ;

CALL proc_ques_per_6months();
 
