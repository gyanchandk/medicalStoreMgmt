import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static java.awt.BorderLayout.*;

public class AddForm extends JFrame implements WindowListener {

    public static Product product;
    public static ExpiryDate expiryDate;
    public static ProductSeller productSeller;

    public static BatchNumber batchNumberGUI;
    public static MRP mrpGUI;
    public static ProductSeller productSellerGUI;
    public static boolean areDetailsCorrect = true;
    public static String formatErrorMsg ="";

    public static Container container;
    public static final int fieldWidth = 25;
    public static  JFrame frame;
    public AddForm() {
        frame = new JFrame();
        product = new Product();
        expiryDate = new ExpiryDate();
        productSeller = new ProductSeller();

        //container = getContentPane();
        setTitle("Add Product Details");
        setLayout(new FlowLayout());
        setBounds(300,100,600,600);
        setResizable(true);

        Box mainBox = Box.createVerticalBox();

        batchNumberGUI = new BatchNumber();
        mainBox.add(batchNumberGUI.getBatchNumberGUI());

        ProductList productNameGUI = new ProductList();
        mainBox.add(productNameGUI.getProductNameGUI());

        ProductCategory productCategoryGUI = new ProductCategory();
        mainBox.add(productCategoryGUI.getProductCategoryGUI());

        ExpiryDate expiryDateGUI = new ExpiryDate();
        mainBox.add(expiryDateGUI.getExpiryDateGUI());

        mrpGUI = new MRP();
        mainBox.add(mrpGUI.getMRPGUI());

        productSellerGUI = new ProductSeller();
        mainBox.add(productSellerGUI.getProductSellerGUI());

        AddFormSubmitBtn submitBtnGUI = new AddFormSubmitBtn();
        mainBox.add(submitBtnGUI.getSubmitBtnGUI());

        frame.add(mainBox);

        //pack();
        setVisible(true);




    }

    public static void main(String[] args){
        new AddForm();
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
