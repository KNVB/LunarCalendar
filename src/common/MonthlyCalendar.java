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
	public int length,firstWeekDay;
	private Hashtable<Integer,MyCalendar> monthlyCalendar; 
	public void setMonthlyCalendar(Hashtable<Integer,MyCalendar> monthlyCalendar)
	{
		this.monthlyCalendar=monthlyCalendar;
	}	
	public Hashtable<Integer,MyCalendar> getMonthlyCalendar()
	{
		return monthlyCalendar;
	}	
}
