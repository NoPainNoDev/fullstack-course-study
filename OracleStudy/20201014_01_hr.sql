SELECT USER
FROM DUAL;
--==>> HR


--■■■ NOT NULL(NN:CK:C) ■■■--

-- 1. 테이블에서 지정한 컬럼의 데이터가
--    NULL 인 상태를 갖지 못하도록 하는 제약조건

-- 2. 형식 및 구조
-- ① 컬럼 레벨의 형식
-- 컬럼명 데이터타입 [CONSTRAINT CONSTRAINT명] NOT NULL

-- ② 테이블 레벨의 형식
-- 컬럼명 데이터타입,
-- 컬럼명 데이터타입,
-- CONSTRAINT CONSTRAINT명 CHECK(컬럼명 IS NOT NULL)

-- 3. 기존에 생성되어 있는 테이블에 NOT NULL 제약조건을 추가할 경우
--    ADD 보다 MODIFY 절이 더 많이 사용된다.

-- 4. 기존 테이블에 데이터가 이미 들어있지 않은 컬럼(-> NULL 인 상태의 컬럼)을
--    NOT NULL 제약조건을 갖게끔 수정하는 경우에는 에러가 발생한다. (불가능하다.)


--○ NOT NULL 지정 실습(① 컬럼 레벨의 형식)
-- 테이블 생성
CREATE TABLE TBL_TEST11
( COL1  NUMBER(5)       CONSTRAINT TEST11_COL1_PK PRIMARY KEY -- 생략하지 않고 쓰기 가능
, COL2  VARCHAR2(30)    CONSTRAINT TEST11_COL2_NN NOT NULL
);
--==>> Table TBL_TEST11이(가) 생성되었습니다.

-- 데이터 입력
INSERT INTO TBL_TEST11(COL1, COL2) VALUES(1, 'TEST');
INSERT INTO TBL_TEST11(COL1, COL2) VALUES(2, 'ABCD');
INSERT INTO TBL_TEST11(COL1, COL2) VALUES(3, NULL);     --> 에러 발생
INSERT INTO TBL_TEST11(COL1) VALUES(4);                 --> 에러 발생

-- 확인
SELECT *
FROM TBL_TEST11;
--==>> 
/*
1	TEST
2	ABCD
*/

-- 제약조건 확인
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST11';
--==>>
/*
HR	TEST11_COL2_NN	TBL_TEST11	C	COL2	"COL2" IS NOT NULL	
HR	TEST11_COL1_PK	TBL_TEST11	P	COL1		
*/


--○ NOT NULL 지정 실습(② 테이블 레벨의 형식)
-- 테이블 생성
CREATE TABLE TBL_TEST12
( COL1   NUMBER(5)
, COL2   VARCHAR2(30)
, CONSTRAINT TEST12_COL1_PK PRIMARY KEY(COL1)
, CONSTRAINT TEST12_COL2_NN CHECK(COL2 IS NOT NULL)
);
--==>> Table TBL_TEST12이(가) 생성되었습니다.


-- 제약조건 확인
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST12';
--==>>
/*
HR	TEST12_COL2_NN	TBL_TEST12	C	COL2	COL2 IS NOT NULL	
HR	TEST12_COL1_PK	TBL_TEST12	P	COL1		
*/


--○ NOT NULL 지정 실습(③ 테이블 생성 이후 제약조건 추가)
-- 테이블 생성
CREATE TABLE TBL_TEST13
( COL1  NUMBER(5)
, COL2  VARCHAR2(30)
);
--==>> Table TBL_TEST13이(가) 생성되었습니다.

-- 제약조건 확인
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST13';
--==>> 조회 결과 없음 

-- 제약조건 추가
ALTER TABLE TBL_TEST13
ADD( CONSTRAINT TEST13_COL1_PK PRIMARY KEY(COL1) 
   , CONSTRAINT TEST13_COL2_NN CHECK(COL2 IS NOT NULL) );
--==>> Table TBL_TEST13이(가) 변경되었습니다.

