package com.example.FootballHuB.config;

import com.example.FootballHuB.controller.Schedule_controller.ScheduleController;
import com.example.FootballHuB.service.MemberService;
import com.example.FootballHuB.service.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    MemberService memberService;

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/members/login")
                .successHandler(new CustomLoginSuccessHandler("/"))
                .usernameParameter("email")
                .failureUrl("/members/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .invalidateHttpSession(false)
                .logoutSuccessHandler(new CustomLogoutSuccessHandler("/"))
                .and()
                .oauth2Login()
                .successHandler(new CustomLoginSuccessHandler("/"))
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
        ;

        http.authorizeRequests()
                // 업데이트 엔드포인트에 대한 권한 설정
                .antMatchers("/chatting/**","/update-spin-count").permitAll()
                .mvcMatchers("/css/**", "/js/**", "/imgs/**", "/img/**", "/scss/**", "/fonts/**").permitAll()
                .mvcMatchers("/", "/members/**", "/item/**", "/images/**", "/shop/**", "/comment/**","/game/**").permitAll()
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        ;

        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint());


        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS); // 세션 항상 생성

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}