package com;

import java.time.DayOfWeek;
import java.util.ArrayList;
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
	private MyDate[] dateList; 
	/**
	 * 西曆月曆物件
	 * @param monthlyCalendar
	 */
	protected MonthlyCalendar()
	{
		
	}
	protected void setDateList(ArrayList<MyDate> dateList)
	{
		this.dateList=dateList.toArray(new MyDate[0]);
	}
	/**
	 * 傳回整個月的 MyLocalDate物件<br>
	 * It return a list of MyLocalDate object for specified month  
	 * @return 整個月的 MyLocalDate物件<br>
	 * A list of MyLocalDate object for specified month
	 */
	public MyDate[] getDateList()
	{
		return this.dateList;
	}	
}