-- 제약조건 추가 이후 다시 확인
SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME = 'TBL_TEST13';
--==>>
/*
HR	TEST13_COL1_PK	TBL_TEST13	P	COL1		
HR	TEST13_COL2_NN	TBL_TEST13	C	COL2	COL2 IS NOT NULL	
*/


--※ NOT NULL 제약조건만 TBL_TEST13 테이블의 COL2 에 추가하는 경우
--   다음과 같은 방법을 사용하는 것도 가능하다.
ALTER TABLE TBL_TEST13
MODIFY COL2 NOT NULL;
--==>> Table TBL_TEST13이(가) 변경되었습니다.


-- 컬럼 레벨에서 NOT NULL 제약조건을 지정한 테이블(TBL_TEST11)
DESC TBL_TEST11;
--==>>
/*
이름   널?       유형           
---- -------- ------------ 
COL1 NOT NULL NUMBER(5)    
COL2 NOT NULL VARCHAR2(30) 
*/


-- 테이블 레벨에서 NOT NULL 제약조건을 지정한 테이블(TBL_TEST12)
DESC TBL_TEST12;
--==>>
/*
이름   널?       유형           
---- -------- ------------ 
COL1 NOT NULL NUMBER(5)    
COL2          VARCHAR2(30) 
*/


-- 테이블 생성 이후 ADD 를 통해 NOT NULL 제약조건을 추가하였으며
-- 여기에 더하여, MODIFY  절을 통해 NOT NULL 제약조건을 추가한 테이블(TBL_TEST13)
DESC TBL_TEST13;
--==>>
/*
이름   널?       유형           
---- -------- ------------ 
COL1 NOT NULL NUMBER(5)    
COL2 NOT NULL VARCHAR2(30) 
*/

SELECT *
FROM VIEW_CONSTCHECK
WHERE TABLE_NAME IN ('TBL_TEST11', 'TBL_TEST12', 'TBL_TEST13');
--==>>
/*
HR	TEST11_COL2_NN	TBL_TEST11	C	COL2	"COL2" IS NOT NULL	
HR	TEST11_COL1_PK	TBL_TEST11	P	COL1		

HR	TEST12_COL2_NN	TBL_TEST12	C	COL2	COL2 IS NOT NULL	
HR	TEST12_COL1_PK	TBL_TEST12	P	COL1	

HR	TEST13_COL1_PK	TBL_TEST13	P	COL1		
HR	TEST13_COL2_NN	TBL_TEST13	C	COL2	COL2 IS NOT NULL	
HR	SYS_C007017	    TBL_TEST13	C	COL2	"COL2" IS NOT NULL	
*/



--------------------------------------------------------------------------------

--■■■ DEFAULT 표현식 ■■■--

-- 1. INSERT 와 UPDATE 문에서
--    특정 값이 아닌 기본 값을 입력하도록 할 수 있다.

-- 2. 형식 및 구조
-- 컬럼명 데이터타입 DEFAULT 기본값

-- 3. INSERT  명령 시 해당 컬럼에 입력될 값을 할당하지 않거나,
--    DEFAULT 키워드를 활용하여 기본으로 설정된 값을 입력하도록 할 수 있다.

-- 4. DEFAULT 키워드와 다른 제약(NOT NULL 등) 표기가 함께 사용되어야 하는 경우
--    DEFAULT 키워드를 먼저 표기(작성)할 것을 권장한다.


--○ DEFAULT 표현식 실습
-- 테이블 생성
CREATE TABLE TBL_BBS                       -- 게시판 테이블 생성
( SID       NUMBER         PRIMARY KEY     -- 게시물 번호 -> 식별자 -> 자동 증가
, NAME      VARCHAR2(20)                   -- 게시물 작성자
, CONTENTS  VARCHAR2(200)                  -- 게시물 내용
, WRITEDAY  DATE           DEFAULT SYSDATE -- 게시물 작성일
, COUNTS    NUMBER         DEFAULT 0       -- 게시물 조회수
, COMMENTS  NUMBER         DEFAULT 0       -- 게시물 댓글 갯수
);
--==>> Table TBL_BBS이(가) 생성되었습니다.

