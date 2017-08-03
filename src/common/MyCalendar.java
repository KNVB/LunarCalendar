package common;
/**
 * 
 * MyCalendar 日期物件<br> 	
 * 
 * 用戶透過讀取屬性來得知相關資訊<br>
 * 本程式參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)<br>
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
	 * 傳回當日的節日/假期資訊
	 * @return 當日的節日/假期資訊
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
	 * 傳回當天年柱
	 * @return 當天年柱  
	 */
	public String getChineseYearName() 
	{
		return lunarCalendar.chineseYearName;
	}
	/** 
	 * 傳回當天年柱
	 * @return 當天月柱  
	 */
	public String getChineseMonthName() 
	{
		return lunarCalendar.chineseMonthName;
	}
	/**
	 *傳回當天日柱
	 *@return 當天日柱
	 */
	public String getChineseDayName() 
	{
		return lunarCalendar.chineseDayName;
	}
	/**
	 *傳回當時時柱
	 *@return 當時時柱
	 */
	public String getChineseHourName() 
	{
		return lunarCalendar.chineseHourName;
	}
	/**
	 * 傳回該年生肖
	 * @return 該年生肖
	 */
	public String getAnimalOfYear() 
	{
		return lunarCalendar.animalOfYear;
	}
	/**
	 * 傳回當天節氣訊息
	 * @return 當天節氣訊息 
	 */
	public String getSolarTermInfo() 
	{
		return lunarCalendar.solarTermInfo;
	}
	
	
	/**
	 * 傳回當天西曆年份
	 * @return 當天西曆年份
	 */
	public int getYear() {
		return year;
	}
	protected void setYear(int year) {
		this.year = year;
	}
	/**
	 * 傳回當天西曆月份
	 * @return 當天西曆月份
	 */
	public int getMonth() {
		return month;
	}
	protected void setMonth(int month) {
		this.month = month;
	}
	/**
	 * 傳回當天西曆日子
	 * @return 當天西曆日子
	 */
	public int getDate() {
		return date;
	}
	protected void setDate(int date) {
		this.date = date;
	}
	/**
	 * 傳回當天星期幾
	 * @return 當天星期幾
	 */
	public int getWeekDay() {
		return weekDay;
	}
	protected void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}
	/**
	 * 傳回當天是否為公眾假期
	 * @return 當天是否為公眾假期
	 */
	public boolean isPublicHoliday() {
		return isPublicHoliday;
	}
	protected void setPublicHoliday(boolean isPublicHoliday) {
		this.isPublicHoliday = isPublicHoliday;
	}
	/**
	 * 傳回當天農曆年份(用數字來表示)
	 * @return 當天農曆年份(用數字來表示)
	 */
	public int getLunarYear()
	{
		return lunarCalendar.year;
	}
	/**
	 * 傳回當天農曆月份(用數字來表示)
	 * @return 當天農曆月份(用數字來表示)
	 */
	public int getLunarMonth()
	{
		return lunarCalendar.month;
	}
	/**
	 * 傳回當天農曆日子(用數字來表示)
	 * @return 當天農曆日子(用數字來表示)
	 */
	public int getLunarDate()
	{
		return lunarCalendar.date;
	}
	/**
	 * 傳回當天是否為閏月
	 * @return 當天是否為閏月 
	 */
	public boolean isLeap()
	{
		return lunarCalendar.isLeap;
	}
}
