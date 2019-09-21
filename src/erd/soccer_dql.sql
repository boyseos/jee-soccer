--1.전체 축구팀 목록, 이름 오름차순
SELECT T.TEAM_NAME "전체 축구팀 목록"
FROM TEAM T
ORDER BY T.TEAM_NAME
;

--2.포지션 종류(중복제거 없으면 빈공간)
SELECT DISTINCT P.POSITION 포지션
FROM PLAYER P
ORDER BY 1 DESC
;

--3.포지션 종류(중복제거, 없으면 신입으로 기재) NVL2()사용
SELECT DISTINCT NVL2(P.POSITION, P.POSITION, '신입') 포지션
FROM PLAYER P
ORDER BY 1 DESC
;

--4.수원팀(ID : KO2)골키퍼
SELECT P.PLAYER_NAME 이름
FROM PLAYER P
WHERE P.TEAM_ID LIKE 'K02'
    AND P.POSITION LIKE 'GK'
ORDER BY 1
;

--5. 수원팀 키가 170이상 선수
--이면서 성이 고씨인 선수
SELECT P.POSITION 포지션, P.PLAYER_NAME 이름
FROM PLAYER P
WHERE P.HEIGHT >= 170
    AND P.PLAYER_NAME LIKE '고%'
        AND P.TEAM_ID LIKE 'K02'
;

--6. 수원팀 선수들 이름
--키와 몸무게 리스트 단위삽입
--키와 몸무게가 없으면 "0"표시
--키 내림차순
SELECT P.PLAYER_NAME 이름, CONCAT(NVL2(P.HEIGHT,P.HEIGHT,0),'cm') 키
    , CASE 
    WHEN P.WEIGHT IS NULL
    THEN '0kg'
    ELSE CONCAT(P.WEIGHT,'kg')
    END 몸무게
FROM PLAYER P
WHERE P.TEAM_ID LIKE 'K02'
ORDER BY 2 DESC
;

--7. 수원팀 선수들 이름
--키와 몸무게 리스트 단위삽입
--키와 몸무게가 없으면 "0"표시
--BMI지수
--키 내림차순
SELECT P.PLAYER_NAME 이름, CASE 
    WHEN P.HEIGHT IS NULL
    THEN '0cm'
    ELSE CONCAT(P.HEIGHT,'cm')
    END 키
    , CASE 
    WHEN P.WEIGHT IS NULL
    THEN '0kg'
    ELSE CONCAT(P.WEIGHT,'kg')
    END 몸무게
    ,ROUND(P.WEIGHT / (P.HEIGHT * P.HEIGHT/10000),2) BMI지수 
FROM PLAYER P
WHERE P.TEAM_ID LIKE 'K02'
ORDER BY 2 DESC
;
--8 수원팀 과 대전팀 선수들 중
--포지션이 GK 인 선수
-- 팀명, 사람명 오름차순
SELECT T.TEAM_NAME TEAM_NAME, POSITION, P.PLAYER_NAME
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE P.TEAM_ID IN ('K02','K10')
    AND P.POSITION LIKE 'GK'
ORDER BY 1,3
;

--9 수원팀 과 대전팀 선수들 중
--키가 180이상 183이하인 선수들
-- 키, 팀명, 사람명 오름차순
SELECT CONCAT(P.HEIGHT,'cm') 키, T.TEAM_NAME 팀명 , P.PLAYER_NAME 이름
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE P.TEAM_ID IN ('K02','K10')
    AND P.HEIGHT BETWEEN 180 AND 183 
ORDER BY 1,2,3
;
--10 모든 선수들 중 포지션을 배정받지 못한 선수들의 팀과 이름
--팀명 사람명 오름차순
SELECT T.TEAM_NAME 팀명, P.PLAYER_NAME 이름
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE P.POSITION IS NULL
ORDER BY 1,2    
;

--11 팀과 스타디움을 조인하여
-- 팀이름, 스타디움 이름 출력
SELECT T.TEAM_NAME 팀명, S.STADIUM_NAME 스타디움
FROM TEAM T JOIN STADIUM S
    ON T.STADIUM_ID LIKE S.STADIUM_ID
