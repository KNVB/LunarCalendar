package common;

import java.util.Hashtable;

public class MonthlyCalendar 
{
	Hashtable<Integer,MyCalendar> monthlyCalendar=new Hashtable<Integer,MyCalendar>(); 
	public int length,firstWeekDay;
	public Hashtable<Integer,MyCalendar> getMonthlyCalendar()
	{
		return monthlyCalendar;
	}
	public void addMyCalendar(int i,MyCalendar mc)
	{
		monthlyCalendar.put(i, mc);
	}
}
