use extra_assignment_4;
-- Question 2: Thêm ít nhất 10 bản ghi vào table
INSERT INTO Department	(Department_Name) 
VALUE 					(N'Sale'		),
						(N'Bảo vệ'		),
                        (N'Nhân sự'		),
                        (N'Marketing'	),
                        (N'Bán hàng'	),
                        (N'Thư kí'		),
                        (N'Giám đốc'	),
                        (N'Phó giám đốc'),
                        (N'Kĩ thuật'	),
                        (N'Nhân sự 2'	);
					
INSERT INTO Employee_Table 	(Employee_Name		, Department_Number	)
VALUE						(N'Nguyễn Văn A'	,		1			),	
							(N'Nguyễn Văn B'	,		2			),
                            (N'Nguyễn Thị C'	,		3			),
                            (N'Nguyễn Văn D'	,		6			),
                            (N'Nguyễn Thị E'	,		2			),
                            (N'Nguyễn Văn F'	,		4			),
                            (N'Nguyễn Văn G'	,		4			),
                            (N'Nguyễn Văn H'	,		1			),
                            (N'Nguyễn Văn I'	,		5			),
                            (N'Nguyễn Thị K'	,		1			);

INSERT INTO Employee_Skill_Table 	(Employee_Number, Skill_Code		, Date_Registered	)
VALUE								( 	1			,	 'Java'			, '2021-04-22'		),
									( 	2			,	 'Java'			, '2021-02-23'		),
                                    ( 	3			,	 'PHP'			, '2021-03-28'		),
                                    ( 	1			,	 'Java'			, '2021-04-25'		),
                                    ( 	4			,	 'SQL'			, '2021-01-28'		),
                                    ( 	5			,	 'Java'			, '2021-04-17'		),
                                    ( 	1			,	 'SQL'			, '2021-01-28'		),
                                    ( 	2			,	 'Java'			, DEFAULT			),
                                    ( 	1			,	 'PHP'			, '2021-04-13'		),
                                    ( 	3			,	 'HQL'			, '2021-04-28'		);

-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
SELECT DISTINCT 	et.*
FROM 				Employee_Table AS et
INNER JOIN 			Employee_Skill_Table AS es ON et.Employee_Number = es.Employee_Number
WHERE				es.Skill_Code = 'Java';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >= 3 nhân viên
SELECT DISTINCT 	d.Department_Number, d.Department_Name, COUNT(1) AS So_nhan_vien
FROM 				Department AS d
INNER JOIN 			Employee_Table AS et ON et.Department_Number = d.Department_Number
GROUP BY 			d.Department_Number
HAVING				So_nhan_vien >= 3
ORDER BY 			d.Department_Number;

-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban. 
SELECT DISTINCT 	d.Department_Number, et.Employee_Number, et.Employee_Name
FROM 				Department AS d
LEFT JOIN 			Employee_Table AS et ON et.Department_Number = d.Department_Number
ORDER BY 			d.Department_Number ASC;

-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
SELECT DISTINCT 	et.*, COUNT(1) AS So_skill
FROM 				Employee_Table AS et
INNER JOIN 			Employee_Skill_Table AS es ON et.Employee_Number = es.Employee_Number
GROUP BY			et.Employee_Number
HAVING 				So_skill > 1;

