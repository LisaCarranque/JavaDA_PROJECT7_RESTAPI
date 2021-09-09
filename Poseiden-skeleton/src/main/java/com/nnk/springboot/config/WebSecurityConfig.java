package com.nnk.springboot.config;

import com.nnk.springboot.config.Filter.AuthTokenFilter;
import com.nnk.springboot.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * This class is responsible for defining Spring Security filtering rules.
 * It provides HttpSecurity configurations to configure csrf, session management, rules for protected resources.
 * We can also extend and customize the default configuration that contains the elements below.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/login-error").permitAll()
                .antMatchers("/app-logout").permitAll()
                .antMatchers("/welcome").permitAll()
                .antMatchers("/user/add").permitAll()
                .antMatchers("/user/validate").permitAll()
            .antMatchers("/bidList/*").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/curvePoint/*").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/trade/*").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/rating/*").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/rule/*").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/user/list").hasAuthority("ADMIN")
                .antMatchers("/user/update/*").hasAuthority("ADMIN")
                .antMatchers("/user/delete/*").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/welcome", true)
                .failureUrl("/login-error")
                .permitAll()
                .and()
                .logout(logout -> logout.deleteCookies("token", "JSESSIONID")
                        .logoutUrl("/app-logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true));


        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    /*
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
}