import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BatchNumber {
    private Box batchNumberBox;
    private JLabel batchNumberLabel;
    private JTextField batchNumberTextField;

    public Box getBatchNumberGUI(){
        batchNumberBox = Box.createHorizontalBox();
        batchNumberLabel = new JLabel("Batch Number: ");
        batchNumberTextField = new JTextField(AddForm.fieldWidth);
        //batchNumberBox.add(batchNumberLabel);
        batchNumberBox.add(batchNumberTextField);

        batchNumberTextField.setBorder(BorderFactory.createTitledBorder(null,
                        "Batch number",
                        TitledBorder.DEFAULT_JUSTIFICATION,
                        TitledBorder.DEFAULT_POSITION));

        batchNumberBox.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        return batchNumberBox;
    }

    public String getBatchNumber(){
        String batchNumber = batchNumberTextField.getText();
        return (batchNumber.length()>0)?batchNumber:"xxxxxxx";
    }
}
