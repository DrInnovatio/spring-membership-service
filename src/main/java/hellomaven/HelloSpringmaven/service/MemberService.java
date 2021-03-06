package hellomaven.HelloSpringmaven.service;

import hellomaven.HelloSpringmaven.domain.Member;
import hellomaven.HelloSpringmaven.repository.MemberRepository;
import hellomaven.HelloSpringmaven.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Joining the membership.
    public Long join(Member member){
        // not allow to join the membership with the same names.
        validateDuplicatedMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("The name has existed already.");
                });
    }
// 16강 부터

    /**
     * Inquiring all the members
     */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // the second commit test
    //
}
