package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Polynomial {
    public double[] coef;
    public int[] exp;

    public Polynomial() {
        coef = new double[]{0};
        exp = new int[]{0};
    }

    public Polynomial(double[] array, int[] powers) {
        coef = array;
        exp = powers;
    }

    public Polynomial(File f) throws FileNotFoundException {
        Scanner input = new Scanner(f);
        System.out.println("File path: " + f.getAbsolutePath());

    }

    public Polynomial add(Polynomial poly) {
        int degmax = Math.max(this.exp[this.exp.length - 1], poly.exp[poly.exp.length - 1]);
        int[] expnew = new int[degmax + 1];
        double[] coefnew = new double[degmax + 1];

        // we shall now add everything from this poly to our arrays above
        for(int i = 0; i < this.coef.length; i++) {
            coefnew[this.exp[i]] += this.coef[i];
        }
        // we now do the same thing for our poly in our argument of this function
        for(int i = 0; i < this.coef.length; i++) {
            coefnew[i] += poly.coef[i];
        }
        // we now hopefully have added the coef of both
        int short_len = 0;
        for (int i = 0; i < coefnew.length; i++) {
            if (coefnew[i] != 0) {
                expnew[short_len] = i;
                short_len++;
            }
        }

        int[] short_exp = new int[short_len];
        double[] short_coef = new double[short_len];
        System.arraycopy(expnew, 0, short_exp, 0, short_len);
        System.arraycopy(coefnew, 0, short_coef, 0, short_len);

        return new Polynomial(short_coef, short_exp);
    }
    public double evaluate(double x) {
        double solved_coef = 0.0;

        for(int i = 0; i < this.coef.length; i++) {
            if(this.exp[i] == 0) {
                solved_coef += this.coef[i];
            } else {
                solved_coef += this.coef[i] * Math.pow(x, this.exp[i]);
            }
        }
        return solved_coef;
    }
    
    public boolean hasRoot(double x){
        double dog = this.evaluate(x);
        return dog == 0;
    }

    public Polynomial multiply (Polynomial poly) {
        // to predict the final size of the polynomial, we must add in the highest degree of both polynomial with each other
        int max1 = this.exp[this.exp.length - 1];
        int max2 = poly.exp[poly.exp.length - 1];
        int max3 = max1 + max2;

        double[] mulcoef = new double[max3 + 1];
        int[] mulexp = new int[max3 + 1];

        for(int i = 0; i < this.coef.length; i++) {
            for(int j = 0; j < poly.coef.length; j++) {
                int check_exp = this.exp[i] + poly.exp[j];
                mulcoef[check_exp] += this.coef[i] * poly.coef[j];
            }
        }
        // copying exp
        int short_len = 0;
        for (int i = 0; i < mulcoef.length; i++) {
            if (mulcoef[i] != 0) {
                mulexp[short_len] = i;
                short_len++;
            }
        }
        // copying coef
        double[] short_coef = new double[short_len];
        int next = 0;
        for (int i = 0; i < mulcoef.length; i++) {
            if (mulcoef[i] != 0) {
                short_coef[next] += mulcoef[i];
                next++;
            }
        }
        int[] short_exp = new int[short_len];
        System.arraycopy(mulexp, 0, short_exp, 0, short_len);
        return new Polynomial(short_coef, short_exp);
    }

    public void saveToFile (String s) {

    }
}
