package org.pxcbpmisframework.core.common.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.pxcbpmisframework.core.common.dao.SystemDao;
import org.pxcbpmisframework.core.common.dao.jdbc.JdbcTemplateDao;
import org.pxcbpmisframework.core.common.qbc.CriteriaQuery;
import org.pxcbpmisframework.core.common.service.SystemService;
import org.pxcbpmisframework.core.page.Page;
import org.pxcbpmisframework.core.util.BrowserUtils;
import org.pxcbpmisframework.core.util.ContextHolderUtils;
import org.pxcbpmisframework.core.util.DataToolsUtils;
import org.pxcbpmisframework.core.util.IpUtils;
import org.pxcbpmisframework.core.util.RequestUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bpmis.pxc.system.pojo.TBLogger;
import bpmis.pxc.system.pojo.TUser;

@Service("systemService")
@Transactional
public class SystemServiceImpl implements SystemService {
	@Resource
	public SystemDao systemDao;

	// @Resource
	// public JdbcTemplateDao jdbcTemplateDao;

	/*
	 * <---------------implements method----------------->
	 */

	public <T> List<T> ByCrifindQuery(Class<T> clazz) {

		return systemDao.ByCrifindQuery(clazz);
	}

	public <T> List<T> ByCrifindQuery(Class<T> clazz, boolean isAsc,
			String ordername) {

		return systemDao.ByCrifindQuery(clazz, isAsc, ordername);
	}

	public Map<?, ?> getPageList(Class<?> clazz, CriteriaQuery cq, Page page) {

		return systemDao.getPageList(clazz, cq, page);
	}

	public <T> void delete(T entity) {

		systemDao.delete(entity);
	}

	public <T> void deleteAll(List<T> entityAll) {

		systemDao.deleteAll(entityAll);
	}

	public <T> void deleteAll(Class<T> entityName, String[] idstr,
			List<T> idlist) {

		systemDao.deleteAll(entityName, idstr, idlist);
	}

	public <T> void deleteEntityByHql(String hql) {

		systemDao.deleteEntityByHql(hql);
	}

	public <T> void deleteEntityById(Class<T> entityName, String id) {

		systemDao.deleteEntityById(entityName, id);
	}

	public <T> void deleteEntityById(Class<T> entityName, Integer id) {

		systemDao.deleteEntityById(entityName, id);
	}

	public <T> List<T> findByQueryHql(String hql) {

		return systemDao.findByQueryHql(hql);
	}

	public <T> Object getClassById(Class<T> clazz, String id) {

		return systemDao.getClassById(clazz, id);
	}

	public Map<?, ?> getPageList(Class<?> clazz, CriteriaQuery cq) {

		return systemDao.getPageList(clazz, cq);
	}

	public CriteriaQuery getPageList2(Class<?> clazz, CriteriaQuery cq) {

		return systemDao.getPageList2(clazz, cq);
	}

	public <T> void save(T entity) {

		systemDao.save(entity);
	}

	public <T> void saveAll(List<T> entityAll) {

		systemDao.saveAll(entityAll);
	}

	public <T> void update(T entity) {

		systemDao.update(entity);
	}

	public <T> void saveOrUpdata(T entity) {

		systemDao.saveOrUpdata(entity);
	}

	public void addCommenLog(String logcontent, String loglevel,
			String operatetype) {

		HttpServletRequest request = ContextHolderUtils.getRequest();
		String broswer = BrowserUtils.getUserAgent(request);

		TUser u = ContextHolderUtils.getSessionUser();
		TBLogger logger = new TBLogger();
		if (u == null)
			logger.setAccount("Guest");
		else {
			logger.setUserid(u.getId());
			logger.setAccount(u.getAccount());
		}
		logger.setLoglevel(loglevel);
		logger.setLogcontent(logcontent);
		logger.setBroswertype(broswer);
		logger.setOperatetime(DataToolsUtils.SimpleFormatTime());
		logger.setOperatetype(operatetype);
		logger.setAdrip(IpUtils.getServerHostIp());

		systemDao.save(logger);
	}

	public void addErrorLog(Map<String, String> map, String loglevel,
			String operatetype) {
		HttpServletRequest request = ContextHolderUtils.getRequest();
		String broswer = BrowserUtils.getUserAgent(request);

		TUser u = ContextHolderUtils.getSessionUser();
		TBLogger logger = new TBLogger();
		if (u == null)
			logger.setAccount("Guest");
		else {
			logger.setUserid(u.getId());
			logger.setAccount(u.getAccount());
		}
		logger.setLoglevel(loglevel);
		logger.setLogcontent(map.get("content"));
		logger.setLogmessage(map.get("errormsg"));
		logger.setBroswertype(broswer);
		logger.setOperatetime(DataToolsUtils.SimpleFormatTime());
		logger.setOperatetype(operatetype);
		logger.setOperateurl(RequestUtil.requestUrl(request));
		logger.setAdrip(RequestUtil.requestIp(request));

		systemDao.save(logger);
	}

	/*
	 * public void execute(String sql) {
	 * 
	 * jdbcTemplateDao.execute(sql); }
	 * 
	 * public int queryForInt(String sql) {
	 * 
	 * return jdbcTemplateDao.queryForInt(sql); }
	 * 
	 * public int queryForInt(String sql, Object[] args) {
	 * 
	 * return jdbcTemplateDao.queryForInt(sql, args); }
	 * 
	 * public <T> List<T> queryForList(String sql, Class<T> entityClass) {
	 * 
	 * return jdbcTemplateDao.queryForList(sql, entityClass); }
	 * 
	 * public <T> List<T> queryForList(String sql, Object[] args, Class<T>
	 * entityClass) {
	 * 
	 * return jdbcTemplateDao.queryForList(sql, args, entityClass); }
	 * 
	 * public String queryForString(String sql) {
	 * 
	 * return jdbcTemplateDao.queryForString(sql); }
	 * 
	 * public String queryForString(String sql, Object[] args) {
	 * 
	 * return jdbcTemplateDao.queryForString(sql, args); }
	 * 
	 * public <T> List<T> queryForList(String sql) {
	 * 
	 * return jdbcTemplateDao.queryForList(sql); }
	 */

	public <T> int loadAll(Class<T> entityName) {

		return systemDao.loadAll(entityName);
	}

	// extend
	public TUser checkUserExits(String username, String passwordMd5) {

		return systemDao.checkUserExits(username, passwordMd5);
	}

	public <T> List<T> ByCrifindQuery(Class<T> entityClass,
			Map<String, Integer> parms) {

		return systemDao.ByCrifindQuery(entityClass, parms);
	}

	public <T> List<T> ByCrifindQueryForObj(Class<T> entityClass,
			Map<Object, Object> parms) {
		return systemDao.ByCrifindQueryForObj(entityClass, parms);
	}

	public int executeByHql(String hql) {

		return systemDao.executeByHql(hql);
	}

	public int executeBySql(String sql) {

		return systemDao.executeBySql(sql);
	}

	public <T> List<T> findByQuerySql(String sql) {

		return systemDao.findByQuerySql(sql);
	}
}
