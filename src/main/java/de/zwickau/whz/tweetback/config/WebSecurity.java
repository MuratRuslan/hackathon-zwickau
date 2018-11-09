package de.zwickau.whz.tweetback.config;


import de.zwickau.whz.tweetback.jwt.JWTAuthenticationFilter;
import de.zwickau.whz.tweetback.jwt.JWTAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static de.zwickau.whz.tweetback.jwt.SecurityConstants.SIGN_UP_URL;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	private UserDetailsService userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().authorizeRequests()
//				.antMatchers(HttpMethod.POST, SIGN_UP_URL)
//				.permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//				.and()
//				.logout()
//				.permitAll()
//				.and()
//				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
//				.addFilter(new JWTAuthorizationFilter(authenticationManager()))
//				// this disables session creation on Spring Security
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().anyRequest().permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Bean
    CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
		corsConfiguration.addAllowedOrigin("http://localhost:4200");
		corsConfiguration.addAllowedHeader("Authorization");
		corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
		corsConfiguration.addExposedHeader("Authorization");
		source.registerCorsConfiguration("/**", corsConfiguration);
		return source;
	}
}