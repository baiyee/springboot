package com.zx.springboot.utils.core.cat.advice;//package com.st.live.base.core.cat.advice;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.dianping.cat.Cat;
//import com.dianping.cat.message.MessageProducer;
//import com.dianping.cat.message.Transaction;
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang3.reflect.MethodUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import CatGcConstants;
//
//import javax.sql.DataSource;
//
///**
// *
// * <pre>
// *
// * </pre>
// * @author suven
// * @version 1.00.00
// * <pre>
// *
// * </pre>
// */
//@Aspect
//@Component
//public class CatDBAdvice  extends CatAdviceValidator {
//
//    private static Logger log = LoggerFactory.getLogger(CatDBAdvice.class);
//
//	@Around("@annotation(db)")
//	public Object monitorSql(ProceedingJoinPoint pjp, CatDBSign db) throws Throwable{
//
//	    if( !this.validator("db")){
//            return this.proceed(pjp);
//         }
//	    if(true){
//			return pjp.proceed();
//		}
//
//        Transaction tran = null;
//        String serverMethod = null;
//        Object[] args = pjp.getArgs();
//        try {
//            if (args != null && args.length > 0) {
//                DataSource ds = (DataSource) MethodUtils.invokeExactMethod(pjp.getThis(), CatGcConstants.GET_DATASOURCE_METHOD);
//                serverMethod = getMethodName(pjp);
//
//                MessageProducer producer = Cat.getProducer();
//                tran = producer.newTransaction(CatGcConstants.TYPE_SQL, serverMethod);
//                String sqlMethodName = getSqlMethodName(args);
//                producer.logEvent(CatGcConstants.TYPE_SQL_METHOD, sqlMethodName, Transaction.SUCCESS, null);
//
//                if (ds instanceof DruidDataSource) {
//                    DruidDataSource dataSource = (DruidDataSource) ds;
//                    producer.logEvent(CatGcConstants.TYPE_SQL_DB, dataSource.getUrl());
//                }
//                if (args.length > 1) {
//                    String sql = unionSQL(args);
//                    tran.addData(CatGcConstants.TYPE_SQL_PARAM, sql);
////                    if(!sql.toLowerCase().contains("where") ){
////						log.error(" Cat Proceeding JoinPoint sql parse not where param , run end resource SQL[{}]",sql);
////						throw new Exception( " Cat Proceeding JoinPoint sql parse not 'where' param , run end resource SQL["+sql+"]" );
////					}
//                }
//            }
//
//            Object obj = pjp.proceed();
//            if (tran != null) {
//                tran.setStatus(Transaction.SUCCESS);
//            }
//            return obj;
//        } catch (Exception e) {
//            if (tran == null) {
//                e.printStackTrace();
//                log.error(" Cat newTransaction Exception  service[{}] , serverMethod[{}] SQL[{}]", CatGcConstants.TYPE_SQL, serverMethod, unionSQL(args));
//                return pjp.proceed();
//            }
//            tran.setStatus(e);
//            Cat.logError(e);
//            Cat.logMetricForCount(CatGcConstants.CAT_METRIC_FOR_COUNT);
//            throw e;
//        } finally {
//            if (tran != null) {
//                tran.complete();
//            }
//        }
//
//	}
//
//
//	private String unionSQL(Object[] args) {
//		String rs = (String) args[0];
//		if(args.length > 1){
//			Object params = args[args.length - 1];
//			if(params instanceof Object[] && ((Object[]) params).length>0){
//				rs += unionParam((Object[]) params);
//			}
//		}
//		return rs;
//	}
//
//	private String unionParam(Object[] params) {
//		StringBuilder rs = new StringBuilder();
//		for(int i = 0, j = params.length; i < j; i++){
////			if(i == 5)
////				break;
//			rs.append(params[i]==null ?"" : params[i]).append(",");
//		}
//		return rs.toString();
//	}
//
//	private String getMethodName(ProceedingJoinPoint point){
//		Signature signature = point.getSignature();
//		String method = this.getInvokeName();
//		StringBuilder clazz = new StringBuilder();
//		if(null != method){
//			clazz.append(method).append(":dataSource:");
//		}
//		clazz.append(signature.getDeclaringTypeName())
//			 .append(signature.getName());
//		return clazz.toString();
//	}
//	/**
//	 * 获取调用方法全路径
//	 */
//	private String getInvokeName() {
//		StackTraceElement[] temp = Thread.currentThread().getStackTrace();
//
//		String clazz = null;
//		for(StackTraceElement ste : temp){
//			if(ste.getClassName().toLowerCase().indexOf(CatGcConstants.DAO_KEY) != -1){
//                clazz = ste.getClassName();
//                if(clazz.indexOf("$$") >0){
//                    clazz = clazz.substring(0,clazz.indexOf("$$"));
//                }
//				return clazz + "." + ste.getMethodName();
//			}
//		}
//		return clazz;
//	}
//
//	/** *
//	 * 获取方法名
//	 * @param argsObj
//	 * @return
//	 */
//	private String getSqlMethodName(Object[] argsObj){
//		if(argsObj != null && argsObj.length > 0){
//			String sqlStr = String.valueOf(argsObj[0]);  //SQL String参数
//			if(StringUtils.isEmpty(sqlStr)){
//				return null;
//			}
//			sqlStr = sqlStr.toUpperCase().trim();
//			for(String daoSql : CatGcConstants.DAO_SQL_TYPE){
//				if(sqlStr.startsWith(daoSql)){
//					return daoSql;
//				}
//			}
//		}
//		return null;
//	}
//}
