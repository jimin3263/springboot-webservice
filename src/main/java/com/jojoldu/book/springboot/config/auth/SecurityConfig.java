package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //spring security 설정 활성화시킴
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().headers().frameOptions().disable() //h2 console 화면
                .and()
                .authorizeRequests()
                .antMatchers("/","/css/**","/images/**", "/js/**","/h2-console/**").permitAll()//전체 열람
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //USER만 확인 가능
                .anyRequest().authenticated()//나머지 -> 인증된 사용자(로그인)
                .and()
                .logout().logoutSuccessUrl("/")//로그아웃 성공 설정
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService); //로그인 성공이후 -> 진행
    }
}
