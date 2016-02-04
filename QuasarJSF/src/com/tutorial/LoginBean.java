/**
 * LoginBean.java
 * 
 */

package com.tutorial;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.Suspendable;

public class LoginBean {
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Suspendable
	public String login() {
		
		System.out.println(((HttpServletRequest) FacesContext.getCurrentInstance() 
				 .getExternalContext().getRequest()));
		//try {
			System.out.println(Fiber.currentFiber());
			System.out.println(Fiber.currentStrand());
			System.out.println(Fiber.getCurrentRun());
			System.out.println(Thread.currentThread());
			//Fiber.sleep(10000);
			//Thread.sleep(100);
			//System.out.println(Strand.currentStrand());
			//System.out.println(Strand.isCurrentFiber());
		//System.out.println("Finished " + ((HttpServletRequest) FacesContext.getCurrentInstance() 
		//			 .getExternalContext().getRequest()));
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}


		return "login";
	}
}
