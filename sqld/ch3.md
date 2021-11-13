## 과목 2. SQL 기본 및 활용

### 제 1장. SQL 기본

### 1. '비절차적 데이터 조작어' 와 '절차적 데이터 조작어'

- 비절차적 데이터 조작어: 사용자가 무슨(WHAT) 데이터를 원하는 지 만을 명세
- 절차적 데이터 조작어: 사용자가 무슨 데이터를 원하는지 + 어떻게 데이터에 접근해야 하는지
  - EX) PL/SQL. T-SQL

### 2. 컬럼 수정 시

**ALTER TABLE 테이블명 ALTER COLUMN 컬럼명 바뀔 내용;**

EX)`ALTER TABLE user COLUMN name VARCHAR(30) NOT NULL;`

‼️기존에 있던 제약 조건은 다시 써 줘야 한다.

### 3. UNIQUE KEY

- 테이블 내에서 중복되는 값은 없지만, NULL 입력이 가능하다.

### 4. CONSTRAINTS에 대한 설명

- CHECK 제약 조건은 데이터베이스에서 무결성을 유지하기 위하여 테이블의 특정 컬럼에 설정하는 제약이다.
- 기본키는 반드시 테이블 당 하나이다.
- 고유키로 지정된 모든 컬럼은 NULL을 가질 수 있다.
- 외래키는 테이블 간의 관계를 정의하기 위해 기본키를 다른 테이블의 외래키가 참조하도록 한다.

### 5. 컬럼 삭제

**ALTER TABLE 테이블명 DROP COLUMN 컬럼명;**

### 6. 참조 무결성 규정

- CASCADE → master 삭제 시 child도 같이 삭제
- SET NULL → master 삭제 시 child 해당필드를 null로 세팅
- SET DEFAULT → master 삭제 시 설정해놓은 default값으로 세팅
- RESTRICT → child 테이블에 PK 값이 없는 경우에만 master 삭제 가능
- NO ACTION → 참조 무결성을 위반하는 삭제/수정 액션을 취하지 않음.

### 7. 테이블명 변경

**RENAME 테이블명 TO 새테이블명;**

### 8. 관계형 데이터베이스에서 child table의 FK 데이터 생성 시 parent table에 PK가 없는 경우, child table 데이터 입력을 허용하지 않는 참조 동작은?

- Dependent
- Automatic → master에 PK가 없는 경우 master 생성 후 child 입력

### 9. 테이블의 데이터를 삭제하는 가장 좋은 방법

- TRUNCATE와 DROP TABLE은 로그를 남기지 않음.

### 10. TRUNCATE 명령어는 UNDO를 위한 데이터를 생성하지 않기 때문에 동일 데이터량 삭제 시 DELETE보다 빠르다.

- DROP
  - DDL
  - ROLLBACK 불가능
  - AUTO COMMIT
  - 테이블 정의 자체 삭제
- TRUNCATE
  - DDL
  - ROLLBACK 불가능
  - AUTO COMMIT
  - 테이블 생성 초기로 만듬
- DELETE
  - DML
  - COMMIT 이전 ROLLBACK 가능
  - 사용자 COMMIT
  - 데이터만 삭제 가능!!

### 11. 트랜잭션: 데이터베이스의 논리 연산 단위로서 밀접히 관련되어 분리될 수 어버슨 한 개 이상의 데이터베이스 조작을 가리킴

### 12. HAVING 절에 GROUP BY 있으면 HAVING에 집계 함수가 있어야 한다.

### 13. CASE문

- simple case
  - CASE location WHEN 'New York' THEN 'East' ELSE 'ETC' END
- searched case
  - CASE WHEN location = 'New York' THEN 'East' ELSE 'ETC' END 

### 14. 단일행 NULL 관련 함수

- NVL(exp1, exp2) : exp1== null이면 exp2 리턴
- NULLIF(exp1, exp2) : exp1== exp2이면 null 리턴 exp1 != exp2 라면 exp1 리턴

- COALESCE(exp1, exp2, exp3, ... ) : exp1, exp2 .... 표현식 결과 중에 최초로 NULL이 아닌 결과 리턴



### 15. 다중행 함수 vs 단일행 함수

- 다중행 함수는 count(), sum() 이런 여러 행이 입력되는 것
- 단일행 함수는 to_char(), to_date() 이런 여러 행이 입력되는 것



### 16. 그룹함수

- 다수의 행 데이터를 한번에 처리
- 장점 : 함수 연산 시 null 데이터를 함수 내부적으로 사전에 고려해서 null값 보유한 필드는 로직 연산 시에 제외한다.
- 중첩된 그룹함수의 경우 최종 결과값은 1건이다!