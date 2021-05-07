-- a) Tạo table với các ràng buộc và kiểu dữ liệu và thêm ít nhất 3 bản ghi vào mỗi table trên
DROP DATABASE IF EXISTS extra_assignment_6;
CREATE DATABASE extra_assignment_6;
USE extra_assignment_6;

-- Tạo các bảng với các ràng buộc 
DROP TABLE IF EXISTS Employee;
CREATE TABLE IF NOT EXISTS Employee(
    EmployeeID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	EmployeeLastName			NVARCHAR(50) NOT NULL,
    EmployeeFirstName			NVARCHAR(50) NOT NULL,
    EmployeeHireDate			DATETIME DEFAULT NOW(),
    EmployeeStatus				ENUM('Done','None') NOT NULL,
    SupervisorID				TINYINT UNSIGNED NOT NULL,
	SocialSecurityNumber		VARCHAR(10),
    FOREIGN KEY					(SupervisorID) REFERENCES Employee(EmployeeID) ON DElETE CASCADE
);

DROP TABLE IF EXISTS Projects;
CREATE TABLE IF NOT EXISTS Projects(
    ProjectID 					TINYINT UNSIGNED AUTO_INCREMENT,
    ManagerID					TINYINT UNSIGNED NOT NULL,
    ProjectName					NVARCHAR(50) NOT NULL,
    ProjectStartDate			DATETIME DEFAULT NOW(),
    ProjectDescription			NVARCHAR(50) NOT NULL,
    ProjectDetail				NVARCHAR(50) NOT NULL,
	ProjectCompletedOn 			DATETIME DEFAULT NOW(),
	PRIMARY KEY					(ProjectID,ManagerID),
    FOREIGN KEY					(ManagerID) REFERENCES Employee(EmployeeID) ON DElETE CASCADE
);

DROP TABLE IF EXISTS Project_Modules;
CREATE TABLE IF NOT EXISTS Project_Modules(
	ModuleID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProjectID 					TINYINT UNSIGNED NOT NULL,
    EmployeeID					TINYINT UNSIGNED NOT NULL,
    ProjectModulesDate			DATETIME DEFAULT NOW(),
    ProjectModuleCompletedOn 	DATETIME DEFAULT NOW(),
    ProjectModuleDescription	NVARCHAR(50) NOT NULL,
    FOREIGN KEY					(ProjectID) REFERENCES Projects(ProjectID) ON DElETE CASCADE,
    FOREIGN KEY					(EmployeeID) REFERENCES Employee(EmployeeID) ON DElETE CASCADE
);

DROP TABLE IF EXISTS Work_Done;
CREATE TABLE IF NOT EXISTS Work_Done(
    WorkDoneID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	EmployeeID 					TINYINT UNSIGNED NOT NULL,
    ModuleID 					TINYINT UNSIGNED NOT NULL,
    WorkDoneDate				DATETIME DEFAULT NULL,
    WorkDoneDescription			NVARCHAR(50) NOT NULL,
    WorkDoneStatus				ENUM('Done','None') NOT NULL,
    FOREIGN KEY					(EmployeeID) REFERENCES Employee(EmployeeID) ON DElETE CASCADE,
    FOREIGN KEY					(ModuleID) REFERENCES Project_Modules(ModuleID) ON DElETE CASCADE
);

-- Thêm bản ghi vào các bảng 
INSERT INTO Employee (EmployeeLastName, EmployeeFirstName, EmployeeHireDate, EmployeeStatus, SupervisorID, SocialSecurityNumber)
VALUES				 (N'A'			  , N'Nguyễn Văn'    , '2020-12-12'    , 'Done'        , 1           , '001'               ),
					 (N'B'			  , N'Nguyễn Văn'    , '2020-05-01'    , 'None'        , 1           , '002'               ),
                     (N'C'			  , N'Nguyễn Thị'    , '2019-01-01'    , 'Done'        , 2           , '003'               ),
                     (N'D'			  , N'Nguyễn Văn'    , '2020-03-30'    , 'None'        , 2           , '004'               ),
                     (N'E'			  , N'Nguyễn Thị'    , '2019-02-15'    , 'Done'        , 1           , '005'               );

