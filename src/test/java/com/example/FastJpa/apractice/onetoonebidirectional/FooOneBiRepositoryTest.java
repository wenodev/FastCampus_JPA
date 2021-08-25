package com.example.FastJpa.apractice.onetoonebidirectional;

import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class FooOneBiRepositoryTest {

    @Autowired
    private FooOneBiRepository fooOneBiRepository;

    @Autowired
    private FooTwoBiRepository fooTwoBiRepository;

    /*
    - cascade 설정해주면 한쪽에서 다른쪽으로 create 할 수 있다.
    - JPA가 다른쪽의 entity를 먼저 저장해준다.
     */
    @BeforeEach
    void test_save(){
        System.out.println(">>> save1");
//        FooTwoBi fooTwoBi = fooTwoBiRepository.save(FooTwoBi.builder()
//                .name("fooTwo1")
//                .build());
        FooOneBi fooOneBi = FooOneBi.builder()
                .name("fooOne1")
                .fooTwoBi(FooTwoBi.builder()
                        .name("fooTwo1")
                        .build())
                .build();
        fooOneBiRepository.save(fooOneBi);

//        System.out.println(">>> save2");
//        FooTwoBi fooTwoBi = FooTwoBi.builder()
//                .name("fooTwo2")
//                .fooOneBi(FooOneBi.builder()
//                        .name("fooOne2")
//                        .build())
//                .build();
//        fooTwoBiRepository.save(fooTwoBi);
    }

    @Test
    void test_select_all(){
        System.out.println(">>> select1");
        fooOneBiRepository.findAll().forEach(System.out::println);

        System.out.println(">>> select2");
        fooTwoBiRepository.findAll().forEach(System.out::println);
    }

    @Test
    void test_select_part(){
        System.out.println(">>> select1");
        System.out.println(fooOneBiRepository.findAll().size());
        System.out.println(fooOneBiRepository.findById(1L).orElseThrow(RuntimeException::new).getFooTwoBi().getName());

//        System.out.println(">>> select2");
//        System.out.println(fooTwoBiRepository.findAll().size());
//        System.out.println(fooTwoBiRepository.findById(2L).orElseThrow(RuntimeException::new).getFooOneBi().getName());
    }

    @Test
    void test_update(){
        FooOneBi fooOneBi = fooOneBiRepository.findById(1L).orElseThrow(RuntimeException::new);
        fooOneBi.setFooTwoBi(FooTwoBi.builder()
                .name("updateName")
                .build());

        System.out.println(fooOneBi);
        System.out.println(fooOneBi.getFooTwoBi());
    }

    @Test
    void test_delete(){
        System.out.println(">>> delete1");
        fooOneBiRepository.deleteById(1L);

        System.out.println(">>> delete2");
        fooTwoBiRepository.findById(1L).orElseThrow(RuntimeException::new);
    }

}
