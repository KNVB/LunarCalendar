# Lunar Calendar Utility

The program is inspired by Sean Lin DHTML web page:

http://sean.o4u.com/2008/04/dhtml.html

Here is the disclaimer from Sean:

If you think this program is good, you can freely forwarded to friends and family to share. Free to make Scope: school, society, guild, company, program research, personal website for people to use it.

Open Source does not mean any abandon of copyright , a written notification should be provided before any form of reference or forwarded.

My written authorization is required before the code or information used in this section for "business or profit" purposes.

The latest version and update information is published at http://sean.o4u.com/ap/calendar/

                            Welcome letter to discuss the study and correct misunderstanding
                            Contact: http://sean.o4u.com/contact/
                            Sean Lin (Lin Xunxian)
                            Respect for others creation‧ Do not delete or change this description
Sean Lin (Lin Xunxian) Mr. email address is sean.tw+blog@gmail.com.

由於本程式是參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100) http://sean.o4u.com/2008/04/dhtml.html,
所以如果想引用和修改本程式,請以下參考Sean Lin (林洵賢)先生的聲明:

如果您覺得這個程式不錯，您可以自由轉寄給親朋好友分享。自由使 用範圍: 學校、學會、公會、公司內部、程式研究、個人網站供人查 詢使用。

Open Source 不代表放棄著作權，任何形式之引用或轉載前請來信告 知。如需於「商業或營利」目的中使用此部份之程式碼或資料，需取 得本人書面授權。

最新版本與更新資訊於 http://sean.o4u.com/ap/calendar/ 公佈

                            歡迎來信互相討論研究與指正誤謬
                            連絡方式：http://sean.o4u.com/contact/
                            Sean Lin (林洵賢)
                            尊重他人創作‧請勿刪除或變更此說明
Sean Lin (林洵賢)先生的email address是sean.tw+blog@gmail.com.

#Usage
The CalendarUtility class provide 2 method:

1. getLunarCalendar: It require a GregorianCalendar object as a input parameter;it return a corresponding LunarCalendar object and this object provide the following information.

	<table>
	<tr><td>Attribute</td><td>Meaning</td></tr>
	<tr><td>animalOfYear</td><td>The animal Of the year in Chinese</td></tr>
	<tr><td>chineseDateString</td><td>The lunar date in Chinese</td></tr>
	<tr><td>chineseDayName</td><td>"Day Pillar" in Chinese</td></tr>
	<tr><td>chineseHourName</td><td>"Hour Pillar" in Chinese</td></tr>
	<tr><td>chineseMonthName</td><td>"Month Pillar in Chinese</td></tr>
	<tr><td>chineseYearName</td><td>"Year Pillar" in Chinese</td></tr>
	<tr><td>isLeap</td><td>is the specified month Lunar Leap Month?</td></tr>
	<tr><td>date</td><td>The lunar day of the specified date in Chinese.</td></tr>
	<tr><td>month</td><td>The lunar month of the specified date.</td></tr>
	<tr><td>year</td><td>The lunar year of the specified date.</td></tr>
	<tr><td>solarTermInfo</td><td>Solar Term Info</td></tr>
	</table>


