package spring.core.member;

public interface MeberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
