import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFormSubmitBtn implements ActionListener {
    private Box submitBox;
    private JButton submitBtn;
    private final String endMarker ="#";

    public Box getSubmitBtnGUI(){
        submitBox = Box.createHorizontalBox();
        submitBtn = new JButton("Add product");
        submitBox.add(submitBtn);
        submitBtn.addActionListener(this);

        submitBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        submitBox.setBorder(BorderFactory.createEmptyBorder(10,10,10,0));
        return submitBox;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Add form submission requested!");

        AddForm.formatErrorMsg="";
        AddForm.areDetailsCorrect=true;

        AddForm.product.setExpiryDate(AddForm.expiryDate);
        AddForm.product.setProductSeller(AddForm.productSeller);

        Product product = AddForm.product;
        product.setBatchNumber(AddForm.batchNumberGUI.getBatchNumber());
        product.setWholesaleMRP(AddForm.mrpGUI.getWholeSaleMRP());
        product.setRetailMRP(AddForm.mrpGUI.getRetailMRP());



        String message = "Batch number: "+product.getBatchNumber()+"\n"
                        +"Product name: "+product.getProductName()+"\n"
                        +"Category: "+product.getProductCategory()+"\n"
                        +"Expiry date: "+product.getExpiryDate().getExpiryMonth()+","
                        +product.getExpiryDate().getExpiryYear()+"\n"
                        +"Wholesale MRP: "+product.getWholesaleMRP()+"\n"
                        +"Retail MRP: "+product.getRetailMRP()+"\n"
                        +"Seller: "+product.getProductSeller().getSellerName();

        //BN103#paracetamol#TABLET#JUNE,2020#5.00#10.00# vikash,gstin1234,kotma,1234567890,234234556,xyz@gamil.com#2
        //b1235#nimuset#CAPSULE#SEPTEMBER,2021#19.0#17.0#rajendra medical

        String productDetail =product.getBatchNumber()+endMarker
                +product.getProductName()+endMarker
                +product.getProductCategory()+endMarker
                +product.getExpiryDate().getExpiryMonth()+","
                +product.getExpiryDate().getExpiryYear()+endMarker
                +product.getWholesaleMRP()+endMarker
                +product.getRetailMRP()+endMarker
                +product.getProductSeller().getSellerName()+endMarker
                +product.getProductId();


        if(AddForm.areDetailsCorrect==false){
            new WrongFormatDialog(AddForm.formatErrorMsg);
        }else{
            AddFormAcknowledgement dialog = new AddFormAcknowledgement(message,productDetail);
        }


    }
}
