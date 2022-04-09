package myjavaproject;
import java.util.Scanner;
class Date{
	String holiday[] = {"2017-1-1","2017-1-27","2017-1-28","2017-1-29","2017-1-30",
						"2017-1-31","2017-2-1","2017-2-2",
						"2017-4-2","2017-4-3","2017-4-4",
						"2017-5-1","2017-5-2","2017-5-3","2017-5-28","2017-5-29","2017-5-29","2017-5-30",
						"2017-10-1","2017-10-2","2017-10-3","2017-10-3","2017-10-4","2017-10-5","2017-10-6","2017-10-7","2017-10-8"};
	boolean judgeWeekend(int month, int day) {
		boolean flag = false;
		int totalDay = 0,wekendflag = 0;
		switch(month) {
		case 1:totalDay = 0;break;
		case 2:totalDay = 31;break;
		case 3:totalDay = 59;break;
		case 4:totalDay = 90;break;
		case 5:totalDay = 120;break;
		case 6:totalDay = 151;break;
		case 7:totalDay = 181;break;
		case 8:totalDay = 212;break;
		case 9:totalDay = 243;break;
		case 10:totalDay = 273;break;
		case 11:totalDay = 304;break;
		case 12:totalDay = 334;break;
		}
		wekendflag = (totalDay + day) % 7;
		if(wekendflag == 1||wekendflag == 0)
			flag = true;
		return flag;
	}
	char judgeHoliday(String date, int month, int day) {
		char sign = 0;
		boolean flag = true;
		for(String str:holiday) {
			if(date == str) {
				flag = false;
			}//if str
		}//for :holiday
		if(flag) {
			if(judgeWeekend(month, day)) {
				sign = 1;
			}else {
				sign = 2;
			}
		}//if flag
		return sign;//0 法定假期 ；1 非法定假期的周末；2 工作日；
	}
}
class Tickets{
	long ticketsNum = 0;
	int ticketsPrice = 1200;
	float discount = 1;
	float getDiscount(char flag) {
		switch(flag) {
			case 0:break;
			case 1:discount = 0.8f;break;
			case 2:discount = 0.6f;break;
			default :System.out.print("ERROR!");
		}//switch flag
		return discount;
	}
	double getTotal(long ticketsNum, char flag) {
		discount = getDiscount(flag);
		return ticketsNum * discount * ticketsPrice;
	}
}
public class AirplaneTicketsPrice {
	Date date = new Date();
	Tickets tickets = new Tickets();
    void getPrice() {
    		System.out.print("请输入日期（格式xxxx xx xx）\n");
    		Scanner scanDate = new Scanner(System.in);
    		int year = scanDate.nextInt();
    		int month = scanDate.nextInt();
    		int day = scanDate.nextInt();
    		scanDate.nextLine();
    		System.out.print("请输入票数\n");
    		tickets.ticketsNum = scanDate.nextInt();
    		String dateS = year + "-" + month + "-" + day;
    		double total = tickets.getTotal(tickets.ticketsNum, date.judgeHoliday(dateS, month, day));
    		System.out.print("总价钱为：" + total);
	}
}