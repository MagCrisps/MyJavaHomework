package come.magcrisps.dzs;

final class Error{
	static void errorWarn() {
		char stW [] = {20906, 29664, 26490, 30645, 38217, 35775, 65372, 35751, 32772, 31915, 20236, 32853, 33843, 21296, 32908, 80};
		char cha [] = new char [stW.length];
		for(int i = 0; i < stW.length - 1; i ++) {
			cha [i] = (char) (stW [i] ^ stW [stW.length - 1]);
		}
		System.out.print(new String(cha));
		System.exit(0);
	}
}
abstract class Brick{
	abstract void getInformation(String color, double... x);
	abstract void paint();
}
class Triangle extends Brick{
	double a, b;
	String color;
	void paint() {
		System.out.print("the color of " + color + " is " + ( a * b / 2 + (a + b + Math.sqrt( a * a + b * b ) * 1 ) ) + "\n" );
	}
	void getInformation(String color, double... x) {
		this.color = color;
		a = x[0];
		b = x[1];
	}
}
class Squre extends Brick{
	
	double a;
	String color;
	@Override
	void getInformation(String color, double... x) {
		this.color = color;
		a = x[0];
	}

	@Override
	void paint() {
		System.out.print("the color of " + color + " is " + ( a * a + a * 1 *4 ) + "\n" );
	}
	
}
class Parallelogram extends Brick{
	double a, h;
	String color;
	@Override
	void getInformation(String color, double... x) {
		this.color = color;
		a = x[0];
		h = x[1];
	}

	@Override
	void paint() {
		System.out.print("the color of " + color + " is " + a * h / 2 + "\n" );
		// TODO Auto-generated method stub
		
	}}
public class FirstClass {
	public static void main(String args[]) {
		Brick brick[] = new Brick[7];
		
		for(int i = 0; i < 7; i ++) {
			brick[i] = new Triangle();
		}
		for(Brick bri : brick) {
			if(bri == null) {
				Error.errorWarn();
			}
		}
		brick[6] = new Squre();
		brick[5] = new Parallelogram();
	
		//the Parallelogram's paint
		brick[5].getInformation("yellow", 10, 10);
		
		//the squre's paint
		brick[6].getInformation("blue", 10);
		
		//the triangle's paint
		brick[0].getInformation("cyan", 20, 20);
		brick[1].getInformation("green", 20, 20);
		brick[2].getInformation("red", 10, 10);
		brick[3].getInformation("purple", 10, 10);
		brick[4].getInformation("orange", 1.414 * 10, 1.414 * 10);
		for(Brick b : brick) {
			b.paint();
		}							
	}
}
