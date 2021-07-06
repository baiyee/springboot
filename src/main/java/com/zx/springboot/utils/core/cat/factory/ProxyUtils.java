package com.zx.springboot.utils.core.cat.factory;//package top.suven.base.core.cat.factory;
//
//import com.dianping.cat.Cat;
//import com.dianping.cat.CatConstants;
//import com.dianping.cat.common.CatContext;
//import com.dianping.cat.common.ContextSession;
//import com.dianping.cat.message.Transaction;
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//import org.springframework.aop.framework.ProxyFactoryBean;
//
//public class ProxyUtils {
//	public static  Object getThriftProxy(Object target , final String path){
//		ProxyFactoryBean proxyFactory = new ProxyFactoryBean() ;
//		proxyFactory.setTarget(target);
//		proxyFactory.addAdvice(new MethodInterceptor() {
//			@Override
//			public Object invoke(MethodInvocation invocation) throws Throwable {
//				CatContext context = before();
//
//				String methodName = invocation.getMethod().getName() ;
//				String name = "thrift-" + path + ":" +  methodName ;
//				Transaction t = Cat.newTransaction(CatConstants.TYPE_SERVICE , name) ;
//
//				beforeService(context, t);
//
//				try {
//					Object obj = invocation.proceed() ;
//					t.setStatus(Transaction.SUCCESS);
//					return obj ;
//				} catch (Throwable e) {
//					t.setStatus(e);
//					throw e ;
//				}finally{
//					t.complete();
//				}
//			}
//		});
//		return proxyFactory.getObject() ;
//	}
//
//	public static  Object getServletProxy(Object target , final String path){
//		ProxyFactoryBean proxyFactory = new ProxyFactoryBean() ;
//		proxyFactory.setTarget(target);
//		proxyFactory.addAdvice(new MethodInterceptor() {
//			@Override
//			public Object invoke(MethodInvocation invocation) throws Throwable {
//
//				CatContext context = before();
//
//				String methodName = invocation.getMethod().getName() ;
//				if("toString".equals(methodName) || "init".equals(methodName)){
//					return invocation.proceed() ;
//				}
//				String name = "servlet-" +  path + ":" +  methodName ;
//				Transaction t = Cat.newTransaction(CatConstants.TYPE_SERVICE , name) ;
//
//				beforeService(context, t);
//
//				try {
//					Object obj = invocation.proceed() ;
//					t.setStatus(Transaction.SUCCESS);
//					return obj ;
//				} catch (Throwable e) {
//					t.setStatus(e);
//					throw e ;
//				}finally{
//					t.complete();
//				}
//			}
//		});
//		return proxyFactory.getObject() ;
//	}
//
//
//	public static CatContext  before(){
//		String header = ContextSession.get() ;
//		CatContext context = new CatContext().warp(header) ;
//		if( context.isRemoteCall()){//衔接远程调用
//			Cat.logRemoteCallServer(context);
//		}
//		return context ;
//	}
//
//	public static void  beforeService(CatContext context ,  Transaction t){
//		if(context.isRemoteCall()){ //请求本地方法
//			Cat.logEvent("Service.client",  context.getClientIp());
//			Cat.logEvent("Service.app", context.getClientName());
//		}
//	}
//}
