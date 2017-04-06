# LunarCalendar

This LunarCalendar object which extends GregorianCalendar object, user can get the following lunar information by reading related attributes:
<table>
<tr><td>Attribute</td><td>Meaning</td></tr>
<tr><td>animalOfYear</td><td>The animal Of the year in Chinese</td></tr>
<tr><td>chineseDateString</td><td>The lunar date in Chinese</td></tr>
<tr><td>chineseDayName</td><td>"Day Pillar" in Chinese</td></tr>
<tr><td>chineseHourName</td><td>"Hour Pillar" in Chinese</td></tr>
<tr><td>chineseMonthName</td><td>"Month Pillar in Chinese</td></tr>
<tr><td>chineseYearName</td><td>"Year Pillar" in Chinese</td></tr>
<tr><td>isHoliday</td><td>is the specified date holiday?</td></tr>
<tr><td>isLunarLeapMonth</td><td>is the specified month Lunar Leap Month?</td></tr>
<tr><td>lunarDay</td><td>The lunar day of the specified date in Chinese.</td></tr>
<tr><td>lunarFestival</td><td>It return the lunar festival info</td></tr>
<tr><td>lunarLeapMonth</td><td>It return the lunar Leap Month of the specified year</td></tr>
<tr><td>lunarMonth</td><td>The lunar month of the specified date in Chinese.</td></tr>
<tr><td>lunarYear</td><td>The lunar year of the specified date in Chinese.</td></tr>
<tr><td>solarTermInfo</td><td>Solar Term Info</td></tr>
</table>
The class is inspired by Sean Lin DHTML web page:

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

The QQCalendar class demonstrate how to use the checkFestival() method to define the date of holidays/festival(* mean that day is holiday).

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

Calendar:

這是一個由西曆(java 來說即是GregorianCalendar)擴展出來物件, 用家只需要new 一個MyCalendar物件便可以透過以下的屬性得知相關資訊:
<table>
<tr><td>屬性</td><td>意思</td></tr>
<tr><td>animalOfYear</td><td>該年生肖</td></tr>
<tr><td>chineseDateString</td><td>當天農曆日子(用四柱來表示)</td></tr>
<tr><td>chineseDayName</td><td>當天日柱</td></tr>
<tr><td>chineseHourName</td><td>當天時柱</td></tr>
<tr><td>chineseMonthName</td><td>當天月柱</td></tr>
<tr><td>chineseYearName</td><td>當天年柱</td></tr>
<tr><td>isHoliday</td><td>當天是假期嗎?</td></tr>
<tr><td>isLunarLeapMonth</td><td>本月是閏月嗎?</td></tr>
<tr><td>lunarDay</td><td>當天農曆日子(用數字來表示)</td></tr>
<tr><td>lunarFestival</td><td>該天農曆節日訊息</td></tr>
<tr><td>lunarLeapMonth</td><td>該年的閏月是那一個月</td></tr>
<tr><td>lunarMonth</td><td>當天農曆月份(用數字來表示)</td></tr>
<tr><td>lunarYear</td><td>當天農曆年份(用數字來表示)</td></tr>
<tr><td>solarTermInfo</td><td>節氣訊息</td></tr>
</table>
QQCalendar:

這是示範如何extend MyCalendar 物件和implements 自己的 checkFestival method來設定假期