ORDER BY 1
;

--12 팀과 스타디움, 스케줄을 조인하여 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력 다중테이블 JOIN을 찾아서 해결하시오.
SELECT T.TEAM_NAME 팀명, S.STADIUM_NAME 스타디움
    , D.AWAYTEAM_ID 원정팀ID, D.SCHE_DATE
FROM TEAM T JOIN STADIUM S
        ON T.STADIUM_ID LIKE S.STADIUM_ID
    JOIN SCHEDULE D
        ON S.STADIUM_ID = D.STADIUM_ID
WHERE D.SCHE_DATE LIKE '20120317'
ORDER BY 1
;
--13 2012년 3월 17일 경기에 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션, 팀명(연고지포함), 스타디움, 경긴잘짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오
SELECT P.PLAYER_NAME 선수명, P.POSITION 포지션
    , T.REGION_NAME || ' ' || T.TEAM_NAME 팀명
    , S.STADIUM_NAME 스타디움
    , D.SCHE_DATE 스케줄날짜
FROM PLAYER P
    JOIN TEAM T
        ON P.TEAM_ID = T.TEAM_ID
    JOIN STADIUM S
        ON S.STADIUM_ID LIKE T.STADIUM_ID
    JOIN SCHEDULE D
        ON D.STADIUM_ID LIKE S.STADIUM_ID
WHERE T.TEAM_NAME LIKE '스틸러스'
    AND P.POSITION LIKE 'GK'
        AND D.SCHE_DATE LIKE '20120317'
ORDER BY 1        
;

--14 홈팀이 3점이상 차이로 승리한 경기의 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을 구하시오.
SELECT S.STADIUM_NAME 스타디움, D.SCHE_DATE 경기날짜
    , (SELECT T.REGION_NAME || ' ' || T.TEAM_NAME
    FROM TEAM T
    WHERE T.TEAM_ID LIKE D.HOMETEAM_ID
    ) 홈팀
    , (SELECT T.REGION_NAME || ' ' || T.TEAM_NAME
    FROM TEAM T
    WHERE T.TEAM_ID LIKE D.AWAYTEAM_ID
    ) 원정팀
    , D.HOME_SCORE "홈팀 점수", D.AWAY_SCORE "원정팀 점수"
FROM SCHEDULE D JOIN STADIUM S
    ON D.STADIUM_ID LIKE S.STADIUM_ID
WHERE D.HOME_SCORE >= (D.AWAY_SCORE + 3)
ORDER BY 2
;
--15 STADIUM에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 20
SELECT S.STADIUM_NAME, S.STADIUM_ID, S.SEAT_COUNT
    ,S.HOMETEAM_ID, T.E_TEAM_NAME
FROM STADIUM S LEFT JOIN TEAM T
    ON S.STADIUM_ID = T.STADIUM_ID
ORDER BY 4
;

--16 평균키가 인천 유나이티스팀의 평균키 보다 작은 팀의
-- 팀ID, 팀명, 평귱키 추출
SELECT T.TEAM_ID, T.TEAM_NAME,ROUND(AVG(P.HEIGHT),2) 평균키
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
GROUP BY T.TEAM_ID,T.TEAM_NAME
    HAVING AVG(P.HEIGHT) < 
    (SELECT AVG(X.HEIGHT) 
    FROM PLAYER X
    WHERE X.TEAM_ID LIKE 'K04'
    )
ORDER BY 3
;

--17 포지션이 MF인 선수들의 소속팀명 및 선수명, 백넘버 출력
SELECT T.TEAM_NAME 팀명 , P.PLAYER_NAME 선수명 , P.BACK_NO 백넘버
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE P.POSITION LIKE 'MF'
ORDER BY 2
;

