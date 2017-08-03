package common;
/**
 * 
 * MyCalendar 日期物件<br> 	
 * 
 * 用戶透過讀取屬性來得知相關資訊<br>
 * 參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)<br>
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
	public String getFestivalInfo() 
	{
		return festivalInfo;
	}
	public void setFestivalInfo(String festivalInfo) 
	{
		this.festivalInfo = festivalInfo;
	}
	public String getChineseYearName() 
	{
		return lunarCalendar.chineseYearName;
	}
	public String getChineseMonthName() 
	{
		return lunarCalendar.chineseMonthName;
	}
	
	public String getChineseDayName() 
	{
		return lunarCalendar.chineseDayName;
	}
	public String getChineseHourName() 
	{
		return lunarCalendar.chineseHourName;
	}
	public String getAnimalOfYear() 
	{
		return lunarCalendar.animalOfYear;
	}
	
	public String getSolarTermInfo() 
	{
		return lunarCalendar.solarTermInfo;
	}
	
	public MyCalendar(LunarCalendar lc)
	{
		lunarCalendar=lc;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}
	public boolean isPublicHoliday() {
		return isPublicHoliday;
	}
	public void setPublicHoliday(boolean isPublicHoliday) {
		this.isPublicHoliday = isPublicHoliday;
	}
	public int getLunarYear()
	{
		return lunarCalendar.year;
	}
	public int getLunarMonth()
	{
		return lunarCalendar.month;
	}
	public int getLunarDate()
	{
		return lunarCalendar.date;
	}
	public boolean isLeap()
	{
		return lunarCalendar.isLeap;
	}
}
