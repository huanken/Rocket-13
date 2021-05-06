-- Tao Database
DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;

-- 1.Tao bang Department
DROP TABLE IF EXISTS Department;
CREATE TABLE IF NOT EXISTS Department (
    DepartmentID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 		NVARCHAR(255) NOT NULL UNIQUE KEY
);

-- 2.Tao bang Position
DROP TABLE IF EXISTS `Position`;
CREATE TABLE IF NOT EXISTS `Position` (
    PositionID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName		ENUM('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE KEY
);

-- 3.Tao bang Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE IF NOT EXISTS `Account` (
    AccountID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email				VARCHAR(255) NOT NULL UNIQUE KEY,
    Username 			NVARCHAR(255) NOT NULL UNIQUE KEY,
	FullName 			NVARCHAR(255) NOT NULL,
	DepartmentID		TINYINT UNSIGNED NOT NULL,
	PositionID 			TINYINT UNSIGNED NOT NULL,
    CreateDate 			DATETIME DEFAULT NOW(),
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);

-- 4.Tao bang Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE IF NOT EXISTS `Group` (
    GroupID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName			NVARCHAR(255) NOT NULL UNIQUE KEY,
    CreatorID 			TINYINT UNSIGNED NOT NULL,
    CreateDate 			DATETIME DEFAULT NOW(),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- 5.Tao bang GroupAccount
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE IF NOT EXISTS GroupAccount (
    GroupID 			TINYINT UNSIGNED NOT NULL,
    AccountID			TINYINT UNSIGNED NOT NULL,
	JoinDate			DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID,AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
);

-- 6.Tao bang TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE IF NOT EXISTS TypeQuestion (
    TypeID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName			ENUM('ESSAY','MULTIPLE-CHOICE')
);

-- 7.Tao bang CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE IF NOT EXISTS CategoryQuestion (
    CategoryID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName		NVARCHAR(255) NOT NULL UNIQUE KEY
);

-- 8.Tao bang Question
DROP TABLE IF EXISTS Question;
CREATE TABLE IF NOT EXISTS Question (
    QuestionID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content				NVARCHAR(255) NOT NULL UNIQUE KEY,
	CategoryID 			TINYINT UNSIGNED NOT NULL,
    TypeID 				TINYINT UNSIGNED NOT NULL,			
    CreatorID 			TINYINT UNSIGNED NOT NULL,
    CreateDate 			DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
	FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- 9.Tao bang Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE IF NOT EXISTS Answer (
    AnswerID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content				NVARCHAR(255) NOT NULL UNIQUE KEY,
	QuestionID 			TINYINT UNSIGNED NOT NULL,
    isCorrect 			BIT DEFAULT 1,			
	FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

-- 10.Tao bang Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE IF NOT EXISTS Exam (
    ExamID	 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`				CHAR(10) NOT NULL,
	Title 				NVARCHAR(255) NOT NULL,
    CategoryID 			TINYINT UNSIGNED NOT NULL,
    Duration 			TINYINT UNSIGNED NOT NULL,		
	CreatorID 			TINYINT UNSIGNED NOT NULL,
    CreateDate 			DATETIME DEFAULT NOW(),
	FOREIGN KEY (CategoryID) REFERENCES Question(CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- 11.Tao bang ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE IF NOT EXISTS ExamQuestion (
    ExamID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    QuestionID 			TINYINT UNSIGNED NOT NULL,	
	FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

