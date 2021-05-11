DROP DATABASE IF EXISTS QL_DoAn;
CREATE DATABASE QL_DoAn;
USE QL_DoAn;

/* 1. Tạo table với các ràng buộc và kiểu dữ liệu
Thêm ít nhất 10 bản ghi vào table: */
DROP TABLE IF EXISTS GiangVien;
CREATE TABLE IF NOT EXISTS GiangVien (
    Id_GV			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Ten_GV		 	NVARCHAR(50) NOT NULL UNIQUE KEY,
    Tuoi			TINYINT UNSIGNED NOT NULL,
    HocVi			ENUM('Ths','Ts','PGS','GS')
);

DROP TABLE IF EXISTS SinhVien;
CREATE TABLE IF NOT EXISTS SinhVien (
    Id_SV			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Ten_SV		 	NVARCHAR(50) NOT NULL,
    NamSinh			DATETIME NOT NULL,
    QueQuan			NVARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS DeTai;
CREATE TABLE IF NOT EXISTS DeTai (
    Id_DeTai	     SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Ten_DeTai		 NVARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS HuongDan;
CREATE TABLE IF NOT EXISTS HuongDan (
    Id				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Id_SV			SMALLINT UNSIGNED NOT NULL,
    Id_DeTai		SMALLINT UNSIGNED NOT NULL,
    Id_GV			SMALLINT UNSIGNED NOT NULL,
    Diem			SMALLINT UNSIGNED NOT NULL,
    FOREIGN KEY (Id_SV) REFERENCES SinhVien(Id_SV),
    FOREIGN KEY (Id_DeTai) REFERENCES DeTai(Id_DeTai),
    FOREIGN KEY (Id_GV) REFERENCES Giangvien(Id_GV)
);

INSERT INTO GiangVien (Ten_GV,		   Tuoi,	Hocvi)
VALUES 				  ('Giang Vien 1', 25, 		'TS'),
					  ('Giang Vien 2', 21, 		'PGS'),
                      ('Giang Vien 3', 22, 		'ThS'),
                      ('Giang Vien 4', 25, 		'TS'),
                      ('Giang Vien 5', 29, 		'PGS'),
                      ('Giang Vien 6', 26, 		'TS'),
                      ('Giang Vien 7', 30, 		'PGS'),
                      ('Giang Vien 8', 25, 		'TS'),
                      ('Giang Vien 9', 40, 		'ThS'),
                      ('Giang Vien 10', 27,		'TS');

INSERT INTO SinhVien (Ten_SV,		   NamSinh,	   			 QueQuan)
VALUES 				  ('Sinh Vien 1', '2001-01-01', 		'Ha Noi'),
					  ('Sinh Vien 2', '2002-01-01', 		'Ha Noi'),
                      ('Sinh Vien 3', '2000-01-01', 		'Ha Noi'),
                      ('Sinh Vien 4', '2001-01-01', 		'Ha Noi'),
                      ('Sinh Vien 5', '2000-01-01', 		'Ha Noi'),
                      ('Sinh Vien 6', '2001-01-01', 		'Ha Noi'),
                      ('Sinh Vien 8', '2000-01-01', 		'Ha Noi'),
                      ('Sinh Vien 7', '2001-01-01', 		'Ha Noi'),
                      ('Sinh Vien 9', '2000-01-01', 		'Ha Noi'),
                      ('Sinh Vien 10','2002-01-01', 		'Ha Noi');

INSERT INTO DeTai (Ten_DeTai)
VALUES 			 ('De Tai 1'),
				 ('De Tai 2'),
                 ('De Tai 3'),
                 ('De Tai 4'),
                 ('De Tai 5'),
                 ('De Tai 6'),
                 ('De Tai 7'),
                 ('De Tai 8'),
                 ('De Tai 9'),
                 ('De Tai 10');

INSERT INTO HuongDan (Id_SV,   Id_DeTai, Id_GV,Diem)
VALUES 				 (1    ,      3,      5,    9   ),
					 (2    ,      1,      1,    8   ),
                     (3    ,      2,      2,    9   ),
                     (2    ,      6,      5,    9   ),
                     (5    ,      3,      5,    7   ),
                     (5    ,      6,      8,    9   ),
                     (1    ,      3,      9,    9   ),
                     (1   ,       5,      5,    5    ),
                     (9    ,      3,      5,    9   ),
                     (9    ,      4,      4,    9   );

-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT 		s.*
FROM   		huongdan h
RIGHT JOIN  sinhvien s ON h.Id_SV = s.Id_SV
WHERE		h.Id_SV IS NULL;

-- b) Lấy ra số sinh viên làm đề tài ‘DeTai 6’ 
SELECT 		COUNT(1) AS So_Sinh_Vien
FROM   		huongdan h
INNER JOIN  detai d ON  h.Id_DeTai = d.Id_DeTai
INNER JOIN  sinhvien s ON h.Id_SV = s.Id_SV
WHERE		d.Ten_DeTai LIKE 'De Tai 6';

/* 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
mã số, họ tên và tên đề tài
(Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có") */
DROP VIEW IF EXISTS SinhVienInfo;
CREATE OR REPLACE VIEW SinhVienInfo AS
SELECT 		s.Id_SV, s.Ten_SV, d.Ten_DeTai
FROM   		huongdan h
INNER JOIN  detai d ON  h.Id_DeTai = d.Id_DeTai
INNER JOIN  sinhvien s ON h.Id_SV = s.Id_SV
UNION
SELECT 		s.Id_SV, s.Ten_SV, 'Chua co'
FROM   		huongdan h
RIGHT JOIN  sinhvien s ON h.Id_SV = s.Id_SV
WHERE       h.Id_SV IS NULL;

SELECT * FROM SinhVienInfo;

/* 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1950
thì hiện ra thông báo "Moi ban kiem tra lai nam sinh */
DROP TRIGGER IF EXISTS trg_check_birthday;
DELIMITER $$
CREATE TRIGGER trg_check_birthday 
BEFORE INSERT ON sinhvien
FOR EACH ROW
BEGIN
	DECLARE v_namsinh INT;
    SELECT YEAR(NamSinh) INTO v_namsinh FROM Sinhvien WHERE NamSinh = NEW.NamSinh;
	IF v_namsinh <= 1950 THEN
	SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT = 'Moi ban kiem tra lai nam sinh';
    END IF;
END $$
DELIMITER ;

INSERT INTO SinhVien (Ten_SV,		 NamSinh, 	  QueQuan)
VALUES 				 ('Sinh vien X','1945-01-01','Ha Noi');

INSERT INTO SinhVien (Ten_SV,		 NamSinh, 	  QueQuan)
VALUES 				 ('Sinh vien Y','2007-01-01','Ha Noi');

/* 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi */
DROP TRIGGER IF EXISTS trg_del_student;
DELIMITER $$
CREATE TRIGGER trg_del_student 
BEFORE DELETE ON sinhvien
FOR EACH ROW
BEGIN
	DELETE FROM huongdan 
    WHERE  Id_SV = OLD.Id_SV;
END $$
DELIMITER ;

DELETE FROM sinhvien
WHERE 		Id_SV = 9;

/* 6. Viết 1 Procedure để khi nhập vào tên của sinh viên thì sẽ thực hiện xóa toàn bộ thông tin 
liên quan của sinh viên trên hệ thống */
DROP PROCEDURE IF EXISTS proc_del_student;
DELIMITER $$
CREATE PROCEDURE proc_del_student (IN in_tensv NVARCHAR(50))
BEGIN
	DECLARE v_id_sv INT;
    SELECT Id_SV INTO v_id_sv FROM sinhvien WHERE Ten_SV = in_tensv;
    DELETE FROM huongdan
    WHERE		Id_SV = v_id_sv;
	DELETE FROM sinhvien
    WHERE		Id_SV = v_id_sv;
END $$
DELIMITER ;

CALL proc_del_student('Sinh vien X');