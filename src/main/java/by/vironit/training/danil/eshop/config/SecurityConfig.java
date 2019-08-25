package by.vironit.training.danil.eshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("appUserDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/productList").permitAll()
                .antMatchers("/admin/users", "/admin/users/**,/bucket/**", "/order/**", "/profile/**","/profile").hasAuthority("ADMIN")
                .antMatchers("/bucket/**", "/bucket", "/order/**", "/order", "/profile/**","/profile").hasAuthority("USER")
                .antMatchers("/login", "/reg").anonymous()
                .antMatchers("/**").permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    //.loginProcessingUrl("/loginAction")
                    .usernameParameter("email")
                    //.passwordParameter("password")
                    .successHandler(new CustomSuccessHandler())
                    .defaultSuccessUrl("/home")
                    .failureUrl("/login?error=true")
                    //.permitAll()
                .and()
                .logout()
                //.deleteCookies("JSESSIONID")
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    //.permitAll()
                //.and()
                   // .exceptionHandling()
                    //.accessDeniedPage("/error")
                .and()
                    .csrf()
                    .disable();
    }

}