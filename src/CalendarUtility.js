class CalendarUtility
{
	constructor(){
		this.lunarInfo=new Array(
			0x4bd8,0x4ae0,0xa570,0x54d5,0xd260,0xd950,0x5554,0x56af,0x9ad0,0x55d2,
			0x4ae0,0xa5b6,0xa4d0,0xd250,0xd255,0xb54f,0xd6a0,0xada2,0x95b0,0x4977,
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
			0xd520);
		this.Gan=new Array("甲","乙","丙","丁","戊","己","庚","辛","壬","癸");
		this.Zhi=new Array("子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥");
		this.Animals=new Array("鼠","牛","虎","兔","龍","蛇","馬","羊","猴","雞","狗","豬");	
			
		this.solarTerm = new Array("小寒","大寒","立春","雨水","驚蟄","春分","清明","穀雨","立夏","小滿","芒種","夏至","小暑","大暑","立秋","處暑","白露","秋分","寒露","霜降","立冬","小雪","大雪","冬至");
		this.sTermInfo = new Array(0,21208,42467,63836,85337,107014,128867,150921,173149,195551,218072,240693,263343,285989,308563,331033,353350,375494,397447,419210,440795,462224,483532,504758);
		this.solarMonth=new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	}
	//=================================================================================================
	buildMonthlyCalendar(y,m) {
		var result=[];
		var cY, cM, cD; //年柱,月柱,日柱
		var lDObj, lY, lM, lD=1, lL, lX=0, tmp1, tmp2, tmp3;
		var sDObj = new Date(y,m,1,0,0,0,0);    //當月一日日期
		var length    = this.solarDays(y,m);    //國曆當月天數
		var firstWeek = sDObj.getDay();    //國曆當月1日星期幾
		var lDPOS = new Array(3);
		var n = 0;
		var firstLM = 0;

		////////年柱 1900年立春後為庚子年(60進制36)
		if(m<2) 
			cY=this.cyclical(y-1900+36-1);
		else 
			cY=this.cyclical(y-1900+36);
		
		var term2=this.sTerm(y,2); //立春日期
		
		////////月柱 1900年1月小寒以前為 丙子月(60進制12)
		var firstNode = this.sTerm(y,m*2) //傳回當月「節」為幾日開始
		cM = this.cyclical((y-1900)*12+m+12);

		//當月一日與 1900/1/1 相差天數
		//1900/1/1與 1970/1/1 相差25567日, 1900/1/1 日柱為甲戌日(60進制10)
		var dayCyclical = Date.UTC(y,m,1,0,0,0,0)/86400000+25567+10;

		for(var i=0;i<length;i++) {
			if(lD>lX) {
				sDObj = new Date(y,m,i+1);    //當月一日日期
				lDObj = this.getLunarDate(sDObj);     //農曆
				lY    = lDObj.year;           //農曆年
				lM    = lDObj.month;          //農曆月
				lD    = lDObj.day;            //農曆日
				lL    = lDObj.isLeap;         //農曆是否閏月
				lX    = lL? this.leapDays(lY): this.monthDays(lY,lM); //農曆當月最後一天

				if(n==0) 
					firstLM = lM;
				lDPOS[n++] = i-lD+1;
			}
			
			//依節氣調整二月分的年柱, 以立春為界
			if(m==1 && (i+1)==term2) 
				cY=this.cyclical(y-1900+36);
			//依節氣月柱, 以「節」為界
			if((i+1)==firstNode) 
				cM = this.cyclical((y-1900)*12+m+13);
			//日柱
			cD = this.cyclical(dayCyclical+i);
		
			var ce=new CalendarElement();
			ce.lunarDate=lD++;
			ce.lunarMonth=lM;
			ce.lunarYear=lY;
			ce.isLeap=lL;
			
			ce.dayOfMonth=i+1;
			//ce.dayOfWeek="";
			ce.month=m+1;
			ce.year=y;


			//ce.chineseHourName="";
			ce.chineseYearName=cY;
			ce.chineseMonthName=cM;
			ce.chineseDayName=cD;
			
			result.push(ce);	
		}
		
		//節氣
		tmp1=this.sTerm(y,m*2  )-1;
		tmp2=this.sTerm(y,m*2+1)-1;
		result[tmp1].festivalInfo = this.solarTerm[m*2];
		result[tmp2].festivalInfo = this.solarTerm[m*2+1];
		if(m==2 || m==3) {
			var estDay = this.getEasterDate(y);
			if(m == estDay.getMonth())
			   result[estDay.getDate()-1].festivalInfo = result[estDay.getDate()-1].festivalInfo+' 復活節 ';
		}
		return result;
	}
	//============================== 傳入 offset 傳回干支, 0=甲子
	cyclical(num) {
	 return(this.Gan[num%10]+this.Zhi[num%12]);
	}
	//======================================= 傳回該年的生肖
	getAnimalOfYear(SY) {
		return this.Animals[(SY-4)%12];
	}
	//======================================= 傳回該年的復活節(春分後第一次滿月週後的第一主日)
	getEasterDate(y) {

		var term2=this.sTerm(y,5); //取得春分日期
		var dayTerm2 = new Date(Date.UTC(y,2,term2,0,0,0,0)); //取得春分的國曆日期物件(春分一定出現在3月)
		var lDayTerm2 = this.getLunarDate(dayTerm2); //取得取得春分農曆

		if(lDayTerm2.day<15) //取得下個月圓的相差天數
			var lMlen= 15-lDayTerm2.day;
		else
			var lMlen= (lDayTerm2.isLeap? this.leapDays(y): this.monthDays(y,lDayTerm2.month)) - lDayTerm2.day + 15;

		//一天等於 1000*60*60*24 = 86400000 毫秒
		var l15 = new Date(dayTerm2.getTime() + 86400000*lMlen ); //求出第一次月圓為國曆幾日
		var dayEaster = new Date(l15.getTime() + 86400000*( 7-l15.getUTCDay() ) ); //求出下個週日

		return new Date(y,dayEaster.getUTCMonth(), dayEaster.getUTCDate());	
	}
	//====================================== 算出農曆, 傳入日期物件, 傳回農曆日期物件
	//                                       該物件屬性有 .year .month .day .isLeap			
	getLunarDate(objDate) {
		var result=new LunarDate();
		var i, leap=0, temp=0;
		var offset   = (Date.UTC(objDate.getFullYear(),objDate.getMonth(),objDate.getDate()) - Date.UTC(1900,0,31))/86400000;

		for(i=1900; i<2100 && offset>0; i++) { 
			temp=this.lYearDays(i); 
			offset-=temp; 
		}

		if(offset<0) {
			offset+=temp; i--;
		}
		result.year = i;
		
		leap = this.leapMonth(i); //閏哪個月
		result.isLeap = false;
		
		for(i=1; i<13 && offset>0; i++) {
			//閏月
			if(leap>0 && i==(leap+1) && result.isLeap==false) { 
				--i; 
				result.isLeap = true; 
				temp = this.leapDays(result.year); 
			} else { 
				temp = this.monthDays(result.year, i); 
			}

			//解除閏月
			if(result.isLeap==true && i==(leap+1)) 
				result.isLeap = false;

			offset -= temp;
		}
		
		if(offset==0 && leap>0 && i==leap+1)
			if(result.isLeap) { 
				result.isLeap = false;
			} else { 
				result.isLeap = true; 
				--i; 
			}

		if(offset<0){ 
			offset += temp; 
			--i; 
		}

		result.month = i;
		result.day = offset + 1;
		return result;
	
	}	
	//====================================== 傳回農曆 y年的總天數
	lYearDays(y) {
		var i, sum = 348;
		for(i=0x8000; i>0x8; i>>=1) 
			sum += (this.lunarInfo[y-1900] & i)? 1: 0;
		return(sum+this.leapDays(y));
	}
	//====================================== 傳回農曆 y年閏月的天數
	leapDays(y) {
	 if(this.leapMonth(y)) 
		return( (this.lunarInfo[y-1899]&0xf)==0xf? 30: 29);
	 else
		return(0);
	}

	//====================================== 傳回農曆 y年閏哪個月 1-12 , 沒閏傳回 0
	leapMonth(y) {
	 var lm = this.lunarInfo[y-1900] & 0xf;
	 return(lm==0xf?0:lm);
	}

	//====================================== 傳回農曆 y年m月的總天數
	monthDays(y,m) {
	 return( (this.lunarInfo[y-1900] & (0x10000>>m))? 30: 29 );
	}
	
	//==============================傳回國曆 y年某m+1月的天數
	solarDays(y,m) {
	 if(m==1)
		return(((y%4 == 0) && (y%100 != 0) || (y%400 == 0))? 29: 28);
	 else
		return(this.solarMonth[m]);
	}
	//===== 某年的第n個節氣為幾日(從0小寒起算)
	sTerm(y,n) {
		var offDate = new Date( ( 31556925974.7*(y-1900) + this.sTermInfo[n]*60000  ) + Date.UTC(1900,0,6,2,5) );
		return(offDate.getUTCDate());
	}

}

class LunarDate
{
	constructor(){
		this.day=-1;
		this.month=-1;
		this.year=-1; 
		this.isLeap=false;
	}	
}
class CalendarElement
{
	constructor() {
		
		this.animalOfYear
		
		this.festivalInfo="";
		this.isLeap;
		this.lunarDate;
		this.lunarMonth;
		this.lunarYear;
		this.publicHoliday;
		this.solarTermInfo="";
		
		this.dayOfMonth;
		this.dayOfWeek="";
		this.month;
		this.year;
		
		
		this.chineseHourName="";
		this.chineseYearName="";
		this.chineseMonthName="";
		this.chineseDayName="";
	}
}