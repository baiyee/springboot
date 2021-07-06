// package com.zx.springboot.utils.core.cat;
//
// import com.dianping.cat.Cat;
// import com.dianping.cat.message.Transaction;
//
// import java.net.InetAddress;
// import java.net.NetworkInterface;
// import java.net.SocketException;
// import java.util.Enumeration;
//
// /**
//  * Created by Max on 2016/9/14.
//  */
// public abstract class CatUtil {
//
//     /**
//      * 异常上报cat
//      * @param e
//      */
//     public static void onFailure(Transaction transaction, Throwable e) {
//         transaction.setStatus(e);
//         Cat.logMetricForCount("RemoteCallError");
//         Cat.logError(e);
//     }
//
//
//
//     /**
//      * cat成功
//      */
//     public static void onSuccess(Transaction transaction) {
//         transaction.setStatus(Transaction.SUCCESS);
//     }
//
//
//     public static String  getHostAddress() {
//         StringBuilder sb = new StringBuilder();
//         try {
//             Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
//             while (en.hasMoreElements()) {
//                 NetworkInterface intf = (NetworkInterface) en.nextElement();
//                 Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
//                 while (enumIpAddr.hasMoreElements()) {
//                     InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
//                     if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()
//                             && inetAddress.isSiteLocalAddress()) {
//                         sb.append(inetAddress.getHostAddress().toString() + "\n");
//                     }
//                 }
//             }
//         } catch (SocketException e) {
//         }
//         return sb.toString();
//     }
// }
