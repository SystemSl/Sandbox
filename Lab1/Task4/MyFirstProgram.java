import myfirstpackage.*;

class MyFirstClass {
	public static void main(String[] s) {
		MySecondClass Numbers = new MySecondClass(1, 2);
		System.out.println(Numbers.RemainderOfTheDivision());
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
			Numbers.SetArg1(i);
			Numbers.SetArg2(j);
			System.out.print(Numbers.RemainderOfTheDivision());
			System.out.print(" ");
			}
		System.out.println();
		}
	}
}