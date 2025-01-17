package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("gayeon");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(result, member);
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("gayeon1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("gayeon2");
        repository.save(member2);

       Member result = repository.findByName("gayeon2").get();

       Assertions.assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("gayeon1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("gayeon2");
        repository.save(member2);

        List<Member> list = repository.findAll();
        Assertions.assertThat(list.size()).isEqualTo(2);
    }
}
