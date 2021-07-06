// package com.zx.springboot.utils.core.cat;
//
// import com.dianping.cat.message.Transaction;
//
// /**
//  * Created by Max on 2016/9/19.
//  */
// public class TransactionHolder {
//     private final static ThreadLocal<Transaction> transaction = new ThreadLocal<>();
//
//     static void set(Transaction $transaction) {
//         com.st.live.base.core.cat.TransactionHolder.transaction.set($transaction);
//     }
//
//     public static Transaction get() {
//         return com.st.live.base.core.cat.TransactionHolder.transaction.get();
//     }
//
//     static void remove() {
//         com.st.live.base.core.cat.TransactionHolder.transaction.remove();
//     }
// }
