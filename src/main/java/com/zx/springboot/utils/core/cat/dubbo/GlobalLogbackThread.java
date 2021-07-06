// package com.zx.springboot.utils.core.cat.dubbo;
//
// import com.st.live.base.util.constants.GlobalConstants;
// import com.st.live.base.util.date.DateUtil;
// import com.st.live.base.util.ids.UUIDGenerator;
// import org.apache.dubbo.rpc.RpcContext;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.slf4j.MDC;
//
// /**
//  * 全局日志跟踪类型
//  *
//  * @author vincentdeng
//  */
// public class GlobalLogbackThread {
//
//    private static Logger logger = LoggerFactory.getLogger(GlobalLogbackThread.class);
//
//     public static void setGlobalLogbackTraceId(){
//         try{
//             String traceId = RpcContext.getContext()
//                     .getAttachment(GlobalConstants.LOGBACK_TRACE_ID);
//             if(null == traceId || "".equals(traceId)){
//                 traceId =  MDC.get(GlobalConstants.LOGBACK_TRACE_ID);
//             }
//             if(null != traceId){
//                 MDC.put(GlobalConstants.LOGBACK_TRACE_ID,traceId);
//                 RpcContext.getContext().setAttachment(GlobalConstants.LOGBACK_TRACE_ID, traceId);
//             }
//         }catch (Exception e){
//             e.printStackTrace();
//             logger.error("Exception by setGlobalLogbackTraceId error[{}]",e);
//         }
//     }
//
//
//     public static void setLogbackTraceId(String traceId){
//         traceId = traceId == null ? "" : traceId;
//         MDC.put(GlobalConstants.LOGBACK_TRACE_ID,traceId);
//     }
//
//     public static String getLogbackTraceIdInMDC(String module){
//         try{
//             String traceId =  MDC.get(GlobalConstants.LOGBACK_TRACE_ID);
//             if(traceId == null){
//                 traceId = initGlobalLogbackTraceId(module);
//             }
//             return traceId;
//         }catch (Exception e){
//             e.printStackTrace();
//             logger.error("Exception by setGlobalLogbackTraceId error[{}]",e);
//         }
//         return "";
//     }
//
//     public static String initGlobalLogbackTraceId(String module){
//         if(module == null){
//             module =  "";
//         }
//         String traceId = new StringBuilder("[")
//                 .append(module)
//                 .append("_")
//                 .append(DateUtil.getNowToNumFormat())
//                 .append("_")
//                 .append(UUIDGenerator.halfUUID())
//                 .append("]").toString();
//         MDC.put(GlobalConstants.LOGBACK_TRACE_ID,traceId);
//         logger.info("MDC server global logback info logback_trace_id ");
//         return traceId;
//     }
//
//     public static void removeTraceId(){
//         MDC.remove(GlobalConstants.LOGBACK_TRACE_ID);
//     }
//
//
//
// }
//
//
