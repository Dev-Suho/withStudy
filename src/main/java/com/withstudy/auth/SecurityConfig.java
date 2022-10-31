package com.withstudy.auth;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity  // 모든 요청 URL이 Spring Security 제어를 받음
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                    .antMatchers("/**").permitAll()  // 설정한 리소스의 접근을 인증절차 없이 허용
                    .anyRequest().authenticated()  // 나머지 모든 리소스에 인증이 필요
                    .and()
                .formLogin()
                    .loginPage("/login")  // 기본 로그인 페이지
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();

        return httpSecurity.build();
    }

    /*
    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println(encoder.encode("password"));
        String encryptText = encoder.encode("password");

        UserDetails user = User.withUsername("user")
                .password(encryptText)
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
     */

    // BCrypt 해싱 함수를 사용하여 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
