import javax.swing.*;
import java.awt.*;

public class DisplayProductDetails extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;
    private Container container;
    public DisplayProductDetails(){
        setTitle("Product Details");
        setBounds(300, 90, 1200, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        container = getContentPane();
        table = new JTable(new ProductTableModel());
        scrollPane = new JScrollPane(table);
        container.add(scrollPane,BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args){
        new LoadProductDetailsFromFile();
        new ProductTableModel();
        new DisplayProductDetails();
    }
}
