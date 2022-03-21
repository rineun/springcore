package spring.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.core.discount.DiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;

@Component
//@RequiredArgsConstructor  //final이 붙은 필드를 모아서 생성자를 자동으로 만들어준다
public class OrderServiceImpl implements OrderService{

   // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //생성자 주입
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자 주입
    // @MainDiscountPolicy : 내가 만든 어노테이션
    //@Qualifier("mainDiscountPolicy")
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //필드주입
    /*
    @Autowired
    private  MemberRepository memberRepository;
    @Autowired
    private  DiscountPolicy discountPolicy;

     */


    //수정자 주입
    //@Autowired(required = false) 주입대상 없을시에는 false넣어준다
    /*
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

     */

    //일반 메서드 주입
    /*
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    *
     */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =  memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }


}
