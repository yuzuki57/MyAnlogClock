package calc;

import java.util.Calendar;


public class CalcCalendar extends AbstractCalc{

	//年、月、日、曜日を取得
	Calendar nowTime = Calendar.getInstance();
	private int year = nowTime.get(Calendar.YEAR);
	private int month = nowTime.get(Calendar.MONTH) + 1;
	private int day = nowTime.get(Calendar.DAY_OF_MONTH);

	@Override
	public String doYear(){
		String Year = String.valueOf(year);
		return Year;
	}
	@Override
	public String doMonth(){
		String Month = String.valueOf(month);
		return Month;
	}
	@Override
	public String doDay(){
		String Day = String.valueOf(day);
		return Day;
	}
	@Override
	public String doWeeks(){

		String[] weeks = new String[7];
	      weeks[0] = "SunDay";
	      weeks[1] = "Monday";
	      weeks[2] = "TuesDay";
	      weeks[3] = "WednesDay";
	      weeks[4] = "ThursDay";
	      weeks[5] = "FriDay";
	      weeks[6] = "SaturDay";
	      int week_int = nowTime.get(Calendar.DAY_OF_WEEK);

		String Weeks = weeks[week_int -1];
		return Weeks;
	}

}
