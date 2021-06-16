package com.example.library.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;
    
    /**
     * 全体に関するセキュリティ設定
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // css と js ファイルを認証不要にする
        web.ignoring().antMatchers("/static/**");
    }

    /**
     * URL毎のセキュリティ設定
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // AUTHORIZE
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/regist").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                // LOGIN
                .formLogin()
//                    .loginPage("/login").permitAll()
//                    .successForwardU1rl("/")
                    .and()
                // LOGOUT
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
        // end
        ;
    }
    
    /**
     * 認証方法の実装
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }

}
