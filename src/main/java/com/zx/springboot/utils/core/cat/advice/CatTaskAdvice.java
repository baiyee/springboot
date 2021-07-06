// package com.zx.springboot.utils.core.cat.advice;
//
// import com.dianping.cat.Cat;
// import com.dianping.cat.message.Transaction;
// import com.st.live.base.core.cat.CatGcConstants;
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Component;
//
// /**
//  * @author reddylin
//  */
// @Component
// @Aspect
// public class CatTaskAdvice  extends CatAdviceValidator{
//
//     private static Logger log = LoggerFactory.getLogger(CatTaskAdvice.class);
//
//     @Around("@annotation(scheduled)")
//     public void reportToCatOnRunning(ProceedingJoinPoint pjp, Scheduled scheduled) throws Throwable {
//
//         if( !this.validator("task")){
//              this.proceed(pjp);
//             return;
//         }
//
//         String className = pjp.getSignature().getDeclaringTypeName();
//         String methodName = pjp.getSignature().getName();
//         String serverMethod = className + ":" + methodName;
//
//         Transaction tran = null;// Cat.newTransaction(BasicConstants.TYPE_CRONTAB, className + ":" + methodName);
//         try {
//             tran = Cat.newTransaction(CatGcConstants.TYPE_CRONTAB, serverMethod);
//             tran.addData("cron", scheduled.cron());
//             pjp.proceed();
//             tran.setStatus(Transaction.SUCCESS);
//         } catch (Exception e) {
//             if (tran == null) {
//                 e.printStackTrace();
//                 log.error(" Cat newTransaction Exception  service[{}] , serverMethod[{}] ", CatGcConstants.TYPE_CRONTAB, serverMethod);
//                 return;
//             }
//             tran.setStatus(e);
//             Cat.logError(e);
//             Cat.logMetricForCount(CatGcConstants.CAT_METRIC_FOR_COUNT);
//             throw e;
//         } finally {
//             if (tran != null)
//                 tran.complete();
//         }
//
//     }
// }
