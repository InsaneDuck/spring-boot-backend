package dev.insaneduck.springbootbackend.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

public class SecurityConfiguration1 {
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

    private static final String[] AUTH_WHITELIST = {
            "/api/v1/auth/**",
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("ADMIN")
                            .requestMatchers(HttpMethod.POST, "/**").hasAnyRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/**").hasAnyRole("ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "/**").hasAnyRole("ADMIN");
                    //.requestMatchers(AUTH_WHITELIST).permitAll();
                });
        httpSecurity.httpBasic();
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
