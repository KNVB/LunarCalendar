package common;
/**
 * 
 * MyCalendar 日期物件<br> 	
 * 
 * 本程式參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)<br>
 * http://sean.o4u.com/2008/04/dhtml.html<br><br>
 *
 * The program is inspired by Sean Lin DHTML web page:<br>
 * http://sean.o4u.com/2008/04/dhtml.html
 *
 * @author Roy Tsang
 */
public class MyCalendar 
{
	private int year;
	private int month;
	private int date;
	private int weekDay;
	
	private boolean isPublicHoliday=false;
	private String festivalInfo=new String();
	private LunarCalendar lunarCalendar;
	
	protected MyCalendar(LunarCalendar lc)
	{
		lunarCalendar=lc;
	}
	/**
	 * 傳回當日的節日/假期資訊<br>
	 * It return the festival information the specified date
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
	 * It return the "Year Pillar" in Chinese of the specified date
	 * @return 當天年柱 <br>
	 * The "Year Pillar" in Chinese of the specified date 
	 */
	public String getChineseYearName() 
	{
		return lunarCalendar.chineseYearName;
	}
	/** 
	 * 傳回當天月柱<br>
	 * It return the "Month Pillar" in Chinese of the specified date
	 * @return 當天月柱<br>
	 * The "Month Pillar" in Chinese of the specified date   
	 */
	public String getChineseMonthName() 
	{
		return lunarCalendar.chineseMonthName;
	}
	/**
	 *傳回當天日柱<br>
	 *It return the "Day Pillar" in Chinese of the specified date
	 *@return 當天日柱<br>
	 * The "Day Pillar" in Chinese of the specified date
	 */
	public String getChineseDayName() 
	{
		return lunarCalendar.chineseDayName;
	}
	/**
	 *傳回當時時柱<br>
	 *It return the "Hour Pillar" in Chinese of the specified hour
	 *@return 當時時柱<br>
	 *The "Day Pillar" in Chinese of the specified hour
	 */
	public String getChineseHourName() 
	{
		return lunarCalendar.chineseHourName;
	}
	/**
	 * 傳回該年生肖<br>
	 * It return the animal Of the year in Chinese of the specified date
	 * @return 該年生肖<br>
	 * The animal Of the year in Chinese of the specified date.
	 */
	public String getAnimalOfYear() 
	{
		return lunarCalendar.animalOfYear;
	}
	/**
	 * 傳回當天節氣訊息<br>
	 * It return the Solar Term Info of the specified date
	 * @return 當天節氣訊息<br>
	 * Solar Term Info of the specified date 
	 */
	public String getSolarTermInfo() 
	{
		return lunarCalendar.solarTermInfo;
	}
	
	
	/**
	 * 傳回當天西曆年份<br>
	 * It return the year of the specified date
	 * @return 當天西曆年份<br>
	 * The year of the specified date
	 */
	public int getYear() {
		return year;
	}
	protected void setYear(int year) {
		this.year = year;
	}
	/**
	 * 傳回當天西曆月份<br>
	 * It return the month of the specified date
	 * @return 當天西曆月份<br>
	 * The month of the specified date
	 */
	public int getMonth() {
		return month;
	}
	protected void setMonth(int month) {
		this.month = month;
	}
	/**
	 * 傳回當天西曆日子<br>
	 * It return the date of the specified date
	 * @return 當天西曆日子<br>
	 * The date of the specified date
	 */
	public int getDate() {
		return date;
	}
	protected void setDate(int date) {
		this.date = date;
	}
	/**
	 * 傳回當天星期幾<br>
	 * It return the day of the specified date.
	 * @return 當天星期幾<br>
	 * The day of the specified date.
	 */
	public int getWeekDay() {
		return weekDay;
	}
	protected void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
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
	 * It return the lunar year of the specified date in number format.
	 * @return 當天農曆年份(用數字來表示)<br>
	 * The lunar year of the specified date in number format.
	 */
	public int getLunarYear()
	{
		return lunarCalendar.year;
	}
	/**
	 * 傳回當天農曆月份(用數字來表示)<br>
	 * It return the lunar month of the specified date in number format.
	 * @return 當天農曆月份(用數字來表示)<br>
	 * The lunar month of the specified date in number format.
	 */
	public int getLunarMonth()
	{
		return lunarCalendar.month;
	}
	/**
	 * 傳回當天農曆日子(用數字來表示)<br>
	 * It return the lunar date of the specified date in number format.
	 * @return 當天農曆日子(用數字來表示)<br>
	 * The lunar date of the specified date in number format.
	 */
	public int getLunarDate()
	{
		return lunarCalendar.date;
	}
	/**
	 * 傳回當天是否為閏月<br>
	 * It return whether is a Lunar Leap Month of the specified month?
	 * @return 當天是否為閏月<br> 
	 * is the specified month Lunar Leap Month?
	 */
	public boolean isLeap()
	{
		return lunarCalendar.isLeap;
	}
}
