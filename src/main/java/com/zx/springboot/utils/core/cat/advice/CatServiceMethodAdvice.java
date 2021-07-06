package com.zx.springboot.utils.core.cat.advice;//package top.suven.base.core.cat.advice;
//
//import com.dianping.cat.Cat;
//import com.dianping.cat.message.Transaction;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import CatGcConstants;
//import GcCommonException;
//
///**
// * Service方法拦截器
// * <pre>
// *
// * </pre>
// * @author andrewyang  yangjianjun@kugou.net
// * @version 1.00.00
// * <pre>
// *
// * </pre>
// */
//@Aspect
//@Component
//public class CatServiceMethodAdvice {
//
//    private static Logger log = LoggerFactory.getLogger(CatServiceMethodAdvice.class);
//
//	@Around(CatGcConstants.SERVICE_METHOD_ADVICE)
//	public Object serviceMethodAdvice(ProceedingJoinPoint  pjp) throws Throwable{
//		String serverMethod = pjp.getSignature().getDeclaringType().getName()+"."+pjp.getSignature().getName();
//
//		Transaction tran = null;
//		Object returnObj = null;
//		try {
//			tran = Cat.getProducer().newTransaction(CatGcConstants.BUSINESS_SERVICE_METHOD, serverMethod);
//			returnObj =  pjp.proceed();
//			tran.setStatus(Transaction.SUCCESS);
//			return returnObj;
//		} catch (Exception ex) {
//            if(tran == null){
//                ex.printStackTrace();
//                log.error(" Cat newTransaction Exception  service[{}] , serverMethod[{}] ", CatGcConstants.BUSINESS_SERVICE_METHOD, serverMethod);
//                return  pjp.proceed();
//            }
//			if(ex instanceof GcCommonException) {//判断是不是kugou自定义异常
//				if(returnObj != null ){
//					tran.setStatus(Transaction.SUCCESS);
//					return returnObj;
//				}else{
//					tran.setStatus(Transaction.SUCCESS);
//					throw ex;
//				}
//			}else{
//				tran.setStatus(ex);
//				throw ex;
//			}
//
//		} finally {
//			if(tran != null)
//			tran.complete();
//		}
//	}
//
//}
