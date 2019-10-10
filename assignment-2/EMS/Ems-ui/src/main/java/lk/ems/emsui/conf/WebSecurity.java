package lk.ems.emsui.conf;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableOAuth2Sso
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/employee/emp-reg").access("hasAuthority('MANAGER')")
                .antMatchers("/project/pro-reg").access("hasAuthority('MANAGER')")
                .antMatchers("/task/task-reg").access("hasAuthority('MANAGER')")
                .antMatchers("/operation").access("hasAuthority('MANAGER')")
                .antMatchers("/","/images/*")
                .permitAll()
                .anyRequest()
                .authenticated();
        http.logout().deleteCookies("JSESSIONID","KSESSIONID")
                .logoutUrl("http://localhost:9090/expire").logoutSuccessUrl("/home").permitAll();
    }
}
