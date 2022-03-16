package spring.core.member;

public class MemberServiceImpl implements MemberService{

    //private final MemberRepository meberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member membrer) {
        memberRepository.save(membrer);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
