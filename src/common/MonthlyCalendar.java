package common;

import java.util.Hashtable;
/**
 * 
 * 西曆月曆物件<br> 	
 * 
 * 用戶透過讀取屬性來得知相關資訊<br>
 * 參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)<br>
 * http://sean.o4u.com/2008/04/dhtml.html
 *
 * @author Roy Tsang
 */
public class MonthlyCalendar 
{
	/**
	 * 該月的日數
	 */
	public int length;
	/**
	 * 該月1日是星期幾
	 */
	public int firstWeekDay;
	private Hashtable<Integer,MyCalendar> monthlyCalendar; 
	/**
	 * 西曆月曆物件
	 * @param monthlyCalendar
	 */
	protected MonthlyCalendar()
	{
		
	}
	protected void setMonthlyCalendar(Hashtable<Integer,MyCalendar> monthlyCalendar)
	{
		this.monthlyCalendar=monthlyCalendar;
	}
	/**
	 * 傳回整個月的 MyCalendar物件
	 * @return 整個月的 MyCalendar物件
	 */
	public Hashtable<Integer,MyCalendar> getMonthlyCalendar()
	{
		return monthlyCalendar;
	}	
}
