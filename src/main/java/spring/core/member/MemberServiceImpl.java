package spring.core.member;

public class MemberServiceImpl implements MemberService{

    private final MeberRepository meberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member membrer) {
        meberRepository.save(membrer);

    }

    @Override
    public Member findMember(Long memberId) {
        return meberRepository.findById(memberId);
    }
}
