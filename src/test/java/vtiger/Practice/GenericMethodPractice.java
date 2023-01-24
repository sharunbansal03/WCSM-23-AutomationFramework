package vtiger.Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
		add(100, 200);
		System.out.println(add(300, 20));
		int a = multiply(2, 7);
		System.out.println(a);
	}

	// Add two integer numbers
	public static int add(int a, int b) {
		int c = a + b;
		return c;
	}

	// Subtract two integer numbers
	public static int subtract(int a, int b) {
		return a - b;
	}

	// multiply two numbers
	public static int multiply(int a, int b) {
		return a * b;
	}

}
