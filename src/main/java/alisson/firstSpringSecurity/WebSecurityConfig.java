package alisson.firstSpringSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}user123")
                .roles("USERS")
                .and()
                .withUser("admin")
                .password("{noop}master123")
                .roles("MANAGERS");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll() // Allow access to the root ("/") for all users.
                .antMatchers("/login").permitAll() // Allow access to "/login" for all users.
                .antMatchers("/managers").hasRole("MANAGERS") // Require "MANAGERS" role for "/managers".
                .antMatchers("/users").hasAnyRole("USERS","MANAGERS") // Require either "USERS" or "MANAGERS" role for "/users".
                .anyRequest().authenticated().and().formLogin(); // All other requests must be authenticated (require login).
                 // Use form-based authentication.
    }
}
