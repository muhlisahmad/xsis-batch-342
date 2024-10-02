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
where sc.score > 80
and e.status = true;

-- 5. Buatlah query untuk menampilkan data jurusan yang mengandung kata 'sistem'
select * from public.majors as m 
where m."name" ilike '%sistem%';

-- 6. Buatlah query untuk menampilkan mahasiswa yang mengambil ujian lebih dari 1
select x.code, s."name", e."name", sc.score 
from public.students s 
join (
	select s.code, count(*)
	from public.students s 
	join public.scores sc
	on sc.student_code = s.code
	group by s.code
	having count(*) > 1) as x
on x.code = s.code 
join public.scores sc
on sc.student_code = s.code
join public.exams e 
on e.code = sc.exam_code;

-- 7. Buatlah query untuk menampilkan data seperti berikut:
-- |===================|=================|======================|==========|================================|===============|===============|
-- |Student Code	   |Student Name	 |Major	  				|Religion  |Lecturer						|Major Status	|Description	|
-- |M001			   |Budi Gunawan	 |Teknik Informatika	|Islam	   |Prof. Dr. Retno Wahyuningsih	|Aktif			|Honorer		|
-- |===================|=================|======================|==========|================================|===============|===============|
select
	s.code as "Student Code",
	s."name" as "Student Name",
	m."name" as "Major",
	r.description as "Religion",
	l."name" as "Lecturer",
case
	when m.status is true then 'Aktif'
	else 'Tidak Aktif'
end as "Major Status",
	lt.description as "Description"
from public.students s 
join public.majors m 
on m.code = s.major_code 
join public.religions r 
on r.code = s.religion_code 
join public.lecturers l 
on l.major_code = m.code 
join public.lecturer_types lt 
on lt.code = l.type_code
where s.code = 'M001';

-- 8. Buatlah query untuk create view dengan menggunakan data pada no. 7, beserta query untuk mengeksekusi view tersebut
create view sv as
select
	s.code as "Student Code",
	s."name" as "Student Name",
	m."name" as "Major",
	r.description as "Religion",
	l."name" as "Lecturer",
case
	when m.status is true then 'Aktif'
	else 'Tidak Aktif'
end as "Major Status",
	lt.description as "Description"
from public.students s 
join public.majors m 
on m.code = s.major_code 
join public.religions r 
on r.code = s.religion_code 
join public.lecturers l 
on l.major_code = m.code 
join public.lecturer_types lt 
on lt.code = l.type_code
where s.code = 'M001';

select * from sv;

-- 9. Buatlah query untuk menampilkan data mahasiswa beserta nilainya (mahasiswa yang tidak punya nilai juga ditampilkan)
select 
	s.code,
	s."name" as "student name",
	coalesce(e."name", '-') as "exams",
	coalesce(sc.score, 0)
from public.students s 
left join public.scores sc
on s.code = sc.student_code
left join public.exams e 
on e.code = sc.exam_code;

-- Day 2 SQL
create schema if not exists company;

create table company.position (
	id bigserial primary key,
	name varchar(100) not null
);

create table company.biodata (
	id bigserial primary key,
	first_name varchar(20) not null,
	last_name varchar(30) not null,
	dob date not null,
	pob varchar(50) not null,
	address varchar(255) not null,
	marital_status boolean not null
);

create table company.departement (
	id bigserial primary key,
	name varchar(100) not null
);

create table company.leave (
	id bigserial primary key,
	type varchar(10) not null,
	name varchar(100) not null
);

create table company.family (
	id bigserial primary key,
	biodata_id bigint,
	name varchar(100),
	status varchar(50),
	foreign key (biodata_id) references company.biodata(id)
		on delete cascade
		on update cascade
);

create table company.travel_type (
	id bigserial primary key,
	name varchar(50) not null,
	travel_fee int not null
);

create table company.employee (
	id bigserial primary key,
	biodata_id bigint,
	nip varchar(5) not null,
	status varchar(10) not null,
	salary varchar(10) not null,
	foreign key (biodata_id) references company.biodata(id)
		on delete cascade
		on update cascade
);

create table company.employee_position (
	id bigserial primary key,
	employee_id bigint,
	position_id bigint,
	foreign key (employee_id) references company.employee(id)
		on delete cascade
		on update cascade,
	foreign key (position_id) references company.position(id)
		on delete cascade
		on update cascade
);

create table company.travel_request (
	id bigserial primary key,
	employee_id bigint,
	travel_type_id bigint,
	start_date date not null,
	end_date date not null,
	foreign key (employee_id) references company.employee(id)
		on delete cascade
		on update cascade,
	foreign key (travel_type_id) references company.travel_type(id)
		on delete cascade
		on update cascade
);

create table company.travel_settlement (
	id bigserial primary key,
	travel_request_id bigint,
	item_name varchar(100) not null,
	item_cost int not null,
	foreign key (travel_request_id) references company.travel_request(id)
		on delete cascade
		on update cascade
);

create table company.leave_request (
	id bigserial primary key,
	employee_id bigint,
	leave_id bigint,
	start_date date not null,
	end_date date not null,
	reason varchar(255),
	foreign key (employee_id) references company.employee(id)
		on delete cascade
		on update cascade,
	foreign key (leave_id) references company.leave(id)
		on delete cascade
		on update cascade
);

