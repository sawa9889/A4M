import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Files {
    private static final String fileLocation = System.getProperty("user.dir");
    private ArrayList<Double> x = new ArrayList<>();
    private ArrayList<Double> y = new ArrayList<>();

    public ArrayList<Double> getX() {
        return x;
    }

    public ArrayList<Double> getY() {
        return y;
    }

    public Files(String fileName) {
        File file = new File(fileLocation + "\\" + fileName);
        readFileCoordX(file);
    }
    private  ArrayList<Double> readFileCoordX(File file){//считывание файла
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String line;
                String arr[] = null;
                while ((line = in.readLine()) != null) {
                   arr = line.split(" ");
                }
                for (String s : arr) {
                    s = s.replace("(","").replace(")","");
                    x.add(Double.valueOf(s.split(",")[0]));
                    y.add(Double.valueOf(s.split(",")[1]));
                }
            } finally {
                in.close();
            }
        } catch(IOException| NullPointerException e) {
            e.getStackTrace();
        }
        return x;
    }

}
