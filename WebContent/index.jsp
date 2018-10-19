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
<%		
int thisMonth,thisYear,thisDate,thisHour;
LocalDateTime now;
Locale locale = request.getLocale();
LunarDateObjectFactory lunarDateObjectFactory=new LunarDateObjectFactory();
try
{
	thisYear=Integer.parseInt(request.getParameter("year"));
	thisMonth=Integer.parseInt(request.getParameter("month"));
	thisDate=Integer.parseInt(request.getParameter("date"));
	thisHour=Integer.parseInt(request.getParameter("hour"));
	
	now=LocalDateTime.of(thisYear, thisMonth, thisDate, thisHour, 0);
}
catch  (NumberFormatException nfe)
{
	now=LocalDateTime.now();
	thisYear=now.getYear();
	thisMonth=now.getMonthValue();
	thisDate=now.getDayOfMonth();
	thisHour=now.getHour();
}
%>
<table border=1>
	<thead>
		<form method="post">
		<tr>
			<td style="text-align: center;">
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
					/
					<select name="date" onchange="this.form.submit();">
<%					for (int i=1;i<32;i++)
					{
						out.println("<option value=\""+i+"\""+((i==thisDate)?" selected":"")+">"+i+"</option>");
					}%>						
					</select>
					&nbsp;
					<select name="hour" onchange="this.form.submit();">
<%					for (int i=0;i<24;i++)
					{
						out.println("<option value=\""+i+"\""+((i==thisHour)?" selected":"")+">"+i+"</option>");
					}%>					
					</select>
			</td>	
		</tr>
		</form>
	</thead>
	<tbody>
		<tr>
			<td>
				<% 
					LunarDateTime lunarDateTime=lunarDateObjectFactory.getLunarDateTime(now);
					out.println("西曆:"+now.getYear()+"年"+now.getMonthValue()+"月"+now.getDayOfMonth()+"日"+now.getHour()+"時"+now.getMinute()+"分"+now.getSecond()+"秒");
				%>
			</td>
		</tr>
		<tr>
			<td>
			<% 
				out.println("農曆歲次:"+lunarDateTime.yearPillar+"【"+lunarDateTime.animalOfYear+"】年"+((lunarDateTime.isLeap)?"閏":"")+lunarDateObjectFactory.numToChineseNum(lunarDateTime.month)+"月"+lunarDateObjectFactory.numToChineseNum(lunarDateTime.date)+"日"+lunarDateTime.hourPillar+"時<br>");
				out.println(lunarDateTime.yearPillar+"年"+lunarDateTime.monthPillar+"月"+lunarDateTime.datePillar+"日"+lunarDateTime.hourPillar+"時");
			%>
			</td>	
		</tr>
	</tbody>
</table>
</body>
</html>