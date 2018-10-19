package common;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * 
 * MyLocalDate 日期物件<br> 	
 * 
 * 本程式參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)<br>
 * http://sean.o4u.com/2008/04/dhtml.html<br><br>
 *
 * The program is inspired by Sean Lin DHTML web page:<br>
 * http://sean.o4u.com/2008/04/dhtml.html
 *
 * @author Roy Tsang
 */
public class MyDateTime 
{
	private boolean isPublicHoliday=false;
	private String festivalInfo=new String();
	private LunarDateTime lunarDateTime;
	private LocalDateTime solarDateTime;
	
	protected MyDateTime(LocalDateTime sc, LunarDateTime lc)
	{
		lunarDateTime=lc;
		solarDateTime=sc;
	}
	/**
	 * 傳回當日的節日/假期資訊<br>
	 * It returns the festival/holiday information the specified date
	 * @return 當日的節日/假期資訊<br>
	 * The festival/holiday information the specified date.
	 */
	public String getFestivalInfo() 
	{
		return festivalInfo;
	}
	protected void setFestivalInfo(String festivalInfo) 
	{
		this.festivalInfo = festivalInfo;
	}
	/** 
	 * 傳回當天年柱<br>
	 * It returns the "Year Pillar" in Chinese of the specified date
	 * @return 當天年柱 <br>
	 * The "Year Pillar" in Chinese of the specified date 
	 */
	public String getYearPillar() 
	{
		return lunarDateTime.yearPillar;
	}
	/** 
	 * 傳回當天月柱<br>
	 * It returns the "Month Pillar" in Chinese of the specified date
	 * @return 當天月柱<br>
	 * The "Month Pillar" in Chinese of the specified date   
	 */
	public String getMonthPillar() 
	{
		return lunarDateTime.monthPillar;
	}
	/**
	 *傳回當天日柱<br>
	 *It returns the "Day Pillar" in Chinese of the specified date
	 *@return 當天日柱<br>
	 * The "Day Pillar" in Chinese of the specified date
	 */
	public String getDatePillar() 
	{
		return lunarDateTime.datePillar;
	}
	/**
	 *傳回當時時柱<br>
	 *It returns the "Hour Pillar" in Chinese of the specified hour
	 *@return 當時時柱<br>
	 *The "Day Pillar" in Chinese of the specified hour
	 */
	public String getHourPillar() 
	{
		return lunarDateTime.hourPillar;
	}
	/**
	 * 傳回該年生肖<br>
	 * It returns the animal Of the year in Chinese of the specified date
	 * @return 該年生肖<br>
	 * The animal Of the year in Chinese of the specified date.
	 */
	public String getAnimalOfYear() 
	{
		return lunarDateTime.animalOfYear;
	}
	/**
	 * 傳回當天節氣訊息<br>
	 * It returns the Solar Term Info of the specified date
	 * @return 當天節氣訊息<br>
	 * Solar Term Info of the specified date 
	 */
	public String getSolarTermInfo() 
	{
		return lunarDateTime.solarTermInfo;
	}
	
	
	/**
	 * 傳回當天西曆年份<br>
	 * It returns the year of the specified date
	 * @return 當天西曆年份<br>
	 * The year of the specified date
	 */
	public int getYear() 
	{
		return solarDateTime.getYear();
	}	
	/**
	 * 傳回當天西曆月份<br>
	 * It returns the month of the specified date
	 * @return 當天西曆月份<br>
	 * The month of the specified date
	 */
	public int getMonth() 
	{
		return solarDateTime.getMonthValue();
	}

	/**
	 * 傳回當天西曆日子<br>
	 * It returns the date of month of the specified date
	 * @return 當天西曆日子<br>
	 * The date of month of the specified date
	 */
	public int getDayOfMonth() 
	{
		return solarDateTime.getDayOfMonth();
	}
	
	/**
	 * 傳回當天星期幾<br>
	 * It returns the day of week of the specified date.
	 * @return 當天星期幾<br>
	 * The day of week of the specified date.
	 */
	public DayOfWeek getDayOfWeek() 
	{
		return solarDateTime.getDayOfWeek();
	}
	
	/**
	 * 傳回當天是否為公眾假期<br>
	 * It check if public holiday of the specified date.
	 * @return 當天是否為公眾假期<br>
	 * is public holiday of the specified date?
	 */
	public boolean isPublicHoliday() {
		return isPublicHoliday;
	}
	protected void setPublicHoliday(boolean isPublicHoliday) {
		this.isPublicHoliday = isPublicHoliday;
	}
	/**
	 * 傳回當天農曆年份(用數字來表示)<Br>
	 * It returns the lunar year of the specified date in number format.
	 * @return 當天農曆年份(用數字來表示)<br>
	 * The lunar year of the specified date in number format.
	 */
	public int getLunarYear()
	{
		return lunarDateTime.year;
	}
	/**
	 * 傳回當天農曆月份(用數字來表示)<br>
	 * It returns the lunar month of the specified date in number format.
	 * @return 當天農曆月份(用數字來表示)<br>
	 * The lunar month of the specified date in number format.
	 */
	public int getLunarMonth()
	{
		return lunarDateTime.month;
	}
	/**
	 * 傳回當天農曆日子(用數字來表示)<br>
	 * It returns the lunar date of the specified date in number format.
	 * @return 當天農曆日子(用數字來表示)<br>
	 * The lunar date of the specified date in number format.
	 */
	public int getLunarDate()
	{
		return lunarDateTime.date;
	}
	/**
	 * 傳回當天是否為閏月<br>
	 * It returns whether is a Lunar Leap Month of the specified month?
	 * @return 當天是否為閏月<br> 
	 * is the specified month Lunar Leap Month?
	 */
	public boolean isLeap()
	{
		return lunarDateTime.isLeap;
	}
}
