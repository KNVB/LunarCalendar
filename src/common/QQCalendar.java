package common;
import java.util.*;
/**
 * 
 * QQCalendar<br> 
 * 這是示範如何extend MyCalendar 物件<br>
 * 和implement 自己的checkFestival method<br>
 * 來設定假期<br>
 *
 * @author Roy Tsang
 */
public class QQCalendar extends LunarCalendar_qq 
{
	static final long serialVersionUID=21513345134L;
	/**
	 當天假期資訊
	*/
	public String myFestival; //不要寫成public String myFestival=new String();否則有問題
//===========================================================================================================================			
//	Constructor
	public QQCalendar()
	{
		super();
	}
	public QQCalendar(int year, int month, int date)
	{
	    super(year, month,date);
	}
	public QQCalendar(int year, int month, int date, int hour, int minute) 
	{
	    super(year, month,date, hour, minute);
	}
	public QQCalendar(int year, int month, int date, int hour, int minute, int second) 
	{
		super(year, month,date, hour, minute,second);
	}
	public QQCalendar(Locale aLocale) 
	{
		super(aLocale);
	}
	public QQCalendar(TimeZone zone) 
	{
		super(zone);
	}
	public QQCalendar(TimeZone zone, Locale aLocale) 
	{
		super(zone, aLocale);
	}
//===========================================================================================================================
//	private method
	private String getFestivalPatternByMonthWeekDay(int m,int w, int d)
	{
		String result=String.valueOf(m);
		if (m<10)
			result="0"+result;
		result=result+String.valueOf(w)+String.valueOf(d);
		return result;	
	} 
	protected void checkFestival()
	{
		super.checkFestival();//如果想要包括農曆節日 就要有這行
		String searchPattern=new String();
		Hashtable <String,String>festivalByWeek=new Hashtable<String,String>();
		Hashtable <String,String>festivalByDate=new Hashtable<String,String>();
		festivalByWeek.put("0520","母親節");
		festivalByWeek.put("0630","父親節");
		festivalByWeek.put("1144","感恩節");
		festivalByDate.put("0101*","新曆新年");
		festivalByDate.put("0123","自由日");
		festivalByDate.put("0214","情人節");
		festivalByDate.put("0308","婦女節");
		festivalByDate.put("0401","愚人節");
		festivalByDate.put("0404","兒童節");
		festivalByDate.put("0422","世界地球日");
		festivalByDate.put("0501*","勞動節");
		festivalByDate.put("0701*","香港特別行政區成立紀念日");
		festivalByDate.put("1001*","國慶日");
		festivalByDate.put("1031","萬聖節");
		festivalByDate.put("1112","孫中山記念日");
		festivalByDate.put("1224","平安夜");
		festivalByDate.put("1225*","聖誕節");
		festivalByDate.put("1226*","聖誕節翌日");
		this.setFirstDayOfWeek(Calendar.MONDAY);
		this.setMinimalDaysInFirstWeek(1);
		int m=this.get(Calendar.MONTH)+1;
		int w=this.get(Calendar.WEEK_OF_MONTH);
		int d=this.get(Calendar.DAY_OF_WEEK)-1;
		/*System.out.println("=============================================");
		System.out.println("DAY_OF_MONTH="+this.get(Calendar.DAY_OF_MONTH));
		System.out.println("MONTH="+(this.get(Calendar.MONTH)+1));
		System.out.println("WEEK_OF_MONTH="+this.get(Calendar.WEEK_OF_MONTH));
		System.out.println("DAY_OF_WEEK="+(this.get(Calendar.DAY_OF_WEEK)-1));*/
		
		searchPattern=getFestivalPatternByMonthWeekDay(m,w,d);
		myFestival="";
		if (festivalByWeek.containsKey(searchPattern))
		{
			myFestival=(String)festivalByWeek.get(searchPattern)+" ";
		}
		d=this.get(Calendar.DAY_OF_MONTH);
		searchPattern=getFestivalPatternByMonthDay(m,d);
		if (festivalByDate.containsKey(searchPattern))
		{
			myFestival+=(String)festivalByDate.get(searchPattern)+" ";
		}
		if(festivalByDate.containsKey(searchPattern+"*"))
		{
			myFestival+=(String)festivalByDate.get(searchPattern+"*")+" ";
			this.isHoliday=true;
		}
		GregorianCalendar eg=getEasterDateByYear(this.get(Calendar.YEAR));
		GregorianCalendar ref=new GregorianCalendar(this.get(Calendar.YEAR),m-1,d);
		long easterTime=eg.getTime().getTime();
		long timeDiff=ref.getTime().getTime();
		timeDiff=timeDiff-easterTime;
		timeDiff/=86400000L;
		switch ((int)timeDiff)
		{
			case -2:myFestival+="耶穌受難節 ";
					this.isHoliday=true;
				    break;
			case -1:myFestival+="耶穌受難節翌日 ";
					this.isHoliday=true;
				    break;
			case 0:	myFestival+="復活節 ";
					this.isHoliday=true;
					break;
			case 1: myFestival+="復活受難節翌日 ";
					this.isHoliday=true;
				    break;
			default:break;
		}
		eg=null;
		ref=null;
		festivalByWeek=null;
		festivalByDate=null;
	}	
	public static void main(String[] args) 
	{
		QQCalendar mc;
		if (args.length==0)
			mc=new QQCalendar();
		else	
			mc=new QQCalendar(Integer.valueOf(args[0]).intValue(),Integer.valueOf(args[1]).intValue()-1,Integer.valueOf(args[2]).intValue());
		System.out.println("Solar Date="+mc.get(Calendar.YEAR)+"/"+(1+mc.get(Calendar.MONTH))+"/"+mc.get(DAY_OF_MONTH));
		System.out.println("Lunar Date="+mc.lunarYear+","+mc.lunarMonth+","+mc.lunarDay);
		System.out.println("Lunar Date String="+mc.chineseDateString);
		System.out.println("Lunar Date in Chinese="+mc.chineseYearName+"年"+mc.chineseMonthName+"月"+mc.chineseDayName+"日"+mc.chineseHourName+"時");
		System.out.println("isLunarLeapMonth="+mc.isLunarLeapMonth);
		System.out.println("leapMonth="+mc.lunarLeapMonth);
		System.out.println("isHoliday="+mc.isHoliday);
		System.out.println("solarTermInfo="+mc.solarTermInfo); 
		System.out.println("AnimalOfYear="+mc.animalOfYear);
		System.out.println("Lunar Festival="+mc.lunarFestival);
		System.out.println("My Festival="+mc.myFestival);
				
		mc=null;
	}

}
