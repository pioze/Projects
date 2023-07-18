CREATE DATABASE projectTask2final;
USE projectTask2final;

/* a) */

/*Creating Faculty Table*/

CREATE TABLE s_faculty(
    fac_code CHAR(2) NOT NULL,
    fac_name VARCHAR(32),
    fac_head INT(6) UNIQUE, /**/
    PRIMARY KEY(fac_code)
);

/*Inserting values into Faculty Table*/

INSERT INTO s_faculty VALUES
('MT', 'Mathematics', 774040),
('PH', 'Physics', 302122),
('CS', 'Computer Science', 706463),
('EL', 'English Language', 922410),
('MS', 'Media Studies', 912100);

SELECT * FROM s_faculty;
DROP TABLE s_faculty;

/*Creating Staff Table*/

CREATE TABLE s_staff(
    staffnr INT(6) NOT NULL, /**/
    surname VARCHAR(15),
    initials VARCHAR(4),
    office_nr VARCHAR(3),
    job VARCHAR(15),
    salary DECIMAL(8,2),
    bonus DECIMAL(8,2),
    PRIMARY KEY (staffnr)
);

/*Inserting values into Staff Table*/

INSERT INTO s_staff VALUES
(100422, 'Faraz', 'MF', 'B77', 'Dean', 63000, 5000),
(100390, 'Qabil', 'AQ', 'C40', 'Lecturer', 58000, 5500),
(100760, 'Paracha', 'BP', 'S36', 'Assistant', 56000, 4000),
(400277, 'Kashif', 'SK', 'P90', 'Artisan', 24300, 2700),
(803040, 'Jefferson', 'RJ', 'A22', 'Librarian', 3000, 275),
(400634, 'Qadir', 'AQ', 'I33', 'Director', 4500, 1500),
(422377, 'Fury', 'TF', 'F22', 'Janitor', 3000, 500),
(966840, 'Paul', 'JP', 'S11', 'Security', 5000, 600),
(144533, 'Saleh', 'AS', 'M9', 'Receptionist', 5500, 490);

SELECT * FROM s_staff;
DROP TABLE s_staff;

/*Create Diploma Table*/

CREATE TABLE s_diploma(
    dip_code CHAR(2) NOT NULL,
    dip_name VARCHAR(25),
    dip_head INT(6), /**/
    fac_code CHAR(2),
    PRIMARY KEY (dip_code),
    FOREIGN KEY (fac_code) REFERENCES s_faculty(fac_code),
    FOREIGN KEY (dip_head) REFERENCES s_staff(staffnr)
);

/*Insert values into Diploma Table*/

INSERT INTO s_diploma VALUES
('J2', 'Algebra', 100422, 'MT'),
('S7', 'Nuclear Physics', 100390, 'PH'),
('L9', 'Artificial Intelligence', 100760, 'CS'),
('M8', 'Modernist Literature', 400277, 'EL'),
('R3', 'Public Relations', 400634, 'MS');

SELECT * FROM s_diploma;
DROP TABLE s_diploma;

/*Create Student Table*/

CREATE TABLE s_student(
    studnr INT(8) NOT NULL, /**/
    surname VARCHAR(15),
    initials VARCHAR(15),
    sex CHAR(1),
    birthdate DATE,
    PRIMARY KEY (studnr)
);

/*Insert values into Student Table*/

INSERT INTO s_student VALUES
(80704060, 'Bravo', 'DB', 'M', '2003-06-06'),
(90043005, 'Smith', 'OS', 'M', '2002-09-11'),
(66304226, 'Perry', 'EP', 'F', '2004-04-04'),
(40093929, 'Niekerk', 'DVK', 'F', '2003-07-10'),
(12288740, 'MKASI', 'GM', 'F', '2002-02-07'),
(07423477, 'Lanning', 'ML', 'F', '2005-12-02');

SELECT * FROM s_student;
DROP TABLE s_student;

/*Create Subject Table*/

CREATE TABLE s_subject(
    subj_code CHAR(3) NOT NULL,
    subj_name VARCHAR(25),
    subj_fee DECIMAL(6,2),
    dip_code CHAR(2),
    prereq CHAR(3),    
	headnr INT(6), /**/
    PRIMARY KEY (subj_code),
    FOREIGN KEY (headnr) REFERENCES s_staff(staffnr),
    FOREIGN KEY (dip_code) REFERENCES s_diploma(dip_code)
);

/*Insert values into Subject Table*/

