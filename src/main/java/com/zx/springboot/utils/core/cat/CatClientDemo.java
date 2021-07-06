// package com.zx.springboot.utils.core.cat;
//
// import com.dianping.cat.Cat;
// import com.dianping.cat.message.Transaction;
//
// import java.util.HashMap;
// import java.util.Map;
//
// public class CatClientDemo {
//
//     public static Object initTest(){
//         Transaction tran = null;
//         Map returnObj = new HashMap();
//         returnObj.put("test","test");
//         try {
//             tran = Cat.newTransaction(CatGcConstants.BUSINESS_SERVICE, "Interface:ClientDemo");
//             tran.addData(CatGcConstants.SERVER_IP, "127.0.0.1");
//             tran.setStatus(Transaction.SUCCESS);
//             return returnObj;
//         } catch (Exception ex) {
//             ex.printStackTrace();
//             if(ex instanceof GcCommonException) {//判断是不是kugou自定义异常
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
//             if(tran != null )
//                 tran.complete();
//         }
//     }
//
//     public static void main(String[] agr){
//         com.st.live.base.core.cat.CatClientDemo.initTest();
//     }
//
// }
