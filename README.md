# "한번에끝내는Java/Spring웹개발마스터초격차패키지" 학습 레포

## 학습 방법
- 출퇴근 시간을 활용하여 강의를 수강하며 노션에 정리한다.
- 깃헙 README 파일예 다시 정리한다.
- 실습이 필요한 코드를 다시 작성해본다.

---

## Ch1

- Jpa는 hibernate의 구현체
- Jakrta 라는 패키지를 불러온다
- Lombok nonnull을 null값을 넣을수 없는 column에 붙이며 당연히 필수값이 된다.

## Ch2

- Jparepo - Crudrepo - repo 순서대로 상속한다
- 개발할때 주로 사용하는 정도는 crud레포이다
- call next value for hibernate_sequence
    - hibernate 에게 seauqence 정보를 알려준다.
- resource 경로에 data.sql 파일을 작성하면 spring boot가 실행할 때 sql 파일을 먼저 실행시켜준다.

```yaml
# JPA 컨피그 설정
jpa:
	show-sql: true # sql을 보여주는 설정
	properties:
		hibernate:
			format_sql: true # 가독성을 좋게하기 위한 설정 -> 일반적으로 생각하는 SQL문 형태로 노출된다.
```

- findAll 할때 sorting 하는 방법

```java
yourRepository.findAll(Sort.by(Direction.DESC), "[원하는 column]");
```

- DeleteAll은 컬럼별로 삭제한다
- DeleteAllInbatch는 한번에 삭제한다
- Paging 처리
    - FindAll(Pagerequest.of(0,3))의 형태로 요청한다.
    - Page<User> 형태로 담아 다양한 정보를 얻을 수 있다.