INSERT INTO s_subject VALUES
('MTH', 'Mathematics', 8250.50, 'J2', 'SCI', 100422),
('PHY', 'Physics', 8100.00, 'S7', 'ENG', 100390),
('CMP', 'Computer Science', 9200.75, 'L9', 'MTH', 100760),
('ENG', 'English Literature', 6300.99, 'M8', 'MDS', 400277),
('DS', 'Development Software', 8000.00, 'L9', 'MTH', 100760),
('MDS', 'Media Studies', 5880.40, 'R3', 'CMP', 400634);

SELECT * FROM s_subject;
DROP TABLE s_subject;

/*Create Lecture Table*/

CREATE TABLE s_lecture(
    subj_code CHAR(3) UNIQUE,
    lecturer_nr INT(6) UNIQUE
);

/*Insert values into Lecture Table*/

INSERT INTO s_lecture VALUES
('MTH', 800400),
('PHY', 739222),
('CMP', 104399),
('ENG', 877504),
('MDS', 603410);

SELECT * FROM s_lecture;
DROP TABLE s_lecture;

/*Create Registration Table*/

CREATE TABLE s_registration(
    studnr INT(8) NOT NULL, /**/
    subj_code CHAR(3) NOT NULL,
    reg_date DATE,
    campus CHAR(1),
    finalmark INT(2), /**/
    PRIMARY KEY(studnr, subj_code),
    FOREIGN KEY(subj_code) REFERENCES s_subject(subj_code),
    FOREIGN KEY (studnr) REFERENCES s_student(studnr)
);

/*Insert values into Registration Table*/

INSERT INTO s_registration VALUES
(80704060, 'MTH', '2023-01-28', 'A', 67),
(90043005, 'PHY', '2023-01-14', 'A', 49),
(66304226, 'CMP', '2021-09-09', 'A', 82),
(40093929, 'ENG', '2022-10-11', 'B', 97),
(12288740, 'CMP', '2021-10-10', 'A', 95),
(07423477, 'MDS', '2018-04-07', 'B', 33);

SELECT * FROM s_registration;
DROP TABLE s_registration;

/*
1. Without using the OR operator, list for every type of job that starts with the letter A, D, L or J, the job in the following format:
    Job Spec
     ---------------
	Artisan
	Assistant
    Dean
	Director
	Lecturer
	Librarian

    6 rows selected.
*/

SELECT job AS 'Job Spec'
FROM s_staff
WHERE LEFT(job,1) IN ('A', 'D', 'J', 'L')
ORDER BY job ASC;

/* 2. Select for every type of job, the average annual salary in the format as seen below. 
Only display jobs where the average annual salary is more than $50,000. 
Ensure that the results are sorted according to the average annual salary.
   Job Spec        AVG_ANN_SAL
   --------------- ------------
ARTISAN				$0057000.00
LECTURER			$0089600.00
RECTOR				$0132000.00
DEAN				$0162000.00
DIRECTOR			$0174000.00
SPECIALIST			$0240000.00
6 rows selected.	
*/

SELECT job AS 'Job Spec', CONCAT('$', (AVG(salary + bonus))) AS 'AVG_ANN_SAL'
FROM s_staff
GROUP BY job
HAVING AVG(salary + bonus) > 50000
ORDER BY AVG(salary + bonus) ASC;

/* 3. List for every diploma, the name of the diploma, the surname and initials of the head of the diploma, 
and the number of subjects presented in the diploma. List the results as seen below :

   DIPLOMA                   HEAD                  Nr of Subjects
   ------------------------- --------------------- --------------
   COST AND MANAGEMENT       Richmond, M                        7
   INFORMATION TECHNOLOGY    Pretorius, BB                     12
*/

SELECT d.dip_name AS 'DIPLOMA', CONCAT(s.surname, ', ', s.initials) AS 'HEAD', COUNT(*) AS 'Nr of Subjects'
FROM s_diploma d
JOIN s_staff s ON d.dip_head = s.staffnr
JOIN s_subject su ON d.dip_code = su.dip_code
GROUP BY d.dip_code
ORDER BY d.dip_name;

SELECT * FROM s_diploma;
SELECT * FROM s_staff;

/* 4. List the prerequisite of the DEVELOPMENT SOFTWARE subjects as follows:
   DS Requirements
   --------------------------------------------------------------
   The prerequisite of Development Software 2 is Development
   Software 1
   The prerequisite of Development Software 3 is Development
   Software 2
*/

SELECT CONCAT('The prerequisite of ', s.subj_name, ' is ', p.subj_name) AS 'DS Requirements'
FROM s_subject s
JOIN s_subject p ON s.prereq = p.subj_code
WHERE s.subj_code LIKE 'DS%';