--18 가장 키큰 선수 5추출, 오라클, 단 키 값이 없으면 제외
SELECT X.*
FROM (SELECT P.PLAYER_NAME 선수명, P.BACK_NO 백넘버
    , P.POSITION 포지션, P.HEIGHT 키
    FROM PLAYER P
    WHERE P.HEIGHT IS NOT NULL
    ORDER BY 4 DESC) X
WHERE ROWNUM <= 5
;

--19 선수 자신이 속한 팀의 평균키보다 작은 선수 정보 출력

SELECT T.TEAM_NAME 팀명, P.PLAYER_NAME 선수명, P.POSITION 포지션
    , P.BACK_NO 백넘버, P.HEIGHT 키
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE P.HEIGHT < (SELECT AVG(X.HEIGHT)
    FROM PLAYER X
    WHERE X.TEAM_ID LIKE P.TEAM_ID
    GROUP BY X.TEAM_ID
    )
GROUP BY P.PLAYER_ID, P.HEIGHT, P.PLAYER_NAME
    , P.POSITION, P.BACK_NO, T.TEAM_NAME
ORDER BY 2
;

--20 2012년 5월 한달간 경기가 있는 경기장 조회
--EXISTS 쿼리는 항상 연관쿼리로 사용한다.
--또한 아무리 조건을 만족하는 건이 여러 건이라도
--조건을 만족하는 1건만 찾으면 추가적인 검색을 진행하지 않는다.

SELECT S.STADIUM_ID ID, S.STADIUM_NAME 경기장명
FROM STADIUM S
WHERE EXISTS (SELECT *
    FROM SCHEDULE D
    WHERE (TO_NUMBER(D.SCHE_DATE)) BETWEEN 20120500 AND 20120533
        AND S.STADIUM_ID LIKE D.STADIUM_ID
)
ORDER BY 2
;

--21 이현 선수 소속팀의 선수명단 출력
-- P.PLAYER_NAME 선수명, P.POSITION 포지션, P.BACK_NO 백넘버
SELECT COUNT(*)
FROM PLAYER P JOIN (SELECT X.TEAM_ID
        FROM PLAYER X
        WHERE X.PLAYER_NAME LIKE '이현') Y
    ON P.TEAM_ID LIKE Y.TEAM_ID
ORDER BY 1
;

--22 NULL 처리에 있어 SUM(NVL(SAL.0))로 하지말고
-- NVL(SUM(SAL),0) 으로 해야 자원낭비가 줄어든다
-- 팀별 포지션별 인원수와 팀별 전체 인원수 출력
SELECT P.TEAM_ID
    ,NVL(SUM(CASE WHEN P.POSITION LIKE 'FW' THEN 1 ELSE 0 END),0) FW
    ,NVL(SUM(CASE WHEN P.POSITION LIKE 'FW' THEN 1 ELSE 0 END),0) MF
    ,NVL(SUM(CASE WHEN P.POSITION LIKE 'FW' THEN 1 ELSE 0 END),0) DF
    ,NVL(SUM(CASE WHEN P.POSITION LIKE 'FW' THEN 1 ELSE 0 END),0) GK
    ,COUNT(*)
FROM TEAM T JOIN PLAYER P
    ON P.TEAM_ID LIKE T.TEAM_ID
GROUP BY P.TEAM_ID
;

--23 GROUP BY 절 없이 전체 선수들의 포지션별 평균 키 및 전체 평균 키 출력
SELECT DISTINCT (SELECT ROUND(AVG(X.HEIGHT),2)
    FROM PLAYER X
    WHERE X.POSITION LIKE 'MF') 미드필더,
    (SELECT ROUND(AVG(X.HEIGHT),2)
    FROM PLAYER X
    WHERE X.POSITION LIKE 'FW') 포워드,
    (SELECT ROUND(AVG(X.HEIGHT),2)
    FROM PLAYER X
    WHERE X.POSITION LIKE 'DF') 디펜더,
    (SELECT ROUND(AVG(X.HEIGHT),2)
    FROM PLAYER X
    WHERE X.POSITION LIKE 'GK') 골키퍼,
    (SELECT ROUND(AVG(X.HEIGHT),2)
    FROM PLAYER X) 전체평균키
