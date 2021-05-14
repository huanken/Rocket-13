/* 1. Tạo table với các ràng buộc và kiểu dữ liệu 
Insert 15 user có trong đó có 5 user thuộc 2 phòng ban khác nhau
3 user có 2 role khác nhau trong 1 phòng
Insert lương của tháng tất cả các user trong tháng 4,5,6 */
DROP DATABASE IF EXISTS TestingExam2;
CREATE DATABASE TestingExam2;
USE TestingExam2;

DROP TABLE IF EXISTS Departments;
CREATE TABLE Departments(
	id			   INT(10) AUTO_INCREMENT PRIMARY KEY,
    `name`		   VARCHAR(30),
    `description`  TEXT,
    created_at	   DATETIME,
	updated_at	   DATETIME
);

DROP TABLE IF EXISTS Users;
CREATE TABLE Users(
	id			   INT(10) AUTO_INCREMENT PRIMARY KEY,
    first_name	   VARCHAR(30),
    last_name	   VARCHAR(30),
    email		   VARCHAR(100),
	phone		   VARCHAR(20),
    employee_id	   VARCHAR(10),
    avatar		   TEXT,
    department_id  INT(10),
    gender		   TINYINT(10),
    age 		   TINYINT(3),
	created_at	   DATETIME,
	updated_at	   DATETIME,
    FOREIGN KEY (department_id) REFERENCES Departments(id)
);

DROP TABLE IF EXISTS User_Department;
CREATE TABLE User_Department(
	id			   INT(10) AUTO_INCREMENT PRIMARY KEY,
    user_id		   INT(10),
    department_id  INT(10),
    start_date	   DATE,
	end_date	   DATE,
	created_at	   DATETIME,
	updated_at	   DATETIME,
	FOREIGN KEY (user_id) REFERENCES Users(id),
	FOREIGN KEY (department_id) REFERENCES Departments(id)
);

DROP TABLE IF EXISTS Roles;
CREATE TABLE Roles(
	id			   INT(10) AUTO_INCREMENT PRIMARY KEY,
    `name`		   VARCHAR(30),
    created_at	   DATETIME,
	updated_at	   DATETIME
);

DROP TABLE IF EXISTS User_Role;
CREATE TABLE User_Role(
	id					   INT(10) AUTO_INCREMENT PRIMARY KEY,
    user_department_id	   INT(10),
    role_id			 	   INT(10),
    start_date	   		   DATE,
	end_date	           DATE,
	created_at	           DATETIME,
	updated_at	           DATETIME,
	FOREIGN KEY (user_department_id) REFERENCES User_Department(id),
	FOREIGN KEY (role_id) REFERENCES Roles(id)
);

DROP TABLE IF EXISTS Salary;
CREATE TABLE Salary(
	id			   INT(10) AUTO_INCREMENT PRIMARY KEY,
    user_role_id   INT(10),
    total_salary   DOUBLE(12,2),
    `month`		   VARCHAR(2),
    `year`		   VARCHAR(4),
    created_at	   DATETIME,
	updated_at	   DATETIME,
	FOREIGN KEY (user_role_id) REFERENCES User_Role(id)
);

DROP TABLE IF EXISTS Salary_Detail_Type;
CREATE TABLE Salary_Detail_Type(
	id			   INT(10) AUTO_INCREMENT PRIMARY KEY,
    `name`		   VARCHAR(10),
    created_at	   DATETIME,
	updated_at	   DATETIME
);

DROP TABLE IF EXISTS Salary_Detail;
CREATE TABLE Salary_Detail(
	id			 			  INT(10) AUTO_INCREMENT PRIMARY KEY,
    amount		 			  DOUBLE(12,2),
	salary_id	 			  INT(10),
    salary_detail_type_id	  INT(10),
	operation				  TINYINT(3),	
	FOREIGN KEY (salary_id) REFERENCES Salary(id),
    FOREIGN KEY (salary_detail_type_id) REFERENCES Salary_Detail_Type(id)
);

INSERT INTO Departments (`name` , 	 `description`  , created_at  , updated_at  )
VALUES				    ('Admin', 	 'Description 1', '2021-01-01', '2021-05-05'),
						('HR',   	 'Description 2', '2021-01-01', '2021-05-05'),
                        ('IT',   	 'Description 3', '2021-01-01', '2021-05-05'),
                        ('Delivery', 'Description 4', '2021-01-01', '2021-05-05');

INSERT INTO Users (first_name  , last_name, email			 , phone 	   , employee_id, avatar   , department_id, gender, age, created_at   , updated_at  )    
VALUES			  ('Nguyen Van', 'A'      , 'email1@mail.com', '0123456789', 'e001'     ,'avatar 1',    1 		  , 1     , 20 ,  '2021-01-01', '2021-05-05'),
				  ('Nguyen Van', 'B'      , 'email2@mail.com', '0223456789', 'e002'     ,'avatar 2',    2 		  , 0     , 30 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'C'      , 'email3@mail.com', '0323456789', 'e003'     ,'avatar 3',    3 		  , 1     , 22 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'D'      , 'email4@mail.com', '0423456789', 'e004'     ,'avatar 4',    4 		  , 1     , 23 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'E'      , 'email5@mail.com', '0523456789', 'e005'     ,'avatar 5',    2 		  , 1     , 25 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'A'      , 'email6@mail.com', '0123456789', 'e006'     ,'avatar 6',    1 		  , 1     , 26 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'B'      , 'email7@mail.com', '0223456789', 'e007'     ,'avatar 7',    4 		  , 0     , 27 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'C'      , 'email8@mail.com', '0323456789', 'e008'     ,'avatar 8',    3 		  , 1     , 29 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'D'      , 'email9@mail.com', '0423456789', 'e009'     ,'avatar 9',    2 		  , 1     , 22 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'E'      , 'emailq@mail.com', '0523456789', 'e0010'    ,'avatar 0',    1 		  , 0     , 21 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'A'      , 'emailw@mail.com', '0123456789', 'e0011'    ,'avatar q',    2 		  , 1     , 22 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'C'      , 'emaile@mail.com', '0323456789', 'e0012'    ,'avatar w',    3 		  , 1     , 24 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'H'      , 'emailr@mail.com', '0923456789', 'e0013'    ,'avatar e',    2 		  , 1     , 25 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'A'      , 'emailt@mail.com', '0123456789', 'e0014'    ,'avatar r',    4 		  , 0     , 26 ,  '2021-01-01', '2021-05-05'),
                  ('Nguyen Van', 'B'      , 'emaily@mail.com', '0223456789', 'e0015'    ,'avatar t',    1 		  , 1     , 21 ,  '2021-01-01', '2021-05-05');

