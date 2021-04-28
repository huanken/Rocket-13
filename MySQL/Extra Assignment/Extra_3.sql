-- Question 1: Thêm ít nhất 10 bản ghi vào tables
INSERT INTO Trainee (   Full_Name			,   Birth_Date	, Gender	, ET_IQ	, ET_Gmath	, ET_English	, Training_Class	, Evaluation_Notes	, VTI_Account		)
VALUE 				(N'Nguyễn Văn A'		,  '2000-09-21'	, 'male'	,	10	,	20		,	19			,   'Rocket-13'		,	'Very good'		,	'account1'		),
					(N'Nguyễn Văn B'		,  '2000-10-20'	, 'male'	,	11	,	14		,	15			,   'Rocket-20'		,	'good'			,	'account2'		),
                    (N'Nguyễn Thị C'		,  '2000-09-28'	, 'female'	,	10	,	15		,	21			,   'Rocket-10'		,	'Very good'		,	'account3'		),
                    (N'Nguyễn Văn D'		,  '2000-08-21'	, 'male'	,	10	,	10		,	25			,   'Rocket-13'		,	'Very good'		,	'account4'		),
                    (N'Nguyễn Thị E'		,  '2000-12-22'	, 'female'	,	12	,	10		,	10			,   'Rocket-15'		,	'Very good'		,	'account5'		),
                    (N'Nguyễn Văn F'		,  '2000-09-24'	, 'male'	,	14	,	28		,	28			,   'Rocket-09'		,	'Not good'		,	'account6'		),
                    (N'Nguyễn Văn G'		,  '2000-12-25'	, 'male'	,	10	,	10		,	10			,   'Rocket-13'		,	'Very good'		,	'account7'		),
                    (N'Nguyễn Thị H'		,  '2000-09-25'	, 'female'	,	11	,	13		,	9			,   'Rocket-01'		,	'Not good'		,	'account8'		),
                    (N'Nguyễn Văn I'		,  '2000-01-28'	, 'male'	,	10	,	10		,	20			,   'Rocket-13'		,	'Very good'		,	'account9'		),
                    (N'Nguyễn Văn K'		,  '2000-01-22'	, 'male'	,	10	,	12		,	10			,   'Rocket-02'		,	'Very bad'		,	'account10'		);

INSERT INTO DataTypes	(   `Name`	, `Code`	, ModifiedDate	)
VALUE 					('Name 1'	, 'VTI01'	, '2021-04-05'	),
						('Name 2'	, 'VTI02'	, '2021-04-04'	),
                        ('Name 3'	, 'VTI03'	, '2021-04-22'	),
                        ('Name 4'	, 'VTI04'	, '2021-04-11'	),
                        ('Name 5'	, 'VTI05'	, '2021-04-05'	),
                        ('Name 6'	, 'VTI06'	, '2021-03-07'	),
                        ('Name 7'	, 'VTI07'	, '2021-05-14'	),
                        ('Name 8'	, 'VTI08'	, '2021-06-06'	),
                        ('Name 9'	, 'VTI09'	, '2021-08-05'	),
                        ('Name 10'	, 'VTI10'	, '2021-09-14'	);

INSERT INTO `DataTypes2` 	(   `Name`			,   BirthDate		, Gender	,	 IsDeletedFlag	)
VALUE 						(N'Nguyễn Văn A'	,  '2000-09-21'		, 	'0'		,		0			),   
							(N'Nguyễn Thị B'	,  '2000-09-25'		, 	'1'		,		1			),
							(N'Nguyễn Văn C'	,  '2000-09-26'		, 	'0'		,		0			),
							(N'Nguyễn Thị D'	,  '2000-09-02'		, 	'1'		,		1			),
							(N'Nguyễn Văn E'	,  '2000-09-01'		, 	'0'		,		0			),
							(N'Nguyễn Văn F'	,  '2000-09-21'		, 	'0'		,		0			),
							(N'Nguyễn Thị G'	,  '2000-09-08'		, 	'1'		,		1			),
							(N'Nguyễn Văn H'	,  '2000-09-09'		, 	'0'		,		1			),
							(N'Nguyễn Thị I'	,  '2000-09-19'		, 	'1'		,		0			),
							(N'Nguyễn Văn K'	,  '2000-09-21'		, 	'0'		,		0			);
 
 -- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau
SELECT		*
FROM 		trainee
ORDER BY 	Birth_Date;
 
 -- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT		Full_Name, (2021 - YEAR(Birth_Date)) AS Age, Gender, Training_Class, Evaluation_Notes, VTI_Account
FROM 		trainee
WHERE		LENGTH(Full_Name) = (SELECT 	MAX(LENGTH(Full_Name)) 
								FROM 		trainee			 );
                        
-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau
SELECT		*
FROM 		trainee
WHERE		(ET_IQ + ET_Gmath) >= 20
AND			ET_IQ >= 8
AND 		ET_Gmath >= 8
AND			ET_English >= 18;

-- Question 5: xóa thực tập sinh có TraineeID = 3
DELETE FROM trainee
WHERE		TraineeID = 3;

-- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
UPDATE 		trainee
SET			Training_Class = '2'
WHERE		TraineeID = 5;