FROM PLAYER P
;

--24 소속팀별로 키가 가장 작은 사람들의 정보
SELECT T.TEAM_ID 팀아이디, MIN(P.HEIGHT)
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
GROUP BY T.TEAM_ID, P.HEIGHT
    HAVING P.HEIGHT LIKE (
        SELECT MIN(X.HEIGHT)
        FROM PLAYER X
        WHERE X.TEAM_ID LIKE P.TEAM_ID
        )
;

-- 25 K리그 2012년 8월 경기결과와 두 팀간의 점수차를 ABS함수를 
-- 사용하여 절대값으로 출력하기
SELECT D.SCHE_DATE, T.TEAM_NAME || '-' || (
    SELECT X.TEAM_NAME
    FROM TEAM X
    WHERE X.TEAM_ID LIKE D.AWAYTEAM_ID
    ) 팀들
    , D.HOME_SCORE || '-' || D.AWAY_SCORE 점수
    , ABS(D.HOME_SCORE - D.AWAY_SCORE) 점수차
FROM SCHEDULE D JOIN TEAM T 
    ON D.STADIUM_ID LIKE T.STADIUM_ID
WHERE TO_NUMBER(D.SCHE_DATE) BETWEEN 20120800 AND 20120840
ORDER BY 1, 4 DESC
;

--26 20120501 부터 20120602 사이에 경기가 있는 경기장 조회
SELECT DISTINCT 스타디움코드, 경기장명
FROM (SELECT Y.STADIUM_ID
    FROM SCHEDULE Y
    WHERE TO_NUMBER(Y.SCHE_DATE) 
        BETWEEN 20120501 AND 20120602) D
    JOIN 
    (SELECT S.STADIUM_ID 스타디움코드, S.STADIUM_NAME 경기장명
     FROM STADIUM S) Z
    ON D.STADIUM_ID LIKE Z.스타디움코드
;

--27 선수정보와 해당 선수와 속한 팀의 평균키 조회
-- 단 정렬시 평균키 내림차순

SELECT T.TEAM_NAME 팀명, P.PLAYER_NAME 선수명
    , P.HEIGHT 키, (SELECT ROUND(AVG(X.HEIGHT),3)
        FROM PLAYER X
        WHERE X.TEAM_ID LIKE P.TEAM_ID) 평균키
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
ORDER BY 4 DESC
;

--28 평균키가 삼성 블루윙즈의 보다
-- 작은 팀의 이름과 해당 팀의 평균키

SELECT P.TEAM_ID 팀아이디, T.TEAM_NAME 팀명, ROUND(AVG(P.HEIGHT),2) 평균키
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
GROUP BY P.TEAM_ID, T.TEAM_NAME
    HAVING AVG(P.HEIGHT) < (SELECT AVG(X.HEIGHT)
        FROM PLAYER X
        WHERE X.TEAM_ID LIKE 'K02'
        )
;

--29 드래곤즈, FC서울, 일화천마 각각의 팀 소속의 GK, MF 선수 정보
SELECT Y.소속팀, X.포지션, X.백넘버, X.선수명, X.키
FROM (SELECT P.POSITION 포지션
    ,P.BACK_NO 백넘버, P.PLAYER_NAME 선수명
    ,P.HEIGHT
    FROM PLAYER P
    WHERE P.POSITION IN ('GK','MF')
    ) X
    JOIN (SELECT T.TEAM_NAME 소속팀, T.TEAM_ID
    FROM TEAM T
    WHERE T.TEAM_NAME IN ('FC서울','일화천마','드래곤즈')
    ) Y
    ON X.TEAM_ID = Y.TEAM_ID
ORDER BY 1 ,2 ,3
;

--30 29번에서 제시한 팀과 포지션이 아닌 선수들의 수
SELECT COUNT(*)
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE NOT T.TEAM_NAME IN('드래곤즈','FC서울','일화천마')
    AND NOT P.POSITION IN('GK','MF')
;


