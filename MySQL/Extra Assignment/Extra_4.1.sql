-- Tao Database Extra_4
DROP DATABASE IF EXISTS Extra_Assignment_4;
CREATE DATABASE Extra_Assignment_4;
USE Extra_Assignment_4;

-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
DROP TABLE IF EXISTS Department;
CREATE TABLE IF NOT EXISTS Department (
    Department_Number		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Department_Name			VARCHAR(50) NOT NULL		
);

DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE IF NOT EXISTS Employee_Table (
    Employee_Number			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Employee_Name			NVARCHAR(50) NOT NULL,
    Department_Number		TINYINT UNSIGNED,
	FOREIGN KEY (Department_Number) REFERENCES Department(Department_Number)
);

DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE IF NOT EXISTS Employee_Skill_Table (
    Employee_Number			TINYINT UNSIGNED,
	Skill_Code				VARCHAR(20) NOT NULL,
	Date_Registered			DATETIME DEFAULT NOW(),
	FOREIGN KEY (Employee_Number) REFERENCES Employee_Table(Employee_Number)
);
