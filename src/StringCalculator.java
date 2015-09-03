package src;

import java.util.Scanner;

public class StringCalculator {

	public static void main(String[] args) {
		System.out.println("Augfabe:");
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		while (S != "q") {
			try {
				System.out.println("Ergebnis:" + calc(S));
			} catch (java.lang.NumberFormatException E) {
				System.out.println("Ungltige Eingabe");
			}
			System.out.println("Augfabe:");
			S = sc.nextLine();
		}
		sc.close();
	}

	public static double calc(String S) throws java.lang.NumberFormatException {
		int a = S.indexOf("(");
		if (S == "")
			return (Double.NaN);
		if (a >= 0) {
			int b = S.indexOf(")", a);
			if (a + 1 == b)
				return (Double.NaN);
			return (calc(S.substring(0, a) + calc(S.substring(a + 1, b) + S.substring(b + 1, S.length()))));
		}
		a = S.indexOf("-");
		if (a > 0)
			return (calc(S.substring(0, a)) - calc(S.substring(a + 1, S.length())));

		a = S.indexOf("+");
		if (a > 0)
			return (calc(S.substring(0, a)) + calc(S.substring(a + 1, S.length())));

		a = S.indexOf("/");
		if (a > 0)
			return (calc(S.substring(0, a)) / calc(S.substring(a + 1, S.length())));

		a = S.indexOf("*");
		if (a > 0)
			return (calc(S.substring(0, a)) * calc(S.substring(a + 1, S.length())));

		a = S.indexOf("^");
		if (a > 0)
			return (Math.pow(calc(S.substring(0, a)), calc(S.substring(a + 1, S.length()))));

		return (Double.parseDouble(S));
	}

}