package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Driver {
	public static void main(String [] args) throws FileNotFoundException {
		Polynomial p = new Polynomial();
		System.out.println(p.evaluate(3));
		double [] c1 = {6,5};
		int [] e1 = {0,3};
		Polynomial p1 = new Polynomial(c1, e1);
		double [] c2 = {-2,-9};
		int [] e2 = {1,4};
		Polynomial p2 = new Polynomial(c2, e2);
		Polynomial s = p1.add(p2);
		System.out.println("s(0.1) = " + s.evaluate(0.1));
		if(s.hasRoot(1))
			System.out.println("1 is a root of s");
		else
			System.out.println("1 is not a root of s");
//		System.out.println("Before Multiplication:");
//		System.out.println("P1 coef:" +  Arrays.toString(p1.coef));
//		System.out.println("P1 exp: " +  Arrays.toString(p1.exp));
//		System.out.println("P2 coef: " + Arrays.toString(p2.coef));
//		System.out.println("P2 exp: " + Arrays.toString(p2.exp));

		Polynomial s1 = p1.multiply(p2);
//		System.out.println("After Multiplication:" + Arrays.toString(s1.coef) + Arrays.toString(s1.exp));

		File F = new File("data.txt");
		Polynomial l1 = new Polynomial(F);

	}
}