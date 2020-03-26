package com.rosterWeb.util.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Hashtable;


/**
 * 
 * 日曆工具物件<br> 	
 * <br>
 * 本程式參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)<br>
 * http://sean.o4u.com/2008/04/dhtml.html<br><br>
 * 
 * The program is inspired by Sean Lin DHTML web page:<br>
 * http://sean.o4u.com/2008/04/dhtml.html
 *
 * @author Roy Tsang
 */
public class CalendarUtility {
	private int lunarInfo[]={0x4bd8,0x4ae0,0xa570,0x54d5,0xd260,0xd950,0x5554,0x56af,0x9ad0,0x55d2,
			0x4ae0,0xa5b6,0xa4d0,0xd250,0xd295,0xb54f,0xd6a0,0xada2,0x95b0,0x4977,
			0x497f,0xa4b0,0xb4b5,0x6a50,0x6d40,0xab54,0x2b6f,0x9570,0x52f2,0x4970,
			0x6566,0xd4a0,0xea50,0x6a95,0x5adf,0x2b60,0x86e3,0x92ef,0xc8d7,0xc95f,
			0xd4a0,0xd8a6,0xb55f,0x56a0,0xa5b4,0x25df,0x92d0,0xd2b2,0xa950,0xb557,
			0x6ca0,0xb550,0x5355,0x4daf,0xa5b0,0x4573,0x52bf,0xa9a8,0xe950,0x6aa0,
			0xaea6,0xab50,0x4b60,0xaae4,0xa570,0x5260,0xf263,0xd950,0x5b57,0x56a0,
			0x96d0,0x4dd5,0x4ad0,0xa4d0,0xd4d4,0xd250,0xd558,0xb540,0xb6a0,0x95a6,
			0x95bf,0x49b0,0xa974,0xa4b0,0xb27a,0x6a50,0x6d40,0xaf46,0xab60,0x9570,
			0x4af5,0x4970,0x64b0,0x74a3,0xea50,0x6b58,0x5ac0,0xab60,0x96d5,0x92e0,
			0xc960,0xd954,0xd4a0,0xda50,0x7552,0x56a0,0xabb7,0x25d0,0x92d0,0xcab5,
			0xa950,0xb4a0,0xbaa4,0xad50,0x55d9,0x4ba0,0xa5b0,0x5176,0x52bf,0xa930,
			0x7954,0x6aa0,0xad50,0x5b52,0x4b60,0xa6e6,0xa4e0,0xd260,0xea65,0xd530,
			0x5aa0,0x76a3,0x96d0,0x4afb,0x4ad0,0xa4d0,0xd0b6,0xd25f,0xd520,0xdd45,
			0xb5a0,0x56d0,0x55b2,0x49b0,0xa577,0xa4b0,0xaa50,0xb255,0x6d2f,0xada0,
			0x4b63,0x937f,0x49f8,0x4970,0x64b0,0x68a6,0xea5f,0x6b20,0xa6c4,0xaaef,
			0x92e0,0xd2e3,0xc960,0xd557,0xd4a0,0xda50,0x5d55,0x56a0,0xa6d0,0x55d4,
			0x52d0,0xa9b8,0xa950,0xb4a0,0xb6a6,0xad50,0x55a0,0xaba4,0xa5b0,0x52b0,
			0xb273,0x6930,0x7337,0x6aa0,0xad50,0x4b55,0x4b6f,0xa570,0x54e4,0xd260,
			0xe968,0xd520,0xdaa0,0x6aa6,0x56df,0x4ae0,0xa9d4,0xa4d0,0xd150,0xf252,
			0xd520};
	private String nStr1[] = {"日","一","二","三","四","五","六","七","八","九","十"};
	private String nStr2[] = {"初","十","廿","卅","卌"};
	private String Zhi[]={"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
	private int solarMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};

