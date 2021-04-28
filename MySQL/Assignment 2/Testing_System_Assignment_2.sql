-- 1.Chen du lieu vao bang Department
INSERT INTO Department(DepartmentName)
VALUES				(N'Marketing'	),
                    (N'Sale'		),
                    (N'Bảo vệ'		),
                    (N'Nhân sự'		),
                    (N'Kỹ thuật'	),
                    (N'Tài chính'	),
                    (N'Phó giám đốc'),
                    (N'Thư kí'		),
                    (N'Bán hàng'	);

-- 2.Chen du lieu vao bang Poisition
INSERT INTO Position	(PositionName	) 
VALUES 					('Dev'			),
						('Test'			),
						('Scrum Master'	),
						('PM'			); 
-- 3.Chen du lieu vao bang Account
INSERT INTO `Account`(Email								, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUES 				('gmail111111@gmail.com'	  		, 'black'	 		,'Nguyễn Văn A'			,   '2'			,   '1'		,'2021-07-21'),
					('gmail111112@gmail.com'	  		, 'red'	 			,'Nguyễn Văn B'			,   '3'			,   '4'		,'2021-01-25'),
                    ('gmail111113@gmail.com'	  		, 'pink'	 		,'Nguyễn Văn C'			,   '4'			,   '1'		,'2021-06-14'),
                    ('gmail111114@gmail.com'	  		, 'yellow'	 		,'Nguyễn Văn D'			,   '5'			,   '3'		,'2021-05-30'),
                    ('gmail111115@gmail.com'	  		, 'brown'	 		,'Nguyễn Văn E'			,   '1'			,   '2'		,'2021-09-11'),
                    ('gmail111116@gmail.com'	  		, 'green'	 		,'Nguyễn Văn F'			,   '2'			,   '4'		,'2021-05-02'),
                    ('gmail111117@gmail.com'	  		, 'blue'	 		,'Nguyễn Văn G'			,   '1'			,   '1'		,  DEFAULT	 ),
                    ('gmail111118@gmail.com'	  		, 'turtle'	 		,'Nguyễn Văn H'			,   '4'			,   '2'		,'2021-08-07'),
                    ('gmail111119@gmail.com'	  		, 'white'	 		,'Nguyễn Văn O'			,   '3'			,   '3'		,'2021-09-19'),
                    ('gmail111110@gmail.com'	  		, 'ken'	 			,'Nguyễn Sinh Huân'		,   '5'			,   '1'		,'2021-11-27');
-- 4.Chen du lieu vao bang Group
INSERT INTO `Group`	(  GroupName			, CreatorID		, CreateDate)
VALUES 				(N'Marketing'			,   1			,'2021-04-23'),
					(N'Sale'				,   5			,'2021-04-11'),
                    (N'Nhân sự'				,   4			,'2021-04-02'),
                    (N'Quản lý'				,   3			,'2021-04-03'),
                    (N'Bán hàng'			,   9			,'2021-04-04'),
                    (N'Hỗ trợ KH'			,   10			,'2021-04-11'),
                    (N'Creator	1'			,   2			,'2021-04-25'),
                    (N'Creator	2'			,   6			,'2021-04-15'),
                    (N'Creator	3'			,   7			,'2021-04-06'),
                    (N'Creator	4'			,   8			,'2021-04-22');

-- 5.Chen du lieu vao bang GroupAccount
INSERT INTO GroupAccount	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	2		,    2		,'2021-03-05'),
							(	3		,    3		,'2021-03-05'),
                            (	4		,    4		,'2021-03-05'),
                            (	5		,    5 		,'2021-03-05'),
                            (	6		,    6		,'2021-03-05'),
                            (	7		,    7		,'2021-03-05'),
                            (	8		,    8		,'2021-03-05'),
                            (	9		,    9		,'2021-03-05'),
                            (	10		,    10		,'2021-03-05'),
                            (	1		,    1		,'2021-03-05');

-- 6.Chen du lieu vao bang TypeQuestion
INSERT INTO TypeQuestion	(TypeName			) 
VALUES 						('Essay'			), 
							('Multiple-Choice'	);
                            
