package com;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

import com.MyCalendarUtility;


public class Testing {

	public Testing() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * For Testing only
	 * @param args command line parameter
	 */
	public static void main(String[] args) 
	{
		//int year=2017,month=4;//
		int year=2015,month=4;//復活節清明節overlap
		//int year=2013,month=4;//復活節撗跨3,4月
		//int year=2019,month=4;
		MyCalendarUtility cu=new MyCalendarUtility();
		//LocalDateTime now=LocalDateTime.now();
		LocalDateTime now=LocalDateTime.of(year,month,29,0,0,0);
		LunarDate lc=cu.getLunarDate(now);
		LocalDateTime easterDate=cu.getEasterDateByYear(year);
		System.out.println("Solar Date="+now.getYear()+"/"+now.getMonthValue()+"/"+now.getDayOfMonth());
		System.out.println("Lunar Date="+lc.chineseYearName+"年"+cu.numToChineseNum(lc.month)+"月"+cu.numToChineseNum(lc.date)+"日");
		System.out.println("Lunar Date in Chinese="+lc.chineseYearName+"年"+((lc.isLeap)?"(閏)":"")+lc.chineseMonthName+"月"+lc.chineseDayName+"日"+lc.chineseHourName+"時");		
		System.out.println("Solar Term Info="+lc.solarTermInfo);
		System.out.println("isLeapMonth="+lc.isLeap);
		System.out.println("AnimalOfYear="+lc.animalOfYear);
		System.out.println("Easter Date for "+year+"/"+easterDate.getMonthValue()+"/"+easterDate.getDayOfMonth());
		System.out.println("===================================================");
		/*MonthlyCalendar mc=cu.getMonthlyCalendar(now.getYear(), now.getMonthValue());
		for (int i=1;i<=mc.length;i++)
		{
			MyDate myLocalDate=mc.getMonthlyCalendar().get(i);
			System.out.println("i="+i+",Solar Date="+myLocalDate.getYear());	
			System.out.println("Solar Date="+myLocalDate.getYear()+"/"+(myLocalDate.getMonth())+"/"+myLocalDate.getDayOfMonth()+" "+myLocalDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.TRADITIONAL_CHINESE));
			System.out.println("Lunar Date="+myLocalDate.getChineseYearName()+"年"+cu.numToChineseNum(myLocalDate.getLunarMonth())+"月"+cu.numToChineseNum(myLocalDate.getLunarDate())+"日");
			System.out.println("Lunar Date in Chinese="+myLocalDate.getChineseYearName()+"年"+((myLocalDate.isLeap())?"(閏)":"")+myLocalDate.getChineseMonthName()+"月"+myLocalDate.getChineseDayName()+"日"+myLocalDate.getChineseHourName()+"時");
			System.out.println("Solar Term Info="+myLocalDate.getSolarTermInfo());
			System.out.println("Festival Info="+myLocalDate.getFestivalInfo());
			System.out.println("is Holiday="+myLocalDate.isPublicHoliday());
			System.out.println("===================================================");
		}*/
	}


}
