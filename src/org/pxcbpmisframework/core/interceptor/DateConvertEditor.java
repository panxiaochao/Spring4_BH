package org.pxcbpmisframework.core.interceptor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

/**
 * 
 * @author 张代浩
 * 
 */
public class DateConvertEditor extends PropertyEditorSupport {
	private static final Logger logger = LogManager
			.getLogger(DateConvertEditor.class);

	//private SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String getAsText() {

		logger.info("===>getAsText:" + getValue());

		/*
		 * Object obj = getValue(); if (null != obj) { return ((DateTime)
		 * obj).toString(formatter); }
		 */

		return getValue().toString();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		logger.info("datetime setAsText:" + text);

		/*
		 * if (StringUtils.isEmpty(text)) { setValue(null); } else {
		 * 
		 * try { setValue(format.parseDateTime(text)); } catch (Exception e) {
		 * logger.info("format datetime error:" + e.getMessage() + ,value: +
		 * text); }
		 * 
		 * }
		 */

	}
}
