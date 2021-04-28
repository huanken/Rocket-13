use testingsystem;
-- Ex 1:  Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT		 a.AccountID, a.Email, a.FullName, d.DepartmentName 
FROM 		`account` a 
INNER JOIN 	department d ON a.DepartmentID = d.DepartmentID;	

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2020
SELECT		 *
FROM 		`account` 
WHERE 		CreateDate < '2020-12-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer 
SELECT		 a.AccountID, a.Email, a.FullName, p.PositionName
FROM 		`account` a 
INNER JOIN 	position p ON a.PositionID = p.PositionID
WHERE 		p.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >=3 nhân viên
SELECT		d.DepartmentName, COUNT(a.DepartmentID) AS So_Luong, group_concat(a.AccountID)
FROM 		`account` a 
INNER JOIN 	department d ON a.DepartmentID = d.DepartmentID
GROUP BY 	a.DepartmentID
HAVING 		So_Luong > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT		q.QuestionID, q.Content, q.CategoryID, q.TypeID, q.CreatorID, q.CreateDate, COUNT(1) AS So_Luong
FROM 		examquestion e
INNER JOIN 	question q ON e.QuestionID = q.QuestionID
GROUP BY 	q.Content	
HAVING 		COUNT(q.Content) = (SELECT	MAX(CountQuestion)
								FROM		
										(SELECT 		COUNT(q.QuestionID) AS CountQuestion
										FROM			examquestion e
										INNER JOIN 		question q ON e.QuestionID = q.QuestionID
										GROUP BY		q.QuestionID) AS MaxQuestion);

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT		c.*, COUNT(q.CategoryID) AS So_Luong
FROM 		categoryquestion c
LEFT JOIN 	question q ON q.CategoryID = c.CategoryID
GROUP BY 	c.CategoryID	
ORDER BY 	So_Luong;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT		q.*, COUNT(q.questionID) AS So_Luong
FROM 		question q
LEFT JOIN 	examquestion eq ON q.QuestionID = eq.QuestionID
GROUP BY 	q.QuestionID	
ORDER BY 	So_Luong DESC;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT		q.QuestionID, q.Content, q.CategoryID, q.TypeID, q.CreatorID, q.CreateDate, COUNT(a.QuestionID) AS So_Luong
FROM 		question q
INNER JOIN 	answer a ON q.QuestionID = a.QuestionID
GROUP BY 	a.QuestionID
HAVING 		So_Luong = (SELECT	MAX(CountAnswer)
						FROM		
							(SELECT COUNT(a.QuestionID) AS CountAnswer	
							FROM	answer a
							RIGHT JOIN  question q ON a.QuestionID = q.QuestionID 
							GROUP BY		q.QuestionID) AS MaxAnswer);

-- Question 9: Thống kê số lượng account trong mỗi group 
SELECT		g.GroupID, g.GroupName, COUNT(ga.AccountID) AS So_Luong_Account
FROM 		`group` g
LEFT JOIN 	groupaccount ga ON g.GroupID = ga.GroupID
GROUP BY 	g.GroupID	
ORDER BY 	So_Luong_Account DESC;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT		p.PositionID, p.PositionName, COUNT(a.AccountID) AS So_Luong_Account
FROM 		position p
LEFT JOIN 	`account` a ON p.PositionID = a.PositionID
GROUP BY	p.PositionID
HAVING 		So_Luong_Account = (SELECT	MIN(CountID)
								FROM		
									(SELECT 	COUNT(a.AccountID)  AS CountID	
									FROM		position p
									RIGHT JOIN  `account` a			 ON p.PositionID = a.PositionID 
									GROUP BY	p.PositionID)		 AS MinAccount);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT		q.QuestionID, q.Content AS Noi_dung, cg.CategoryName AS Category, tq.TypeName AS Loai_cau_hoi, a.FullName AS Nguoi_tao, q.CreateDate AS Ngay_tao, a2.Content AS Tra_loi
FROM 		question q
LEFT JOIN 	categoryquestion cg ON q.CategoryID = cg.CategoryID
LEFT JOIN 	typequestion tq ON q.TypeID = tq.TypeID
LEFT JOIN 	`account` a ON q.CreatorID = a.AccountID
LEFT JOIN 	answer a2 ON q.QuestionID = a2.QuestionID;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT		tq.TypeName AS loai_cau_hoi, COUNT(q.TypeID) AS so_luong
FROM		question q 
INNER JOIN 	TypeQuestion tq ON q.TypeID = tq.TypeID
GROUP BY	q.TypeID;

-- Question 14/15:Lấy ra group không có account nào
SELECT		g.GroupID,g.GroupName
FROM		`group` g
WHERE 		g.GroupID NOT IN (SELECT GroupID
								FROM groupaccount);

-- Question 16: Lấy ra question không có answer nào
SELECT		q.QuestionID, q.Content
FROM		question q
LEFT JOIN 	answer a ON q.QuestionID = a.QuestionID
WHERE 		a.AnswerID IS NULL;

-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
SELECT		a.*
FROM		`account` a
INNER JOIN 	groupaccount ga ON a.AccountID = ga.AccountID
WHERE 		ga.GroupID = 1;
                        
-- b) Lấy các account thuộc nhóm thứ 2
SELECT		a.*
FROM		`account` a
INNER JOIN 	groupaccount ga ON a.AccountID = ga.AccountID
WHERE 		ga.GroupID = 2;

-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT		a.*
FROM		`account` a
INNER JOIN 	groupaccount ga ON a.AccountID = ga.AccountID
WHERE 		ga.GroupID = 1
UNION
SELECT		a.*
FROM		`account` a
INNER JOIN 	groupaccount ga ON a.AccountID = ga.AccountID
WHERE 		ga.GroupID = 2;

-- Question 18: 
-- a) Lấy các group có lớn hơn 5 thành viên
SELECT		g.GroupName, COUNT(ga.AccountID) AS So_thanh_vien
FROM		`group` g
INNER JOIN 	groupaccount ga ON g.GroupID = ga.GroupID
GROUP BY 	g.GroupID
HAVING 		So_thanh_vien > 5;

-- b) Lấy các group có nhỏ hơn 7 thành viên
SELECT		g.GroupName, COUNT(ga.AccountID) AS So_thanh_vien
FROM		`group` g
INNER JOIN 	groupaccount ga ON g.GroupID = ga.GroupID
GROUP BY 	g.GroupID
HAVING 		So_thanh_vien < 7;

-- c) Ghép 2 kết quả từ câu a) và câu b)
SELECT		g.GroupName, COUNT(ga.AccountID) AS So_thanh_vien
FROM		`group` g
INNER JOIN 	groupaccount ga ON g.GroupID = ga.GroupID
GROUP BY 	g.GroupID
HAVING 		So_thanh_vien > 5
UNION ALL
SELECT		g.GroupName, COUNT(ga.AccountID) AS So_thanh_vien
FROM		`group` g
INNER JOIN 	groupaccount ga ON g.GroupID = ga.GroupID
GROUP BY 	g.GroupID
HAVING 		So_thanh_vien < 7;
