// package com.zx.springboot.utils.core.cat.advice;
//
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.springframework.beans.factory.annotation.Autowired;
//
// public class CatAdviceValidator {
//
//
//     @Autowired
//     private CatAdviceConfigSetting catAdviceConfigSetting;
//
//     public boolean validator(String validator ){
//         switch (validator){
//             case "url" :
//                 return    catAdviceConfigSetting.isUrl() ;
//             case "redis" :
//                 return   catAdviceConfigSetting.isRedis() ;
//             case "db" :
//                 return    catAdviceConfigSetting.isDb() ;
//             case "filter" :
//                 return    catAdviceConfigSetting.isFilter() ;
//             case "http" :
//                 return    catAdviceConfigSetting.isHttp() ;
//             case "task" :
//                 return    catAdviceConfigSetting.isTask() ;
//            default:
//                return false;
//         }
//     }
//
//     public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable{
//        return joinPoint.proceed();
//     }
// }
