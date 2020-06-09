import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductList implements ActionListener {
    private  ArrayList<String> productList;
    private final String filePath ="./src/productList.txt";
    private FileReader fileReader;
    private FileWriter fileWriter;

    private  JComboBox productName;
    private  JLabel productNameLabel;
    private  Box productNameBox;

    private void populateProductList(){

        File file = new File(filePath);
        productList = new ArrayList<String>();

        int ch;
        String productName = "";

        try {
            fileReader = new FileReader(file);
            while ((ch=fileReader.read())!=-1){

               if((char)ch=='\n'){
                   productList.add(productName);
                   productName="";
                   continue;
               }
               productName+=(char)ch;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayList(){
        for(String item : productList){
            System.out.println(item);
        }
    }

    private  String[] getProductList(){
        populateProductList();
        return productList.toArray(new String[0]);

    }

    private void addProductNameToFile(String pName){
          FileUtilty.writeToFile(filePath,pName);
    }



    public Box getProductNameGUI(){
        productNameBox = Box.createHorizontalBox();
        productNameLabel = new JLabel("Product Name: ");
        productName = new JComboBox(getProductList());

        AddForm.product.setProductName((String) productName.getSelectedItem());
        productName.addActionListener(this);
        //productNameBox.add(productNameLabel);

        productName.setBorder(BorderFactory.createTitledBorder(null,
                "Product name",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION));

        productNameBox.add(productName);

        productNameBox.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        return productNameBox;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == productName){
            System.out.println("Selected productName: "+productName.getSelectedItem());
            String pName = (String) productName.getSelectedItem();
            AddForm.product.setProductName(pName);
        }
    }

}
