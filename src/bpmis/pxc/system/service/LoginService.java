package bpmis.pxc.system.service;

import org.pxcbpmisframework.core.common.service.SystemService;

import bpmis.pxc.system.pojo.TUser;

public interface LoginService extends SystemService{
	public <T> int LoadPojoSize(Class<T> obj);

	public TUser checkUserExits(String username, String passwordMd5);

}
