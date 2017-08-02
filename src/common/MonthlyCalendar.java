package common;

import java.util.Hashtable;

public class MonthlyCalendar 
{
	Hashtable<Integer,MyCalendar> monthlyCalendar; 
	public int length,firstWeekDay;
	public void setMonthlyCalendar(Hashtable<Integer,MyCalendar> monthlyCalendar)
	{
		this.monthlyCalendar=monthlyCalendar;
	}	
	public Hashtable<Integer,MyCalendar> getMonthlyCalendar()
	{
		return monthlyCalendar;
	}	
}
