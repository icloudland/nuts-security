/**
 * 
 */
package org.idreamlands.security.browser.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.session.InvalidSessionStrategy;

import org.idreamlands.security.core.properties.SecurityProperties;

/**
 * 默认的session失效处理策略
 * 
 * @author idreamlands
 *
 */
public class NutsInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {

	public NutsInvalidSessionStrategy(SecurityProperties securityProperties) {
		super(securityProperties);
	}

	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		onSessionInvalid(request, response);
	}

}
