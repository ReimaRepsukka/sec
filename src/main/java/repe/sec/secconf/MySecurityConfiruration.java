package repe.sec.secconf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import repe.sec.data.Role;
import repe.sec.encoder.MyPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfiruration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyPasswordEncoder pwEncoder;

    @Autowired
    UserDetailsService udService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(udService).passwordEncoder(pwEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/public/**").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.GET, "/admin/**").hasAnyAuthority(Role.ADMIN.toString());

        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();

    }
}
