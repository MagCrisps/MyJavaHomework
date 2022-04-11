package homework2pac;

import java.util.Scanner;

class Column{
	int a;
	int b;
	int height;
	double area = 0.0;
	Scanner scan = new Scanner(System.in);
	void getInformation() {
		System.out.print("请输入柱体的底面参数a，b以及高h（以单个空格分隔各数据）\n");
		a = scan.nextInt();
		b = scan.nextInt();
		height = scan.nextInt();
		System.out.print("数据输入完成！\n");
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
		System.out.printf("需要的桶数为%.1f",columnNum * paint.getNum(col));
	}
}
