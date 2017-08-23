package org.aganzo.corejava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CaculatorProxy implements InvocationHandler{
	private Caculator obj;

	public CaculatorProxy(Caculator obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before invocation");
		Object ret = method.invoke(proxy, args);
		System.out.println("after invocation");
		return ret;
	}
	
	

}
