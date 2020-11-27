SELECT USER
FROM DUAL;
--==>> SCOTT

PURGE RECYCLEBIN;
--==>> RECYCLEBIN이(가) 비워졌습니다.

SELECT *
FROM TAB;
--==>>
/*
BONUS	TABLE	
DEPT	TABLE	
EMP	TABLE	
EMPVIEW	VIEW	
SALGRADE	TABLE	
TBL_BUSEO	TABLE	
TBL_CITY	TABLE	
TBL_EMP	TABLE	
TBL_EVENTLOG	TABLE	
TBL_IDPW	TABLE	
TBL_INSA	TABLE	
TBL_INSABACKUP	TABLE	
TBL_JIKWI	TABLE	
TBL_MEMBER	TABLE	
TBL_MEMBERSCORE	TABLE	
TBL_SAWON	TABLE	
TBL_STUDENTS	TABLE	
TBL_SUNGJUK	TABLE	
TBL_TEST1	TABLE	
TBL_TEST2	TABLE	
TBL_TEST3	TABLE	
TBL_상품	TABLE	
TBL_입고	TABLE	
TBL_출고	TABLE	
VIEW_MEMBERSCORE	VIEW	
*/


--○ 기존 테이블 제거
DROP TABLE TBL_BOARD PURGE;
--==>>

--○ 게시판 정용 테이블 생성(TBL_BOARD)
CREATE TABLE TBL_BOARD
( NUM       NUMBER(9)                       NOT NULL    -- 게시물 번혼
, NAME      VARCHAR2(30)                    NOT NULL    -- 게시물 작성자
, PWD       VARCHAR2(20)                    NOT NULL    -- 게시물 암호
, EMAIL     VARCHAR2(50)                                -- 작성자 이메일
, SUBJECT   VARCHAR2(100)                   NOT NULL    -- 게시물 제목
, CONTENT   VARCHAR2(4000)                  NOT NULL    -- 게시물 내용
, IPADDR    VARCHAR2(20)                                -- 접속한 클라이언트의 IP 주소
, HITCOUNT  NUMBER          DEFAULT 0       NOT NULL    -- 게시물 조회수
, CREATED   DATE            DEFAULT SYSDATE NOT NULL    -- 게시물 작성일
, CONSTRAINT BOARD_NUM_PK PRIMARY KEY(NUM)              -- 게시물 번호에 PK 제약조건 설정
);
--==>> Table TBL_BOARD이(가) 생성되었습니다.


--○ 게시물 번호의 최대값을 얻어내는 쿼리문 구성
SELECT NVL(MAX(NUM), 0) AS MAXNUM
FROM TBL_BOARD;
--> 한 줄 구성
SELECT NVL(MAX(NUM), 0) AS MAXNUM FROM TBL_BOARD
;
--==>> 0


--○ 게시물 작성 쿼리문 구성
INSERT INTO TBL_BOARD(NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT, IPADDR, HITCOUNT, CREATED)
VALUES(1, '강정우', '1234', 'kjw@test.com', '작성테스트', '내용물작성', '211.238.142.152', 0, SYSDATE);
--> 한 줄 구성
INSERT INTO TBL_BOARD(NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT, IPADDR, HITCOUNT, CREATED) VALUES(1, '강정우', '1234', 'kjw@test.com', '작성테스트', '내용물작성', '211.238.142.152', 0, SYSDATE)
;
--==>> 1 행 이(가) 삽입되었습니다.


--○ 커밋
COMMIT;
--==>> 커밋 완료.


--○ DB 레코드의 갯수(전체 게시물 수)를 가져오는 쿼리문 구성
SELECT COUNT(*) AS COUNT
FROM TBL_BOARD;
--> 한 줄 구성
SELECT COUNT(*) AS COUNT FROM TBL_BOARD
;
--==>> 1


--○ 특정 영역의(시작 번호 ~ 끝 번호) 게시물의 목록을 읽어오는 쿼리문 구성

