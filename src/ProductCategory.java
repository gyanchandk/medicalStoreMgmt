import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductCategory implements ActionListener {
    private  ArrayList<String> productCategory;
    private  final String filePath = "./src/productCategory.txt";
    private  FileReader fileReader;
    private  Box productCategoryBox;
    private  JLabel productCategoryLabel;
    private   JComboBox category;

    public ProductCategory(){
        productCategory = new ArrayList<String>();
        openProductCategoryFile();
        loadFromProductCategoryFile();
    }

    private void loadFromProductCategoryFile(){
        int ch;
        try {
            String line="";
            while ((ch=fileReader.read())!=-1){
                if((char)ch=='\n'){
                    //System.out.println(line+"\n");
                    productCategory.add(line);
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

    private void openProductCategoryFile(){
        File file = new File(filePath);
        try {
            fileReader = new FileReader(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] getProductCategoryList(){
        return productCategory.toArray(new String[0]);
    }
    private void addToProductCategoryFile(String category){

    }

    public  Box getProductCategoryGUI(){
        productCategoryBox = Box.createHorizontalBox();
        productCategoryLabel = new JLabel("Category: ");
        category = new JComboBox(getProductCategoryList());
        AddForm.product.setProductCategory((String) category.getSelectedItem());
        category.addActionListener(this);
        //productCategoryBox.add(productCategoryLabel);

        category.setBorder(BorderFactory.createTitledBorder(null,
                "Category",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION));

        productCategoryBox.add(category);

        productCategoryBox.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        return productCategoryBox;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Selected category: "+category.getSelectedItem());
        String pCategory = (String) category.getSelectedItem();
        AddForm.product.setProductCategory(pCategory);
    }
}
