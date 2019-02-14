package com;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import com.MyCalendarUtility;
/**
 * This is a testing class for the holiday handling customization demonstration.
*/
public class Testing extends MyCalendarUtility 
{
	public Testing() {
		super();
	}
	/**
	 * 傳回該年的復活節LocalDate物件(春分後第一次滿月週後的第一主日)<br>
	 * It returns a LocalDate object which devote the date of easter of given year
	 * @param y 年份
	 * @return 傳回該年復活節LocalDate物件
	 */
	public LocalDateTime getEasterDateByYear(int y)
	{
		int lMlen,term2=sTerm(y,5); //取得春分日期
		LocalDateTime dayTerm2=LocalDateTime.of(y,3, term2,0,0,0);//取得春分的國曆日期物件(春分一定出現在3月)
		LunarDate lDayTerm2 = getLunarDate(dayTerm2); //取得取得春分農曆
		
		if (lDayTerm2.date<15)
		{
			lMlen=15-lDayTerm2.date;
		}
		else
		{
			if (lDayTerm2.isLeap)
			{
				lMlen=leapDays(y);//農曆 y年閏月的天數
			}
			else
			{
				lMlen=lunarMonthDayCount(lDayTerm2.year,lDayTerm2.month);//農曆 y年m月的總天數
			}
			lMlen=lMlen-lDayTerm2.date + 15;
		}
		dayTerm2=dayTerm2.plusDays(lMlen);
		if (dayTerm2.getDayOfWeek()==DayOfWeek.SUNDAY)
		{
			dayTerm2=dayTerm2.plusDays(1);
		}
		while (dayTerm2.getDayOfWeek()!=DayOfWeek.SUNDAY)
		{
			dayTerm2=dayTerm2.plusDays(1);
		}
		return dayTerm2;
	}
	protected Map <Integer,ArrayList<String>> prepareHolidayList(ArrayList<MyDate> solarMonthlyDateList)
	{
		int year,month;
		LocalDateTime easterDate,goodFriday,holySaturday,easterMonday;
		Map <Integer,ArrayList<String>> holidayList=super.prepareHolidayList(solarMonthlyDateList);
		
		String chingMingDatePattern,solarMonthPattern;
		String easterDatePattern,goodFridayPattern,holySaturdayPattern,easterMondayPattern;
		month=solarMonthlyDateList.get(0).getMonth();
		year=solarMonthlyDateList.get(0).getYear();
		
		//Ching Ming Festival/清明節日期
		chingMingDatePattern="04"+String.format("%02d",sTerm(year,6));
		
		//Easter/復活節日期
		easterDate=getEasterDateByYear(year);
		easterDatePattern=String.format("%02d", easterDate.getMonthValue())+String.format("%02d",easterDate.getDayOfMonth());
		
		//Good Friday日期
		goodFriday=easterDate.minusDays(2);
		goodFridayPattern=String.format("%02d",goodFriday.getMonthValue())+String.format("%02d",goodFriday.getDayOfMonth());
		
		//Holy Saturday日期
		holySaturday=easterDate.minusDays(1);
		holySaturdayPattern=String.format("%02d",holySaturday.getMonthValue())+String.format("%02d",holySaturday.getDayOfMonth());
		
		//Easter Monday日期
		easterMonday=easterDate.plusDays(1);
		easterMondayPattern=String.format("%02d",easterMonday.getMonthValue())+String.format("%02d",easterMonday.getDayOfMonth());
		
		for (MyDate myDate:solarMonthlyDateList)
		{
			solarMonthPattern=String.format("%02d", month)+String.format("%02d",myDate.getDayOfMonth());
			if (easterDatePattern.equals(solarMonthPattern))
				holidayList.computeIfAbsent(myDate.getDayOfMonth(),k->new ArrayList<String>()).add("Easter");
			if (goodFridayPattern.equals(solarMonthPattern))
				holidayList.computeIfAbsent(myDate.getDayOfMonth(),k->new ArrayList<String>()).add("Good Friday*");
			if (holySaturdayPattern.equals(solarMonthPattern))
				holidayList.computeIfAbsent(myDate.getDayOfMonth(),k->new ArrayList<String>()).add("Holy Saturday*");
			if (easterMondayPattern.equals(solarMonthPattern))
				holidayList.computeIfAbsent(myDate.getDayOfMonth(),k->new ArrayList<String>()).add("Easter Monday*");
			
			if (chingMingDatePattern.equals(solarMonthPattern))
				holidayList.computeIfAbsent(myDate.getDayOfMonth(),k->new ArrayList<String>()).add("清明節*");
		}
		//System.out.println(holidayList);
		return holidayList;
	}
	/**
	 * For Testing only
	 * @param args command line parameter
	 */
	public static void main(String[] args) 
	{
		//int year=2017,month=4;//
		//int year=2017,month=1;
		//int year=2015,month=4;//復活節清明節overlap
		//int year=2016,month=12;//聖誕節補假
		int year=2013,month=3;//復活節撗跨3,4月
		//int year=2014,month=1; //農曆,西曆都有
		//int year=2018,month=2;//農曆新年補假
		Testing cu=new Testing();
		
		//LocalDateTime now=LocalDateTime.now();
		LocalDateTime now=LocalDateTime.of(year,month,28,0,0,0);
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
		MonthlyCalendar mc=cu.getMonthlyCalendar(now.getYear(), now.getMonthValue());
		
		MyDate []myDateList=mc.getDateList();
		MyDate myLocalDate;
		for (int i=0;i<myDateList.length;i++)
		{
			myLocalDate=myDateList[i];
			System.out.println("i="+(i+1)+",Solar Date="+myLocalDate.getYear());	
			System.out.println("Solar Date="+myLocalDate.getYear()+"/"+(myLocalDate.getMonth())+"/"+myLocalDate.getDayOfMonth()+" "+myLocalDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.TRADITIONAL_CHINESE));
			System.out.println("Lunar Date="+myLocalDate.getChineseYearName()+"年"+cu.numToChineseNum(myLocalDate.getLunarMonth())+"月"+cu.numToChineseNum(myLocalDate.getLunarDate())+"日");
			System.out.println("Lunar Date in Chinese="+myLocalDate.getChineseYearName()+"年"+((myLocalDate.isLeap())?"(閏)":"")+myLocalDate.getChineseMonthName()+"月"+myLocalDate.getChineseDayName()+"日"+myLocalDate.getChineseHourName()+"時");
			System.out.println("Solar Term Info="+myLocalDate.getSolarTermInfo());
			System.out.println("Festival Info="+myLocalDate.getFestivalInfo());
			System.out.println("is Holiday="+myLocalDate.isPublicHoliday());
			System.out.println("===================================================");
		}
	}
}
