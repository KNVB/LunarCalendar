package common;

public class MyCalendar 
{
	private int year;
	private int month;
	private int date;
	private int weekDay;
	
	private boolean isHoliday=false;
	private String holidayInfo=new String();
	private LunarCalendar lunarCalendar;
	public String getHolidayInfo() {
		return holidayInfo;
	}
	public void setHolidayInfo(String holidayInfo) {
		this.holidayInfo = holidayInfo;
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
	public boolean isHoliday() {
		return isHoliday;
	}
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
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
