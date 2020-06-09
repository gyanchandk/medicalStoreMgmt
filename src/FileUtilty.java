import java.io.*;

public class FileUtilty {
    public static final String endMarker="#";

    public static void writeToFile(String filePath,String information){

        try {
            File file = new File(filePath);

            if(file.exists()){
                System.out.println(filePath+"exists");
            }else{
                System.out.println(filePath+"does not exists");
            }
            FileWriter fileContext = new FileWriter(file,true);
            writeIntoFile(fileContext,information);
            writeIntoFile(fileContext,"\n");
            fileContext.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void writeIntoFile(FileWriter fileWriter,String information){
        try {
            for (int i = 0; i <information.length() ; i++) {
                fileWriter.write(information.charAt(i));
                System.out.println("writeIntoFile"+information.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




//    public static void main(String []args){
//        String pathName= "./src/productList.txt";
//        String[] names={"glucose","abhyariisth"};
//
//
//
//    }

}



