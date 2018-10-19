package common;

public class LunarDateTime 
{
	/**
	 *當天農曆年份(用數字來表示)<br>
	 *The lunar year of the specified date.
	 */ 	
	public int year;
	/**
	 *當天農曆月份(用數字來表示)<br>
	 *The lunar month of the specified date.
	 */ 	
	public int month;
	/**
	 *當天農曆日子(用數字來表示)<br>
	 *The lunar day of the specified date in number.
	 */ 	
	public int date;
	/**
	 * 是否為閏月<br>
	 * is the specified month Lunar Leap Month?
	 */
	public boolean isLeap=false;
	/** 
	 * 當天年柱<br>
	 * "Year Pillar" in Chinese of the specified date
	 */
	public String yearPillar=new String();
	/**
	 * 當天月柱<br>
	 * "Month Pillar in Chinese of the specified date
	 */
	public String monthPillar=new String();
	/**
	 *當天日柱<br>
	 *"Day Pillar" in Chinese of the specified date
	 */
	public String datePillar=new String();
	/**
	 *當時時柱<BR>
	 *"Hour Pillar" in Chinese of the specified date
	 */
	public String hourPillar=new String();
	/**
	 *當天節氣訊息<br>
	 *Solar Term Info of the specified date
	 */
	public String solarTermInfo=new String();
	/**
	 * 該年生肖<BR>
	 * The animal Of the year in Chinese of the specified date
	 */
	public String animalOfYear=new String();

}
