package com.zx.springboot.utils.util.ips;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;

public class Ip2regionDbSearch{
	 private static volatile DbSearcher dbSearcher;  
	 private static String dbPath;
	      
	 private Ip2regionDbSearch(){
	    	
	 }

	public static  DbSearcher getDbSearcher(String path) throws Exception{
	 	dbPath = path;
		if(dbSearcher == null){
			synchronized(Ip2regionDbSearch.class){
				if(dbSearcher == null){
					dbSearcher = new DbSearcher(new DbConfig(),dbPath);
				}
			}
		}
		return dbSearcher;
	}

	 public static  DbSearcher getDbSearcher() throws Exception{  
		 if(dbSearcher == null){  
			synchronized(Ip2regionDbSearch.class){
				 if(dbSearcher == null){  
					 dbSearcher = new DbSearcher(new DbConfig(),dbPath);  
				 }  
			 }  
		 }  
		 return dbSearcher;  
	}

	public static String getDbPath() {
		return dbPath;
	}

	public static void setDbPath(String dbPath) {
		Ip2regionDbSearch.dbPath = dbPath;
	}
}
