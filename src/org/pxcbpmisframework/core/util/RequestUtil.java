package org.pxcbpmisframework.core.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestUtil {
	private static final Logger log = LogManager.getLogger(RequestUtil.class);

	/**
	 * 获取请求路径
	 * 
	 * @param request
	 * @return
	 */
	public static String requestUrl(HttpServletRequest request) {
		String strUrl = request.getRequestURI();
		if (request.getQueryString() != null)
			strUrl += "?" + (request.getQueryString());
		return strUrl;
	}

	/**
	 * 获取客服端IP
	 * 
	 * @param request
	 * @return
	 */
	public static String requestIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

	/**
	 * 列出浏览器信息
	 * 
	 * @param request
	 */
	public static void resquestParms(HttpServletRequest request) {
		log.info("*************************浏览器信息*************************");
		log.info("Protocol: " + request.getProtocol());
		log.info("Scheme: " + request.getScheme());
		log.info("Server Name: " + request.getServerName());
		log.info("Server Port: " + request.getServerPort());
		log.info("Protocol: " + request.getProtocol());
		log.info("Remote Addr: " + request.getRemoteAddr());
		log.info("Remote Host: " + request.getRemoteHost());
		log.info("Character Encoding: " + request.getCharacterEncoding());
		log.info("Content Length: " + request.getContentLength());
		log.info("Content Type: " + request.getContentType());
		log.info("Auth Type: " + request.getAuthType());
		log.info("HTTP Method: " + request.getMethod());
		log.info("Path Info: " + request.getPathInfo());
		log.info("Path Trans: " + request.getPathTranslated());
		log.info("Query String: " + request.getQueryString());
		log.info("Remote User: " + request.getRemoteUser());
		log.info("Session Id: " + request.getRequestedSessionId());
		log.info("Request URI: " + request.getRequestURI());
		log.info("Servlet Path: " + request.getServletPath());
		log.info("Accept: " + request.getHeader("Accept"));
		log.info("Host: " + request.getHeader("Host"));
		log.info("Referer : " + request.getHeader("Referer"));
		log.info("Accept-Language : " + request.getHeader("Accept-Language"));
		log.info("Accept-Encoding : " + request.getHeader("Accept-Encoding"));
		log.info("User-Agent : " + request.getHeader("User-Agent"));
		log.info("Connection : " + request.getHeader("Connection"));
		log.info("*************************浏览器信息*************************");
	}
}
