package com.sparta.week06.configuration;


import com.sparta.week06.jwt.AccessDeniedHandlerException;
import com.sparta.week06.jwt.AuthenticationEntryPointException;
import com.sparta.week06.jwt.TokenProvider;
import com.sparta.week06.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfiguration {

  @Value("${jwt.secret}")
  String SECRET_KEY;
  private final TokenProvider tokenProvider;
  private final UserDetailsServiceImpl userDetailsService;
  private final AuthenticationEntryPointException authenticationEntryPointException;
  private final AccessDeniedHandlerException accessDeniedHandlerException;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Order(SecurityProperties.BASIC_AUTH_ORDER)
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors();
    http.headers().frameOptions().disable();

    http.csrf().disable()

        .exceptionHandling()
        .authenticationEntryPoint(authenticationEntryPointException)
        .accessDeniedHandler(accessDeniedHandlerException)

        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        .and()
//            권한없이 (=토큰없이) 이용가능한 api설정
        .authorizeRequests()
        .antMatchers("/api/user/**").permitAll()
        .antMatchers("/api/post").permitAll()
        .antMatchers("/api/comment").permitAll()
        .antMatchers("/h2-console/**").permitAll() // h2-console 사용을 위해 추가
        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll() // preflight 허용을 위해 추가
        .anyRequest().authenticated()

        .and()
        .apply(new JwtSecurityConfiguration(SECRET_KEY, tokenProvider, userDetailsService));

    return http.build();
  }
}
