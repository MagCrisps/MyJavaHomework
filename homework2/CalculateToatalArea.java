package homework2pac;

import java.util.Scanner;

class Column{
	int a;
	int b;
	int height;
	double area = 0.0;
	Scanner scan = new Scanner(System.in);
	void getInformation() {
		System.out.print("����������ĵ������a��b�Լ���h���Ե����ո�ָ������ݣ�\n");
		a = scan.nextInt();
		b = scan.nextInt();
		height = scan.nextInt();
		System.out.print("����������ɣ�\n");
	}
	void calculate() {
		area = 3.14 * a * b;
	}
}
class Paint{
	private static int paintArea = 70;
	double getNum(Column col) {
		return (col.area/paintArea);
	}
}
public class CalculateToatalArea {
	Column col = new Column();
	Paint paint = new Paint();
	void calculateBarrells(int columnNum) {
		col.getInformation();
		col.calculate();
		System.out.printf("��Ҫ��Ͱ��Ϊ%.1f",columnNum * paint.getNum(col));
	}
}
