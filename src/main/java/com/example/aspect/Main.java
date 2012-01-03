package com.example.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static final Log LOG = LogFactory.getLog(Main.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx.registerShutdownHook();
		
		HelloSdn bean = ctx.getBean(HelloSdn.class);
		bean.helloSdn();
		
		LOG.info("Done");
	}
}