/* 5. List all students that are registered at the same campus as GM MKASI, 
in the exact format as displayed below. 
Pay attention to the alignment of the surnames directly below each other (not using spaces!).

   Registered Students
   -------------------------------------------------------------------
   C   BARNARD, a male has registered on the twenty-first of May 1976
   GM  MKASI, a female has registered on the twenty-first of May 1976
   JH  SMUTS, a male has registered on the twelfth of January 1970
   VM  SMITH, a male has registered on the third of December 1976
*/

SELECT CONCAT(UPPER(SUBSTR(s.surname, 1, 2)), ' ', s.surname, ', a ', 
CASE s.sex 
WHEN 'M' THEN 'male'
WHEN 'F' THEN 'female'
end, ' has registered on the ', 
CASE DATE_FORMAT(r.reg_date, '%e')
WHEN '1' THEN 'first' WHEN '2' THEN 'second' WHEN '3' THEN 'third' WHEN '4' THEN 'fourth'
WHEN '5' THEN 'fifth' WHEN '6' THEN 'sixth' WHEN '7' THEN 'seventh' WHEN '8' THEN 'eighth'
WHEN '9' THEN 'ninth' WHEN '10' THEN 'tenth' WHEN '11' THEN 'eleventh' WHEN '12' THEN 'twelfth'
WHEN '13' THEN 'thirteenth' WHEN '14' THEN 'fourteenth' WHEN '15' THEN 'fifteenth' WHEN '16' THEN 'sixteenth'
WHEN '17' THEN 'seventeenth' WHEN '18' THEN 'eighteenth' WHEN '19' THEN 'nineteenth' WHEN '20' THEN 'twentieth'
WHEN '21' THEN 'twenty-first' WHEN '22' THEN 'twenty-second' WHEN '23' THEN 'twenty-third' WHEN '24' THEN 'twenty-fourth'
WHEN '25' THEN 'twenty-fifth' WHEN '26' THEN 'twenty-sixth' WHEN '27' THEN 'twenty-seventh' WHEN '28' THEN 'twenty-eighth'
WHEN '29' THEN 'twenty-ninth' WHEN '30' THEN 'thirtieth' WHEN '31' THEN 'thirty-first'
end,
' of ', date_format(reg_date, '%M %Y'))
AS 'Registered Students'
FROM s_student s
JOIN s_registration r ON s.studnr = r.studnr
WHERE r.campus = (
    SELECT campus
    FROM s_student
    JOIN s_registration ON s_student.studnr = s_registration.studnr
    WHERE s_student.surname = 'MKASI'
)
ORDER BY s.surname;

/* 6. Insert into a new table called DIP_VIEW, data using a query. After inserting, 
you should be able to view the contents of the table with column names as displayed below:

SQL> SELECT *
4
2 FROM dip_view;
   HEAD_OF_DIPLOMA      DIPLOMA_NAME                 AVG_FEE
   -------------------- ------------------------- ----------
   M RICHMOND           COST AND MANAGEMENT              800
   BB PRETORIUS         INFORMATION TECHNOLOGY    1483.33333
*/

CREATE TABLE DIP_VIEW AS
SELECT UPPER(s_staff.surname) AS HEAD_OF_DIPLOMA, UPPER(s_diploma.dip_name) AS DIPLOMA_NAME,
AVG(s_subject.subj_fee) AS AVG_FEE
FROM s_staff
JOIN s_diploma ON s_staff.staffnr = s_diploma.dip_head
JOIN s_subject ON s_subject.dip_code = s_diploma.dip_code
GROUP BY s_diploma.dip_code;

SELECT * FROM DIP_VIEW;
DROP TABLE DIP_VIEW;

/* 7. List the details of the five staff members, who earn the highest salaries, 
in the format, as seen below. Do not take undefined/non-existing values into account.

   Highest earning Employees
   --------------------------------------------------------------
   J BOND, a Specialist, earns R360000
   FJ ENGELBRECHT, a Director, earns R240000
   JB MASEKO, a Dean, earns R180000
   TR BUYS, a Dean, earns R144000
   FR DU PLESSIS, a Director, earns R144000
*/

SELECT CONCAT(initials, ' ', UPPER(surname), ', a ', job, ', earns R', ROUND(salary)) AS 'Highest Earning Employees'
FROM s_staff
WHERE salary IS NOT NULL
ORDER BY salary DESC
LIMIT 5;
