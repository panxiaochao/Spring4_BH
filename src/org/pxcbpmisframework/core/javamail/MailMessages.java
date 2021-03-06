package org.pxcbpmisframework.core.javamail;

public interface MailMessages {
	/**
	 * QQ 邮箱
	 */
	public static final String QQ_SMTP = "smtp.qq.com";
	public static final String QQ_POP3 = "pop.qq.com";
	public static final Integer QQ_SMTP_PORT = 25;
	public static final Integer QQ_POP3_PORT = 110;
	/**
	 * 163 网易邮箱
	 */
	public static final String WANG_SMTP = "smtp.163.com";
	public static final String WANG_POP3 = "pop.163.com";
	public static final Integer WANG_SMTP_PORT = 25;
	public static final Integer WANG_POP3_PORT = 110;
	/**
	 * sina 邮箱
	 */
	public static final String SINA_SMTP = "smtp.sina.com";
	public static final String SINA_POP3 = "pop3.sina.com";
	public static final Integer SINA_SMTP_PORT = 25;
	public static final Integer SINA_POP3_PORT = 110;
	/**
	 * sohu 邮箱
	 */
	public static final String SOHU_SMTP = "smtp.sohu.com";
	public static final String SOHU_POP3 = "pop3.sohu.com";
	public static final Integer SOHU_SMTP_PORT = 25;
	public static final Integer SOHU_POP3_PORT = 110;

