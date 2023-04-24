-- 사원정보 INFO (개인정보관련메뉴)
CREATE TABLE INFO(
ID VARCHAR2(10) PRIMARY KEY, --사번
DEPTN NUMBER NOT NULL,  -- 부서명
NAME VARCHAR2(20) NOT NULL, -- 팀원이름
PASS VARCHAR2(20) DEFAULT 0000 , --사용자 비밀번호(디폴트 값 1234)
GRADE NUMBER NOT NULL, --직급(0:팀장 1:팀원 9:퇴사자)

IN_D DATE DEFAULT SYSDATE NOT NULL,--입사일
OUT_D DATE DEFAULT '0001-01-01', --퇴사일
BDAY DATE DEFAULT '0001-01-01', --생년월일
PNUM NUMBER,--연락처
AD VARCHAR2(50), --주소
off_d varchar2(10) --연차
);


insert into info (id, deptn, name, grade, pnum, ad)
values('230423' , 0, '사장', 0, 01025801478, '서울특별시 가산동 KOSMO');

insert into info (id, deptn, name, grade, pnum, ad)
values('230424' , 0, '사장아들', 1, 01025801478, '서울특별시 가산동 KOSMO');


DROP TABLE INFO;

---기안 대기문서함
CREATE TABLE Approval (
IDX NUMBER NOT NULL,
ID VARCHAR2(10),
FOREIGN KEY(ID) REFERENCES INFO (ID),
NAME VARCHAR2(20),
DEPTN NUMBER,
TITLE VARCHAR2(200),
CONTENT VARCHAR2(3500),
STATE VARCHAR2(2000) default '대기',
BOSS VARCHAR2(20),
regdate date default sysdate not null,
ofile varchar2(200),
nfile varchar2(200),
companion varchar2(2000)
);

DROP TABLE Approval;
DROP TABLE Approvalno;
DROP TABLE Approvalok;

--기안 반려 문서함
CREATE TABLE Approvalno (
IDX NUMBER NOT NULL,
ID VARCHAR2(10),
FOREIGN KEY(ID) REFERENCES INFO (ID),
NAME VARCHAR2(20),
DEPTN NUMBER,
TITLE VARCHAR2(200),
CONTENT VARCHAR2(3500),
STATE VARCHAR2(2000) ,
BOSS VARCHAR2(20),
regdate date default sysdate not null,
ofile varchar2(200),
nfile varchar2(200),
companion varchar2(2000)
);

--기안 승인 문서함.
CREATE TABLE Approvalok (
IDX NUMBER NOT NULL,
ID VARCHAR2(10),
FOREIGN KEY(ID) REFERENCES INFO (ID),
NAME VARCHAR2(20),
DEPTN NUMBER,
TITLE VARCHAR2(200),
CONTENT VARCHAR2(3500),
STATE VARCHAR2(2000) ,
BOSS VARCHAR2(20),
regdate date default sysdate not null,
ofile varchar2(200),
nfile varchar2(200),
companion varchar2(2000)
);

--기안 대기 문서함 번호
CREATE SEQUENCE SEQ_APPROVAL_NUM
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOMAXVALUE
NOCYCLE
NOCACHE;

--기안 반려 문서함 번호
CREATE SEQUENCE SEQ_APPROVALNO_NUM
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOMAXVALUE
NOCYCLE
NOCACHE;

--기안 승인 문서함 번호
CREATE SEQUENCE SEQ_APPROVALOK_NUM
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOMAXVALUE
NOCYCLE
NOCACHE;

DROP SEQUENCE SEQ_APPROVAL_NUM;
DROP SEQUENCE SEQ_APPROVALNO_NUM;
DROP SEQUENCE SEQ_APPROVALOK_NUM;


-------------------------------조직도----------
--TB_DEPT TABLE 생성
DROP TABLE TB_DEPT;
CREATE TABLE TB_DEPT
( 
   DEPT_CD     VARCHAR2(8) NOT NULL PRIMARY KEY,
   PAR_DEPT_CD VARCHAR2(8),
   DEPT_NM     VARCHAR2(50),
   LV          NUMBER(10),
   ID          VARCHAR(10) NOT NULL
);

-- 기본값 삽입
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_001',NULL,'REBOOT','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_002','DE_001','인사팀','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_003','DE_001','시스템팀','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_004','DE_001','업무팀','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_005','DE_002','팀장','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_006','DE_002','팀원','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_007','DE_003','팀장','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_008','DE_003','팀원','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_009','DE_004','팀장','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_010','DE_004','팀원','NULL');