INSERT INTO User_Department   (user_id   , department_id, start_date  , end_date	  , created_at  , updated_at)
VALUES						  (1		 , 1			, '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
							  (2		 , 2	  		, '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
							  (3		 , 3		  	, '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
							  (4		 , 4		  	, '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
							  (5		 , 2		  	, '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
							  (1		 , 4		  	, '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
							  (2		 , 3		  	, '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
							  (3		 , 2	 	 	, '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
							  (4		 , 1		  	, '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
							  (5		 , 2		  	, '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02');

INSERT INTO Roles (`name` 	  	 , created_at  , updated_at)
VALUES			  ('Giam doc'	 , '2021-01-01', '2021-05-05'),
				  ('Truong phong', '2021-01-01', '2021-05-05'),
                  ('Pho phong'	 , '2021-01-01', '2021-05-05'),
                  ('Nhan vien'	 , '2021-01-01', '2021-05-05'),
                  ('CTV'		 , '2021-01-01', '2021-05-05');
                  
INSERT INTO User_Role (user_department_id, role_id, start_date  , end_date	  , created_at  , updated_at  )
VALUES				  (1				 , 1	  , '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
					  (1				 , 2	  , '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
                      (2				 , 3	  , '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
                      (2				 , 4	  , '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
                      (3				 , 3	  , '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
                      (3				 , 1	  , '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
                      (4				 , 2	  , '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
                      (6				 , 3	  , '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
                      (4				 , 5	  , '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02'),
                      (5				 , 5	  , '2021-01-01', '2021-03-03', '2021-01-01', '2021-02-02');

INSERT INTO Salary (user_role_id, total_salary, `month`, `year`, created_at  , updated_at  )
VALUES			   (1			, '50000.50'  , '4'	   , '2021', '2021-05-05', '2021-05-06'),
				   (1			, '50000.50'  , '5'	   , '2021', '2021-05-05', '2021-05-06'),
                   (1			, '50000.50'  , '6'	   , '2021', '2021-05-05', '2021-05-06'),
                   (2			, '40000.50'  , '4'	   , '2021', '2021-05-05', '2021-05-06'),
                   (2			, '40000.50'  , '5'	   , '2021', '2021-05-05', '2021-05-06'),
                   (2			, '40000.50'  , '6'	   , '2021', '2021-05-05', '2021-05-06'),
                   (3			, '30000.50'  , '4'	   , '2021', '2021-05-05', '2021-05-06'),
                   (3			, '30000.50'  , '5'	   , '2021', '2021-05-05', '2021-05-06'),
                   (3			, '30000.50'  , '6'	   , '2021', '2021-05-05', '2021-05-06'),
                   (4			, '20000.50'  , '4'	   , '2021', '2021-05-05', '2021-05-06'),
                   (4			, '20000.50'  , '5'	   , '2021', '2021-05-05', '2021-05-06'),
                   (4			, '20000.50'  , '6'	   , '2021', '2021-05-05', '2021-05-06'),
                   (5			, '10000.50'  , '4'	   , '2021', '2021-05-05', '2021-05-06'),
                   (5			, '10000.50'  , '5'	   , '2021', '2021-05-05', '2021-05-06'),
                   (5			, '10000.50'  , '6'	   , '2021', '2021-05-05', '2021-05-06');

INSERT INTO Salary_Detail_Type (`name`		, created_at  , updated_at	)
VALUES						   ('Luong cung', '2021-01-01', '2021-02-02'),
							   ('Phu cap'   , '2021-01-01', '2021-02-02'),
                               ('Thuong'    , '2021-01-01', '2021-02-02'),
                               ('Thue TNCN' , '2021-01-01', '2021-02-02'),	
                               ('BHXH'      , '2021-01-01', '2021-02-02');
                               
INSERT INTO Salary_Detail (amount   , salary_id, salary_detail_type_id, operation)
VALUES					  ('10000.5', 1		   , 1					  , 1	     ),
						  ('10000.5', 1		   , 2					  , 2	     ),
                          ('10000.5', 1		   , 3					  , 3	     ),
                          ('10000.5', 1		   , 4					  , 3	     ),
                          ('10000.5', 2		   , 1					  , 1	     ),
                          ('10000.5', 2		   , 2					  , 2	     ),
                          ('10000.5', 2		   , 3					  , 3	     ),
                          ('10000.5', 3		   , 1					  , 1	     ),
                          ('10000.5', 3		   , 2					  , 2	     );
                          