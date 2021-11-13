##### 순수 관계 연산자

- SELECT, PROJECT, JOIN, DIVIDE

##### 계층구조

- 계층적 쿼리는 오라클만 가진 기능 중 하나이다.

- connect by prior c1 = c2 ... -> 방금 전 행의 c1값이 현재행의 c2인 행을 찾아라.

  

**서브 쿼리** 

- 서브쿼리는 단일행 또는 복수행 비교 연산자와 함께 사용할 수 있다.
- 서브쿼리는 SELECT, FROM, HAVING, ORDER BY 절 등에서 사용이 가능하다.
- 연관(Correlated) 서브쿼리는 서브쿼리가 메인쿼리 컬럼을 포함하고 있는 형태의 서브쿼리이다.
- 서브쿼리의 결과가 복수행 결과를 반환하는 경우에는 IN, ANY, ALL 등의 복수행 비교 연산자와 사용해야 한다.
- 다중 컬럼 서브쿼리는 서브쿼리의 결과로 여러개의 컬럼이 반환되어 메인 쿼리의 조건과 비교되는데, SQL server에서는 현재 지원하지 않는 기능이다.



##### count 절 - when

COUNT(CASE WHEN s.동의여부='N' THEN 0 ELSE NULL END) >= 1



###### group by 절이 없는 집계 쿼리

집계 기준은 전체 집합이다.

ex) 

SELECT deptno, COUNT(*) cnt

 FROM emp 

GROUP BY deptno; 는 부서별 집계

SELECT COUNT(*) FROM emp; 는 전체 집계



##### 서브쿼리

- 단일행 서브쿼리의 연산자로는 =, <, <=, >, >=, <> 가 되어야한다.
- 단일행 서브쿼리의 비교연산자는 다중행 서브쿼리의 비교연산자로 사용할 수 없지만, 반대의 경우는 가능하다.
- 비연관 서브쿼리가 주로 메인 쿼리에 값을 제공하기 위한 목적으로 사용된다.
- 메인쿼리의 결과가 서브쿼리로 제공될 수도 있고, 서브쿼리의 결과가 메인 쿼리로 제공될 수도 있으므로 실행 순서는 상황에 따라 달라진다.
- inline view(= 동적뷰, dynamic view) 는 from 절에 있는 서브쿼리이다.
- select절에 사용된 서브쿼리는 스칼라 서브쿼리이다.



##### grouping sets

- 표시된 인수들에 대한 개별 집계를 구할 수 있음
- 이 때 표시된 인수들 간에는 계층 구조인 ROLLUP과는 달리 평등한 관계이므로 인수의 순서가 바뀌어도 결과는 같다.
- GROUPING SETS 함수도 결과에 대한 정렬이 필요한 경우는 ORDER BY 절에 명시적으로 정렬 컬럼이 표시되어야 한다. 



##### 윈도우 함수(window function, Analytic Function)

- partition과 group by 구문은 의미적으로 유사하다
- partition 구문이 없으면 전체 집합을 하나의 partition으로 정의한 것과 동일하다.
- 윈도우 함수는 결과에 대한 함수 처리이기 때문에 결과 건수는 줄지 않는다.
- 윈도우 함수 적용 범위는 partition을 넘을 수 없다. 



##### 순위를 구하는 함수

RANK, DENSE_RANK, ROW_NUMBER 함수 

- RANK -> 중간 순위를 비움
- DENSE_RANK -> 중간 순위를 비우지 않음

- ROW_NUMBER 함수는 RANK나 DENSE_RANK 함수가 동일한 값에 대해서는 동일한 순위를 부여하는데 반해, 동일한 값이라도 고유한 순위를 부여한다.



##### RANGE between 1000 PRECEDING and 1000 FOLLOWING

**UNBOUNDED PRECEDING** - **PRECEDING** - **CURRENCT ROW** - **FOLLOWING** - **UNBOUNDED FOLLOWING**



##### LAG OVER, LEAD OVER

- 파티션별 윈도우에서 이전 몇 번째 행의 값을 가져올 수 있다. 

- 이후 몇번 째 행의 값을 가져오는 것은 LEAD 함수이며 SQL SERVER에서는 지원하지 않는다.



##### PL/SQL

- 변수와 상수 등을 사용하여 일반 SQL 문장을 실행할 때 WHERE절의 조건 등으로 대입할 수 있다.
- Procedure, User Defined Function, Trigger 객체를 PL/SQL로 작성할 수 있다.
- Procedure 내부에 작성된 절차적 코드는 PL/SQL 엔진이 처리하고 일반적인 SQL 문장은 SQL 실행기가 처리한다. 
- 

