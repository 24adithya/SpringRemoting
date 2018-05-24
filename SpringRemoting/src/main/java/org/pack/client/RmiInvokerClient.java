package org.pack.client;

import org.pack.services.ServiceRequestDTO;
import org.pack.services.SpringService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RmiInvokerClient {
	
	private SpringService springService;

	public void setSpringService(SpringService springService) {
		this.springService = springService;
	}

	public SpringService getSpringService() {
		return springService;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/rmi-invoker-app-context.xml");
		ctx.refresh();
		RmiInvokerClient rmiInvokerClient = ctx.getBean("rmiInvokerClient", RmiInvokerClient.class);
		ServiceRequestDTO requestDTO = new ServiceRequestDTO(null, "org.pack.ch9.spring.transactions.hibernate.home.ContactService", "findAll", null);
		Object response = rmiInvokerClient.getSpringService().processRequest(requestDTO);
		
		System.out.println(response);
	}

}
 