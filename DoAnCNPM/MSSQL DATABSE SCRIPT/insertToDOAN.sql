go
use DB_DOAN_QLHS
go
insert into AccountManage (username,password,privilege) values ('admin','admin','admin');
insert into AccountManage (username,password,privilege) values ('user','user','');
go
insert into KHOI VALUES (N'10',N'KHOI 10',5);
insert into KHOI VALUES (N'11',N'KHOI 11',4);
insert into KHOI VALUES (N'12',N'KHOI 12',3);
go
insert into LOP values (N'10a',N'10',N'10a1',0);
insert into LOP values (N'10b',N'10',N'10a2',0);
insert into LOP values (N'10c',N'10',N'10a3',0);
insert into LOP values (N'10d',N'10',N'10a4',0);
insert into LOP values (N'10e',N'10',N'10a5',0);
insert into LOP values (N'11a',N'11',N'11a1',0);
insert into LOP values (N'11b',N'11',N'11a2',0);
insert into LOP values (N'11c',N'11',N'11a3',0);
insert into LOP values (N'11d',N'11',N'11a4',0);
insert into LOP values (N'12a',N'12',N'12a1',0);
insert into LOP values (N'12b',N'12',N'12a2',0);
insert into LOP values (N'12c',N'12',N'12a3',0);
go
insert into LOAIKIEMTRA values ('15',N'Kiểm tra 15 phút');
insert into LOAIKIEMTRA values ('45',N'Kiểm tra 45 phút');
insert into LOAIKIEMTRA values ('hk',N'Kiểm tra học kì');
go
insert into MONHOC values ('To',N'Toán');
insert into MONHOC values ('Ly',N'Lý');
insert into MONHOC values ('Ho',N'Hóa');
insert into MONHOC values ('Va',N'Văn');
insert into MONHOC values ('DD',N'Đạo đức');
insert into MONHOC values ('Si',N'Sinh');
insert into MONHOC values ('Su',N'Sử');
insert into MONHOC values ('Di',N'Địa');
insert into MONHOC values ('TD',N'Thể Dục');
go
insert into HOCKY values ('HK1',N'Học kì 1');
insert into HOCKY values ('HK2',N'Học kì 2');
go
insert into NAMHOC values ('K17',N'Năm học 2017-2020','')
insert into NAMHOC values ('K18',N'Năm học 2018-2021','')

GO

create view [dbo].[MaHSview]
AS
	select count(MaHocSinh) [sl]
	from TIEPNHAN_HS
GO
create proc [dbo].[FillBDFromLop] @MaLop nvarchar(10)
as 
	select c.*
	from CT_BANGDIEM c,BANG_DIEM_HS b,LOP l
	where c.MaBangDiem=b.MaBangDiem and b.MaLop=l.MaLop and l.MaLop=@MaLop
GO
CREATE proc [dbo].[fillNhapDiem] @MaBD int 
as
	select d.*,b.MaLop,b.MaBangDiem
	from DANHSACH_HS d,BANG_DIEM_HS b
	where d.MaHocSinh=b.MaHocSinh and b.MaBangDiem=@MaBD
GO
CREATE proc [dbo].[NhapDiem] @MaLop nvarchar(10)
as
	select d.*,b.MaBangDiem,b.MaLop
	from DANHSACH_HS d,BANG_DIEM_HS b,LOP l
	where d.MaHocSinh=b.MaHocSinh and b.MaLop=l.MaLop and b.MaLop like @MaLoP
GO
CREATE TRIGGER [dbo].[trg_inshs] ON [dbo].[TIEPNHAN_HS]
FOR INSERT
AS
BEGIN
	declare @lastID varchar(5) 
	if((select COUNT(MaHocSinh) from TIEPNHAN_HS)=1)
	BEGIN
		if((select count(MaHocSinh) from DANHSACH_HS)=0)
		BEGIN
			update TIEPNHAN_HS set MaHocSinh= 'HS0' where MaHocSinh=''
		END
		else
		BEGIN
			set @lastID = CONVERT(INT,SUBSTRING ((select top 1 MaHocSinh from DANHSACH_HS order by MaHocSinh desc),3,5)+1)
			update TIEPNHAN_HS set MaHocSinh= 'HS'+@lastID WHERE MaHocSinh=''
		END
	END
	else
	BEGIN
		set @lastID = CONVERT(INT,SUBSTRING ((select top 1 MaHocSinh from TIEPNHAN_HS order by MaHocSinh desc),3,5)+1)
		update TIEPNHAN_HS set MaHocSinh= 'HS'+@lastID WHERE MaHocSinh=''
	END
END
GO

