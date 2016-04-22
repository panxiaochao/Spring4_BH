package bpmis.pxc.system.controller.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * @Title: MyTaskTest.java
 * @Description: (定时任务测试类 )
 * @author Lypxc
 * @date 2015年12月18日
 */
@Component
public class MyTaskTest {

	@Scheduled(cron = "0/5 * * * * ? ")
	public void taskCycle() {
		System.out.println("hello!");
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-task.xml");
	}
}
