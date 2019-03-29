USE master
CREATE DATABASE Mock_project_G2
GO
USE Mock_project_G2
GO

CREATE SCHEMA loggin;
GO
CREATE SCHEMA candidate;
GO
CREATE	SCHEMA trainee;
GO
CREATE	SCHEMA class;
GO
CREATE	SCHEMA trainer;
GO
----create table-------------
--1 users table
CREATE TABLE candidate.Users(
users_id INT PRIMARY KEY IDENTITY(1,1),
users_name VARCHAR(50) UNIQUE NOT NULL,
passwords VARCHAR(50) NOT NULL,
role_id INT,
);
GO
--2 role table
CREATE TABLE candidate.Roles(
role_id INT PRIMARY KEY IDENTITY(1,1),
role_name VARCHAR(50),

);
GO
--3. candidate table
CREATE TABLE candidate.Candidate(
candidate_id INT PRIMARY KEY IDENTITY(1,1),
application_date DATE,
location_id INT,
statuzz VARCHAR(50),
remark VARCHAR(40)
);
GO 
--chanel table
CREATE TABLE candidate.Chanel(
chanel_id INT PRIMARY KEY IDENTITY(1,1),
candidate_id INT,
chanel_name VARCHAR(50),
remarks VARCHAR(50)
)
GO
--offer table
CREATE TABLE candidate.Offer(
offer_id INT PRIMARY KEY IDENTITY(1,1),
candidate_id INT,
job_rank VARCHAR(20),
technology VARCHAR(50),
contact_type VARCHAR(50),
offer_salary DECIMAL,
remarks VARCHAR(50),
)
GO
--EntryTest table
CREATE TABLE candidate.EntryTest(
test_id INT PRIMARY KEY IDENTITY(1,1),
candidate_id INT,
times INT,
dates DATE,
laguage_valuator VARCHAR(50),
laguage_result VARCHAR(20),
technical_valuator VARCHAR(50),
technical_result VARCHAR(20),
result VARCHAR(30),
remarks VARCHAR(50),
)
GO
--interview table
CREATE TABLE candidate.interview(
interview_id INT PRIMARY KEY IDENTITY(1,1),
candidate_id INT,
times INT,
dates DATE,
interviewer VARCHAR(50),
comments TEXT,
result VARCHAR(30),
remarks VARCHAR(50),
);
GO
--candidateProfile table
CREATE TABLE candidate.CandiadteProfile(
profile_id INT PRIMARY KEY IDENTITY(1,1),
candidate_id INT,
full_name VARCHAR(50),
date_of_birth DATE,
gender BIT,
university_id INT,
faculty_id INT,
graduration_year VARCHAR(4),
phone VARCHAR(13),
email VARCHAR(50),
typee VARCHAR(50),
skill VARCHAR(50),
foreign_language VARCHAR(50),
levels VARCHAR(50),
cv VARCHAR(100),
remark VARCHAR(50)
);
GO
--university table 
CREATE TABLE candidate.University(
university_id INT PRIMARY KEY IDENTITY(1,1),
university_name VARCHAR(50),
remark VARCHAR(50)
);
GO
--faculty table
CREATE TABLE candidate.Faculty(
faculty_id INT PRIMARY KEY IDENTITY(1,1),
faculty_name VARCHAR(50),
remark VARCHAR(50)
);
GO
--Class table
CREATE TABLE candidate.Class(
	class_id				INT PRIMARY KEY IDENTITY,
	class_name				VARCHAR(255),
	class_code				VARCHAR(255),
	expected_start_date		DATE,
	expected_end_date		DATE,
	location_id				INT,
	class_admin_id			INT,
	planned_trainee_number	NUMERIC(19,0),
	bud_id					INT,
	bubget_code_id			INT,
	estimated_buget			DECIMAL(11,3),
	subject_type_id			INT,
	dt_id					INT,
	ft_id					INT,
	statuzz					VARCHAR(50),
	[scope_id]				INT,
	sst_id					INT,
	audit_id				INT,
	learning_path			VARCHAR(255),
	trainer_id				INT
)
--History table.
CREATE TABLE candidate.History(
his_id INT PRIMARY KEY IDENTITY(1,1),
candidate_id INT,
his_log TEXT )
GO
--Constant Login.
ALTER TABLE candidate.Users ADD CONSTRAINT FK_users_roles FOREIGN KEY (role_id) REFERENCES candidate.Roles(role_id)
--add constant for Candidate_profile table

GO
ALTER TABLE candidate.CandiadteProfile ADD CONSTRAINT profile_unique UNIQUE(candidate_id)
GO
ALTER TABLE candidate.CandiadteProfile ADD CONSTRAINT FK_profile_candidate FOREIGN KEY (candidate_id) REFERENCES candidate.Candidate(candidate_id);
GO
ALTER TABLE candidate.CandiadteProfile ADD CONSTRAINT FK_profile_University	FOREIGN KEY (university_id) REFERENCES candidate.University(university_id);
GO
ALTER TABLE candidate.CandiadteProfile ADD CONSTRAINT FK_profile_Faculty	FOREIGN KEY (faculty_id) REFERENCES candidate.Faculty(faculty_id);
GO
ALTER TABLE candidate.EntryTest ADD CONSTRAINT FK_entry_candidate	FOREIGN KEY (candidate_id) REFERENCES candidate.Candidate(candidate_id);
GO
ALTER TABLE candidate.interview ADD CONSTRAINT FK_interview_candidate	FOREIGN KEY (candidate_id) REFERENCES candidate.Candidate(candidate_id);
GO
ALTER TABLE candidate.Offer ADD CONSTRAINT FK_offer_candidate	FOREIGN KEY (candidate_id) REFERENCES candidate.Candidate(candidate_id);
GO
ALTER TABLE candidate.Chanel ADD CONSTRAINT FK_chanel_candidate	FOREIGN KEY (candidate_id) REFERENCES candidate.Candidate(candidate_id);
GO
ALTER TABLE candidate.History ADD CONSTRAINT FK_his_candidate	FOREIGN KEY (candidate_id) REFERENCES candidate.Candidate(candidate_id)

