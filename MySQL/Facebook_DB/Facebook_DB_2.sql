-- Ques3: Bạn hãy lấy dữ liệu của tất cả nhân viên đang làm việc tại Vietnam.
SELECT 		s.*
FROM 		office o
INNER JOIN  `national` n ON o.National_id = n.National_id
INNER JOIN  staff s ON s.Office_id = o.Office_id
WHERE		n.National_Name = 'Viet Nam';

-- Ques4: Lấy ra ID, FullName, Email, National của mỗi nhân viên.
SELECT 		s.Staff_id, CONCAT(s.First_Name,' ',s.Last_Name) AS Full_Name, s.Email, n.National_Name
FROM 		office o
INNER JOIN  `national` n ON o.National_id = n.National_id
INNER JOIN  staff s ON s.Office_id = o.Office_id
ORDER BY	s.Staff_id;

-- Ques5: Lấy ra tên nước mà nhân viên có Email: "daonq@viettel.com.vn" đang làm việc.
SELECT 		n.National_Name
FROM 		office o
INNER JOIN  `national` n ON o.National_id = n.National_id
INNER JOIN  staff s ON s.Office_id = o.Office_id
WHERE		s.Email = 'daonq@viettel.com.vn';

/* Ques6: Bạn hãy tìm xem trên hệ thống có quốc gia nào có thông tin trên hệ thống nhưng 
không có nhân viên nào đang làm việc. */
SELECT 		n.National_Name, COUNT(s.Staff_id) AS So_luong_nv
FROM 		`national` n 
LEFT JOIN   office o ON o.National_id = n.National_id
LEFT JOIN   staff s ON s.Office_id = o.Office_id
GROUP BY	n.National_id
HAVING   	So_luong_nv = 0;

/* Ques7: Thống kê xem trên thế giới có bao nhiêu quốc gia mà FB đang hoạt động sử dụng 
tiếng Anh làm ngôn ngữ chính. */
SELECT 		COUNT(n.National_id) AS So_quoc_gia
FROM 		`national` n 
WHERE   	n.Language_Main = 'Tieng Anh';

/* Ques8: Viết lệnh để lấy ra thông tin nhân viên có tên (First_Name) có 10 ký tự, bắt đầu bằng 
chữ N và kết thúc bằng chữ C. */
SELECT 		*
FROM 		staff 
WHERE   	LENGTH(First_Name) = 10 
AND			First_Name LIKE 'N%C';

/* Ques9: Bạn hãy tìm trên hệ thống xem có nhân viên nào đang làm việc nhưng do nhập khi 
nhập liệu bị lỗi mà nhân viên đó vẫn chưa cho thông tin về trụ sở làm việc(Office). */
SELECT 		*
FROM 		staff s
LEFT JOIN   office o ON s.Office_id = o.Office_id
WHERE       o.Office_id IS NULL;

/* Ques10: Nhân viên có mã ID =9 hiện tại đã nghỉ việc, bạn hãy xóa thông tin của nhân viên 
này trên hệ thống. */
DELETE FROM staff
WHERE		Staff_id = 9;

/* Ques11: FB vì 1 lý do nào đó không còn muốn hoạt động tại Australia nữa, và Mark 
Zuckerberg muốn bạn xóa tất cả các thông tin trên hệ thống liên quan đến quốc gia này. Hãy 
tạo 1 Procedure có đầu vào là tên quốc gia cần xóa thông tin để làm việc này và gửi lại cho
anh ấy. */
DROP PROCEDURE IF EXISTS proc_del_national;
DELIMITER $$
CREATE PROCEDURE proc_del_national(IN in_national_name NVARCHAR(50))
BEGIN
	DECLARE v_national_id TINYINT UNSIGNED;
    DECLARE v_office_id TINYINT UNSIGNED;
    SELECT National_id INTO v_national_id FROM `national` WHERE National_Name = in_national_name;
    SELECT Office_id INTO v_office_id FROM `office` WHERE National_id = v_national_id;
    DELETE FROM staff WHERE Office_id = v_office_id;
    DELETE FROM office WHERE Office_id = v_office_id;
    DELETE FROM `national` WHERE National_id = v_national_id;
END $$
DELIMITER ;
CALL proc_del_national('Australia');

/* Ques12: Mark muốn biết xem hiện tại đang có bao nhiêu nhân viên trên toàn thế giới đang
làm việc cho anh ấy, hãy viết cho anh ấy 1 Function để a ấy có thể lấy dữ liệu này 1 cách 
nhanh chóng. */
DROP FUNCTION IF EXISTS f_total_staff;
DELIMITER $$
CREATE FUNCTION f_total_staff() RETURNS INT
READS SQL DATA
DETERMINISTIC
BEGIN
	DECLARE v_total_staff TINYINT UNSIGNED;
    SELECT		 COUNT(Staff_id) INTO v_total_staff
    FROM		 staff;
    RETURN 		 v_total_staff;
END $$
DELIMITER ;

SELECT f_total_staff();

/* Ques13: Để thuận tiện cho việc quản trị Mark muốn số lượng nhân viên tại mỗi quốc gia chỉ
tối đa 10.000 người. Bạn hãy tạo trigger cho table Staff chỉ cho phép insert mỗi quốc gia có 
tối đa 10.000 nhân viên giúp anh ấy (có thể cấu hình số lượng nhân viên nhỏ hơn vd 11 nhân
viên để Test). */
DROP TRIGGER IF EXISTS trg_limit_staff;
DELIMITER $$
CREATE TRIGGER trg_limit_staff
BEFORE INSERT ON staff
FOR EACH ROW
BEGIN
DECLARE v_count_staff INT;
	SELECT 		COUNT(s.Staff_id) INTO v_count_staff
	FROM 		office o
	INNER JOIN  `national` n ON o.National_id = n.National_id
	INNER JOIN  staff s ON s.Office_id = o.Office_id
    WHERE		o.Office_id = NEW.Office_id
    GROUP BY	n.National_id;
	IF (v_count_staff >= 3) THEN
	SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT = 'No more than 10.000 staffs in 1 national';
 END IF;
END $$
DELIMITER ;

INSERT INTO staff (First_Name,     Last_Name,    Email,    Office_id)
VALUES			  ('First Name X', 'Last Name X','Email X', 3 		);
