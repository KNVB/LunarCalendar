# LunarCalendar
This is MyCalendar object which extends GregorianCalendar object,
user can get lunar information by reading related attributes.

由於本程式是參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)
http://sean.o4u.com/2008/04/dhtml.html,

所以如果想引用和修改本程式,請以下參考Sean Lin (林洵賢)先生的聲明:

如果您覺得這個程式不錯，您可以自由轉寄給親朋好友分享。自由使
用範圍: 學校、學會、公會、公司內部、程式研究、個人網站供人查
詢使用。

Open Source 不代表放棄著作權，任何形式之引用或轉載前請來信告
知。如需於「商業或營利」目的中使用此部份之程式碼或資料，需取
得本人書面授權。

最新版本與更新資訊於 http://sean.o4u.com/ap/calendar/ 公佈


　                            歡迎來信互相討論研究與指正誤謬
                      連絡方式：http://sean.o4u.com/contact/
                      　　　　　　　　　　Sean Lin (林洵賢)
                          尊重他人創作‧請勿刪除或變更此說明

Sean Lin (林洵賢)先生的email address是sean.tw+blog@gmail.com.

LunarCalendar:
這是一個由西曆(java 來說即是GregorianCalendar)擴展出來物件,
用家只需要new 一個MyCalendar物件便可以透過以下的屬性得知相關資訊:
animalOfYear      該年生肖
chineseDateString 當天農曆日子(用四柱來表示)
chineseDayName    當天日柱
chineseHourName   當天時柱
chineseMonthName  當天月柱
chineseYearName   當天年柱
isHoliday         當天是假期嗎?
isLunarLeapMonth  本月是閏月嗎?
lunarDay          當天農曆日子(用數字來表示)
lunarFestival     該天農曆節日訊息
lunarLeapMonth    該年的閏月是那一個月
lunarMonth        當天農曆月份(用數字來表示)
lunarYear         當天農曆年份(用數字來表示)
solarTermInfo     節氣訊息 

QQCalendar:
This class demonstrate how to use checkFestival method to check whether the date is a holiday.
這是示範如何extend MyCalendar 物件和implements 自己的
checkFestival method來設定假期
