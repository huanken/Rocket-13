-- Ques1: Tạo table với các ràng buộc và kiểu dữ liệu.
DROP DATABASE IF EXISTS Facebook_DB;
CREATE DATABASE Facebook_DB;
USE Facebook_DB;

DROP TABLE IF EXISTS `National`;
CREATE TABLE `National`(
	National_id			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    National_Name		NVARCHAR(50),
    Language_Main		VARCHAR(20)
);

DROP TABLE IF EXISTS `Office`;
CREATE TABLE `Office`(
	Office_id			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Street_Address		NVARCHAR(50),
    National_id			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY 		(National_id) REFERENCES `National`(National_id)
);

DROP TABLE IF EXISTS `Staff`;
CREATE TABLE `Staff`(
	Staff_id			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    First_Name			NVARCHAR(50),
    Last_Name			NVARCHAR(50),
    Email				VARCHAR(50),
    Office_id			TINYINT UNSIGNED NOT NULL,
	FOREIGN KEY 		(Office_id) REFERENCES `Office`(Office_id)
);

-- Ques2: Thêm 10 bản ghi vào các table.
INSERT INTO `National` (National_Name, 		Language_Main)
VALUES				   ('National Name 1','Language Main 1'),
					   ('National Name 2','Language Main 2'),
                       ('Viet Nam'		 ,'Language Main 3'),
                       ('National Name 4','Tieng Anh'),
                       ('National Name 5','Language Main 5'),
                       ('National Name 6','Language Main 6'),
                       ('National Name 7','Tieng Anh'),
                       ('National Name 8','Language Main 8'),
                       ('National Name 9','Language Main 9'),
                       ('National Name 10','Language Main 10');
                       
INSERT INTO `Office`   (Street_Address, 	 National_id)
VALUES				   ('Street Address 1',		1		),
					   ('Street Address 2',		2		),
                       ('Street Address 3',		3		),
                       ('Street Address 4',		4		),
                       ('Street Address 5',		5		),
                       ('Street Address 6',		1		),
                       ('Street Address 7',		6		),
                       ('Street Address 8',		1		),
                       ('Street Address 9',		2		),
                       ('Street Address 10',	4		);
            

INSERT INTO `Staff`    (First_Name, 	 Last_Name,    Email,   Office_id)
VALUES				   ('First Name 1','Last Name 1','Email 1', 1	     ),
                       ('First Name 2','Last Name 2','Email 2', 2	     ),
                       ('First Name 3','Last Name 3','daonq@viettel.com.vn', 3	     ),
                       ('First Name 4','Last Name 4','Email 4', 4	     ),
                       ('First Name 5','Last Name 5','Email 5', 3	     ),
                       ('First Name 6','Last Name 6','Email 6', 3	     ),
                       ('Nst Name C',	'Last Name 7','Email 7', 1	     ),
                       ('First Name 8','Last Name 8','Email 8', 3	     ),
                       ('Nirst Name C','Last Name 9','Email 9', 6	     ),
                       ('First Name 10','Last Name 10','Email 10', 10	 );
