package com.sm.whale.config

import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@EnableWebSecurity
class WebConfiguration: WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        if (http != null) {
            http
                    .httpBasic().disable()
                    .cors().configurationSource(corsConfigurationSource())
                    .and()
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/**").hasRole("OWNER")
                    .antMatchers(HttpMethod.PUT, "/**").hasAnyRole("USER", "OWNER")
                    .antMatchers(HttpMethod.DELETE, "/**").hasAnyRole("USER", "OWNER")
                    .antMatchers(HttpMethod.GET, "/**").hasAnyRole("USER", "OWNER")
                    .anyRequest().permitAll()
        };

    }

    fun corsConfigurationSource(): CorsConfigurationSource{
        var configuratuon: CorsConfiguration = CorsConfiguration();

        configuratuon.addAllowedOriginPattern("*");
        configuratuon.addAllowedHeader("*");
        configuratuon.addAllowedMethod("*");

        var source: UrlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuratuon);
        return source;
    }

}