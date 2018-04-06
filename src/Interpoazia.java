import java.util.ArrayList;
import java.util.Comparator;

public class Interpoazia {
    ArrayList<Double> x;
    ArrayList<Double> y;

    static private class nominator{
       double xn;
       nominator(double xn){
           this.xn=xn;
       }

       public Double count(double x){
           return x-xn;
       }
    }

    ArrayList<nominator> Nominators=new ArrayList<>();

    public Interpoazia(ArrayList<Double> x,ArrayList<Double> y) {
        this.x = x;
        this.y = y;
        getReady();
    }

    private void getReady() {
        for (int i = 0; i < x.size(); i++) {
            Nominators.add(new nominator(x.get(i)));
        }
    }

    public ArrayList<Proj.point> getPoints(int count){

        ArrayList<Proj.point> Points=new ArrayList<>();
        for (int i=0;i<x.size();i++){Points.add(new Proj.point(x.get(i),y.get(i)));}

        ArrayList<Double> X=x;
        X.sort(Comparator.naturalOrder());
        Double length=(X.get(X.size()-1)-X.get(0))/count;
        Double Y;
        System.out.println(length);
        for (double x1=X.get(0);x1<X.get(X.size()-1);){
            Y=0.0;
            for(int i=0;i<X.size();i++){
                Double sum=1.0;
                for (int j=0;j<X.size();j++){
                    if (i!=j){
                        sum*=Nominators.get(j).count(x1)/(x.get(i)-x.get(j));
                    }
                }
                Y+=sum*y.get(i);

            }

            Points.add(new Proj.point(x1,Y));
            x1+=length;
        }
        return Points;
    }
}
