package com.example.FastJpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//	1. many to one 단방향으로 해결할 수 있는관계인지 확인한다. (one to many 단방향은 지양한다.)
//			2. 못한다면 one to many / many to one 양방향으로 설정한다.
//
//
//			- cascade 설정해주면 한쪽에서 다른쪽으로 create 할 수 있다.
//			- JPA가 다른쪽의 entity를 먼저 저장해준다.
//
//
//
//			- oneToOne 단방향에서 애너테이션을 붙인 쪽에서 다른쪽을 어떻게 관리할 수 있을지 알아본다.
//			- cascade 사용 방법과 시기에 대해 알아본다.
//			- option에 따른 SQL문 변화를 알아본다.
//			# 알게된점
//			- one to one 단방향일 경우, 추가적으로 신경쓸필요 없이 lazy 로딩을 적용하면 된다.
//			- 상황에 알맞게 castacde 와 option을 활용하여 편하게 사용하면된다.
//
//
//
//			- FooOne에  @OneToOne만 붙인 경우
//		- FooOne에 FooTwo를 저장한다.
//		- FooTwo를 FooTwoRepository에 저장하지 않고 FooOne에서 저장하면 오류가 발생한다. 영속화가 되지 않았기 때문이다.
//		- CascadeType.PERSIST을 설정하거나 fooTwoRepository에 저장해서 불러와야 한다.
//
//
//		lazy laoding을 적용하면 필요할때만 연관된 엔티티를 불러온다.
//
//		- fooOne을 select하게 되면 join하지 않고 fooOneEntity와 fooTwoEntity를 각각 select 한다.
//
//
//		- fooOne을 select하게 되면 join하지 않고 fooOneEntity와 fooTwoEntity를 각각 select 한다.
//
//		- fooTwo을 select할때 left outer join이 일어난다.
//		optional == false(null == false) 조건을 주면 inner join이다.
//		left outer join 보다는 inner join의 성능이 좋기 때문에 FooTwo가 필수값이 될 수 있는지 확인하는게 좋다.
//		만약 FooTwo가 없는데 불러온다면 NullPointerException이 발생한다. 어떻게 해결하면 좋을지 고민해봐야한다.
//		필수값일때만 사용하는것보 방법 중 하나이다.
//
//
//		- cascade remove로 설정하면 같이 지워진다.
@SpringBootTest
class FastJpaApplicationTests {

	@Test
	void contextLoads() {
	}

}