SELECT NUM, NAME, SUBJECT, HITCOUNT, CREATED
FROM 
(
    SELECT ROWNUM RNUM, DATA.*
    FROM
    (
    SELECT NUM, NAME, SUBJECT, HITCOUNT, TO_CHAR(CREATED, 'YYYY-MM-DD') AS CREATED
    FROM TBL_BOARD
    ORDER BY NUM DESC
    ) DATA
)
WHERE RNUM >= 1 AND RNUM <= 10;
--> 한 줄 구성
SELECT NUM, NAME, SUBJECT, HITCOUNT, CREATED FROM (SELECT ROWNUM RNUM, DATA.* FROM ( SELECT NUM, NAME, SUBJECT, HITCOUNT, TO_CHAR(CREATED, 'YYYY-MM-DD') AS CREATED FROM TBL_BOARD ORDER BY NUM DESC) DATA) WHERE RNUM >= 1 AND RNUM <= 10
;
--==>> 1	강정우	작성테스트	0	2020-11-27


--○ 특정 게시물 조회에 따른 조회 횟수 증가 쿼리문 구성
UPDATE TBL_BOARD
SET HITCOUNT = HITCOUNT + 1
WHERE NUM=1;
--> 한 줄 구성
UPDATE TBL_BOARD SET HITCOUNT = HITCOUNT + 1 WHERE NUM=1
;
--==>> 1 행 이(가) 업데이트되었습니다.

--○ 확인
SELECT *
FROM TBL_BOARD;
--==>> 1	강정우	1234	kjw@test.com	작성테스트	내용물작성	211.238.142.152	2	2020-11-27


--○ 커밋
COMMIT;
--==>> 커밋 완료.


--○ 특정 게시물의 내용을 읽어오는 쿼리문 구성
SELECT NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT
     , IPADDR, HITCOUNT, TO_CHAR(CREATED, 'YYYY-MM-DD') AS CREATED
FROM TBL_BOARD
WHERE NUM=1;
--> 한 줄 구성
SELECT NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT, IPADDR, HITCOUNT, TO_CHAR(CREATED, 'YYYY-MM-DD') AS CREATED FROM TBL_BOARD WHERE NUM=1
;


--○ 특정 게시물을 삭제하는 쿼리문 구성
DELETE
FROM TBL_BOARD
WHERE NUM=1;
--> 한 줄 구성
DELETE FROM TBL_BOARD WHERE NUM=1
;
--==>> 1 행 이(가) 삭제되었습니다.


--○ 롤백
ROLLBACK;
--==>> 롤백 완료.


--○ 특정 게시물을 수정하는 쿼리문 구성
UPDATE TBL_BOARD
SET NAME='권소윤', PWD='9876', EMAIL='ksw@test.com', SUBJECT='안녕하세요', CONTENT='반갑습니다.'
WHERE NUM=1;
--> 한 줄 구성
UPDATE TBL_BOARD SET NAME='권소윤', PWD='9876', EMAIL='ksw@test.com', SUBJECT='안녕하세요', CONTENT='반갑습니다.' WHERE NUM=1
;


--○ 커밋
COMMIT;
--==>> 커밋 완료.

-- 테스트
INSERT INTO TBL_BOARD(NUM, NAME, PWD, EMAIL, SUBJECT, CONTENT, IPADDR, HITCOUNT, CREATED)
VALUES(5, '김승범', '1234', 'ksb@test.com', '작성테스트2', '내용물작성2', '211.238.142.154', 0, SYSDATE);


--○ 게시물 다음 번호 읽어오는 쿼리문 구성
SELECT NVL(MIN(NUM), -1) NEXTNUM
FROM TBL_BOARD
WHERE NUM > 1;
--> 한 줄 구성
SELECT NVL(MIN(NUM), -1) NEXTNUM FROM TBL_BOARD WHERE NUM > 1
;

--○ 게시물 이전 번호 읽어오는 쿼리문 구성
SELECT NVL(MAX(NUM), -1) BEFORENUM
FROM TBL_BOARD
WHERE NUM < 1;
--> 한 줄 구성
SELECT NVL(MAX(NUM), -1) BEFORENUM FROM TBL_BOARD WHERE NUM < 1
;



