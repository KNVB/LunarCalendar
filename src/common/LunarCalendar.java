package common;

public class LunarCalendar 
{
	/**
	 *當天農曆年份(用數字來表示)
	 */ 	
	public int lunarYear;
	/**
	 *當天農曆月份(用數字來表示)
	 */ 	
	public int lunarMonth;
	/**
	 *當天農曆日子(用數字來表示)
	 */ 	
	public int lunarDate;
	/**
	 * 是否為閏月
	 */
	public boolean isLeap=false;
	/** 
	 * 當天年柱
	 */
	public String chineseYearName=new String(); 
	/**
	 * 當天月柱
	 */
	public String chineseMonthName=new String();
	/**
	 *當天日柱
	 */
	public String chineseDayName=new String();  
	/**
	 *當天時柱
	 */
	public String chineseHourName=new String();
	/**
	 該年生肖
	 */
	public String animalOfYear=new String();
	/**
	 節氣訊息
	 */
	public String solarTermInfo=new String();   
}
