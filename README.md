# LunarCalendar Utility
It is a tool for generate solar information , lunar information, festival and holiday information and related information for a given date.<br>
The program is inspired by Sean Lin DHTML web page:

<a href="http://sean.o4u.com/2008/04/dhtml.html">http://sean.o4u.com/2008/04/dhtml.html</a>


本工具程式可以計算出某天的西曆,農曆,節日/假期和相關資訊<br>
本程式是參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)<br> 

<a href="http://sean.o4u.com/2008/04/dhtml.html">http://sean.o4u.com/2008/04/dhtml.html</a><br><br>

## Disclaimer

Here is the disclaimer from Sean:

If you think this program is good, you can freely forwarded to friends and family to share. The scope of free to use including: school, society, guild, company, program research, personal website.

Open Source does not mean any abandon of copyright , a written notification should be provided before any form of reference or forwarded.

My written authorization is required before any coding or information used for business or profit purposes.

The latest version and update information is published at http://sean.o4u.com/ap/calendar/

                            Welcome letter to discuss the study and correct misunderstanding
                            Contact: http://sean.o4u.com/contact/
                            Sean Lin (Lin Xunxian)
                            Respect for others creation‧ Do not delete or change this description
                            Mr. Sean Lin (Lin Xunxian) email address is sean.tw+blog@gmail.com.
                            

如果想引用和修改本程式,請參考以下Sean Lin (林洵賢)先生的聲明:

如果您覺得這個程式不錯，您可以自由轉寄給親朋好友分享。自由使 用範圍: 學校、學會、公會、公司內部、程式研究、個人網站供人查 詢使用。

Open Source 不代表放棄著作權，任何形式之引用或轉載前請來信告 知。如需於「商業或營利」目的中使用此部份之程式碼或資料，需取 得本人書面授權。

最新版本與更新資訊於 http://sean.o4u.com/ap/calendar/ 公佈

                            歡迎來信互相討論研究與指正誤謬
                            連絡方式：http://sean.o4u.com/contact/
                            Sean Lin (林洵賢)
                            尊重他人創作‧請勿刪除或變更此說明
                            Sean Lin (林洵賢)先生的email address是sean.tw+blog@gmail.com.

## Usage
There are 3 methods MyCalendarUtility class provided :
<ol>
	<li>
		getHolidayList:<br>
		It returns a list of holiday for the given year.
	</li><br>	
	<li>
		getLunarDate:<br> 
		It return a corresponding LunarDate object when a LocalDateTime object is given.<br>
		The detail information about LunarDate object are provided in JavaDoc. 
	</li><br>
	<li> 
		getMonthlyCalendar:<br>	
		It return a MonthlyCalendar object when a year and month parameter is provided.<br>
		The detail information about MonthlyCalendar and MyCalendar object are provided in JavaDoc.<br>
		It is useful for Monthly Calendar generation.
	</li>	
</ol>
Users can extend MyCalendarUtility.prepareHolidayList method to customize the holiday handling.

The Testing Class is for the holiday handling customization demonstration.
<br><br><br><br>
MyCalendarUtility 有三個重要的method
<ol>
	<li>
		getHolidayList:<br>
		 傳回該年的假期清單。
	</li><br>
	<li>
		getLunarDate:<br>
		傳入單一西曆日子(即是 LocalDateTime),傳回LunarDate物件,有關LunarDate物件的詳細資料請參考JavaDoc。
	</li><br>
	<li>
		getMonthlyCalendar:<br>
		傳入年份月份,傳回對應的MonthlyCalendar物件,在這個物件內可以獲取整個月的MyCalendar物件,關於MyCalendar物件的詳細資料請參考JavaDoc。<br>
		這個method對編制月曆很有用。
	</li>
</ol>	
用戶可以extend MyCalendarUtility.prepareHolidayList 的method來自訂假日處理。

Testing 就用示範如何自訂假日處理。	
