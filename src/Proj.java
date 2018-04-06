import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;


public class Proj {

    static public class point{
        private Double x;
        private Double y;

        public point(Double x, Double y) {
            this.x = x;
            this.y = y;
        }

        public Double getX() {
            return x;
        }

        public void setX(Double x) {
            this.x = x;
        }

        public Double getY() {
            return y;
        }

        public void setY(Double y) {
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Formul formula;
        ArrayList<Double> x= new ArrayList<>() ;
        ArrayList<Double> y= new ArrayList<>();
        ArrayList<point> points=new ArrayList<>();
//        Scanner in = new Scanner(System.in);
//        in.useLocale(Locale.US);
//        System.out.println("Num of iterations: ");
//        int countOfNum = in.nextInt();
//        for(int i=0; i<countOfNum; i++){
//            System.out.println("X:");
//            Double xn = in.nextDouble();
//            System.out.println("Y:");
//            Double yn = in.nextDouble();
//            x.add(xn);
//            y.add(yn);
//        }

        int countOfNum=0;
        Files coord = new Files("coordinates.txt");
        x = coord.getX();
        y = coord.getY();
        for (int i=0;i<x.size();i++){
            points.add(new point(x.get(i),y.get(i)));
        }
        countOfNum = x.size();
        formula = new Formul(x, y);
        System.out.println("a=" + formula.countA());
        System.out.println("b=" + formula.countB());
        Interpoazia inter=new Interpoazia(x,y);
        ArrayList<point> Points=inter.getPoints(100);

        Points.sort(new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                if (o1.getX()>o2.getX()){
                    return 1;
                }else
                {
                    return -1;
                }
            }
        });

        for (point point:Points){
            System.out.println(point.x);
            System.out.println(point.y);
            System.out.println();
        }
        x=new ArrayList<>();
        y=new ArrayList<>();
        for (int i=0;i<Points.size();i++){
            x.add(Points.get(i).getX());
            y.add(Points.get(i).getY());
        }
        Graphica graphica = new Graphica(x, y, countOfNum, formula.countA(), formula.countB());
    }
}
