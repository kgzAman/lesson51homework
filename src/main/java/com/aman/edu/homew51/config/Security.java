package com.aman.edu.homew51.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class Security extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/subscription/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/images/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/publication/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE, "/publication/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE, "/likes/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/likes/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.DELETE, "/comment/**")
                .fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/comment/**")
                .fullyAuthenticated();

        http.authorizeRequests()
                .anyRequest()
                .permitAll();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.httpBasic();
        http.formLogin().disable().logout().disable();
        http.csrf().disable();
    }
}


