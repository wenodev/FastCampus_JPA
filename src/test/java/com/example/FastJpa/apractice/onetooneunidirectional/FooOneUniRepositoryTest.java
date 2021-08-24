package com.example.FastJpa.apractice.onetooneunidirectional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/*
- oneToOne 단방향에서 애너테이션을 붙인 쪽에서 다른쪽을 어떻게 관리할 수 있을지 알아본다.
- cascade 사용 방법과 시기에 대해 알아본다.
- option에 따른 SQL문 변화를 알아본다.
# 알게된점
- one to one 단방향일 경우, 추가적으로 신경쓸필요 없이 lazy 로딩을 적용하면 된다.
- 상황에 알맞게 castacde 와 option을 활용하여 편하게 사용하면된다.
 */
@SpringBootTest
class FooOneUniRepositoryTest {

    @Autowired
    private FooOneUniRepository fooOneRepository;

    @Autowired
    private FooTwoUniRepository fooTwoRepository;

    private FooOneUni fooOne;

    /*
    - FooOne에  @OneToOne만 붙인 경우
    - FooOne에 FooTwo를 저장한다.
    - FooTwo를 FooTwoRepository에 저장하지 않고 FooOne에서 저장하면 오류가 발생한다. 영속화가 되지 않았기 때문이다.
        - CascadeType.PERSIST을 설정하거나 fooTwoRepository에 저장해서 불러와야 한다.
     */
    @BeforeEach
    void test_save(){
        System.out.println(">>> save");

        FooTwoUni fooTwo = fooTwoRepository.save(FooTwoUni.builder()
                .name("foo two")
                .build());

        fooOne = fooOneRepository.save(FooOneUni.builder()
                .name("foo one")
                .fooTwo(fooTwo)
                .build());
    }


    //lazy laoding을 적용하면 필요할때만 연관된 엔티티를 불러온다.
    @Test
    void test_select(){
        // - fooOne을 select하게 되면 join하지 않고 fooOneEntity와 fooTwoEntity를 각각 select 한다.
        System.out.println(">>> select1");
        fooOneRepository.findAll();

        System.out.println(">>> select2");
        System.out.println((fooOneRepository.findById(1L).orElseThrow(RuntimeException::new)));

        // - fooTwo을 select할때 left outer join이 일어난다.
        // optional == false(null == false) 조건을 주면 inner join이다.
        // left outer join 보다는 inner join의 성능이 좋기 때문에 FooTwo가 필수값이 될 수 있는지 확인하는게 좋다.
        // 만약 FooTwo가 없는데 불러온다면 NullPointerException이 발생한다. 어떻게 해결하면 좋을지 고민해봐야한다.
        //  필수값일때만 사용하는것보 방법 중 하나이다.
        System.out.println(">>> select3");
        System.out.println(fooOneRepository.findById(1L).orElseThrow(RuntimeException::new)
                .getFooTwo().getName());
    }

    /*
    - fooTwo를 수정할 수 있다.
     */
    @Test
    void test_update(){
        System.out.println(">>> update1");
        fooOne.setName("foo-modified");
        fooOneRepository.save(fooOne);

        System.out.println(">>> update2");
        fooOne.setFooTwo(FooTwoUni.builder()
                        .name("fooTwoname-two")
                .build());
        fooOneRepository.save(fooOne);
    }

    /*
    - cascade remove로 설정하면 같이 지워진다.
     */
    @Test
    void test_delete(){
        System.out.println(">>> delete");
        fooOneRepository.deleteById(1L);
    }

}
