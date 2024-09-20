public class Polynomial {
    public double[] coef;

    public Polynomial() {
        coef = new double[]{0};
    }

    public Polynomial(double[] array) {
        coef = array;
    }

    public Polynomial add(Polynomial poly) {
        int len = this.coef.length;
        int len2 = poly.coef.length;
        int MaxLen = 0;
        if(len >= len2){MaxLen = len;}
        if(len2 >= len){MaxLen = len2;}
        double[] nice = new double[MaxLen];

        for(int i = 0; i < MaxLen; i++){
            if(i < len){
                nice[i] += this.coef[i];
            }
            if(i < len2){
                nice[i] += poly.coef[i];
            }
        }

        Polynomial uno = new Polynomial(nice);
        return uno;
    }
    public double evaluate(double x) {
        int len = this.coef.length;
        double[] nice = new double[len];
        double cat = 0.0;

        if(len == 2){
            cat = this.coef[0] + this.coef[1]*x;
            return cat;
        }

        if(len == 1){
            return this.coef[0];
        }
        double expo = x;
        for(int i = 0; i < len ; i++){
            nice[i] = this.coef[i];

            if(i >= 2){
                expo *= x;
                nice[i] = nice[i] * expo;
            }
            else{
                if(i == 1){
                    nice[i] = nice[i] * x;
                }
            }
        }
        //now we sum everything in nice and save it in another double
        for(int i = 0; i < len; i++){
            cat = nice[i] + cat;
        }
        return cat;
    }
    
    public boolean hasRoot(double x){
        double dog = this.evaluate(x);
        double cat = 0;
        if (dog == 0){
            return true;
        }
        else{
            return false;
        }
    }

}