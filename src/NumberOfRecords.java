import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class NumberOfRecords {
    private FileInputStream fin;
    private FileOutputStream fout;
    private Properties p;

    public NumberOfRecords(){
        p = new Properties();
    }
    public int getNumberOfRecords(){
        try {
            fin = new FileInputStream("numbersOfRecords.dat");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(fin!=null){
            try {
                p.load(fin);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return Integer.parseInt(p.getProperty("numberOfRecords"));
    }
    public void incrementNumberOfRecords(){
        String count = String.valueOf(getNumberOfRecords()+1);
        p.put("numberOfRecords",count);

        try {
            fout = new FileOutputStream("numbersOfRecords.dat");
            p.store(fout,"Number of product records");
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
