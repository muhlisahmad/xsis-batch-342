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
	student_code char(4),
	code char(4) primary key,
	score int not null
);