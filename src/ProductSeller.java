import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductSeller implements ActionListener {
    private String sellerName;
    private String GSTNumber;
    private String sellerLocation;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailAddress;
    public static final int productSellerFieldCount = 6;
    private static ArrayList<String> sellerNames;
    private static final String filePath = "./src/sellerNames.txt";
    private static FileReader fileReader;

    private Box sellerBox;
    private ButtonGroup btnGrp;
    public ProductSeller() {
        this.setSellerName("xxxxxx");
        this.setGSTNumber("xxxxxx");
        this.setSellerLocation("xxxxxx");
        this.setContactNumber("0000000000");
        this.setAlternateContactNumber("0000000000");
        this.setEmailAddress("xxx@xxx.com");


        sellerBox = Box.createVerticalBox();
        btnGrp = new ButtonGroup();


    }

    public Box getProductSellerGUI(){
        String[] names = getSellerNames();
        for (String name:names) {
            JRadioButton btn = new JRadioButton(name);
            sellerBox.add(btn);
            btnGrp.add(btn);
            btn.addActionListener(this);

        }

        sellerBox.setBorder(BorderFactory.createTitledBorder(null,
                "Seller name",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION));
        return sellerBox;

    }

    private static void populateSellers(){
        File file = new File(filePath);
        sellerNames = new ArrayList<String>();

        try {
            fileReader = new FileReader(file);
            String sellerName = "";
            int ch;
            while ((ch=fileReader.read())!=-1){

                if((char)ch=='\n'){
                    sellerNames.add(sellerName);
                    sellerName="";
                    continue;
                }
                sellerName+=(char)ch;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getSellerNames(){
        populateSellers();
        return sellerNames.toArray(new String[0]);
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setGSTNumber(String GSTNumber) {
        this.GSTNumber = GSTNumber;
    }

    public String getGSTNumber() {
        return GSTNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setAlternateContactNumber(String alternateContactNumber) {
        this.alternateContactNumber = alternateContactNumber;
    }

    public String getAlternateContactNumber() {
        return alternateContactNumber;
    }

    public void setSellerLocation(String sellerLocation) {
        this.sellerLocation = sellerLocation;
    }

    public String getSellerLocation() {
        return sellerLocation;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static void main(String[] args){
        new ProductSeller();
        String[] names= getSellerNames();
        for (String name: names) {
            System.out.println(name);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //System.out.println(actionEvent.getSource());
        System.out.println(actionEvent.getActionCommand());
        AddForm.productSeller.setSellerName(actionEvent.getActionCommand());
    }
}
