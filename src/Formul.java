import java.util.ArrayList;

public class Formul {

    private ArrayList<Double> x= new ArrayList<>();
    private ArrayList<Double> y= new ArrayList<>();

    Formul(ArrayList<Double> x, ArrayList<Double> y){
        this.x=x;
        this.y=y;
    }

    public Double countA(){

        ArrayList<Double> xy=new ArrayList<>();
        for (int a=0;a<x.size();a++){
            xy.add(x.get(a)*y.get(a));
        }

        ArrayList<Double> x2=new ArrayList<>();
        for (Double b:x){
            x2.add(b*b);
        }

        int n=x.size();

        return (n*sum(xy)-sum(x)*sum(y))/(n*sum(x2)-sum(x)*sum(x));
    }

    public Double countB(){
        int n=x.size();
        return (sum(y)-countA()*sum(x))/n;
    }

    public double sum(ArrayList<Double> array){
        double sum=0;
        for (Double a:array){
            sum+=a;
        }
        return sum;
    }
}