-- INFO 정보 -> TB_DEPT 옮기기 
DECLARE
    v_dept_cd   TB_DEPT.DEPT_CD%TYPE := 'DE_011';
    v_dept_nm   TB_DEPT.DEPT_NM%TYPE;
BEGIN
    FOR emp IN (SELECT ID, DEPTN, NAME, GRADE
                FROM INFO)
    LOOP
        IF emp.DEPTN = 0 AND emp.GRADE = 0 THEN
            v_dept_nm := emp.NAME;
            INSERT INTO TB_DEPT(ID, DEPT_CD, PAR_DEPT_CD, DEPT_NM, LV)
            VALUES (emp.ID, v_dept_cd, 'DE_005', v_dept_nm, 4);
            v_dept_cd := 'DE_' || TO_CHAR(TO_NUMBER(SUBSTR(v_dept_cd, 4)) + 1, 'FM000');
        ELSIF emp.DEPTN = 0 AND emp.GRADE = 1 THEN
            v_dept_nm := emp.NAME;
            INSERT INTO TB_DEPT(ID,DEPT_CD, PAR_DEPT_CD, DEPT_NM , LV)
            VALUES (emp.ID,v_dept_cd, 'DE_006', v_dept_nm,4);
            v_dept_cd := 'DE_' || TO_CHAR(TO_NUMBER(SUBSTR(v_dept_cd, 4)) + 1, 'FM000');
        ELSIF emp.DEPTN = 1 AND emp.GRADE = 0 THEN
            v_dept_nm := emp.NAME;
            INSERT INTO TB_DEPT(ID,DEPT_CD, PAR_DEPT_CD, DEPT_NM , LV)
            VALUES (emp.ID,v_dept_cd, 'DE_007', v_dept_nm, 4);
            v_dept_cd := 'DE_' || TO_CHAR(TO_NUMBER(SUBSTR(v_dept_cd, 4)) + 1, 'FM000');
        ELSIF emp.DEPTN = 1 AND emp.GRADE = 1 THEN
            v_dept_nm := emp.NAME;
            INSERT INTO TB_DEPT(ID,DEPT_CD, PAR_DEPT_CD, DEPT_NM , LV)
            VALUES (emp.ID,v_dept_cd, 'DE_008', v_dept_nm, 4);
            v_dept_cd := 'DE_' || TO_CHAR(TO_NUMBER(SUBSTR(v_dept_cd, 4)) + 1, 'FM000');
        ELSIF emp.DEPTN = 2 AND emp.GRADE = 0 THEN
            v_dept_nm := emp.NAME;
            INSERT INTO TB_DEPT(ID,DEPT_CD, PAR_DEPT_CD, DEPT_NM , LV)
            VALUES (emp.ID,v_dept_cd, 'DE_009', v_dept_nm, 4);
            v_dept_cd := 'DE_' || TO_CHAR(TO_NUMBER(SUBSTR(v_dept_cd, 4)) + 1, 'FM000');
        ELSIF emp.DEPTN = 2 AND emp.GRADE = 1 THEN
            v_dept_nm := emp.NAME;
            INSERT INTO TB_DEPT(ID,DEPT_CD, PAR_DEPT_CD, DEPT_NM, LV)
            VALUES (emp.ID,v_dept_cd, 'DE_010', v_dept_nm,4);
            v_dept_cd := 'DE_' || TO_CHAR(TO_NUMBER(SUBSTR(v_dept_cd, 4)) + 1, 'FM000');
        END IF;
    END LOOP;
END;

---------------근태
--아 나 데이터베이스는 이거 하나썼음
create table am2 (
IDX NUMBER,
ID VARCHAR2(10), --사번
TYPE NUMBER, -- 출근 0/ 퇴근 1
DAY_T VARCHAR(30), --날짜
TIME_S VARCHAR(30), --출근시간 
TIME_E VARCHAR(30), --퇴근시간
 CONSTRAINT FK_AM2 FOREIGN KEY(ID) REFERENCES INFO(ID)
);

drop table am2;

-- 근태 번호
DROP SEQUENCE SEQ_NUM;

CREATE SEQUENCE SEQ_NUM  
MINVALUE 1 
MAXVALUE 100000 
INCREMENT BY 1 
START WITH 21 
CACHE 20 
NOORDER  
NOCYCLE ;
