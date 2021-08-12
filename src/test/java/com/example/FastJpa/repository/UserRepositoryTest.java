package com.example.FastJpa.repository;

import com.example.FastJpa.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Transactional
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void test_print(){
        userRepository.findAll().forEach(System.out::println);
    }

    /*
    - 조회커리 종류 : find, get, read, query, search, stream
    - find 다음에 나오는 단어는 변경가능하다.
    - 결과가 한개인 쿼리는 Optional로, 한개 이상인 쿼리는 List로 return 해야한다.
     */
    @Test
    void test_select(){
        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin@fastcampus.com"));
    }

    /*
    - [Top or First + 숫자] 형태로 조회하면 [limit + 숫자] 형태의 where절이 실행된다.
    - Top 과 Top1 은 동일한 쿼리를 조회한다.
    - last는 존재하지 않기 때문에 findByName이 실행된다.
     */
    @Test
    void test_select_with_limit(){
        System.out.println("findTopByName : " + userRepository.findTopByName("martin"));
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
        System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));
        System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));
        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));
    }

    @Test
    void test_select_with_logical_operator(){
        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "dennis"));
    }

    /*
    - [findBy + 대소비교구문] 형태로 조회한다.
    - After, GreaterThan은 동일하게 동작한다. (초과)
    - After, GreaterThantEqual은 같은값 포함한다. (이상)
    - Before, Less는 동일하게 동작한다. (미만)
    - Before, LessThanEqual은 같은값 포한한다. (이하)
    - Between은 이상, 이하의 값을 조회한다.
    - 날짜를 비교하여 조회할 때 유용하다.
     */
    @Test
    void test_select_with_comparison_operator(){
        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtBefore : " + userRepository.findByCreatedAtBefore(LocalDateTime.now().plusDays(1L)));
        System.out.println("findByCreatedAtLessThan : " + userRepository.findByCreatedAtLessThan(LocalDateTime.now().plusDays(1L)));
        System.out.println("findByCreatedAtLessThanEqual : " + userRepository.findByCreatedAtLessThanEqual(LocalDateTime.now().plusDays(1L)));

        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));

        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
    }

    @Test
    void test_select_with_nullCheck(){
        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
        System.out.println("findByNameIsNotNull : " + userRepository.findByNameIsNotNull());
    }

    /*
    - 형태1 : findBy + 컬럼 + OrderBy + 원하는 컬럼 + Desc or Asc...
    - 형태2 : findBy + 컬럼 ("컬럼이름", Sort.by(Order.desc("원하는컬럼"), ...))
    - 형태3 : findAll("컬럼이름", Sort.by(Order.desc("원하는컬럼"), ...))
    - 형태4 : findAll("컬럼이름", Sort.by(Direction.DESC("원하는컬럼"), 원하는컬럼)
    - 1번과 2~4번 방법을 상황에 알맞게 사용하면 된다.
    - 업무할때는 주로 2~4번을 활용한다.
     */
    @Test
    void test_sorting(){
        System.out.println("findTopByName : " + userRepository.findTopByName("martin"));
        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("martin"));
        System.out.println("findTop2ByNameOrderByIdDesc : " + userRepository.findTop2ByNameOrderByIdDesc("martin"));
        System.out.println("findByNameOrderByIdDesc : " + userRepository.findByNameOrderByIdDesc("martin"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));

        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Order.desc("id"), Order.asc("email"))));

        System.out.println("findAllOrderByIdDesc : " + userRepository.findAll(Sort.by(Direction.DESC, "id")));
        System.out.println("findAllOrderByIdDesc : " + userRepository.findAll(Sort.by(Order.desc("id"))));
    }

    @Test
    void test_paging(){
        System.out.println("findByNameWithPaging : " + userRepository.findByName("martin", PageRequest.of(1, 1, Sort.by(Order.desc("id")))).getTotalElements());
        System.out.println("findAllWithPaging : " + userRepository.findAll(PageRequest.of(0, 2, Sort.by(Order.desc("id")))).getTotalPages());
        System.out.println("findAllWithPaging : " + userRepository.findAll(PageRequest.of(1, 2)));
        userRepository.findAll(PageRequest.of(1, 2)).forEach(System.out::println);
    }

    @Test
    void test_Enum(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        System.out.println(user);
//        user.setGender(Gender.FEMALE);
        userRepository.save(user);

        System.out.println(userRepository.findById(1L).orElseThrow(RuntimeException::new));
    }

    @Test
    void test_Listener(){
        userRepository.save(User.builder()
                        .email("member6")
                        .name("member6")
                        .build());
        userRepository.findAll().forEach(System.out::println);
    }

}
