package com.danCode.toDoWebApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {



        String username = "admin";
        String password = "admin";
        UserDetails userDetails = createNewUser( username, password);
        UserDetails userDetails2 = createNewUser("dani", "dani");

        return new InMemoryUserDetailsManager(userDetails,userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER","ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*spring boot security have the following setting by default:
        1. All urls are protected
        2. a login form is showing for unauthorized requests
        3. CSRF disable
        4. does not allow html Frames

        because we are overriding the security filter chain we need to define it again:
    */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //1.
        http.authorizeHttpRequests(
            auth -> auth.anyRequest().authenticated()
        );
        //2.
        http.formLogin(Customizer.withDefaults());
        //3.
        http.csrf(csrf -> csrf.disable());
        //4. https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html#headers(org.springframework.security.config.Customizer)
        http.headers(headers-> headers.frameOptions((frameOptions) -> frameOptions.disable()));

        return http.build();
    }
}
