package com.shop.config;

import com.shop.entity.Member;
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

    /**
     * UserDetails 구현
     * 해당 유저의 권한목록 리턴
     */
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
    /**
     * OAuth2User 구현
     * @return
     */
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    /**
     * OAuth2User 구현
     * @return
     */
    @Override
    public String getName() {
        String sub = attributes.get("sub").toString();
        return sub;
    }
}