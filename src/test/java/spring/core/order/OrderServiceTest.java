package spring.core.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.core.AppConfig;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;
    //MemberService memberService = new MemberServiceImpl(meberRepository);
    //OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService= appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
