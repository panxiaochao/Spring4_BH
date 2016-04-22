package org.pxcbpmisframework.core.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class BpmisSysTag extends TagSupport {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("static-access")
	public int doStartTag() throws JspException {
		// 内置一个pageContext对象，我们之前说到pageContext对象，它里面是封装了9个隐式对象
		HttpServletRequest request = (HttpServletRequest) this.pageContext
				.getRequest();
		JspWriter out = this.pageContext.getOut();
		String ip = request.getRemoteAddr();
		try {
			out.print(name + ":" + ip);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return this.EVAL_PAGE;
	}
}
