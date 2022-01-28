package com.NoCruelty.NoCruelty.configurations;

import com.NoCruelty.NoCruelty.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class security extends WebSecurityConfigurerAdapter {

//	@Autowired
//	@Qualifier("userService")
//	public UserService userService;
    @Autowired
    UserDetailsService userDetailsService;

    @Override
//	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//		http.headers().frameOptions().sameOrigin()
//			.and()
//				.authorizeRequests().antMatchers("/css/*","/.json/*", "/js/*", "/img/*", "*/*").permitAll()
//                        
//			.and()
//				.authorizeRequests().antMatchers("/list").hasRole("ADMIN")
//			.and()
//				.formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
//				.passwordParameter("password")
//				.defaultSuccessUrl("/").failureUrl("/user/login")
//				.permitAll()
//			.and()
//				.logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
//			.and()
//				.csrf().disable();
//                
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ROL_ADMIN,")
                .antMatchers("/user").hasRole("ROL_USER,")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
            }
        };
    }
}