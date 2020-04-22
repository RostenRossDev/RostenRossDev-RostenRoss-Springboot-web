package com.rostenross.springboot.app;

import javax.sql.DataSource;

import com.rostenross.springboot.app.authhandler.LoginSuccesHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private LoginSuccesHandler successHandler;

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configuredGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication()
        .dataSource(dataSource)
        .passwordEncoder(passwordEncoder)
        .usersByUsernameQuery("select username, password, enabled from users where username=?")
        .authoritiesByUsernameQuery("select u.username, a.authority from authorities a inner join users u on (a.user_id=u.id) where u.username=?");

        /*PasswordEncoder encoder = this.passwordEncoder;
        UserBuilder users = User.builder().passwordEncoder(encoder::encode);

        builder.inMemoryAuthentication().withUser(users.username("admin").password("1234").roles("ADMIN", "USER"))
                .withUser(users.username("user").password("1234").roles("USER"));*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/css/**","/js/**","/images/**","/listar").permitAll()
        .antMatchers("/ver/**").hasAnyRole("USER")
        .antMatchers("/uploads").hasAnyRole("USER")
        .antMatchers("/form/**").hasAnyRole("ADMIN")
        .antMatchers("/eliminar/**").hasAnyRole("ADMIN")
        .antMatchers("/factura/**").hasAnyRole("ADMIN")
        .anyRequest().authenticated()
        .and()
            .formLogin()
                .successHandler(successHandler)
                .loginPage("/login")
            .permitAll()
        .and()
        .logout().permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/error_403");
    }

    
    
}