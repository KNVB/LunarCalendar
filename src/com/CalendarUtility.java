package com;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import com.LunarDate;

/**
 * 
 * 日曆工具物件<br> 	
 *This is Calendar Utility for MonthlyCalendar,LunarDate generation.<br> 
 * 本程式參考自Sean Lin (林洵賢)先生的農曆月曆與世界時間DHTML程式(AD1900至AD2100)<br>
 * http://sean.o4u.com/2008/04/dhtml.html<br><br>
 * 
 * The program is inspired by Sean Lin DHTML web page:<br>
 * http://sean.o4u.com/2008/04/dhtml.html
 *
 * @author Roy Tsang
 */
public class CalendarUtility {
	private int lunarInfo[]={0x4bd8,0x4ae0,0xa570,0x54d5,0xd260,0xd950,0x5554,0x56af,0x9ad0,0x55d2,
			0x4ae0,0xa5b6,0xa4d0,0xd250,0xd295,0xb54f,0xd6a0,0xada2,0x95b0,0x4977,
			0x497f,0xa4b0,0xb4b5,0x6a50,0x6d40,0xab54,0x2b6f,0x9570,0x52f2,0x4970,
			0x6566,0xd4a0,0xea50,0x6a95,0x5adf,0x2b60,0x86e3,0x92ef,0xc8d7,0xc95f,
			0xd4a0,0xd8a6,0xb55f,0x56a0,0xa5b4,0x25df,0x92d0,0xd2b2,0xa950,0xb557,
			0x6ca0,0xb550,0x5355,0x4daf,0xa5b0,0x4573,0x52bf,0xa9a8,0xe950,0x6aa0,
			0xaea6,0xab50,0x4b60,0xaae4,0xa570,0x5260,0xf263,0xd950,0x5b57,0x56a0,
			0x96d0,0x4dd5,0x4ad0,0xa4d0,0xd4d4,0xd250,0xd558,0xb540,0xb6a0,0x95a6,
			0x95bf,0x49b0,0xa974,0xa4b0,0xb27a,0x6a50,0x6d40,0xaf46,0xab60,0x9570,
			0x4af5,0x4970,0x64b0,0x74a3,0xea50,0x6b58,0x5ac0,0xab60,0x96d5,0x92e0,
			0xc960,0xd954,0xd4a0,0xda50,0x7552,0x56a0,0xabb7,0x25d0,0x92d0,0xcab5,
			0xa950,0xb4a0,0xbaa4,0xad50,0x55d9,0x4ba0,0xa5b0,0x5176,0x52bf,0xa930,
			0x7954,0x6aa0,0xad50,0x5b52,0x4b60,0xa6e6,0xa4e0,0xd260,0xea65,0xd530,
			0x5aa0,0x76a3,0x96d0,0x4afb,0x4ad0,0xa4d0,0xd0b6,0xd25f,0xd520,0xdd45,
			0xb5a0,0x56d0,0x55b2,0x49b0,0xa577,0xa4b0,0xaa50,0xb255,0x6d2f,0xada0,
			0x4b63,0x937f,0x49f8,0x4970,0x64b0,0x68a6,0xea5f,0x6b20,0xa6c4,0xaaef,
			0x92e0,0xd2e3,0xc960,0xd557,0xd4a0,0xda50,0x5d55,0x56a0,0xa6d0,0x55d4,
			0x52d0,0xa9b8,0xa950,0xb4a0,0xb6a6,0xad50,0x55a0,0xaba4,0xa5b0,0x52b0,
			0xb273,0x6930,0x7337,0x6aa0,0xad50,0x4b55,0x4b6f,0xa570,0x54e4,0xd260,
			0xe968,0xd520,0xdaa0,0x6aa6,0x56df,0x4ae0,0xa9d4,0xa4d0,0xd150,0xf252,
			0xd520};
	private String nStr1[] = {"日","一","二","三","四","五","六","七","八","九","十"};
	private String nStr2[] = {"初","十","廿","卅","卌"};
	private String Zhi[]={"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
	
	private String solarTerm[] ={"小寒","大寒","立春","雨水","驚蟄","春分","清明","穀雨","立夏","小滿","芒種","夏至","小暑","大暑","立秋","處暑","白露","秋分","寒露","霜降","立冬","小雪","大雪","冬至"};
	public Hashtable <String,String>lunarHolidayList=new Hashtable<String,String>();
	public Hashtable <String,String>solarHolidayList=new Hashtable<String,String>();
	public Hashtable<DayOfWeek,String>weekDayNames=new Hashtable<DayOfWeek,String>();
	/**
	 * 日曆工具物件<br>
	 * 支援年份(由AD1900至AD2100)<br><br>
	 * Calendar Utility<br>
	 * It support from AD1900 to AD2100
	 */
	public CalendarUtility() {
		lunarHolidayList.put("0101","大年初一");
		lunarHolidayList.put("0102","年初二");
		lunarHolidayList.put("0103","年初三");
		lunarHolidayList.put("0408","佛誕");
		lunarHolidayList.put("0505","端午節");
		lunarHolidayList.put("0816","中秋節翌日");
		lunarHolidayList.put("0909","重陽節");

		solarHolidayList.put("0101","新曆新年");
		solarHolidayList.put("0501","勞動節");
		solarHolidayList.put("0701","香港特別行政區成立紀念日");
		solarHolidayList.put("1001","國慶日");
		solarHolidayList.put("1225","聖誕節");
		solarHolidayList.put("1226","聖誕節翌日");
		
		weekDayNames.put(DayOfWeek.SUNDAY,"Su");
		weekDayNames.put(DayOfWeek.MONDAY,"M");
		weekDayNames.put(DayOfWeek.TUESDAY,"T");
		weekDayNames.put(DayOfWeek.WEDNESDAY,"W");
		weekDayNames.put(DayOfWeek.THURSDAY,"Th");
		weekDayNames.put(DayOfWeek.FRIDAY,"F");
		weekDayNames.put(DayOfWeek.SATURDAY,"S");
	}
	public ArrayList<CalendarElement> buildMonthlyCalendar(int year, int month) {
		CalendarElement ce;
		ArrayList<CalendarElement> result=new ArrayList<CalendarElement>();
		int firstSolarTermDate,secondSolarTermDate;
		LocalDate solarDateObj=null,tempDateObj;
		LunarDate lunarDateObj=null;
		String solarDate,lunarDate;
		Map<Integer,ArrayList<String>> publicHolidayList=new TreeMap<Integer,ArrayList<String>>();
		for (int i=1;i<=getMonthLength(year,month);i++) {
			solarDateObj=LocalDate.of(year, month, i);
			lunarDateObj=getLunarDate(solarDateObj.atStartOfDay());
			ce =new CalendarElement(solarDateObj,lunarDateObj);
			
			solarDate=String.format("%02d", solarDateObj.getMonthValue())+String.format("%02d", solarDateObj.getDayOfMonth());
			if (solarHolidayList.containsKey(solarDate)) {
				recordFestivalInfo(publicHolidayList, i,solarHolidayList.get(solarDate));
			}
			lunarDate=String.format("%02d", lunarDateObj.month)+String.format("%02d", lunarDateObj.date);
			
			if (lunarHolidayList.containsKey(lunarDate) && !ce.isLeap()) { //農曆閏月不算假期
				recordFestivalInfo(publicHolidayList, i,lunarHolidayList.get(lunarDate));
			}
			if (ce.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
				ce.setPublicHoliday(true);
			}
			result.add(ce);
		}
		
		//復活節只出現在3或4月
		if ((month==3)||(month==4)) {
			//Easter/復活節日期
			LocalDate easterDate=getEasterDateByYear(year);
			
			//Good Friday日期
			tempDateObj=easterDate.minusDays(2);
			if (tempDateObj.getMonthValue()==month) {
				recordFestivalInfo(publicHolidayList, tempDateObj.getDayOfMonth(),"耶穌受難節");
			}
			//Holy Saturday日期
			tempDateObj=easterDate.minusDays(1);
			if (tempDateObj.getMonthValue()==month) {
				recordFestivalInfo(publicHolidayList, tempDateObj.getDayOfMonth(),"耶穌受難節翌日");
			}
			//Easter Monday日期
			tempDateObj=easterDate.plusDays(1);
			if (tempDateObj.getMonthValue()==month) {
				recordFestivalInfo(publicHolidayList, tempDateObj.getDayOfMonth(),"復活節星期一");
			}
		}
		//節氣
		firstSolarTermDate=this.sTerm(year,(month-1)*2  );
		secondSolarTermDate=this.sTerm(year,(month-1)*2+1);
		
		/*
		System.out.println((month)+"月第一節氣日子:"+firstSolarTermDate);
		System.out.println((month)+"月第二節氣日子:"+secondSolarTermDate);
		System.out.println(result.size());
		*/
		ce=result.remove(firstSolarTermDate-1);
		ce.setSolarTermInfo(this.solarTerm[(month-1)*2]);
		result.add(firstSolarTermDate-1,ce);
		if (ce.getSolarTermInfo().equals("清明")) {
			recordFestivalInfo(publicHolidayList, firstSolarTermDate,ce.getSolarTermInfo()+"節");
		}
		ce=result.remove(secondSolarTermDate-1);
		ce.setSolarTermInfo(this.solarTerm[(month-1)*2+1]);
		result.add(secondSolarTermDate-1,ce);
		//System.out.println(publicHolidayList.toString());
		processHoliday(publicHolidayList,result);
		return result;
	}
	/**
	 * 傳回該年生肖
	 * @param y 年份
	 * @return 傳回該年生肖
	 */
	private String getAnimalOfYear(int y)
	{
		String Animals[]={"鼠","牛","虎","兔","龍","蛇","馬","羊","猴","雞","狗","豬"};
		return Animals[(y-4)%12];
	}
	/**
	 * 傳回時柱<br>
	 * It returns "Hour Pillar" in Chinese of a given hour
	 * @param h 傳入hour
	 * @return 傳回時柱
	 */
	public String getChineseHourName(int h)
	{
		int i=-1;
		if ((h==23) || (h==0))
		{
			i=0;
		}
		else
		{
			double x=(double)h;
			i=(int)(Math.round(x/2));
		}
		return Zhi[i];
	} 
	/**
	 * 傳回天干地支
	 * @param num 傳入 offset
	 * @return 傳回干支, 0=甲子
	 */
	private  String getCyclical(int num)
	{
		String Gan[]={"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
		return(Gan[num%10 ]+Zhi[num%12]);
	}
	
	/**
	 * 傳回該年的復活節LocalDate物件(春分後第一次滿月週後的第一主日)<br>
	 * It returns a LocalDate object which devote the date of easter of given year
	 * @param y 年份
	 * @return 傳回該年復活節LocalDate物件
	 */
	public LocalDate getEasterDateByYear(int y) {
		int lMlen,term2=sTerm(y,5); //取得春分日期
		LocalDate dayTerm2=LocalDate.of(y,3, term2);//取得春分的國曆日期物件(春分一定出現在3月)
		LunarDate lDayTerm2 = getLunarDate(dayTerm2.atStartOfDay()); //取得取得春分農曆
		
		if (lDayTerm2.date<15)//取得下個月圓的相差天數
		{
			lMlen=15-lDayTerm2.date;
		}
		else
		{
			if (lDayTerm2.isLeap)
			{
				lMlen=leapDays(y);//農曆 y年閏月的天數
			}
			else
			{
				lMlen=lunarMonthDayCount(lDayTerm2.year,lDayTerm2.month);//農曆 y年m月的總天數
			}
			lMlen=lMlen-lDayTerm2.date + 15;
		}
		dayTerm2=dayTerm2.plusDays(lMlen);
		if (dayTerm2.getDayOfWeek()==DayOfWeek.SUNDAY)
		{
			dayTerm2=dayTerm2.plusDays(1);
		}
		while (dayTerm2.getDayOfWeek()!=DayOfWeek.SUNDAY)
		{
			dayTerm2=dayTerm2.plusDays(1);
		}
		return dayTerm2;	 
	}
	/**
	 * 傳入LocalDate物件, 傳回LunarDate物件<br>
	 * It returns a corresponding LunarDate object when a LocalDate object is given.
	 * @param inLocalDateObj LocalDate物件
	 * @return LunarDate物件<br>
	 * A corresponding LunarDate object when a LocalDate object is given.
	 */
	public LunarDate getLunarDate(LocalDateTime inLocalDateTimeObj)
	{
		int i, leap=0;
		int inYear,inMonth,inDate;
		long firstNode=0L,dayCyclical=0L,offset=0L,temp=0L;
		LunarDate result=new LunarDate ();
		LocalDate startDate=LocalDate.of(1900,1,31);
		LocalDate inLocalDate=inLocalDateTimeObj.toLocalDate();
		
		inYear=inLocalDateTimeObj.getYear();
		inMonth=inLocalDateTimeObj.getMonthValue();
		inDate=inLocalDateTimeObj.getDayOfMonth();
		offset=Duration.between(startDate.atStartOfDay(ZoneId.of("UTC")),inLocalDate.atStartOfDay(ZoneId.of("UTC"))).toDays();
		//System.out.println("0 offset="+offset);
		for(i=1900; i<2100 && offset>0; i++) { 
			temp=this.lYearDays(i); 
			offset-=temp; 
		}

		if(offset<0) {
			offset+=temp; i--;
		}
		//System.out.println("1 offset="+offset);
		result.year = i;
		result.animalOfYear=getAnimalOfYear(i);
		leap = getLunarLeapMonth(i); //閏哪個月
		result.isLeap = false;
		//System.out.println("lunarLeapMonth="+leap);
		
		for(i=1; i<13 && offset>0; i++) {
			//閏月
			if(leap>0 && i==(leap+1) && result.isLeap==false) { 
				--i; 
				result.isLeap = true; 
				temp = this.leapDays(result.year); 
				//console.log("0 i="+i+",temp="+temp);
			} else { 
				temp = lunarMonthDayCount(result.year, i); 
				//console.log("1 i="+i+",temp="+temp);
			}
			//console.log("2 i="+i+",temp="+temp);
			//解除閏月
			if(result.isLeap==true && i==(leap+1)) 
				result.isLeap = false;

			offset -= temp;
			//console.log("1.5 offset="+offset);
		}
		//System.out.println("2 offset="+offset);
		if(offset==0 && leap>0 && i==leap+1)
			if(result.isLeap) { 
				result.isLeap = false;
			} else { 
				result.isLeap = true; 
				--i; 
			}
		//System.out.println("3 offset="+offset);
		if(offset<0){ 
			offset += temp; 
			--i; 
		}
		//System.out.println("4 offset="+offset);
		result.month = i;
		result.date = (int) (offset + 1);
		result.chineseYearName=getCyclical(result.year-1900+36);
		
		firstNode = this.sTerm(inYear,inMonth*2); //傳回當月「節」為幾日開始
		//System.out.println("firstNode="+offset);
		
		if(firstNode<inDate) {
			result.chineseMonthName = getCyclical((inYear-1900)*12+inMonth+12);
		} else {
			result.chineseMonthName = getCyclical((inYear-1900)*12+inMonth+13);
		}
		//當月一日與 1900/1/1 相差天數
		//1900/1/1與 1970/1/1 相差25567日, 1900/1/1 日柱為甲戌日(60進制10)
		startDate=LocalDate.of(1900,1,1);
		inLocalDate=LocalDate.of(inYear,inMonth,1);
		dayCyclical=Duration.between(startDate.atStartOfDay(ZoneId.of("UTC")),inLocalDate.atStartOfDay(ZoneId.of("UTC"))).toDays();
		//System.out.println("0 dayCyclical="+dayCyclical);
		dayCyclical+=(10L-1L);
		//System.out.println("1 dayCyclical="+dayCyclical);
		
		//日柱
		result.chineseDayName = getCyclical((int)dayCyclical+inDate);
		
		//時柱
		result.chineseHourName=getChineseHourName(inLocalDateTimeObj.getHour());
		
		
		return result;
	}
	/**
	 * 傳回農曆 y年閏哪個月 1-12 , 沒閏傳回 0
	 * @param y
	 * @return 傳回農曆 y年閏哪個月 1-12 , 沒閏傳回 0
	 *
	 */
	private int getLunarLeapMonth(int y) 
	{
		int lm = lunarInfo[y-1900] & 0xf;
		return(lm==0xf?0:lm);
	}
	/**
	 * 傳回西曆 y年某month月的天數
	 * @return 該月的天數
	 */
	private int getMonthLength(int year,int month) 
	{
		YearMonth yearMonthObject = YearMonth.of(year, month);
		return yearMonthObject.lengthOfMonth(); 
	}
	/**
	 * 傳回農曆 y年閏月的天數
	 * @param y
	 * @return 傳回農曆 y年閏月的天數
	 *
	 */
	private int leapDays(int y) 
	{
		if(getLunarLeapMonth(y)!=0) 
		{	
			return( (lunarInfo[y-1899]&0xf)==0xf? 30: 29);
		}
		else 
			return(0);
	}
	/**
	 * 傳回農曆 y年m月的總天數
	 * @param y 年份
	 * @param m 月份
	 * @return 傳回農曆 y年m月的總天數
	 * 
	 */
	private int lunarMonthDayCount(int y,int m) 
	{
		if ((lunarInfo[y-1900] & (0x10000>>m))>0)
			return 30;
		else
			return 29;	  
	}
	/**
	 *  傳回農曆 y年的總天數
	 *  @param y
	 *  @return 傳回農曆 y年的總天數
	 *
	 */
	private int lYearDays(int y) 
	{
		int i, sum = 348;
		for(i=0x8000; i>0x8; i>>=1) 
		{	
			if ((lunarInfo[y-1900] & i)>0)
			{
				sum+=1;
			}
		}
		return(sum+leapDays(y));
	}
	/**
	 * 傳入數字傳回相應的中文數字<br>
	 * It returns corresponding Chinese of a given number 
	 * @param d 傳入數字
	 * @return 傳回中文數字
	 */
	public String numToChineseNum(int d)
	{
		String s=new String();
		if (d<10)
			s=nStr1[d];
		else
		{
			s = nStr2[(int)(d/10)];
			if ((d%10)>0)
				s += nStr1[d%10];
		}
		return s;
	}
	
	private void processHoliday(Map<Integer, ArrayList<String>> publicHolidayList, ArrayList<CalendarElement> calendarElementList) {
		publicHolidayList.forEach((index,festivalInfoList)->{
			 festivalInfoList.forEach(festivalInfo->{
				 //System.out.printf("0 %d %s\n",index,festivalInfo);
				 
				 int realIndex=index;
				 CalendarElement calendarElement;
				 if (calendarElementList.get(index-1).isPublicHoliday()) {
					 realIndex=index+1;
					 if (realIndex < calendarElementList.size()){
						 festivalInfo+="補假";
					 } else {
						 return;
					 }
				 }
				 
				 calendarElement=calendarElementList.remove(realIndex-1);
				 calendarElement.setPublicHoliday(true);
				 calendarElement.setFestivalInfo(festivalInfo);
				 calendarElementList.add(realIndex-1,calendarElement);

			 });
		 });
		
	}

	private void recordFestivalInfo(Map<Integer,ArrayList<String>> holidayList,int index,String festivalInfo) {
		ArrayList<String> festivalInfoList;
		
		if (holidayList.containsKey(index)) {
			festivalInfoList=holidayList.remove(index);
		} else {
			festivalInfoList=new ArrayList<String>();
		}
		festivalInfoList.add(festivalInfo);
		holidayList.put(index, festivalInfoList);
	}
	/**
	 * 傳回某年的第n個節氣為幾日(從0小寒起算)
	 * @param y 年份
	 * @param n 第幾個
	 * @return 某年的第n個節氣為幾日(從0小寒起算)
	 */
	private int sTerm(int year, int n) {
		int result=0,index,solarTermBase[]={4,19,3,18,4,19,4,19,4,20,4,20,6,22,6,22,6,22,7,22,6,21,6,21};
		byte temp;
		String solarTermIdx ="0123415341536789:;<9:=<>:=1>?012@015@015@015AB78CDE8CD=1FD01GH01GH01IH01IJ0KLMN;LMBEOPDQRST0RUH0RVH0RWH0RWM0XYMNZ[MB\\]PT^_ST`_WH`_WH`_WM`_WM`aYMbc[Mde]Sfe]gfh_gih_Wih_WjhaWjka[jkl[jmn]ope]qph_qrh_sth_W";
		String solarTermOS = "211122112122112121222211221122122222212222222221222122222232222222222222222233223232223232222222322222112122112121222211222122222222222222222222322222112122112121222111211122122222212221222221221122122222222222222222222223222232222232222222222222112122112121122111211122122122212221222221221122122222222222222221211122112122212221222211222122222232222232222222222222112122112121111111222222112121112121111111222222111121112121111111211122112122112121122111222212111121111121111111111122112122112121122111211122112122212221222221222211111121111121111111222111111121111111111111111122112121112121111111222111111111111111111111111122111121112121111111221122122222212221222221222111011111111111111111111122111121111121111111211122112122112121122211221111011111101111111111111112111121111121111111211122112122112221222211221111011111101111111110111111111121111111111111111122112121112121122111111011111121111111111111111011111111112111111111111011111111111111111111221111011111101110111110111011011111111111111111221111011011101110111110111011011111101111111111211111001011101110111110110011011111101111111111211111001011001010111110110011011111101111111110211111001011001010111100110011011011101110111110211111001011001010011100110011001011101110111110211111001010001010011000100011001011001010111110111111001010001010011000111111111111111111111111100011001011001010111100111111001010001010000000111111000010000010000000100011001011001010011100110011001011001110111110100011001010001010011000110011001011001010111110111100000010000000000000000011001010001010011000111100000000000000000000000011001010001010000000111000000000000000000000000011001010000010000000";
		//return(solarTermBase[n] +  Math.floor( solarTermOS.charAt( ( Math.floor(solarTermIdx.charCodeAt(y-1900)) - 48) * 24 + n  ) ) );
		index=year-1900;
		temp=solarTermIdx.getBytes()[index];
		index=temp;
		index=(index-48)*24+n;
		result=solarTermOS.getBytes()[index]-48; //convert char to int
		result+=solarTermBase[n];
		return result;
	}
	
	/**
	 * For Testing only
	 * @param args command line parameter
	 */
	public static void main(String[] args) {
		int date,month,year;
		CalendarUtility cu=new CalendarUtility();
		// year=2017;month=1;date=24;
		// year=2015;month=4;date=24;//復活節清明節overlap
		// year=2016;month=12;date=24;//聖誕節補假
		// year=2013;month=3;date=24;//復活節撗跨3,4月
		// year=2014;month=1;date=24;//農曆,西曆都有
		// year=2018;month=2;date=24;//農曆新年補假
		//year=2020;month=4;date=24;//佛誕問題
		year=2020;month=5;date=24;
		LocalDateTime now=LocalDateTime.of(year,month,date,2,0,0);
		LunarDate lc=cu.getLunarDate(now);
		System.out.println("Lunar Date="+lc.chineseYearName+"年"+cu.numToChineseNum(lc.month)+"月"+cu.numToChineseNum(lc.date)+"日");
		System.out.println("Lunar Date in Chinese="+lc.chineseYearName+"年"+((lc.isLeap)?"(閏)":"")+lc.chineseMonthName+"月"+lc.chineseDayName+"日"+lc.chineseHourName+"時");
		System.out.println("AnimalOfYear="+lc.animalOfYear);
		System.out.println("isLeapMonth="+lc.isLeap);
		System.out.println("===================================================");
		ArrayList<CalendarElement> calendarElementList=cu.buildMonthlyCalendar( year,  month);
		calendarElementList.forEach((calendar)-> {
			System.out.println("Solar Date="+calendar.getYear()+"/"+calendar.getMonth()+"/"+calendar.getDayOfMonth()+" "+calendar.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.TRADITIONAL_CHINESE));
			System.out.println("Solar Term Info="+calendar.getSolarTermInfo());
			System.out.println("Lunar Date="+calendar.getChineseYearName()+"年"+((calendar.isLeap())?"(閏)":"")+cu.numToChineseNum(calendar.getLunarMonth())+"月"+cu.numToChineseNum(calendar.getLunarDate())+"日");
			System.out.println("Lunar Date in Chinese="+calendar.getChineseYearName()+"年"+((calendar.isLeap())?"(閏)":"")+calendar.getChineseMonthName()+"月"+calendar.getChineseDayName()+"日"+calendar.getChineseHourName()+"時");
			System.out.println("Festival Info="+calendar.getFestivalInfo());
			System.out.println("is Holiday="+calendar.isPublicHoliday());
			System.out.println("===================================================");
		});
	}
}
