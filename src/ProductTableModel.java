import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private static final String[] columnNames = Product.headerTitles;
    private  Object[][] data ;

    public ProductTableModel(){

        int numberOfProducts = LoadProductDetailsFromFile.getNumberOfProducts();


        System.out.println("numberOfProducts:"+numberOfProducts);
        data = new Object[numberOfProducts][];

        ArrayList<Product> productArrayList = LoadProductDetailsFromFile.getProductDetailList();
        for (int i = 0; i <numberOfProducts ; i++) {
            Product currProduct = productArrayList.get(i);
            data[i] = new Object[]{
                    currProduct.getProductId(),
                    currProduct.getBatchNumber(),
                    currProduct.getProductName(),
                    currProduct.getProductCategory(),
                    currProduct.getExpiryDate().getExpiryMonth() +" , "+currProduct.getExpiryDate().getExpiryYear(),
                    currProduct.getWholesaleMRP(),
                    currProduct.getRetailMRP(),
                    currProduct.getProductSeller().getSellerName()
                           // +" , "+currProduct.getProductSeller().getSellerLocation()
            };

        }
    }


    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }


}
