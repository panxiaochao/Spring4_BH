package bpmis.pxc.system.service.impl;

import javax.annotation.Resource;

import org.pxcbpmisframework.core.common.dao.SystemDao;
import org.pxcbpmisframework.core.common.service.impl.SystemServiceImpl;
import org.springframework.stereotype.Service;

import bpmis.pxc.system.pojo.TUser;
import bpmis.pxc.system.service.LoginService;

@Service("loginService")
public class LoginServiceImpl extends SystemServiceImpl implements LoginService  {
	@Resource
	public SystemDao systemDao;

	public <T> int LoadPojoSize(Class<T> obj) {
		return this.systemDao.loadAll(obj);
	}

	public TUser checkUserExits(String username, String pwd) {
		return this.systemDao.checkUserExits(username.trim(), pwd.trim());
	}

}