	// 注册信息
	// background:url(http://www.w3cfuns.com/template/w3cfuns2013/images/extend/logo/maillogo.png)
	// #4682d1 no-repeat 15px;
	static String RegSuccess_Content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"><body style=\"margin:0;\">"
			+ "<div style=\"margin:0 auto; width:700px; box-shadow:0 0 10px rgba(0, 0, 0, 0.2);\">"
			+ "<div style=\"padding-left:30px; height:60px; line-height:63px; border-radius:3px 3px 0 0; background-color:#4682d1; font-size:18px; font-weight:700; color:#fff;  overflow:hidden;\"><b>BPMIS_CMS 技术中心</b>-Email 地址验证</div>"
			+ "<div style=\"padding:15px 30px; font-size:14px; word-wrap:break-word; border:#c5c5c5 solid; border-width:0 1px; line-height:24px;\" >"
			+ "<p><b>Hi, #account#：</b></p>"
			+ "<p style=\"text-indent:2em;\">首先，感谢您对我们BPMIS_CMS 的支持，您收到这封邮件，是由于在 BPMIS_CMS 进行了新用户注册，或用户修改 Email 使用了这个邮箱地址。如果您并没有访问过 BPMIS_CMS，或没有进行上述操作，请忽略这封邮件。</p>"
			+ "<b style=\"display:block; margin-top:30px; color:red;\">帐号激活说明</b>"
			+ "<p style=\"padding:5px 0; text-indent:2em;\">如果您是 BPMIS_CMS 的新用户，或在修改您的注册 Email 时使用了本地址，我们需要对您的地址有效性进行验证以避免垃圾邮件或地址被滥用。</p>"
			+ "<p style=\"text-indent:2em;\">您只需点击下面的链接即可激活您的帐号："
			+ "<div style=\"margin:10px 0; padding:15px; border:1px #c4d1d7 solid; background:#f7fdff;\">"
			+ "<a href=#href# target=_blank style=\"color:#05a;\">http://xxx.sad..casds.ads.adsa.dsad.sads</a>"
			+ "</div><p align=right>(如果上面不是链接形式，请将该地址手工粘贴到浏览器地址栏再访问)</p></p>"
			+ "<p style=\"text-indent:2em;\">感谢您的访问，祝您生活愉快！</p><div style=\"margin-top:30px; padding:20px 0 10px; line-height:24px; border-top:1px #ccc solid;\">此信是由 <a style=\"color:#05a; text-decoration:none; font-weight:700;\" href=# target=_blank>BPMIS_CMS 技术中心</a>&nbsp;系统发出，系统不接收回信，请勿直接回复。<br  /></div>"
			+ "<p align=right>BPMIS_CMS 管理团队</p>"
			+ "</div>"
			+ "<div style=\"height:10px; border-radius:0 0 3px 3px; border: 1px solid #C5C5C5; border-top: none; background:#4682d1 url(http://www.w3cfuns.com/template/w3cfuns2013/images/extend/mail_bottom.gif) repeat-x;\"></div>"
			+ "</div></body></html>";
	static String Update_Info = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"><body style=\"margin:0;\">"
			+ "<div style=\"margin:0 auto; width:700px; box-shadow:0 0 10px rgba(0, 0, 0, 0.2);\">"
			+ "<div style=\"padding-left:30px; height:60px; line-height:63px; border-radius:3px 3px 0 0; background-color:#4682d1; font-size:18px; font-weight:700; color:#fff;  overflow:hidden;\"><b>BPMIS_CMS 技术中心</b></div>"
			+ "<div style=\"padding:15px 30px; font-size:14px; word-wrap:break-word; border:#c5c5c5 solid; border-width:0 1px; line-height:24px;\" >"
			+ "<p><b>Hi, #account#：</b></p>"
			+ "<p style=\"text-indent:2em;\">首先，感谢您对我们BPMIS_CMS 的支持，您收到这封邮件是BPMIS_CMS 技术中心向您发的一封信息动态邮件！</p>"
			// content
			+ "<p style=\"text-indent:2em;color:#05a;font-weight:700;\">内容更新：（#today#）</p>"
			+ "<div style=\"margin:10px 0; padding:15px 0; border:1px #c4d1d7 solid; background:#f7fdff;\">"
			+ "<ul style=\"margin-left: 30px;padding:0;\">"
			+ "<li>模板设计搭建。</li>"
			+ "<li>BPMIS v4 已提入日程。</li>"
			+ "</ul>"
			+ "</div>"
			// end content
			+ "<p style=\"text-indent:2em;\">感谢您在我们身边一致相伴，我们会继续努力，希望您继续关注我们，因为我们的努力离不开您的脚步！</p>"
			+ "<p style=\"text-indent:2em;\">感谢您的访问，祝您生活愉快！</p><div style=\"margin-top:30px; padding:20px 0 10px; line-height:24px; border-top:1px #ccc solid;\">此信是由 <a style=\"color:#05a; text-decoration:none; font-weight:700;\" href=# >BPMIS_CMS 技术中心</a>&nbsp;系统发出，系统不接收回信，请勿直接回复。<br  /></div>"
			+ "<p align=right>BPMIS_CMS 管理团队 (Manager：panxiaochao)</p>"
			+ "</div>"
			+ "<div style=\"height:10px; border-radius:0 0 3px 3px; border: 1px solid #C5C5C5; border-top: none; background:#4682d1 url(http://www.w3cfuns.com/template/w3cfuns2013/images/extend/mail_bottom.gif) repeat-x;\"></div>"
			+ "</div></body></html>";
	static String FeedBack_Info = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"><body style=\"margin:0;\">"
			+ "<div style=\"margin:0 auto; width:700px; box-shadow:0 0 10px rgba(0, 0, 0, 0.2);\">"
			+ "<div style=\"padding-left:30px; height:60px; line-height:63px; border-radius:3px 3px 0 0; background-color:#4682d1; font-size:18px; font-weight:700; color:#fff;  overflow:hidden;\"><b>BPMIS_CMS 技术中心</b>-回馈意见</div>"
			+ "<div style=\"padding:15px 30px; font-size:14px; word-wrap:break-word; border:#c5c5c5 solid; border-width:0 1px; line-height:24px;\" >"
			+ "<p><b>Hi, #account#：</b></p>"
			+ "<p style=\"text-indent:2em;\">首先，感谢您对我们BPMIS_CMS 的支持与反馈，您收到这封邮件是BPMIS_CMS 技术中心向您发的一封信息动态回馈信息！</p>"
			+ "<p style=\"text-indent:2em;color:#05a;font-weight:700;\">回馈内容：</p>"
			// content
			+ "<div style=\"margin:10px 0; padding:15px; border:1px #c4d1d7 solid; background:#f7fdff;text-indent:2em;\">sad进口货达声科技打算空间里的ask了解asdsad阿斯达斯大撒旦撒倒萨倒萨大撒旦撒旦撒倒萨倒萨大撒旦</div>"
			// end content
			+ "<p style=\"text-indent:2em;\">感谢您在我们身边一致相伴，我们会继续努力，希望您继续关注我们，因为我们的努力离不开您的脚步！</p>"
			+ "<div style=\"margin-top:30px; padding:20px 0 10px; line-height:24px; border-top:1px #ccc solid;\">此信是由 <a style=\"color:#05a; text-decoration:none; font-weight:700;\" href=# >BPMIS_CMS 技术中心</a>&nbsp;系统发出，系统不接收回信，请勿直接回复。<br  /></div>"
			+ "<p align=right>BPMIS_CMS 管理团队 (Manager：panxiaochao)</p>"
			+ "</div>"
			+ "<div style=\"height:10px; border-radius:0 0 3px 3px; border: 1px solid #C5C5C5; border-top: none; background:#4682d1 url(http://www.w3cfuns.com/template/w3cfuns2013/images/extend/mail_bottom.gif) repeat-x;\"></div>"
			+ "</div></body></html>";
}
