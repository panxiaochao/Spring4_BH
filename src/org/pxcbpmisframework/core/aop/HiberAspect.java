package org.pxcbpmisframework.core.aop;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

/**
 * 
 * @Title: HiberAspect.java
 * @Description: (对Hibernate的操作进行一个拦截，触发相应拦截器的事件做预处理或善后处理 )
 * @author Lypxc
 * @date 2015年10月22日
 */

@Component
public class HiberAspect extends EmptyInterceptor {
	private static final Logger logger = LogManager
			.getLogger(HiberAspect.class);
	private static final long serialVersionUID = 1L;

	// entity - POJO对象
	// id - POJO对象的主键
	// state - POJO对象的每一个属性所组成的集合(除了ID)
	// propertyNames - POJO对象的每一个属性名字组成的集合(除了ID)
	// types - POJO对象的每一个属性类型所对应的Hibernate类型组成的集合(除了ID)
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {

		return false;
	}

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {

		return false;
	}
}
