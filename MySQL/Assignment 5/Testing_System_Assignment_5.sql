-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW v_nhanviensale AS
SELECT  	a.*
FROM		`account` a 
INNER JOIN 	department d ON a.DepartmentID = d.DepartmentID
WHERE 		DepartmentName = 'Sale';

SELECT * FROM v_nhanviensale;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW v_MaxGAccount AS
WITH CTE_GetMaxAccount 
AS	(SELECT	MAX(So_account)
	FROM		
			(SELECT 		COUNT(AccountID) AS So_account
			FROM			groupaccount 				
			GROUP BY		AccountID) AS MaxQuestion)
            
SELECT		a.*,COUNT(ga.AccountID) AS So_luong
FROM 		`account` a 
INNER JOIN 	groupaccount ga ON a.AccountID = ga.AccountID
GROUP BY 	ga.AccountID	
HAVING		COUNT(ga.AccountID) = ( SELECT * FROM CTE_GetMaxAccount);
                            
SELECT * FROM v_MaxGAccount;


-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW v_LengthContent AS
SELECT	  	q.*
FROM		question q
WHERE 		LENGTH(Content) > 30;

SELECT * FROM v_LengthContent;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW v_deptmaxaccount AS
WITH CTE_v_DeptMaxAccount AS
		(SELECT 	COUNT(DepartmentID)
		FROM		`account`
        GROUP BY 	DepartmentID
        ORDER BY	COUNT(DepartmentID) DESC
        LIMIT		1)
        
SELECT	  	d.*, COUNT(d.DepartmentID) AS So_luong
FROM		department d
INNER JOIN	`account` a ON a.DepartmentID = d.DepartmentID
GROUP BY 	d.DepartmentID
HAVING		So_luong = (SELECT * FROM CTE_v_DeptMaxAccount);

SELECT * FROM CTE_v_DeptMaxAccount;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW v_NguyenQuestion AS
SELECT	  	q.*, a.FullName
FROM		question q
INNER JOIN	`account` a ON a.AccountID = q.CreatorID
WHERE 		SUBSTRING_INDEX(a.FullName, ' ', 1) = 'Nguyễn';

SELECT * FROM v_NguyenQuestion;