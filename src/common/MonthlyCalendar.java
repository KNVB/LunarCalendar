package common;

import java.time.DayOfWeek;
import java.util.Hashtable;
/**
 * 
 * 西曆月曆物件<br> 	
 * 
 * 參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)<br>
 * http://sean.o4u.com/2008/04/dhtml.html<br><br>
 *
 * The program is inspired by Sean Lin DHTML web page:<br>
 * http://sean.o4u.com/2008/04/dhtml.html
 *
 * @author Roy Tsang
 */
public class MonthlyCalendar 
{
	/**
	 * 該月的日數<br>
	 * The total number of day of the specified month.
	 */
	public int length;
	/**
	 * 該月1日是星期幾<br>
	 * The day of 1st of the specified month.
	 */
	public DayOfWeek firstWeekDay;
	private Hashtable<Integer,MyDate> monthlyCalendar; 
	/**
	 * 西曆月曆物件
	 * @param monthlyCalendar
	 */
	protected MonthlyCalendar()
	{
		
	}
	protected void setMonthlyCalendar(Hashtable<Integer,MyDate> monthlyCalendar)
	{
		this.monthlyCalendar=monthlyCalendar;
	}
	/**
	 * 傳回整個月的 MyLocalDate物件<br>
	 * It return a list of MyLocalDate object for specified month  
	 * @return 整個月的 MyLocalDate物件<br>
	 * A list of MyLocalDate object for specified month
	 */
	public Hashtable<Integer,MyDate> getMonthlyCalendar()
	{
		return monthlyCalendar;
	}	
}
