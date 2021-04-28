USE Testing_System_Assignment_1;

-- 	2. Lấy ra tất cả các phòng ban
SELECT 	*
FROM	department;
    
--  3. Lấy ra id của phòng ban "Sale"
SELECT 	DepartmentID
FROM	department
WHERE	DepartmentName = 'Sale';

--  4. Lấy ra thông tin account có full name dài nhất
SELECT  *
FROM	`account` AS a
WHERE	LENGTH(a.FullName) = 
		(SELECT MAX(LENGTH(FullName))
         FROM	`account`);
            
--  5. Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
WITH		 CTE_dep3 AS (
	SELECT 	 * FROM `account` WHERE DepartmentID = 3
)
SELECT  	 *
FROM		 CTE_dep3 
WHERE		 LENGTH(FullName) = 
			 (SELECT 	MAX(LENGTH(FullName)) FROM CTE_dep3)
ORDER BY	 Fullname;		

--  6. Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT  GroupName
FROM	`group`
WHERE	CreateDate < '2019-12-20';
    
--  7. Lấy ra ID của question có >= 4 câu trả lời
SELECT 		QuestionID
FROM		answer
GROUP BY 	QuestionID
HAVING 		COUNT(1) >= 4;

--  8.  Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT 	`code`
FROM	exam
WHERE	Duration	 > 60
AND 	CreateDate 	 > '2019-12-20';
        
--  9. Lấy ra 5 group được tạo gần đây nhất
SELECT 		*
FROM		`group`
ORDER BY 	CreateDate DESC
LIMIT 		5;

--  10. Đếm số nhân viên thuộc department có id = 2
SELECT 	COUNT(AccountID)
FROM	`account`
WHERE	DepartmentID = 2;

--  11. Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT 	*
FROM	`account`
WHERE	SUBSTRING_INDEX(FullName, '.', 1) LIKE 'D%o';

--  12. Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE 
FROM 	exam
WHERE	CreateDate	 < '2019-12-20';

--  13. Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE 
FROM 	question
WHERE	SUBSTRING_INDEX(Content, '.', 2) 	LIKE 'câu hỏi%';
    
--  14. Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE 	`account` 
SET 	FullName	 = N'Nguyễn Bá Lộc',
		Email		 = 'loc.nguyenba@vti.com.vn'
WHERE	AccountID	 = 5;

--  15. Update account có id = 5 sẽ thuộc group có id = 4
UPDATE 	groupaccount 
SET 	GroupID = 4
WHERE	AccountID = 5;
