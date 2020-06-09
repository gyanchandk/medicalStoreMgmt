import java.io.*;
import java.util.Properties;

public class TestBench {
    private  FileInputStream fin;
    private  FileOutputStream fout;
    private  Properties p;

    public TestBench(){
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
    public void setNumberOfRecords(int number){
        String count = String.valueOf(number);
        p.put("numberOfRecords",count);

        try {
            fout = new FileOutputStream("numbersOfRecords.dat");
            p.store(fout,"Number of product records");
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){

        TestBench t= new TestBench();
        System.out.println(t.getNumberOfRecords());
        t.setNumberOfRecords(987);
        System.out.println(t.getNumberOfRecords());


    }
}
