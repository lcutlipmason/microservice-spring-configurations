package com.lcm.configserver

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
class BasicSecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http : HttpSecurity) {
          http
            .csrf()
                .disable()
            .authorizeRequests()
              .anyRequest().authenticated()
              .and()
              .httpBasic();
    }

}