-- 7.Chen du lieu vao bang CategoryQuestion
INSERT INTO CategoryQuestion		(CategoryName	)
VALUES 								('SQL'			),
									('HQL'			),
                                    ('IQL'			),
                                    ('DQL'			),
                                    ('EQL'			),
                                    ('AQL'			),
                                    ('BQL'			),
                                    ('PQL'			),
                                    ('WQL'			),
                                    ('XQL'			);

-- 8.Chen du lieu vao bang Question
INSERT INTO Question	(Content			, CategoryID, TypeID		, CreatorID	, CreateDate )
VALUES 					(N'Câu hỏi về SQL'	,	1		,   '1'			,   '2'		,'2021-04-25'),
						(N'Câu Hỏi về HQL'	,	2		,   '2'			,   '10'	,'2021-04-23'),
                        (N'Câu Hỏi về IQL'	,	3		,   '1'			,   '9'		,'2021-04-17'),
                        (N'Câu Hỏi về DQL'	,	4		,   '2'			,   '8'		,'2021-04-21'),
                        (N'Câu Hỏi về EQL'	,	5		,   '2'			,   '2'		,'2021-04-22'),
                        (N'Câu Hỏi về AQL'	,	6		,   '1'			,   '7'		,'2021-04-12'),
                        (N'Câu Hỏi về BQL'	,	7		,   '2'			,   '5'		,'2021-04-13'),
                        (N'Câu Hỏi về PQL'	,	8		,   '1'			,   '2'		,'2021-04-01'),
                        (N'Câu Hỏi về WQL'	,	9		,   '2'			,   '1'		,'2021-04-07'),
                        (N'Câu Hỏi về XQL'	,	10		,   '1'			,   '3'		,'2021-04-04');

-- 9.Chen du lieu vao bang Answer
INSERT INTO Answer	(  Content		, QuestionID	, isCorrect	)
VALUES 				(N'Trả lời 01'	,   1			,	0		),
					(N'Trả lời 02'	,   5			,	1		),
                    (N'Trả lời 03'	,   4			,	0		),
                    (N'Trả lời 04'	,   2			,	1		),
                    (N'Trả lời 05'	,   10			,	1		),
                    (N'Trả lời 06'	,   5			,	0		),
                    (N'Trả lời 07'	,   1			,	1		),
                    (N'Trả lời 08'	,   8			,	0		),
                    (N'Trả lời 09'	,   7			,	1		),
                    (N'Trả lời 10'	,   6			,	1		);
	
-- 10.Chen du lieu vao bang Exam
INSERT INTO Exam	(`Code`			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUES 				('EX001'		, N'Kiểm tra SQL'		,	1			,	60		,   '2'			,'2021-04-13'),
					('EX002'		, N'Kiểm tra HQL'		,	2			,	90		,   '5'			,'2021-04-22'),
                    ('EX003'		, N'Kiểm tra HQL'		,	3			,	60		,   '6'			,'2021-04-22'),
                    ('EX004'		, N'Kiểm tra WQL'		,	5			,	60		,   '4'			,'2021-04-18'),
                    ('EX005'		, N'Kiểm tra EQL'		,	7			,	120		,   '10'		,'2021-04-15'),
                    ('EX006'		, N'Kiểm tra QQL'		,	8			,	60		,   '1'			,'2021-04-13'),
                    ('EX007'		, N'Kiểm tra XQL'		,	9			,	45		,   '5'			,'2021-04-15'),
                    ('EX008'		, N'Kiểm tra AQL'		,	4			,	60		,   '8'			,'2021-04-17'),
                    ('EX009'		, N'Kiểm tra BQL'		,	6			,	90		,   '7'			,'2021-04-12'),
                    ('EX0010'		, N'Kiểm tra SQL'		,	10			,	90		,   '8'			,'2021-04-29');
-- 11.Chen du lieu vao bang Exam
INSERT INTO ExamQuestion(ExamID		, QuestionID) 
VALUES 					(	  1		,		5	),
						(	  2		,		6	),
                        (	  3		,		7	),
                        (	  5		,		8	),
                        (	  7		,		9	),
                        (	  4		,		10	),
                        (	  6		,		2	),
                        (	  9		,		1	),
                        (	  10	,		3	),
                        (	  8	 	,		4	);
                        