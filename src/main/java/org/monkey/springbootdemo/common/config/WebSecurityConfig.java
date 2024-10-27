package org.monkey.springbootdemo.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.monkey.springbootdemo.common.component.MyPasswordEncoder;
import org.monkey.springbootdemo.common.component.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * WebSecurityConfig
 *
 * @author cc
 * @since 2024/10/14 9:19
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //return http.authorizeRequests((authz) -> authz.anyRequest().authenticated()).build();
        return http
                .authorizeRequests(authz -> authz
                        .antMatchers("/index", "/blog/list", "/blog/detail/**").permitAll()// 设置所有人都可以访问登录页面
                        .anyRequest().authenticated())
                .formLogin(form -> form
						.loginPage("/login")
						//.loginProcessingUrl("/login")
						.successHandler(authenticationSuccessHandler())
						.failureHandler(authenticationFailureHandler())
                        .permitAll())
				.csrf().disable()
                .build();
    }

	@Bean
	public AuthenticationProvider authenticationProvider(MyUserDetailService userDetailsService, MyPasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}
	// 自定义登录成功处理器
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		/*return (request, response, authentication) -> {
			Map<String, Object> result = new HashMap<>();
			result.put("msg", "登录成功");
			result.put("status", 200);
			response.setContentType("application/json;charset=UTF-8");
			String s = new ObjectMapper().writeValueAsString(result);
			response.getWriter().println(s);
        };*/
		SavedRequestAwareAuthenticationSuccessHandler authSuccessHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		// 验证成功后默认跳转的URL
		authSuccessHandler.setDefaultTargetUrl("/index");
		return authSuccessHandler;
	}

	// 自定义登录失败处理器
	public AuthenticationFailureHandler authenticationFailureHandler() {
		/*return (request, response, exception) -> {
			Map<String, Object> result = new HashMap<>();
			result.put("msg", "登录失败: "+exception.getMessage());
			result.put("status", 500);
			response.setContentType("application/json;charset=UTF-8");
			String s = new ObjectMapper().writeValueAsString(result);
			response.getWriter().println(s);
        };*/
		SimpleUrlAuthenticationFailureHandler handler = new SimpleUrlAuthenticationFailureHandler();
		// 认证失败后重定向的URL
		handler.setDefaultFailureUrl("/login?error=true");
		return handler;
	}
}
