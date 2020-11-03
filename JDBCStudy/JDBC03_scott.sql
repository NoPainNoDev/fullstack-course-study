-- JDBC03_scott.sql

SELECT USER
FROM DUAL;
--==>> SCOTT


--○ 실습 테이블 생성(TBL_SCORE)
CREATE TABLE TBL_SCORE
( SID       NUMBER
, NAME      VARCHAR2(30)
, KOR       NUMBER(3)
, ENG       NUMBER(3)
, MAT       NUMBER(3)
);
--==>> Table TBL_SCORE이(가) 생성되었습니다.

--○ 제약조건 추가(SID 컬럼에 PK 제약조건 추가)
ALTER TABLE TBL_SCORE
ADD CONSTRAINT SCORE_SID_PK PRIMARY KEY(SID);
--==>> Table TBL_SCORE이(가) 변경되었습니다.


--○ 제약조건 추가(KORE, ENG, MAT 컬럼에 CK 제약조건 추가)
ALTER TABLE TBL_SCORE
ADD ( CONSTRAINT SCORE_KOR_CK CHECK (KOR BETWEEN 0 AND 100)
    , CONSTRAINT SCORE_ENG_CK CHECK (ENG BETWEEN 0 AND 100)
    , CONSTRAINT SCORE_MAT_CK CHECK (MAT BETWEEN 0 AND 100) );
--==>> Table TBL_SCORE이(가) 변경되었습니다.

CREATE SEQUENCE SCORESEQ
NOCACHE;
--==>> Sequence SCORESEQ이(가) 생성되었습니다.

INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT) VALUES(SCORESEQ.NEXTVAL, "", 0, 0, 0)
;

SELECT COUNT(*) AS COUNT FROM TBL_SCORE
;

SELECT SID, NAME, KOR, ENG, MAT FROM TBL_SCORE ORDER BY SID
;