package com.example.FootballHuB.dto;

import com.example.FootballHuB.entity.Member;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
@ToString
public class PrincipalDetails implements OAuth2User, UserDetails {

    private Member member;
    private Map<String, Object> attributes;

    //UserDetails : Form 로그인 시 사용
    public PrincipalDetails(Member member) {
        this.member = member;
    }

    //OAuth2User : OAuth2 로그인 시 사용
    public PrincipalDetails(Member member, Map<String, Object> attributes) {
        //PrincipalOauth2UserService 참고
        this.member = member;
        this.attributes = attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole().toString();
            }
        });
        return collect;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return attributes.get("sub").toString();
    }

    @Override
    public String getUsername() {
        return member.getName(); // 사용자의 이름을 반환합니다.
    }
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 사용자 계정이 만료되지 않았음을 반환합니다. 만약 사용자 계정 만료를 처리하려면 조건을 적용하세요.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 사용자 계정이 잠겨 있지 않음을 반환합니다. 만약 사용자 계정 잠금 여부를 처리하려면 조건을 적용하세요.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 사용자 자격 증명이 만료되지 않았음을 반환합니다. 만약 사용자 자격 증명의 만료 여부를 처리하려면 조건을 적용하세요.
    }

    @Override
    public boolean isEnabled() {
        return true; // 사용자 계정이 활성화되었음을 반환합니다. 만약 사용자 계정의 활성화 여부를 처리하려면 조건을 적용하세요.
    }


}