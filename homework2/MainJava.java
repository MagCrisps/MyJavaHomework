package homework2pac;

import java.nio.channels.NonWritableChannelException;
import java.util.Scanner;

class Subject{
	int score[] = new int[6];//each subject's score
	int sumScore = 0;//total score
	int sum() {
		for(int x:score)
			sumScore += x;
		return sumScore;
	}
	void  enArrC(Students stu[]) {
		int i, j, max;
		for(i = 0; i < stu.length - 1; i ++) {
			max = i;
			for(j = i + 1; j < stu.length; j ++) {
				if (stu[j].sumSco > stu[max].sumSco) {
					max = j;
				}
			}
			if (max != i) {
				Students temp = stu[i];
				stu[i] = stu[max];
				stu[max] = temp;
			}
		}
	}
}
class Students{
	String name;
	long number;
	int sumSco;
	Scanner scan = new Scanner(System.in);
	static Subject subject = new Subject();
	void getInformation() {
		System.out.print("请输入学生姓名：\n");
		name = scan.nextLine();
		System.out.print("请输入学生学号：\n");
		number = scan.nextInt();
		System.out.print("请分别输入学生六门课程分数（以回车结束每次输入）：\n");
		for(int i = 0; i < 6;i ++) {
			subject.score[i] = scan.nextInt();
		}
		sumSco = subject.sum();
		System.out.print("该同学的各门分数统计完成\n");
	}
	static void getArr(Students[] arr){
		subject.enArrC(arr);//get arr of student
	}
}
public class MainJava {
	public static final int PEOPLE = 10;
	static void fun() {
		Students stu[] = new Students[PEOPLE];
		for(int i = 0; i < PEOPLE; i ++) {
			stu[i] = new Students();
		}
		int arrNum = 0;
		for(Students st : stu) {
			st.getInformation();
		}
		Students.getArr(stu);
		System.out.println("学生的排名 姓名 学号 总分数\n");
		for(Students st : stu) {
			System.out.print((++arrNum) + " "+ st.name + " " + st.number  + " " + st.sumSco + "\n");
		}
	}
	
	public static void main(String arg[]) {
		//fun();
		Error error = new Error();
		//Error.errorWarn();
		test tes = new test();
		//tes.dogTestDrive();
		//tes.fuction();
		CalculateToatalArea cTA = new CalculateToatalArea();
		
		cTA.calculateBarrells(6);
	}	
}