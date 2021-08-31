package com.nnk.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.sql.DataSource;

/**
 * This class allows configuring Spring Security authentication methods
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

/*    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService customUserDetailsService;*/
    @Autowired
    private DataSource dataSource;


    /**
     * This method is used by Spring Security to authorize and authenticate an existing user
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username as username, password as password, 1 as enabled "
                        + "FROM users "
                        + "WHERE username = ?")
                .authoritiesByUsernameQuery("select username as username, role as authority "
                        + "from users "
                        + "where username = ?");
    }

    /**
     * This method is used by Spring Security to grant access to application pages according to
     * user role and redirect user to login form if it is not already logged
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/login", "/app-logout", "/logout", "/user/add", "/user/validate").permitAll()
                .antMatchers("/").hasAnyAuthority("USER")
                .antMatchers("/user/list").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error.html")
                .permitAll()
                .defaultSuccessUrl("/welcome", true)
                .and()
                .logout(logout -> logout.deleteCookies("JSESSIONID")
                        .logoutUrl("/app-logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true))
                .rememberMe().rememberMeParameter("remember-me-new").tokenValiditySeconds(86400).and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS).maximumSessions(2)
                .maxSessionsPreventsLogin(true)
                .sessionRegistry(sessionRegistry())
                .expiredUrl("/login-session.html");

    }


    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }

    /**
     * This method is used to exclude dependencies from Spring Security filters in order
     * to load them in Spring Security logging form
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/webjars/**");
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * We need this bean for the session management. Specially if we want to control the concurrent session-control support
     * with Spring security.
     * @return
     */
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

/*    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }*/

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
