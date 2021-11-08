package hellomaven.HelloSpringmaven.service;

import hellomaven.HelloSpringmaven.domain.Member;
import hellomaven.HelloSpringmaven.repository.MemberRepository;
import hellomaven.HelloSpringmaven.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
