/* 2. Viết câu lệnh query 
a) Get lương tháng 5 của 1 user bất kì. */
SELECT 		 SUM(s.total_salary)
FROM  		 salary s
INNER JOIN 	 user_role ur ON s.user_role_id = ur.id 
INNER JOIN 	 user_department ud ON ud.id = ur.user_department_id
INNER JOIN 	 users u ON u.id = ud.user_id 
WHERE 		 `month` = '5' AND u.id = 1;

/* b) Get danh sách lương tháng 5 của 1 phòng bất kì sắp xếp theo tổng 
lương giảm dần. */
SELECT 		 u.id,u.first_name,u.last_name,s.total_salary
FROM  		 salary s
INNER JOIN 	 user_role ur ON s.user_role_id = ur.id 
INNER JOIN 	 user_department ud ON ud.id = ur.user_department_id
INNER JOIN 	 users u ON u.id = ud.user_id 
WHERE 		 `month` = '5' AND u.department_id = 1
GROUP BY	 u.id
ORDER BY 	 s.total_salary DESC;

/* c) Get nhưng user bị tính lương sai(total_salary != total detail salary) 
trong tháng 5/2020 */
 
/* d) Get tổng chi phí của các phòng trong tháng 5/2021 */
SELECT 		 d.`name`,SUM(s.total_salary)
FROM  		 salary s
INNER JOIN 	 user_role ur ON s.user_role_id = ur.id 
INNER JOIN 	 user_department ud ON ud.id = ur.user_department_id
INNER JOIN 	 departments d ON d.id = ud.department_id
WHERE 		 `month` = '5'
GROUP BY	 d.id;

/* 3. Viết thủ tục cho phép get chi tiết lương tháng của 1 user bất kì 
hiển thị thông tin sau: Type, Amount, Operation; sao cho hàng 
cuối cùng sẽ là cột tổng */

/* 4. Viết thủ tục cho phép get lương tháng của 1 user bất kì hiển thị thông tin 
sau: fullname (first_name + last_name), department, role, salary */
DROP PROCEDURE IF EXISTS proc_get_salary_user;
DELIMITER $$
CREATE PROCEDURE proc_get_salary_user (IN in_month TINYINT(2), IN in_id_user SMALLINT)
BEGIN
	SELECT 		 CONCAT(u.first_name,' ',u.last_name) AS FullName,d.`name` AS Department,r.`name` AS `Role`,SUM(s.total_salary) AS Total_Salary
	FROM  		 salary s
	INNER JOIN 	 user_role ur ON s.user_role_id = ur.id 
	INNER JOIN 	 user_department ud ON ud.id = ur.user_department_id
	INNER JOIN 	 users u ON u.id = ud.user_id 
    INNER JOIN   departments d ON d.id = ud.department_id
    INNER JOIN   roles r ON r.id = ur.role_id
	WHERE 		 `month` = in_month AND u.id = in_id_user;
END $$
DELIMITER ;

CALL proc_get_salary_user(4,2);

/* 5. Viết trigger cho phép khi insert data role của 1 user trong phòng thì 
khoảng thời gian các role phải khác nhau và nằm trong khoảng thời gian 
của user nằm trong phòng đó. 
Ví dụ: user A nằm thuộc phòng Admin từ 1/4/2020 đến 1/8/2020, user A 
có role Nhân viên từ 1/4/2020-1/6/2020 thì khi user đó lên trưởng phòng 
Admin thì phải nằm trong khoảng 1/4/2020-1/8/2020 và khác khoảng 
1/4/2020 và 1/6/2020. */
