/**
 * 
 */
package org.idreamlands.security.core.validate.code.sms;

/**
 * @author idreamlands
 *
 */
public interface SmsCodeSender {
	
	/**
	 * @param mobile
	 * @param code
	 */
	void send(String mobile, String code);

}