	private String solarTerm[] ={"小寒","大寒","立春","雨水","驚蟄","春分","清明","穀雨","立夏","小滿","芒種","夏至","小暑","大暑","立秋","處暑","白露","秋分","寒露","霜降","立冬","小雪","大雪","冬至"};
	private Hashtable <String,String>lunarHolidayList=new Hashtable<String,String>();
	private Hashtable <String,String>solarHolidayList=new Hashtable<String,String>();
	public Hashtable<DayOfWeek,String>weekDayNames=new Hashtable<DayOfWeek,String>();
	private LocalDate solarStartDate=LocalDate.of(1900, 1, 31);
	/**
	 * 日曆工具物件<br>
	 * 支援年份(由AD1900至AD2100)<br><br>
	 * Calendar Utility<br>
	 * It support from AD1900 to AD2100
	 */
	 public CalendarUtility() {
		lunarHolidayList.put("0101","大年初一");
		lunarHolidayList.put("0102","年初二");
		lunarHolidayList.put("0103","年初三");
		lunarHolidayList.put("0408","佛誕");
		lunarHolidayList.put("0505","端午節");
		lunarHolidayList.put("0816","中秋節翌日");
		lunarHolidayList.put("0909","重陽節");
		
		solarHolidayList.put("0101","新曆新年");
		solarHolidayList.put("0501","勞動節");
		solarHolidayList.put("0701","香港特別行政區成立紀念日");
		solarHolidayList.put("1001","國慶日");
		solarHolidayList.put("1225","聖誕節");
		solarHolidayList.put("1226","聖誕節翌日");
		
		weekDayNames.put(DayOfWeek.SUNDAY,"Su");
		weekDayNames.put(DayOfWeek.MONDAY,"M");
		weekDayNames.put(DayOfWeek.TUESDAY,"T");
		weekDayNames.put(DayOfWeek.WEDNESDAY,"W");
		weekDayNames.put(DayOfWeek.THURSDAY,"Th");
		weekDayNames.put(DayOfWeek.FRIDAY,"F");
		weekDayNames.put(DayOfWeek.SATURDAY,"S");
	 }
	/**
	 * 傳回該年生肖
	 * @param y 年份
	 * @return 傳回該年生肖
	 */
	private String getAnimalOfYear(int y)
	{
		String Animals[]={"鼠","牛","虎","兔","龍","蛇","馬","羊","猴","雞","狗","豬"};
		return Animals[(y-4)%12];
	}
	/**
	*     傳入LocalDate物件, 傳回LunarDate物件<br>
	* It returns a corresponding LunarDate object when a LocalDate object is given.
	* @param inLocalDateObj LocalDate物件
	* @return LunarDate物件<br>
	* A corresponding LunarDate object when a LocalDate object is given.
	*/
	public LunarDate getLunarDate(LocalDate inLocalDateObj)
	{
		int i,lunarLeapMonth;
		long offset=0L,temp=0L;

		LunarDate result=new LunarDate();
		LocalDateTime inLocalDateTimeObj=inLocalDateObj.atStartOfDay();
		
		offset=inLocalDateTimeObj.atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
		offset=(offset-solarStartDate.atStartOfDay().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli())/86400000L;
		System.out.println("0 offset="+offset);
		for(i=1900; i<2100 && offset>0; i++) 
		{ 
			temp=lYearDays(i); 
			offset-=temp; 
		}
		if(offset<0) 
		{ 
			offset+=temp; 
			i--; 
		}
		System.out.println("1 offset="+offset);
		result.year=i;
		lunarLeapMonth=getLunarLeapMonth(i);
		result.isLeap=false;
		System.out.println("lunarLeapMonth="+lunarLeapMonth);
		for(i=1; i<13 && offset>0; i++) 
		{
			//閏月
			if(lunarLeapMonth>0 && i==(lunarLeapMonth+1) && result.isLeap==false)
			{ 
				--i; 
				result.isLeap = true; 
				temp = leapDays(result.year);
				System.out.println("0 i="+i+",temp="+temp);
			}
			else
			{ 
				temp = lunarMonthDayCount(result.year, i);
				System.out.println("1 i="+i+",temp="+temp);
			}
			System.out.println("2 i="+i+",temp="+temp);
			//解除閏月
			if(result.isLeap==true && i==(lunarLeapMonth)) 
				result.isLeap = false;

			offset -= temp;
			System.out.println("1.5 offset="+offset);
		}
		System.out.println("2 offset="+offset);
		if(offset==0L && lunarLeapMonth>0 && i==lunarLeapMonth)
			if(result.isLeap)
			{
				result.isLeap = false; 
			}
			else
			{ 
				result.isLeap = true; 
				--i; 
			}
		System.out.println("3 offset="+offset);
		if(offset<0L)
		{ 
			offset += temp; 
			--i; 
		}
		System.out.println("4 offset="+offset);
		result.month=i;
		result.date=(int)offset+1;

		return result;
	}
	/**
	 * 傳回農曆 y年閏哪個月 1-12 , 沒閏傳回 0
	 * @param y
	 * @return 傳回農曆 y年閏哪個月 1-12 , 沒閏傳回 0
	 *
	 */
	private int getLunarLeapMonth(int y) 
	{
		int lm = lunarInfo[y-1900] & 0xf;
		return(lm==0xf?0:lm);
	}
	/**
	 * 傳回國曆 y年某month月的天數
	 * @return 該月的天數
	 */
	private int getMonthLength(int year,int month) 
	{
	 if(month==2)
	    return(((year%4 == 0) && (year%100 != 0) || (year%400 == 0))? 29: 28);
	 else
	    return(solarMonth[month-1]);
	}
	/**
	 * 傳回農曆 y年閏月的天數
	 * @param y
	 * @return 傳回農曆 y年閏月的天數
	 *
	 */
	private int leapDays(int y) 
	{
		if(getLunarLeapMonth(y)!=0) 
		{	
			return( (lunarInfo[y-1899]&0xf)==0xf? 30: 29);
		}
		else 
			return(0);
	}
	
