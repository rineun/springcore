package spring.core.member;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryMemberRepository implements MemberRepository {

    // HashMap 동시성 이슈가 발생함  ==> ConcurrentHashMap
    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
       return store.get(memberId);
    }
}
