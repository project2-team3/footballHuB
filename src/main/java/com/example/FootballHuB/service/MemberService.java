package com.example.FootballHuB.service;

import com.example.FootballHuB.entity.gameEntity.GameGift;
import com.example.FootballHuB.repository.MemberRepository;
import com.example.FootballHuB.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Transactional
    public void updateSpinCountByEmail(String email, int spinCount) {
        Member member = memberRepository.findByEmail(email);
        if (member != null) {
            member.setSpinCount(spinCount);
            memberRepository.save(member);
        } else {
            throw new EntityNotFoundException("해당 이메일 주소를 가진 사용자를 찾을 수 없습니다: " + email);
        }
    }
    public int getSpinCountByEmail(String email) {
        Member member = memberRepository.findByEmail(email);
        if (member != null ) {
            return member.getSpinCount();
        } else {
            return 0; // 사용자를 찾을 수 없을 때 0을 반환하거나 예외를 던질 수 있습니다.
        }
    }

    // 스핀 횟수를 초기화하고 세션에서 마지막 스핀 시간을 제거하는 메소드
    @Scheduled(cron = "0 0 12 * * ?") // 매일 오후 12시에 실행
    public void resetSpinCount() {
        List<Member> members = memberRepository.findAll();
        int spinCount = 1; // 스핀 횟수를 0으로 초기화

        for (Member member : members) {
            member.setSpinCount(spinCount);
            memberRepository.save(member); // 사용자 정보를 업데이트하여 스핀 횟수 초기화
        }
    }
    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);
        if(member == null){
            throw new UsernameNotFoundException(email);
        }
        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}