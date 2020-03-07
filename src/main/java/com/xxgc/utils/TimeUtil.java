package com.xxgc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	
	private static String nowtime=null;//未格式化时间
	private static String res=null;//时间戳
	/* 
     * 将时间转换为时间戳
     */    
    public static String dateToStamp(String nowtimes){
    	
        SimpleDateFormat sdfh = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date;
		try {
			date = sdfh.parse(nowtimes);
			long ts = date.getTime();
	        nowtime = String.valueOf(ts);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nowtime;
    }
    
    /* 
     * 将时间戳转换为时间
     */
    public static String stampToDate(String artime){
    	SimpleDateFormat sdfh = new SimpleDateFormat("yyyy-MM-dd");
			long lt = new Long(artime);
	        Date date = new Date(lt);
	        String nowtimes = sdfh.format(date);
	        res=nowtimes;
			return res;
	} 
}
