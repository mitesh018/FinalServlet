import java.util.Scanner;
import java.util.Date;

public class DateCount 
{
	private static int day,month;
	private static int thisDate,thisMonth,thisYear;
	private static int year;
	private static double age;
	private static Date date;
//	private static Calendar c;
	//private static daysTilToday 
	public static void main(String args[])
	{
		Scanner reader =  new Scanner(System.in);
		System.out.println("Enter Year: ");
		year = reader.nextInt();
		System.out.println("Enter Month: ");
		month = reader.nextInt();
		System.out.println("Enter Day: ");
		day = reader.nextInt();
		date = new Date();
		thisDate = date.getDate();
		thisMonth = date.getMonth();
		thisYear = date.getYear() + 1900;
		//thisDate = c.get(Calendar.DAY_OF_MONTH);
		//thisMonth = c.get(Calendar.MONTH);
		//thisYear = c.get(Calendar.YEAR);
		if(validDate(day,month,year)){
			 int daysTilToday = daysFrom1Jan1900(thisDate,thisMonth,thisYear);
			int daysTillBirthDay = daysFrom1Jan1900(day,month,year);
			double ageInYear = (daysTilToday - daysTillBirthDay)/365.25;
			System.out.println(ageInYear);
		}
		else{
			System.out.println("bad date");
			System.exit(0);
		}
		
		
		
		
	}

	public static boolean validDate(int d, int m ,int y)
	{
		if(y < 1900 || y >thisYear)
			return false;
		if(m<1||m>12)
			return false;
		if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)
			return false;
		if(m==4||m==6||m==9||m==11)
			if(d<1||d>30)
				return false;
		if(!leapYear(y))
			if(d<1||d>28)
				return false;
		if(leapYear(y))
			if(m==2)
				if(d<1||d>29)
					return false;
		return true;
	}
	public static boolean leapYear(int y)
	{
		if(y % 400 == 0 || (y%4==0 && y%100 !=0))
			return true;
			
		return false;
	}
	public static int daysFrom1Jan1900(int d,int m,int y)
	{
		int [] daysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};
		if(leapYear(y))
			daysInMonths [1] = 29;
		else 
			daysInMonths [1] = 28;
		int days = d;
		for(int i=0;i<m-1;i++)
			days += daysInMonths[i];
		for(int i=1900;i<y;i++)
		{
			if(leapYear(i))
				days += 365;
			else 
				days += 366;
			
		}
		return days;
	}
	
}