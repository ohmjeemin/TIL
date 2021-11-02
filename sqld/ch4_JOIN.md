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





