package org.pxcbpmisframework.core.interceptor;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class MyWebBinding implements WebBindingInitializer {

	private static final Logger logger = LogManager
			.getLogger(MyWebBinding.class);

	public void initBinder(WebDataBinder databinder, WebRequest webrequest) {
		// TODO Auto-generated method stub
		logger.info("---MyWebBinding---");
		databinder.registerCustomEditor(Date.class, new DateConvertEditor());

	}

}
