package org.pxcbpmisframework.core.javamail;

import org.pxcbpmisframework.core.util.DataToolsUtils;

import bpmis.pxc.system.pojo.TUser;

/**
 * 快速发送邮件，用于注册或发送一些信息等等
 * 
 * @author panxiaochao
 * @version 2013.06.13
 */
public class FastEmailSendUtils {
	/**
	 * @Title: RegSuccess
	 * @Description: TODO(主要是针对注册成功调用的默认发送邮件)
	 * @param
	 * @return void
	 * @throws
	 */
	public static void RegSuccess(TUser entity) {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setToAddress(entity.getEmail());
		mailInfo.setSubject("BPMIS_CMS 注册或修改-Email 验证");
		String mailcontent = MailMessages.RegSuccess_Content.replaceAll(
				"#account#", entity.getAccount());
		mailInfo.setContent(mailcontent);

		if (SimpleMailSender.sendHtmlMail(mailInfo))
			System.out.println("<----------email success------->");
		else
			System.out.println("<----------email fail------->");
	}

	public static void RegInfo(TUser entity) {
		String mailcontent = MailMessages.Update_Info.replaceAll("#account#",
				entity.getAccount()).replaceAll("#today#",
				DataToolsUtils.SimpleFormatTime("yyyy-MM-dd"));
		//System.out.println(mailcontent);
		//
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setToAddress(entity.getEmail());
		mailInfo.setSubject("BPMIS_CMS 通知");
		mailInfo.setContent(mailcontent);
		//
		if (SimpleMailSender.sendHtmlMail(mailInfo))
			System.out.println("<----------email success------->");
		else
			System.out.println("<----------email fail------->");
	}

	public static void main(String[] args) {

		TUser user = new TUser();
		user.setEmail("291096836@qq.com");
		user.setAccount("裘熠_XS");
		FastEmailSendUtils.RegInfo(user);

		// System.out.println(MailMessages.Update_Info.replaceAll("#today#",
		// DataToolsUtils.SimpleFormatTime("yyyy-MM-dd")));
	}
}
