package bpmis.pxc.system.controller.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pxcbpmisframework.core.json.AjaxJson;
import org.pxcbpmisframework.core.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bpmis.pxc.system.service.LoginService;

@Controller
@RequestMapping("/test")
public class TestController {
	private static final Logger logger = LogManager
			.getLogger(TestController.class);
	@Resource
	public LoginService loginService;

	@PostConstruct
	public void init() {
		logger.info("-----------------------   PostConstruct init()   -----------------------");
	}

	@PreDestroy
	public void dostory() {
		logger.info("-----------------------   PreDestroy dostory   -----------------------");
	}

	@RequestMapping
	public String index(HttpServletRequest request) {
		System.out.println("----------->go test");
		List<?> list = loginService.findByQueryHql("from TBLogger");
		request.setAttribute("list", list);
		// System.out.println(list.size());
		// RequestUtil.resquestParms(request);
		System.out.println(RequestUtil.requestUrl(request));
		// Integer.parseInt("abc");
		logger.info("默认方法！");
		System.out.println("----------->end test");
		return "login";
	}

	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request) {
		System.out.println("----------->go test");

		// Assert.isTrue(i > 0, "The value must be greater than zero");
		logger.info("测试呢！");
		System.out.println("----------->end test");
		return "login";
	}

	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson ajaxtest() {
		AjaxJson ajx = new AjaxJson();
		Integer.parseInt("abc");
		ajx.setMsg("登录成功！");
		System.out.println("11");
		return ajx;
	}

	@RequestMapping(value = "/fm")
	public String freemarker(HttpServletRequest request) {
		logger.info("测试呢！");
		return "test.ftl";
	}

	@RequestMapping(value = "/upload")
	public String upload(HttpServletRequest request) {
		logger.info("上传！");
		return "upload";
	}

	@RequestMapping(value = "/outImg/{file}")
	private ModelAndView outImg(@PathVariable String file,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView empty = new ModelAndView();
		// response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-store"); // 禁用浏览器缓存，不能用no-cache，因为这个还是会有缓存
		response.setHeader("pragma", "no-cache");
		response.setCharacterEncoding("utf-8");
		response.setContentType("image/png");
		//
		File pic = new File("E:/log/upload/" + file+".png");
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			fis = new FileInputStream(pic);
			os = response.getOutputStream();
			int count = 0;
			byte[] buffer = new byte[1024 * 1024];
			while ((count = fis.read(buffer)) != -1)
				os.write(buffer, 0, count);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		empty.clear();
		return empty;
	}

}
