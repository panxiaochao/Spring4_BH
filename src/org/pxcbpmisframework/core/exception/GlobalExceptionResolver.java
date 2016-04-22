package org.pxcbpmisframework.core.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pxcbpmisframework.core.common.service.SystemService;
import org.pxcbpmisframework.core.constant.Globals;
import org.pxcbpmisframework.core.json.AjaxJson;
import org.pxcbpmisframework.core.util.JSONHelper;
import org.pxcbpmisframework.core.util.oConvertUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @Title: GlobalExceptionResolver.java
 * @Description: (全局处理异常捕获 根据请求区分ajax和普通请求，分别进行响应 )
 * @author Lypxc
 * @date 2015年10月22日
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
	@Resource
	private SystemService systemService;

	private static final Logger logger = LogManager
			.getLogger(GlobalExceptionResolver.class);

	private static final int WIRTE_DB_MAX_LENGTH = 900;// 记录数据库最大字符长度

	private static final String LOG_LEVEL = Globals.Logger_Leavel_ERROR;

	private static final String LOG_OPT = Globals.Logger_Type_ERROR;

	/**
	 * 对异常信息进行统一处理，区分异步和同步请求，分别处理
	 */
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		boolean isajax = isAjax(request);
		Throwable deepestException = deepestException(ex);
		return processException(request, response, handler, deepestException,
				isajax);
	}

	/**
	 * 判断当前请求是否为异步请求.
	 */
	private boolean isAjax(HttpServletRequest request) {
		return oConvertUtils.isNotEmpty(request.getHeader("X-Requested-With"));
	}

	/**
	 * 获取最原始的异常出处，即最初抛出异常的地方
	 */
	private Throwable deepestException(Throwable e) {
		Throwable tmp = e;
		int breakPoint = 0;
		while (tmp.getCause() != null) {
			if (tmp.equals(tmp.getCause())) {
				break;
			}
			tmp = tmp.getCause();
			breakPoint++;
			if (breakPoint > 1000) {
				break;
			}
		}
		return tmp;
	}

	/**
	 * 处理异常.
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param deepestException
	 * @param isajax
	 * @return
	 */
	private ModelAndView processException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Throwable ex,
			boolean isajax) {
		logger.error("全局处理异常捕获", ex);
		logDb(ex);
		if (isajax) {
			return processAjax(request, response, handler, ex);
		} else {
			return processNotAjax(request, response, handler, ex);
		}
	}

	/**
	 * 异常信息记录
	 * 
	 * @param ex
	 */
	private void logDb(Throwable ex) {
		String exceptionMessage = getThrowableMessage(ex);
		// String exceptionMessage = ex.getMessage();
		Map<String, String> map = new HashMap<String, String>();
		map.put("content", "错误异常: " + ex.getClass().getSimpleName());
		if (exceptionMessage != null) {
			if (exceptionMessage.length() > WIRTE_DB_MAX_LENGTH) {
				exceptionMessage = exceptionMessage.substring(0,
						WIRTE_DB_MAX_LENGTH);
			}
		} else {
			exceptionMessage = "";
		}
		map.put("errormsg", exceptionMessage);
		systemService.addErrorLog(map, LOG_LEVEL, LOG_OPT);
	}

	/**
	 * ajax异常处理并返回.
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @return
	 */
	private ModelAndView processAjax(HttpServletRequest request,
			HttpServletResponse response, Object handler, Throwable ex) {
		ModelAndView empty = new ModelAndView();
		// response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store"); // 禁用浏览器缓存，不能用no-cache，因为这个还是会有缓存
		response.setHeader("pragma", "no-cache");
		response.setCharacterEncoding("utf-8");
		//
		AjaxJson json = new AjaxJson();
		json.setSuccess(false);
		json.setMsg(ex.getMessage());
		try {
			String jsonString = JSONHelper.bean2json(json);
			PrintWriter pw = response.getWriter();
			pw.write(jsonString);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		empty.clear();
		return empty;
	}

	/**
	 * 普通页面异常处理并返回.
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param deepestException
	 * @return
	 */
	private ModelAndView processNotAjax(HttpServletRequest request,
			HttpServletResponse response, Object handler, Throwable ex) {
		String exceptionMessage = getThrowableMessage(ex);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("exceptionMessage", exceptionMessage);
		model.put("ex", ex);
		return new ModelAndView("error/500", model);
	}

	/**
	 * 返回错误信息字符串
	 * 
	 * @param ex
	 *            Exception
	 * @return 错误信息字符串
	 */
	public String getThrowableMessage(Throwable ex) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			pw.flush();
			sw.flush();
		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (pw != null) {
				pw.close();
			}
		}
		return sw.toString();
	}
}