	/**
	 * 傳回農曆 y年m月的總天數
	 * @param y 年份
	 * @param m 月份
	 * @return 傳回農曆 y年m月的總天數
	 * 
	 */
	private int lunarMonthDayCount(int y,int m) 
	{
		if ((lunarInfo[y-1900] & (0x10000>>m))>0)
			return 30;
		else
			return 29;	  
	}

	/**
	 *  傳回農曆 y年的總天數
	 *  @param y
	 *  @return 傳回農曆 y年的總天數
	 *
	 */
	private int lYearDays(int y) 
	{
		int i, sum = 348;
		for(i=0x8000; i>0x8; i>>=1) 
		{	
			if ((lunarInfo[y-1900] & i)>0)
			{
				sum+=1;
			}
		}
		return(sum+leapDays(y));
	}

	/**
	 * 傳入數字傳回相應的中文數字<br>
	 * It returns corresponding Chinese of a given number 
	 * @param d 傳入數字
	 * @return 傳回中文數字
	 */
	public String numToChineseNum(int d)
	{
		String s=new String();
		if (d<10)
			s=nStr1[d];
		else
		{
			s = nStr2[(int)(d/10)];
			if ((d%10)>0)
				s += nStr1[d%10];
		}
		return s;
	}
	
	/**
	 * For Testing only
	 * @param args command line parameter
	 */
	public static void main(String[] args) 
	{
		//int year=2017,month=4;//
		//int year=2015,month=3;//復活節清明節overlap
		//int year=2013,month=3;//復活節撗跨3,4月
		//int year=2018,month=2;//農曆新年補假
		int year=2020,month=4,date=30;
		CalendarUtility cu=new CalendarUtility();
		LocalDate now=LocalDate.now();
		//LocalDate now=LocalDate.of(year,month,date);
		LunarDate lc=cu.getLunarDate(now);
		//LocalDate easterDate=cu.getEasterDateByYear(year);
		System.out.println("Solar Date="+now.getYear()+"/"+now.getMonthValue()+"/"+now.getDayOfMonth());
		System.out.println("Lunar Date="+lc.chineseYearName+"年"+cu.numToChineseNum(lc.month)+"月"+cu.numToChineseNum(lc.date)+"日");
		System.out.println("Lunar Date in Chinese="+lc.chineseYearName+"年"+((lc.isLeap)?"(閏)":"")+lc.chineseMonthName+"月"+lc.chineseDayName+"日"+lc.chineseHourName+"時");		
		System.out.println("Solar Term Info="+lc.solarTermInfo);
		System.out.println("isLeapMonth="+lc.isLeap);
		System.out.println("AnimalOfYear="+lc.animalOfYear);
		//System.out.println("Easter Date for "+year+"/"+easterDate.getMonthValue()+"/"+easterDate.getDayOfMonth());
		System.out.println("===================================================");
		/*
		MonthlyCalendar mc=cu.getMonthlyCalendar(now.getYear(), now.getMonthValue());
		for (int i=1;i<=mc.length;i++)
		{
			MyDate myLocalDate=mc.getMonthlyCalendar().get(i);
			System.out.println("i="+i+",Solar Date="+myLocalDate.getYear());	
			System.out.println("Solar Date="+myLocalDate.getYear()+"/"+(myLocalDate.getMonth())+"/"+myLocalDate.getDayOfMonth()+" "+myLocalDate.getDayOfWeek());
			System.out.println("Lunar Date="+myLocalDate.getChineseYearName()+"年"+cu.numToChineseNum(myLocalDate.getLunarMonth())+"月"+cu.numToChineseNum(myLocalDate.getLunarDate())+"日");
			System.out.println("Lunar Date in Chinese="+myLocalDate.getChineseYearName()+"年"+((myLocalDate.isLeap())?"(閏)":"")+myLocalDate.getChineseMonthName()+"月"+myLocalDate.getChineseDayName()+"日"+myLocalDate.getChineseHourName()+"時");
			System.out.println("Solar Term Info="+myLocalDate.getSolarTermInfo());
			System.out.println("Festival Info="+myLocalDate.getFestivalInfo());
			System.out.println("is Holiday="+myLocalDate.isPublicHoliday());
			System.out.println("===================================================");
		}
		*/
	}	
}
