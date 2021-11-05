##### 순수 관계 연산자

- SELECT, PROJECT, JOIN, DIVIDE

###### 

##### 계층구조

- 계층적 쿼리는 오라클만 가진 기능 중 하나이다.

- connect by prior c1 = c2 ... -> 방금 전 행의 c1값이 현재행의 c2인 행을 찾아라.

  

**서브 쿼리** : 하나의 SQL문안에 포함되어 있는 또 다른 SQL문, 알려지지 않은 기준을 이용한 검색에 사용 

**서브 쿼리 사용시 주의 사항**

1. 서브쿼리를 괄호로 감싸서 사용한다.

2. 서브쿼리는 단일 행 또는 복수 행 비교 연산자와 함께 사용 가능하다.
     단일 행 비교 연산자는 서브쿼리의 결과가 반드시 1건 이하여야 하고 복수 행 비교 연산자는 결과 건수와 상관없다.

3. 서브쿼리에서는 ORDER BY를 사용하지 못한다.
4.  SELECT, FROM, WHERE, HAVING, ORDER BY, INSERT-VALUES, UPDATE-SET 절에 사용 가능



\* 단일 행 서브쿼리

\- 서브쿼리의 실행 결과가 항상 1건 이하인 서브쿼리

\- 단일 행 비교 연산자와 함께 사용

\- =, <, >, <=, >=, <>



\* 다중 행 서브쿼리

\- 서브쿼리의 실행 결과가 여러 건인 서브쿼리

\- 다중 행 비교 연산자와 함께 사용

\- IN, ALL, ANY, SOME, EXISTS



\* 다중 칼럼 서브쿼리

\- 서브쿼리의 실행 결과로 여러 칼럼을 반환

\- 메인쿼리의 조건절에 여러 칼럼을 동시 비교

\- 서브쿼리와 메인쿼리에서 비교하고자 하는 칼럼 개수와 칼럼의 위치가 동일해야 함

**
**

\* 인라인 뷰

\- 테이블 명이 올 수 있는 곳에 사용, ORDER BY 사용 가능

 

**ㅇ 뷰** : 테이블은 실제로 데이터를 가지고 있는 반면, 뷰는 실제 데이터를 가지고 있지 않다.(가상 테이블)

 

*** 뷰 사용 장점**

**1.** **독립성** : 테이블 구조가 변경되어도 뷰를 사용하는 응용프로그램은 변경하지 않아도 된다.

**2.** **편리성** : 복잡한 질의를 뷰로 생성함으로써 관련 질의를 단순하게 작성할 수 있다.

**3.** **보안성** : 직원의 급여정보와 같이 숨기고 싶은 정보가 존재할 때 사용

CREATE VIEW V_PLAYER_TEAM AS ~

DROP VIEW V_PLAYER_TEAM;



**ㅇ ROLLUP**

\- Subtotal을 생성하기 위해 사용

\- Grouping Columns의 수를 N이라고 했을 때 N+1 Level의 Subtotal이 생성 (인수 순서에 주의)



| 1234 | SELECT DNAME, JOB, COUNT(*) "Total Empl", SUM(SAL) "Total Sal" FROM EMP, DEPT WHERE DEPT.DEPTNO = EMP.DEPTNO GROUP BY ROLLUP (DNAME, JOB);[Colored by Color Scripter](http://colorscripter.com/info#e) | [cs](http://colorscripter.com/info#e) |
| ---- | ------------------------------------------------------------ | ------------------------------------- |
|      |                                                              |                                       |



**
**

*** GROUPING** : Subtotal의 total을 생성

*** CUBE** : 결합 가능한 모든 값에 대하여 다차원 집계를 생성. ROLLUP에 비해 시스템에 부하 심함

*** GROUPING SETS** : 인수들에 대한 개별 집계를 구할 수 있다 (다양한 소계 집합 생성 가능)



출처: https://data-make.tistory.com/478 [Data Makes Our Future]

- 