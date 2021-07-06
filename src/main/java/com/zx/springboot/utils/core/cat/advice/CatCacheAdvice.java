// package com.zx.springboot.utils.core.cat.advice;
//
//
// import com.dianping.cat.Cat;
// import com.dianping.cat.message.Transaction;
// import com.st.live.base.core.cat.CatGcConstants;
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.reflect.MethodSignature;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;
//
// import java.lang.reflect.Method;
//
// /**
//  *
//  * <pre>
//  *
//  * </pre>
//  * @version 1.00.00
//  * <pre>
//  *
//  * </pre>
//  */
// @Aspect
// @Component
// public class CatCacheAdvice extends CatAdviceValidator{
//
//     private static Logger log = LoggerFactory.getLogger(CatCacheAdvice.class);
//
// 	@Around("@annotation(redisSign)")
// 	public Object monitorCache(ProceedingJoinPoint pjp,CatCacheSign redisSign) throws Throwable{
//
//        if( !this.validator("redis")){
//            return this.proceed(pjp);
//        }
// 		String service = redisSign.service();
// 		String className = pjp.getSignature().getDeclaringTypeName();
// 		String methodName = pjp.getSignature().getName();
//         String serverMethod = className+":"+methodName;
//
//
//
// 		Transaction tran = null;//Cat.newTransaction(service, className+":"+methodName);
// 		String redisKey =  getKey(pjp);
// 		try {
//             tran = Cat.newTransaction(CatGcConstants.TYPE_REDIS,serverMethod);
// 			Object returnObj = pjp.proceed();
// 			if(returnObj == null){
// 				Cat.logEvent(service, CatGcConstants.TYPE_REDIS_MISS);
// 			}else{
// 				Cat.logEvent(service, CatGcConstants.TYPE_REDIS_HIT);
// 			}
// 			tran.addData(CatGcConstants.CACHE_KEY, redisKey);
// 			tran.setStatus(Transaction.SUCCESS);
// 			return returnObj;
// 		} catch (Exception e) {
// 		    if(tran == null){
//                 e.printStackTrace();
//                 log.error(" Cat newTransaction Exception  service[{}] , serverMethod[{}], redisKeyValue[{}] ",
// 						service, serverMethod ,redisKey );
//                 return  pjp.proceed();
//             }
// 			tran.setStatus(e);
// 			Cat.getProducer().logError(e);
// 			Cat.logMetricForCount("ServerError");
// 			throw e;
// 		}finally {
// 			if(null != tran){
//                 tran.complete();
//             }
//
// 		}
//
// 	}
//
// 	/**
// 	 * @param pjp
// 	 */
// 	private String getKey(ProceedingJoinPoint pjp) {
// 		String key = "";
// 		MethodSignature signature = (MethodSignature) pjp.getSignature();
// 		Method method = signature.getMethod();
//         Class<?>[] params = method.getParameterTypes();
// 		Object cacheKey = null;
// 		for (int i = 0, j = params.length; i < j; i++) {
//             CatCacheKeySign cache= params[i].getAnnotation(CatCacheKeySign.class);
// 			if (cache != null) {
// 				cacheKey = pjp.getArgs()[i];
// 				break;
// 			}
// 		}
// 		if(cacheKey == null){
// 			cacheKey  = pjp.getArgs()[0];
// 		}
// 		if (cacheKey instanceof String) {
// 			key = (String) cacheKey;
// 		} else if (cacheKey instanceof byte[]) {
// 			key = new String((byte[]) cacheKey);
// 		} else if (cacheKey instanceof String[]) {
// 			key = unionStrs((String[]) cacheKey);
// 		}
// 		return key;
// 	}
//
// 	private String unionStrs(String[] oriKey) {
// 		String rs = "";
// 		for (int i = 0, j = oriKey.length; i < j; i++) {
// 			rs += oriKey[i];
// //			if (i == 3)
// //				break;
// 		}
// 		return rs;
// 	}
//
// }
