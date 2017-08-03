package common;
/**
 * 
 * 農曆日曆物件<br> 	
 *
 * 用戶透過讀取屬性來得知相關資訊<br>
 * 本程式參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)<br>
 * http://sean.o4u.com/2008/04/dhtml.html
 *
 * @author Roy Tsang
 */
public class LunarCalendar 
{
	/**
	 *當天農曆年份(用數字來表示)
	 */ 	
	public int year;
	/**
	 *當天農曆月份(用數字來表示)
	 */ 	
	public int month;
	/**
	 *當天農曆日子(用數字來表示)
	 */ 	
	public int date;
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
	 *當時時柱
	 */
	public String chineseHourName=new String();
	/**
	 該年生肖
	 */
	public String animalOfYear=new String();
	/**
	 當天節氣訊息
	 */
	public String solarTermInfo=new String();
	/**
	 * 農曆日曆物件
	 */
	public LunarCalendar()
	{
		
	}
}
