<%@ page trimDirectiveWhitespaces="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.*"%>
<%@ page import="java.time.format.*"%>
<%@ page import="java.util.*"%>
<%@ page import="common.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar</title>
</head>
<body>
<%! 
	public void showWeekDay(LunarDateObjectFactory myCalendarUtility,MyDateTime myDate,JspWriter out) throws Exception
	{
		if (myDate==null)
			out.println("<td></td>");
		else
		{	
			if ((myDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))||(myDate.isPublicHoliday()))
				out.println("<td style=\"width:160px;height:100px;color:red;font-weight:bold;vertical-align:top\">"+getHTML(myCalendarUtility,myDate)+"</td>");
			else	
				out.println("<td style=\"width:160px;height:100px;vertical-align:top\">"+getHTML(myCalendarUtility,myDate)+"</td>");
		}
	}
	public String getHTML(LunarDateObjectFactory myCalendarUtility,MyDateTime myDate)
	{
		String result=new String(),chineseDayNum; 
		result ="<div style=\"display:flex;flex-direction:column;justify-content:space-between;height:100%\">";
		result+="	<div style=\"display:flex;flex-direction:row;justify-content:space-between\">";
		result+="		<div>"+myDate.getDayOfMonth()+"</div>";
		if (myDate.getSolarTermInfo().equals(""))
		{
			chineseDayNum=myCalendarUtility.numToChineseNum(myDate.getLunarDate());
			if (myDate.getLunarDate()<10)
				chineseDayNum="初"+chineseDayNum;
		}
		else
		{
			chineseDayNum=myDate.getSolarTermInfo();
		}
		result+="		<div style=\"writing-mode:vertical-lr;\">"+chineseDayNum+"</div>";
		result+="	</div>";
		result+="	<div style=\"text-align:center;\">";
		result+="		"+myDate.getFestivalInfo();
		result+="	</div>";
		result+="</div>";
		return result;
	}
%>
<%		
int thisMonth,thisYear;
LocalDate now=LocalDate.now();
Locale locale = request.getLocale(); 
try
{
	thisYear=Integer.parseInt(request.getParameter("year"));
	thisMonth=Integer.parseInt(request.getParameter("month"));
}
catch  (NumberFormatException nfe)
{
	thisYear=now.getYear();
	thisMonth=now.getMonthValue();
}
%>
<table border=1>
	<thead>
		<form method="post">
		<tr>
			<td style="text-align: center;" colSpan="7">
					<select name="year" onchange="this.form.submit();">
<%					for (int i=1900;i<2100;i++)
					{
						out.println("<option value=\""+i+"\""+((i==thisYear)?" selected":"")+">"+i+"</option>");
					}%>						
					</select>
					/
					<select name="month" onchange="this.form.submit();">
<%						for (Month c : Month.values())
						{  
							out.println("<option value=\""+c.getValue()+"\""+((c.getValue()==thisMonth)?" selected":"")+">"+c.getDisplayName(TextStyle.FULL, locale)+"</option>");
						}%>
					</select>
			</td>	
		</tr>
		</form>
	</thead>
	<tbody>
		<tr>
<%  int i;
	LunarDateObjectFactory myCalendarUtility=new LunarDateObjectFactory();
	MonthlyCalendar mc=myCalendarUtility.getMonthlyCalendar(thisYear, thisMonth);
	Hashtable <Integer,MyDateTime>dateList=mc.getMonthlyCalendar();
	ArrayList<DayOfWeek> myDayOfWeekList=new ArrayList<DayOfWeek>();
	myDayOfWeekList.add(DayOfWeek.SUNDAY);
	myDayOfWeekList.add(DayOfWeek.MONDAY);
	myDayOfWeekList.add(DayOfWeek.TUESDAY);
	myDayOfWeekList.add(DayOfWeek.WEDNESDAY);
	myDayOfWeekList.add(DayOfWeek.THURSDAY);
	myDayOfWeekList.add(DayOfWeek.FRIDAY);
	myDayOfWeekList.add(DayOfWeek.SATURDAY);
	for (DayOfWeek dow:myDayOfWeekList)
	{	
		if (dow.equals(DayOfWeek.SUNDAY))
			out.println("<td style=\"text-align: center;color:red;font-weight:bold\">"+dow.getDisplayName(TextStyle.SHORT, locale)+"</td>");
		else	
			out.println("<td style=\"text-align: center;\">"+dow.getDisplayName(TextStyle.SHORT, locale)+"</td>");
	}	
%>		
		</tr>
		<tr>
<%	int date=1;
	boolean monthStarted=false;
	for (DayOfWeek dow:myDayOfWeekList)
	{
		if (dow.equals(mc.firstWeekDay))
			monthStarted=true;
		if (monthStarted)
		{
			showWeekDay(myCalendarUtility,dateList.get(date++),out);
		}
		else
		{
			showWeekDay(myCalendarUtility,null, out);
		}
	}
%>	
		</tr>
<% 
	while (date<dateList.size())
	{%>
		<tr>
<%			
			for (DayOfWeek dow:myDayOfWeekList)
			{
				showWeekDay(myCalendarUtility,dateList.get(date++),out);
			}
%>		
		</tr>	
<%	}%>		
	</tbody>
</table>
</body>
</html>