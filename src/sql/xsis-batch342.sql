-- Create table lecturer_types
create table public.lecturer_types(
	code char(4) primary key,
	description varchar(20)
);

-- Create table exams
create table public.exams (
	code char(4) primary key,
	name varchar(20) not null,
	status boolean default true
);

-- Create table religions
create table public.religions (
	code char(4) primary key,
	description varchar(20) not null
);

-- Create table majors
create table public.majors (
	code char(4) primary key,
	name varchar(50) not null,
	status boolean default true
);

-- Create table lecturers
create table public.lecturers (
	code char(4) primary key,
	name varchar(50) not null,
	type_code char(4),
	major_code char(4),
	foreign key (type_code) references public.lecturer_types(code)
		on delete cascade
		on update cascade,
	foreign key (major_code) references public.majors(code)
		on delete cascade
		on update cascade
);

-- Create table students
create table public.students (
	code char(4) primary key,
	name varchar(50) not null,
	address varchar(150) not null,
	religion_code char(4),
	major_code char(4),
	foreign key (religion_code) references public.religions(code)
		on delete cascade
		on update cascade,
	foreign key (major_code) references public.majors(code)
		on delete cascade
		on update cascade
);

-- Create table scores
create table public.scores (
	id serial primary key,
	student_code char(4),
	exam_code char(4),
	foreign key (student_code) references public.students(code)
		on delete cascade
		on update cascade,
	foreign key (exam_code) references public.exams(code)
		on delete cascade
		on update cascade,
	score int not null
);

-- Insert lecturer_types seed data
insert into public.lecturer_types (code, description)
values ('T001', 'Tetap'), ('T002', 'Honorer'), ('T003', 'Expertise');

-- Insert exams seed data
insert into public.exams (code, name, status) values 
('U001', 'Algoritma', true),
('U002', 'Aljabar', true),
('U003', 'Statistika', false),
('U004', 'Etika Profesi', false),
('U005', 'Bahasa Inggris', true);

-- Insert religions seed data
insert into public.religions (code, description) values
('A001', 'Islam'),
('A002', 'Kristen'),
('A003', 'Katolik'),
('A004', 'Hindu'),
('A005', 'Budha');

-- Insert majors seed data
insert into public.majors (code, name, status) values
('J001', 'Teknik Informatika', true),
('J002', 'Management Informatika', true),
('J003', 'Sistem Informasi', false),
('J004', 'Sistem Komputer', true),
('J005', 'Komputer Akuntasi', false);

-- Insert lecturer seed data
insert into public.lecturers (code, name, major_code, type_code) values
('D001', 'Prof. Dr. Retno Wahyuningsih', 'J001', 'T002'),
('D002', 'Prof. Roy M. Sutikno', 'J002', 'T001'),
('D003', 'Prof. DrHendri A. Verburgh', 'J003', 'T002'),
('D004', 'Prof. Risma Suparwata', 'J004', 'T002'),
('D005', 'Prof. Amir Sjarifdudni Madjid, MM, MA', 'J005', 'T001');

-- Insert students seed data
insert into public.students (code, name, address, religion_code, major_code) values
('M001', 'Budi Gunawan', 'Jl. Mawar No 3 RT 05 Cicalengka, Bandung', 'A001', 'J001'),
('M002', 'Rinto Raharjo', 'Jl. Kebagusan No. 33 RT04 RW06 Bandung', 'A002', 'J002'),
('M003', 'Asep Saepudin', 'Jl. Sumatera No. 12 RT02 RW01, Ciamis', 'A001', 'J003'),
('M004', 'M. Hafif Isbullah', 'Jl. Jawa No 01 RT01 RW01, Jakarta Pusat', 'A001', 'J001'),
('M005', 'Cahyono', 'Jl. Niagara No. 54 RT01 RW09, Surabaya', 'A003', 'J002');

-- Insert scores seed data
insert into public.scores (student_code, exam_code, score) values
('M004', 'U001', 90),
('M001', 'U002', 80),
('M002', 'U003', 85),
('M004', 'U002', 95),
('M005', 'U005', 70);

-- 1. Buatlah query untuk mengubah colum Nama_Dosen dengan type data varchar dengan panjang 200 pada table Dosen
alter table public.lecturers
alter column name
set data type varchar(200);

-- 2. Buatlah query untuk menampilkan data berikut:
--|---------|--------------|--------------------|-------|
--|M001     |Budi Gunawan  |Teknik Informatika  |Islam  |
--|---------|--------------|--------------------|-------|
select * from public.students as s where s.code='M001';

-- 3. Buatlah query untuk menampilkan data mahasiswa yang mengambil jurusan dengan Status Jurusan = Non Aktif
select s.code, s.name, m.name as major_name
from public.students as s
join public.majors as m
on s.major_code = m.code
where m.status = false;

-- 4. Buatlah query untuk menampilkan data mahasiswa dengan nilai diatas 80 untuk ujian dengan Status Ujian = aktif
select s.code, s.name, e.name, sc.score 
from public.students as s
join public.scores as sc
on sc.student_code = s.code 
join public.exams as e 
on e.code = sc.exam_code 
where sc.score >= 80
and e.status = true;

