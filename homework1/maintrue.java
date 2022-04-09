package myjavaproject;

class Factorial{
	int sum;
	long factorialn(long num) {
		if(num > 1) {
			num *= factorialn(num - 1) ;
		}else {
			num = 1;
		}
		return num;
	}
	double sumadd(int length) {
		double sum = 0;
		if(length >= 0) {
			while(length != 0) {
				sum += 1.0/factorialn(length --);
			}
		}else {
			System.out.print("error!\n");
		}
		return sum;
	}
	
}
public class maintrue {
	static void fun() {
		Factorial a = new Factorial();
	System.out.printf("the retsult is %.4f\n", a.sumadd(20));
	mainjava m = new mainjava();
	long [] arr = m.findthearr(6,2,3,5,7,12,55,6,7,9,58,64);
	for(long ln:arr)
		System.out.print(ln + " ");
	}
	public static void main(String[] args) {
	AirplaneTicketsPrice aTP = new AirplaneTicketsPrice();
	//aTP.getPrice();
	//fun();
	}
}
