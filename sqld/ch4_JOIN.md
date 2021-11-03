#### JOIN이 헷갈려서 정리하는 문서

INNER JOIN 할 때 PK가 WHERE 절에 다 있어야 함

테이블 사이의 JOIN의 조건이 없는 경우엔 카티시안곱 발생

```sql
SELECT A.고객ID, A.고객명, SUM(B.사용량*C.단가) AS 사용금액
FROM 고객 A INNER JOIN 시간대별 사용량 B
ON(A.고객ID = B.고객ID) INNER JOIN 시간대구간 C
ON B.사용시간대 BETWEEN C.시작시간대 AND C.종료시간대
GROUP BY A.고객ID, A.고객명
ORDER BY A.고객ID, A.고객명;
```

서브 쿼리를 쓰면 안되는 경우 -> 서브 쿼리 테이블과 메일 쿼리 테이블이 같은 경우

조인 쿼리를 서브 쿼리로 변경할 수 있다.

NULL은 조인에 참여하지 않는다.

EXIST, NOT EXIST -> 서브 쿼리가 TRUE인지 FALSE인지 체크하는 것

OUTER JOIN은 ANSI 표준이며, Oracle에서는 (+)로 표현할 수 있다.

ex) 

​	SELECT * FROM a, b WHERE b.id(+) = a.id -- Oracle OUTER JOIN

​	SELECT * FROM a LEFT OUTER JOIN b ON b.id = a.id -- 동일한 표현	

​	출처: https://blog.edit.kr/entry/Oracle-쿼리중에-의-의미 [소금인형 - SW개발자?]

b.id (+) 이렇게 되어 있으면 저 b의 id가 없으면 NULL을 넣어달라는 뜻이다.
