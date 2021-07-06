// package com.zx.springboot.utils.core.cat.advice;
//
// import com.dianping.cat.Cat;
// import com.dianping.cat.message.MessageProducer;
// import com.dianping.cat.message.Transaction;
// import com.st.live.base.core.cat.CatGcConstants;
// import com.st.live.base.core.cat.CatUtil;
// import com.st.live.base.core.cat.GcCommonException;
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.Signature;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
//
// import javax.annotation.PostConstruct;
//
// /**
//  * 接口监控， requestMapping spring controller 级别。
//  * @author summerao
//  *
//  */
// @Aspect
// @Component
// public class CatUrlAdvice  extends CatAdviceValidator{
//
//
//     private static Logger log = LoggerFactory.getLogger(CatUrlAdvice.class);
//
//     private String srvIp;
//
//     @PostConstruct
//     public void init() {
//         StringBuilder sb = new StringBuilder();
//         sb.append(CatUtil.getHostAddress());
//         srvIp = sb.toString();
//     }
//     @Around("@annotation(rm)")
//     public Object getMappingUrlToCatDealExpire(ProceedingJoinPoint  pjp, GetMapping rm) throws Throwable{
//         String url = getRequestParameter(rm.value());
//         return  urlToCatDealExpireDealExpire(pjp,url);
//     }
//     @Around("@annotation(rm)")
//     public Object postMappingUrlToCatDealExpire(ProceedingJoinPoint  pjp, PostMapping rm) throws Throwable{
//         String url = getRequestParameter(rm.value());
//         return  urlToCatDealExpireDealExpire(pjp,url);
//     }
//
//     @Around("@annotation(rm)")
//     public Object requestMappingUrlToCatDealExpireDealExpire(ProceedingJoinPoint  pjp,RequestMapping rm) throws Throwable{
//         String url = getRequestParameter(rm.value());
//         return  urlToCatDealExpireDealExpire(pjp,url);
//     }
//     private Object urlToCatDealExpireDealExpire(ProceedingJoinPoint  pjp, String url) throws Throwable{
//
//         if( !this.validator("url")){
//             return this.proceed(pjp);
//         }
//
//         Transaction tran = null;
//         Object returnObj = null;
//         String serverMethod = url;
//
//         try {
//             String param = "";
//             serverMethod = getMethodName(pjp,serverMethod);
//             MessageProducer producer = Cat.getProducer();
//             tran = producer.newTransaction(CatGcConstants.BUSINESS_SERVICE,serverMethod );
//             tran.addData(CatGcConstants.TYPE_REQUEST, param);
//             tran.addData(CatGcConstants.SERVER_IP, srvIp);
//             returnObj =  pjp.proceed();
//             tran.setStatus(Transaction.SUCCESS);
//             return returnObj;
//         } catch (Exception ex) {
//             if(tran == null){
//                 ex.printStackTrace();
//                 log.error(" Cat newTransaction Exception  service[{}] , serverMethod[{}] ", CatGcConstants.BUSINESS_SERVICE, serverMethod);
//                 return  pjp.proceed();
//             }
//             if(ex instanceof GcCommonException) {//判断是不是自定义异常
//                 if(returnObj != null ){
//                     tran.setStatus(Transaction.SUCCESS);
//                     return returnObj;
//                 }else{
//                     tran.setStatus(Transaction.SUCCESS);
//                     throw ex;
//                 }
//             }else{
//                 tran.setStatus(ex);
//                 Cat.logError(ex);
//                 Cat.logMetricForCount(CatGcConstants.CAT_METRIC_FOR_COUNT);
//                 throw ex;
//             }
//
//         } finally {
//             if(tran != null ){
//                 tran.complete();
//             }
//
//         }
//
//     }
//
//     private String getRequestParameter(String[] arg){
//         String requestParameter = "";
//         if(arg !=null && arg.length>0){
//             requestParameter = arg[0];
//         }
//         return requestParameter;
//     }
//
//     private String getMethodName(ProceedingJoinPoint  pjp, String url){
//         Signature signature =  pjp.getSignature();
//         String methodName = signature.getName();
//         String className =  signature.getDeclaringTypeName();
//         className = className == null? "" : className;
//         className = className.substring(className.lastIndexOf(".") + 1);
//         StringBuilder sb = new StringBuilder("Interface:")
//                 .append(className).append(".")
//                 .append(methodName).append("(")
//                 .append(url)
//                 .append(")");
//
//         return sb.toString();
//     }
//
//
// }
