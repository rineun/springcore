package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        basePackages = "spring.core",
        excludeFilters = @Filter(type= FilterType.ANNOTATION, classes=Configuration.class)
)
public class AutoAppConfig {

    //수동빈 등록  vs 자동빈 등록  -> 수동 빈 등록이 우선권을 가진다. => (수동 빈이 자동 빈을 오버라이딩 해버린다.)
    /*
    @Bean(name="memoryMemberRepository")
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

     */
}
