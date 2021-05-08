/* Exercise 1: Tiếp tục với Database ở buổi 6
Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp lệ 
(Project_Modules.ProjectModulesDate < Projects.ProjectStartDate,
Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn) */
DROP TRIGGER IF EXISTS trg_format_module;
DELIMITER $$
CREATE TRIGGER 		trg_format_module 
BEFORE INSERT ON 	project_modules
FOR EACH ROW
BEGIN
	DECLARE 	v_ProjectStartDate DATE;
    DECLARE 	v_ProjectCompletedOn DATE;
    SELECT 		ProjectStartDate INTO v_ProjectStartDate FROM projects WHERE ProjectID = NEW.ProjectID;
    SELECT		ProjectCompletedOn INTO v_ProjectCompletedOn FROM projects WHERE ProjectID = NEW.ProjectID;
	IF 			NEW.ProjectModulesDate < v_ProjectStartDate OR NEW.ProjectModuleCompletedOn > v_ProjectCompletedOn 
    THEN 			
    SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT = 'Nhập dữ liệu không hợp lệ';
	END IF;
END $$
DELIMITER ;

/* Exercise 2: View
Trong database phần Assignment 3, Tạo 1 VIEW để lấy ra tất cả các thực tập sinh là 
ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số 
điểm như sau:
 ET_IQ + ET_Gmath>=20
 ET_IQ>=8
 ET_Gmath>=8
 ET_English>=18 */
USE 		extra_assignment_1_2_3;
CREATE VIEW vw_ET_Trainee AS
SELECT 		TraineeID,Full_Name,
			CASE
            WHEN ET_IQ + ET_Gmath>=20 AND ET_IQ>=8 AND ET_Gmath>=8 AND ET_English>=18 THEN 'ET'
            ELSE 'NOT ET'
            END AS isET
FROM 		trainee;

SELECT * FROM vw_ET_Trainee;