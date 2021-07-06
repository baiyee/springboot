// package com.zx.springboot.utils.core.cat.advice;
//
// import com.dianping.cat.Cat;
// import com.dianping.cat.message.Transaction;
// import com.st.live.base.core.cat.CatGcConstants;
// import org.apache.commons.lang3.StringUtils;
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;
//
// @Aspect
// @Component
// public class CatHttpAdvice  extends CatAdviceValidator{
//
//     private static Logger log = LoggerFactory.getLogger(CatHttpAdvice.class);
//
// 	@Around("@annotation(hs)")
// 	public Object monitorCache(ProceedingJoinPoint pjp,CatHttpSign hs) throws Throwable{
//
//         if( !this.validator("http")){
//             return this.proceed(pjp);
//         }
//
// 	    String methodName = pjp.getSignature().getName();
// 		String url = "UNKNOWN";
// 		Object[] argsObj = pjp.getArgs();
// 		if(argsObj!=null && argsObj.length>0){
// 			String agrs0 = (String) argsObj[0];
// 			if(StringUtils.isNotBlank(agrs0)){
// 				if(agrs0.contains("?")){
// 					url = agrs0.substring(0, agrs0.indexOf("?")-1);
// 				}else{
// 					url = agrs0;
// 				}
// 			}
// 		}
// 		Transaction tran = null;
// 		String serverMethod =  url+":"+methodName;
// 		try {
// 			tran = Cat.getProducer().newTransaction(CatGcConstants.TYPE_CALL, serverMethod);
// 			Object returnObj = pjp.proceed();
// 			tran.setStatus(Transaction.SUCCESS);
// 			return returnObj;
// 		} catch (Exception e) {
//             if(tran == null){
//                 e.printStackTrace();
//                 log.error(" Cat newTransaction Exception  service[{}] , serverMethod[{}] ", CatGcConstants.TYPE_CALL, serverMethod);
//                 return  pjp.proceed();
//             }
// 			tran.setStatus(e);
// 			Cat.logError(e);
// 			Cat.logMetricForCount("ServerError");
// 			throw e;
// 		}finally {
// 			if(null != tran)
// 			tran.complete();
// 		}
//
// 	}
// }