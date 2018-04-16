/**
 * 
 */
package org.idreamlands.security.server;

import org.idreamlands.security.app.authentication.openid.OpenIdAuthenticationSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

import org.idreamlands.security.core.authentication.FormAuthenticationConfig;
import org.idreamlands.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import org.idreamlands.security.core.authorize.AuthorizeConfigManager;
import org.idreamlands.security.core.validate.code.ValidateCodeSecurityConfig;

/**
 * 资源服务器配置
 * 
 * @author idreamlands
 *
 */
@Configuration
@EnableResourceServer
public class NutsResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	protected AuthenticationSuccessHandler nutsAuthenticationSuccessHandler;
	
	@Autowired
	protected AuthenticationFailureHandler nutsAuthenticationFailureHandler;
	
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	
	@Autowired
	private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;
	
	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	
	@Autowired
	private SpringSocialConfigurer nutsSocialSecurityConfig;
	
	@Autowired
	private AuthorizeConfigManager authorizeConfigManager;
	
	@Autowired
	private FormAuthenticationConfig formAuthenticationConfig;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		formAuthenticationConfig.configure(http);
		
		http//.apply(validateCodeSecurityConfig)
			//	.and()
			.apply(smsCodeAuthenticationSecurityConfig)
				.and()
			.apply(nutsSocialSecurityConfig)
				.and()
			.apply(openIdAuthenticationSecurityConfig)
				.and()
			.csrf().disable();
		
		authorizeConfigManager.config(http.authorizeRequests());
	}

}