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

class MySecondClass {
	private int arg1;
	private int arg2;
	public void SetArg1(int n) {
		arg1 = n;
	}
	public void SetArg2(int n) {
		arg2 = n;
	}
	public int GetArg1() {
		return arg1;
	}
	public int GetArg2() {
		return arg2;
	}
	public MySecondClass(int n1, int n2) {
		arg1 = n1;
		arg2 = n2;
	}
	public int RemainderOfTheDivision() {
		return (arg1 % arg2);
	}
}