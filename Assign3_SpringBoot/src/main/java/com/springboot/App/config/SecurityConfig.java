package com.springboot.App.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("yash").password("{noop}test").roles("USER").and()
                .withUser("pratik").password("{noop}test2").roles("ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/student/add").hasRole("ADMIN")
                .antMatchers("/student/delete/**").hasRole("ADMIN")
                .antMatchers("/student/update").hasRole("ADMIN")
                .anyRequest().fullyAuthenticated()
                .and().httpBasic();

        http.csrf().disable();
    }
}


