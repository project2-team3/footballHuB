package com.example.FootballHuB.service;

import com.example.FootballHuB.dto.PrincipalDetails;
import com.example.FootballHuB.dto.MemberFormDto;
import com.example.FootballHuB.entity.Member;
import com.example.FootballHuB.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession session;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getRegistrationId();    //google
        String providerId = oAuth2User.getAttribute("sub");
        String name = provider + "_" + providerId;
        // 사용자가 입력한 적은 없지만 만들어준다

        String uuid = UUID.randomUUID().toString().substring(0, 7);
        String password = "패스워드" + uuid;
        // 사용자가 입력한 적은 없지만 만들어준다

        String email = oAuth2User.getAttribute("email");

        Member byUsername = memberRepository.findByEmail(email);
        if (byUsername == null) {
            MemberFormDto memberFormDto = new MemberFormDto();
            memberFormDto.setEmail(email);
            memberFormDto.setName(name);
            memberFormDto.setAddress("");
            memberFormDto.setPassword(password);
            memberFormDto.setProvider(provider);
            memberFormDto.setProviderId(providerId);
            byUsername = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(byUsername);
            session.setAttribute("member", memberFormDto);
        }
        return new PrincipalDetails(byUsername, oAuth2User.getAttributes());
    }
}
