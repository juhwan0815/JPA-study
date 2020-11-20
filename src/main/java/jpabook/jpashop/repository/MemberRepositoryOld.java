package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
@RequiredArgsConstructor // 스프링 데이터 JPA에서 지원하는 기능 @Autowired 가능
public class MemberRepositoryOld {

    private final EntityManager em;
//    @PersistenceContext // EntityManager 를 스프링이 주입
//    private EntityManager em;

//    @PersistenceUnit
//    private EntityManagerFactory emf; // EntityManagerFactory 를 스프링이 주입

    public void save(Member member){
        em.persist(member); // 영속화
    }

    public Member findOne(Long id){
        return em.find(Member.class,id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
    }
}
