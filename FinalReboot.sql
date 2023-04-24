-- ������� INFO (�����������ø޴�)
CREATE TABLE INFO(
ID VARCHAR2(10) PRIMARY KEY, --���
DEPTN NUMBER NOT NULL,  -- �μ���
NAME VARCHAR2(20) NOT NULL, -- �����̸�
PASS VARCHAR2(20) DEFAULT 0000 , --����� ��й�ȣ(����Ʈ �� 1234)
GRADE NUMBER NOT NULL, --����(0:���� 1:���� 9:�����)

IN_D DATE DEFAULT SYSDATE NOT NULL,--�Ի���
OUT_D DATE DEFAULT '0001-01-01', --�����
BDAY DATE DEFAULT '0001-01-01', --�������
PNUM NUMBER,--����ó
AD VARCHAR2(50), --�ּ�
off_d varchar2(10) --����
);


insert into info (id, deptn, name, grade, pnum, ad)
values('230423' , 0, '����', 0, 01025801478, '����Ư���� ���굿 KOSMO');

insert into info (id, deptn, name, grade, pnum, ad)
values('230424' , 0, '����Ƶ�', 1, 01025801478, '����Ư���� ���굿 KOSMO');


DROP TABLE INFO;

---��� ��⹮����
CREATE TABLE Approval (
IDX NUMBER NOT NULL,
ID VARCHAR2(10),
FOREIGN KEY(ID) REFERENCES INFO (ID),
NAME VARCHAR2(20),
DEPTN NUMBER,
TITLE VARCHAR2(200),
CONTENT VARCHAR2(3500),
STATE VARCHAR2(2000) default '���',
BOSS VARCHAR2(20),
regdate date default sysdate not null,
ofile varchar2(200),
nfile varchar2(200),
companion varchar2(2000)
);

DROP TABLE Approval;
DROP TABLE Approvalno;
DROP TABLE Approvalok;

--��� �ݷ� ������
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

--��� ���� ������.
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

--��� ��� ������ ��ȣ
CREATE SEQUENCE SEQ_APPROVAL_NUM
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOMAXVALUE
NOCYCLE
NOCACHE;

--��� �ݷ� ������ ��ȣ
CREATE SEQUENCE SEQ_APPROVALNO_NUM
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOMAXVALUE
NOCYCLE
NOCACHE;

--��� ���� ������ ��ȣ
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


-------------------------------������----------
--TB_DEPT TABLE ����
DROP TABLE TB_DEPT;
CREATE TABLE TB_DEPT
( 
   DEPT_CD     VARCHAR2(8) NOT NULL PRIMARY KEY,
   PAR_DEPT_CD VARCHAR2(8),
   DEPT_NM     VARCHAR2(50),
   LV          NUMBER(10),
   ID          VARCHAR(10) NOT NULL
);

-- �⺻�� ����
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_001',NULL,'REBOOT','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_002','DE_001','�λ���','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_003','DE_001','�ý�����','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_004','DE_001','������','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_005','DE_002','����','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_006','DE_002','����','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_007','DE_003','����','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_008','DE_003','����','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_009','DE_004','����','NULL');
    INSERT INTO TB_DEPT(DEPT_CD,PAR_DEPT_CD,DEPT_NM,ID)VALUES('DE_010','DE_004','����','NULL');

-- INFO ���� -> TB_DEPT �ű�� 
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

---------------����
--�� �� �����ͺ��̽��� �̰� �ϳ�����
create table am2 (
IDX NUMBER,
ID VARCHAR2(10), --���
TYPE NUMBER, -- ��� 0/ ��� 1
DAY_T VARCHAR(30), --��¥
TIME_S VARCHAR(30), --��ٽð� 
TIME_E VARCHAR(30), --��ٽð�
 CONSTRAINT FK_AM2 FOREIGN KEY(ID) REFERENCES INFO(ID)
);

drop table am2;

-- ���� ��ȣ
DROP SEQUENCE SEQ_NUM;

CREATE SEQUENCE SEQ_NUM  
MINVALUE 1 
MAXVALUE 100000 
INCREMENT BY 1 
START WITH 21 
CACHE 20 
NOORDER  
NOCYCLE ;
