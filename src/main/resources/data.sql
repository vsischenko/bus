create sequence group_seq;
CREATE TABLE EMPLOYEE
(
EMP_TID int default group_seq.nextval PRIMARY KEY ,
LAST_NAME varchar(255),
FIRST_NAME varchar(255),
VACATION_DATE DATE ,
VACATION_DURATION int
);