create table company.employee_leave (
	id bigserial primary key,
	employee_id bigint,
	period varchar(4) not null,
	regular_quota int not null,
	foreign key (employee_id) references company.employee(id)
		on delete cascade
		on update cascade
);

create table company.contact_person (
	id bigserial primary key,
	biodata_id bigint,
	type varchar(5) not null,
	contact varchar(100) not null,
	foreign key (biodata_id) references company.biodata(id)
		on delete cascade
		on update cascade
);

-- Data Insertion

insert into company."position" (name) values
('Direktur'),
('General Manager'),
('Manager'),
('Staff');

insert into company.biodata (first_name, last_name, dob, pob, address, marital_status) values
('Raya', 'Indriyani', '1991-01-01', 'Bali', 'Jl. Raya Baru, Bali', false),
('Rere', 'Wulandari', '1991-01-02', 'Bandung', 'Jl. Berkah Ramadhan, Bandung', false),
('Bunga', 'Maria', '1991-03-03', 'Jakarta', 'Jl. Mawar Semerbak, Bogor', true),
('Natasha', 'Wulan', '1990-04-10', 'Jakarta', 'Jl. Mawar Harum, Jakarta', false),
('Zahra', 'Aurelia Putri', '1991-03-03', 'Jakarta', 'Jl. Mawar Semerbak, Bogor', true),
('Katniss', 'Everdeen', '1989-01-12', 'Jakarta', 'Jl. Bunga Melati, Jakarta', true);

insert into company.departement (name) values
('Recruitment'),
('Sales'),
('Human Resource'),
('General Affair');

insert into company.travel_type (name, travel_fee) values
('In Indonesia', 200000),
('Out Indonesia', 350000);

insert into company.leave (type, name) values
('Regular', 'Cuti Tahunan'),
('Khusus', 'Cuti Menikah'),
('Khusus', 'Cuti Haji & Umroh'),
('Khusus', 'Melahirkan');

insert into company.employee (biodata_id, nip, status, salary) values
(1, 'NX001', 'Permanen', 12000000),
(2, 'NX002', 'Kontrak', 15000000),
(4, 'NX003', 'Permanen', 13500000),
(5, 'NX004', 'Permanen', 12000000),
(6, 'NX005', 'Permanen', 17000000),
(3, 'NX006', 'Kontrak', 15000000);

insert into company.contact_person (biodata_id, type, contact) values
(1, 'MAIL', 'raya.indriyani@gmail.com'),
(1, 'PHONE', '085612345678'),
(2, 'MAIL', 'rere.wulandari@gmail.com'),
(2, 'PHONE', '081312345678'),
(2, 'PHONE', '087812345678'),
(3, 'MAIL', 'bunga.maria@gmail.com'),
(4, 'MAIL', 'natasha.wulan@gmail.com'),
(5, 'MAIL', 'zahra.putri@gmail.com'),
(6, 'MAIL', 'katniss.everdeen@gmail.com');

insert into company.employee_leave (employee_id, period, regular_quota) values
(1, '2020', 16),
(2, '2020', 12),
(1, '2021', 16),
(2, '2021', 12),
(4, '2021', 12),
(5, '2021', 12),
(6, '2021', 12);

insert into company.leave_request (employee_id, leave_id, start_date, end_date, reason) values
(1, 1, '2020-10-10', '2020-10-12', 'Liburan'),
(1, 1, '2020-11-12', '2020-11-15', 'Acara keluarga'),
(2, 2, '2020-05-05', '2020-05-07', 'Menikah'),
(2, 1, '2020-09-09', '2020-09-13', 'Touring'),
(2, 1, '2020-12-24', '2020-12-25', 'Acara keluarga');

insert into company.travel_request (employee_id, travel_type_id, start_date, end_date) values
(1, 1, '2020-07-07', '2020-07-08'),
(1, 1, '2020-08-07', '2020-08-08'),
(2, 2, '2020-04-04', '2020-04-07');

insert into company.travel_settlement (travel_request_id, item_name, item_cost) values
(1, 'Tiket travel Do-Car berangkat', 165000),
(1, 'Hotel', 750000),
(1, 'Tiket travel Do-Car pulang', 165000),
(2, 'Tiket pesawat berangkat', 750000),
(2, 'Hotel', 650000),
(2, 'Tiket pesawat pulang', 1250000),
(3, 'Tiket pesawat berangkat', 4750000),
(3, 'Hotel', 6000000),
(2, 'Tiket pesawat pulang', 4250000);

insert into company."family" (biodata_id, "name", status) values
(3, 'Azka Fadlan Zikrullah', 'Suami'),
(3, 'Primrose Everdeen', 'Anak'),
(5, 'Jaka Samudera Buana', 'Suami'),
(5, 'Friska Davira', 'Anak'),
(5, 'Harum Indah Az Zahra', 'Anak'),
(6, 'Adya Pratama Yuda', 'Suami');

insert into company.employee_position (employee_id, position_id) values
(5, 1),
(4, 2),
(3, 3),
(2, 4),
(1, 4);

-- 1. Urutkan nama-nama karyawan dan statusnya, diurutkan dari yang paling tua ke yang paling muda
select b.first_name, b.last_name, b.marital_status, b.dob
from company.biodata b 
join company.employee e 
on e.biodata_id = b.id
order by b.dob asc;

-- 2. Tampilkan last name dengan huruf capital dimana last name nya diawali dengan huruf ?M?
select b.last_name 
from company.biodata b
where b.last_name like 'M%';