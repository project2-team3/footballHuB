package com.example.FootballHuB.dto;

import com.example.FootballHuB.entity.Member;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
@ToString
public class PrincipalDetails implements OAuth2User {

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
}