--※ SID 를 자동 증가 값으로 운영하려면 시퀀스 객체가 필요하다.
--   자동으로 입력되는 컬럼은 사용자의 입력 항목에서 제외시킬 수 있다.

-- 시퀀스 생성
CREATE SEQUENCE SEQ_BBS
NOCACHE;
--==>> Sequence SEQ_BBS이(가) 생성되었습니다.

-- 날짜 관련 세션 설정 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
--==>> Session이(가) 변경되었습니다.


-- 게시물 작성
INSERT INTO TBL_BBS(SID, NAME, CONTENTS, WRITEDAY, COUNTS, COMMENTS)
VALUES(SEQ_BBS.NEXTVAL, '조인경', '오라클 DEFAULT 표현식을 실습중입니다.'
     , TO_DATE('2020-10-14 12:05:00', 'YYYY-MM-DD HH24:MI:SS'), 0, 0);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BBS(SID, NAME, CONTENTS, WRITEDAY, COUNTS, COMMENTS)
VALUES(SEQ_BBS.NEXTVAL, '박다빈', '계속 실습중입니다.', SYSDATE, 0, 0);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BBS(SID, NAME, CONTENTS, WRITEDAY, COUNTS, COMMENTS)
VALUES(SEQ_BBS.NEXTVAL, '허수민', '열심히 실습중입니다.', DEFAULT, 0, 0);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BBS(SID, NAME, CONTENTS, WRITEDAY, COUNTS, COMMENTS)
VALUES(SEQ_BBS.NEXTVAL, '박해진', '무진장 실습중입니다.', DEFAULT, DEFAULT, DEFAULT);
--==>> 1 행 이(가) 삽입되었습니다.

INSERT INTO TBL_BBS(SID, NAME, CONTENTS)
VALUES(SEQ_BBS.NEXTVAL, '강정우', '마무리');
--==>> 1 행 이(가) 삽입되었습니다.


-- 확인
SELECT *
FROM TBL_BBS;
--==>>
/*
1	조인경	오라클 DEFAULT 표현식을 실습중입니다.	2020-10-14 12:05:00	0	0
2	박다빈	계속 실습중입니다.	2020-10-14 12:06:57	0	0
3	허수민	열심히 실습중입니다.	2020-10-14 12:08:08	0	0
4	박해진	무진장 실습중입니다.	2020-10-14 12:08:36	0	0
5	강정우	마무리	2020-10-14 12:09:25	0	0
*/


-- DEFAULT 표현식 확인(조회)
SELECT *
FROM USER_TAB_COLUMNS
WHERE TABLE_NAME = 'TBL_BBS';
--==>> 
/*
TBL_BBS	SID	        NUMBER			22			N	1													NO	NO		0		NO	YES	NONE
TBL_BBS	NAME	    VARCHAR2	    20			Y	2											CHAR_CS	20	NO	NO		20	B	NO	YES	NONE
TBL_BBS	CONTENTS	VARCHAR2	   200			Y	3											CHAR_CS	200	NO	NO		200	B	NO	YES	NONE
TBL_BBS	WRITEDAY	DATE		     7			Y	4	31	"SYSDATE"											NO	NO		0		NO	YES	NONE
TBL_BBS	COUNTS	    NUMBER			22			Y	5	31	"0"											NO	NO		0		NO	YES	NONE
TBL_BBS	COMMENTS	NUMBER			22			Y	6	35	"0"											NO	NO		0		NO	YES	NONE
*/


--○ 테이블 생성 이후 DEFAULT 표현식 추가 / 변경
ALTER TABLE 테이블명
MODIFY 컬럼명 [자료형] DEFAULT 기본값; 

--○ 기존의 DEFAULT 표현식 제거
ALTER TABLE 테이블명
MODIFY 컬럼명 [자료형] DEFAULT NULL; 

