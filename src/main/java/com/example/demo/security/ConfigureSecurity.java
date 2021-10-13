package com.example.demo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
@Slf4j
@Component
public class ConfigureSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        try {
//            auth.jdbcAuthentication();
            auth
                    .inMemoryAuthentication()
                    .withUser("prat")
                    .password("prat")
                    .roles("USER");
        } catch (Exception e){
            Logger.getLogger(String.valueOf(e));
        }
    }

    @Override
    protected void configure(HttpSecurity http){
        try {
            http.authorizeRequests()
                    .antMatchers("/").hasRole("USER")
//                    .antMatchers("/", "jsptrial").permitAll()
                    .and()
                    .formLogin();
        } catch (Exception e){
            Logger.getLogger(String.valueOf(e));
        }
    }

    @Bean
    public PasswordEncoder getBcryptPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
