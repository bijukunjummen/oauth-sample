package org.bk.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    @Configuration
    @Order(1)
    public static class BasicAuthSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //@formatter:off
            http
                .authorizeRequests()
                    .antMatchers("/index.html", "/home.html", "/", "/login", "/configprops", "/env", "/hystrix.stream", "/routes").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                    .and()
                    .csrf()
                    .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
                    .disable();
            //@formatter:on
        }


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.
            inMemoryAuthentication()
            .withUser("user").password("password").roles("USER").and()
            .withUser("admin").password("password").roles("USER", "ADMIN");
        }

    }
}
