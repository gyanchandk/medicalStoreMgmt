import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadProductDetailsFromFile {
    private static FileReader fileReader;
    private static final String filePath = "./src/productDetail.txt";
    private static final String endMarker ="#";
    private static ArrayList<Product> productArrayList;
    private static int numberOfProducts;

    public LoadProductDetailsFromFile(){
        productArrayList = new ArrayList<Product>();
        numberOfProducts = 0;
        openProductDetailsFile();
        loadDetailsFromFile();

    }

    public static int getNumberOfProducts(){
        return numberOfProducts;
    }
    public static ArrayList<Product> getProductDetailList(){
        return productArrayList;
    }

    private void loadDetailsFromFile(){

        int ch;
        try {
            String line="";
            while ((ch=fileReader.read())!=-1){
                if((char)ch=='\n'){
                    System.out.println("loadDetailsFromFile:"+line);
                    String[] info = line.split(endMarker,Product.fieldCount);
                    if(info.length < Product.fieldCount){
                        continue;
                    }
                    else{
                        productArrayList.add(stringToProductObject(info));
                        numberOfProducts+=1;
                    }
                    line="";
                    continue;
                }
                line+=(char)ch;

            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void openProductDetailsFile(){
        File file = new File(filePath);
        try {
            fileReader = new FileReader(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product stringToProductObject(String[] info){
        System.out.println("stringToProductObject:"+info[0]);
        Product productDetail = new Product();
        productDetail.setDetail(info);

        return productDetail;
    }

    public void print(){
        for(Product product : productArrayList){
            System.out.println(product.getProductName());

        }
    }

}
