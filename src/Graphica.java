import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Graphica extends Frame implements ComponentListener{
    private static final long serialVersionUID = 1L;
    private double a=-10,b=10;
    private ArrayList<Double> x, y;
    private Double a1, b1;
    private int num;



    private Graphica() throws HeadlessException {
    }


    private void draw2points(Graphics g,double x1,double y1,double x2,double y2){
        int a1,b1,a2,b2;
        int width=getWidth();
        int height=getHeight()+20;
        double s=(b-a)/2;
        a1=(int)((x1-a)/(b-a)*width);
        b1=(int)((s-y1)/(b-a)*height);
        a2=(int)((x2-a)/(b-a)*width);
        b2=(int)((s-y2)/(b-a)*height);
        g.drawLine(a1,b1,a2,b2);
    }

    public void paint(Graphics g){
        //draw axes
        int width=getWidth();
        int height=getHeight()+20;
        g.setPaintMode();
        g.setColor(Color.black);
        g.drawLine(height/2-370,0,height/2 -370,width-5);
        g.drawLine(5,height/2,width-5,height/2);
        g.setColor(Color.red);
        //draw graph
        double prevx,prevy = 0;
        prevx = x.get(0); prevy = y.get(0);
        for (int i=0; i<x.size(); i++){

            draw2points(g,prevx,prevy,x.get(i),y.get(i));
            prevx=x.get(i);
            prevy=y.get(i);

        }
        //draw line
        {
            g.setColor(Color.GREEN);
            double x1, y1, dx;
            x1 = a;
            dx = (double) (b - a) / 1000;
            y1 = a1*x1 + b1;
            while (x1 <= b) {
                prevx = x1;
                prevy = y1;
                x1 += dx;
                y1 = a1*x1+b1;
                if ((!Double.isNaN(y1)) && (!Double.isNaN(prevy)))
                    draw2points(g, prevx, prevy, x1, y1);
            }
        }

    }

    public boolean handleEvent(Event evt){
        if(evt.id == Event.WINDOW_DESTROY) {
            dispose();
            return true;
        }
        else
            return super.handleEvent(evt);
    }

    Graphica(ArrayList<Double> x, ArrayList<Double> y, int num, Double a, Double b) {
        Graphica fr = new Graphica();

        fr.x = x;
        fr.y = y;
        fr.num = num;
        fr.a1 = a;
        fr.b1 = b;
        fr.a = Collections.min(x).doubleValue()-1;
        fr.b = Collections.max(x).doubleValue()+1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fr.setResizable(false);
        fr.setMinimumSize(new Dimension(1000,1000));
        fr.setSize(new Dimension(500,200));
        fr.setTitle("Graph");
        fr.setVisible(true);
        fr.addComponentListener(fr);
        fr.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){System.exit(0);}
        });
        fr.repaint();
    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}