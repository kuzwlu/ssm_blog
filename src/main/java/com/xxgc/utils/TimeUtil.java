package com.xxgc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	
	private static String nowtime=null;//δ��ʽ��ʱ��
	private static String res=null;//ʱ���
	/* 
     * ��ʱ��ת��Ϊʱ���
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
     * ��ʱ���ת��Ϊʱ��
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