INSERT INTO Projects (ManagerID, ProjectName, ProjectStartDate, ProjectDescription, ProjectDetail,ProjectCompletedOn )
VALUES				 ( 1   	   , N'Dự án 1' , '2020-12-12'    , 'Java'       	  , 'Detail 1'   , '2020-12-12' 	 ),
					 ( 2   	   , N'Dự án 2' , '2020-06-12'    , 'SQL'       	  , 'Detail 2'   , '2020-12-13' 	 ),	
                     ( 1   	   , N'Dự án 3' , '2020-01-12'    , 'PHP'     		  , 'Detail 3'   , '2020-12-15' 	 );

INSERT INTO Project_Modules (ProjectID, EmployeeID, ProjectModulesDate, ProjectModuleCompletedOn, ProjectModuleDescription)
VALUES						( 1   	   , 5        , '2020-07-24'      , '2021-04-30'      	    , 'Descripton 1' 		  ),
							( 2   	   , 3        , '2020-08-05'      , '2021-04-05'      	    , 'Descripton 2' 		  ),
                            ( 3   	   , 3        , '2020-09-19'      , '2021-03-07'      	    , 'Descripton 3' 		  ),
                            ( 1   	   , 4        , '2020-10-05'      , '2021-02-25'      	    , 'Descripton 4' 		  ),
                            ( 2   	   , 5        , '2020-07-20'      , '2021-03-28'      	    , 'Descripton 5' 		  );

INSERT INTO Work_Done (EmployeeID, ModuleID, WorkDoneDate  , WorkDoneDescription	 ,	 WorkDoneStatus)
VALUES				  ( 5   	 , 1       , '2019-07-24'  , 'Module Descripton 1'   ,   'Done' 	   ),
					  ( 3   	 , 2       , '2019-08-10'  , 'Module Descripton 2'   ,   'None'    	   ),	
                      ( 3   	 , 3       , '2019-07-24'  , 'Module Descripton 3'   ,   'Done'		   ),	
                      ( 4   	 , 4       , '2019-09-24'  , 'Module Descripton 4'   ,   'Done'		   ),	
                      ( 5   	 , 5       , '2019-07-10'  , 'Module Descripton 5'   ,   'None'		   );
                      
/* b) Viết stored procedure (không có parameter) để Remove tất cả thông tin project đã  hoàn thành sau 3 tháng kể từ ngày hiện.
 In số lượng record đã remove từ các table liên quan trong khi removing (dùng lệnh print) */
DROP PROCEDURE IF EXISTS proc_after_3_months;
DELIMITER $$
CREATE PROCEDURE proc_after_3_months()
BEGIN
DELETE FROM projects
WHERE		(MONTH(ProjectCompletedOn) - MONTH(ProjectStartDate)) < 3;
END$$
DELIMITER ;

CALL proc_after_3_months;

/* c) Viết stored procedure (có parameter) để in ra các module đang được thực hiện */
DROP PROCEDURE IF EXISTS proc_module;
DELIMITER $$
CREATE PROCEDURE proc_module()
BEGIN
SELECT 		m.*
FROM 		project_modules m
INNER JOIN	work_done w ON m.ModuleID = w.ModuleID	
WHERE		w.WorkDoneDate IS NULL;
END$$
DELIMITER ;

CALL proc_module();

/* d) Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc 
		dù không ai giao việc cho nhân viên đó (trong bảng Works) */
DROP PROCEDURE IF EXISTS proc_emp_no_work;
DELIMITER $$
CREATE PROCEDURE proc_emp_no_work()
BEGIN
SELECT 		e.*
FROM 		employee e
LEFT JOIN	work_done w ON e.EmployeeID = w.EmployeeID
WHERE		w.EmployeeID IS NULL;
END$$
DELIMITER ;

CALL proc_emp_no_work();
