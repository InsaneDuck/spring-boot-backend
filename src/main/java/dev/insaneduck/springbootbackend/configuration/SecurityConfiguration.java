package dev.insaneduck.springbootbackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails satya = User.builder()
//                .username("satya")
//                .password("{noop}password")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(satya);
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.
                setUsersByUsernameQuery
                        ("select username,password,enabled from users where username=?");
        jdbcUserDetailsManager.
                setAuthoritiesByUsernameQuery
                        ("select username,role from roles where username=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(
                authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("ADMIN")

                            .requestMatchers(HttpMethod.POST, "/**").hasAnyRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/**").hasAnyRole("ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "/**").hasAnyRole("ADMIN");
                });

        httpSecurity.httpBasic();
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }


}
