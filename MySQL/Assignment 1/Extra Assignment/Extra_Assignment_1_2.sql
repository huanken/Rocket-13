-- Tao Database
DROP DATABASE IF EXISTS Extra_Assignment_1_2;
CREATE DATABASE Extra_Assignment_1_2;
USE Extra_Assignment_1_2;

-- Ex 1
-- 1.Tao bang Trainee voi constraint va datatype
DROP TABLE IF EXISTS Trainee;
CREATE TABLE IF NOT EXISTS Trainee (
    TraineeID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name 			NVARCHAR(50) NOT NULL,
    Birth_Date 			DATE NOT NULL,
    Gender				ENUM('Male','Female','Unknown') NOT NULL,
    ET_IQ				TINYINT NOT NULL,
    ET_Gmath			TINYINT NOT NULL,
    ET_English			TINYINT NOT NULL,
    Training_Class 		VARCHAR(10) NOT NULL,
    Evaluation_Notes	NVARCHAR(50)
);

-- 2. Them truong VTI_Account 
ALTER TABLE Trainee
ADD COLUMN 	VTI_Account VARCHAR(50) NOT NULL UNIQUE KEY;

-- Ex 2
DROP TABLE IF EXISTS `DataTypes`;
CREATE TABLE IF NOT EXISTS `DataTypes` (
    ID		 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`				VARCHAR(20) NOT NULL,
    `Code` 				CHAR(5) NOT NULL UNIQUE KEY,
    ModifiedDate 		TIME NOT NULL
);

-- Ex 3
DROP TABLE IF EXISTS `DataTypes2`;
CREATE TABLE IF NOT EXISTS `DataTypes` (
    ID		 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`				VARCHAR(20) NOT NULL,
    BirthDate			DATE NOT NULL,
    Gender				BIT DEFAULT NULL,
    IsDeletedFlag		BIT DEFAULT 0
);
