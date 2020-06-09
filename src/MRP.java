import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MRP {
    private  Box MRPBox;
    private Box outerBox;
    private  JLabel wholeSaleMRPLabel;
    private  JTextField wholesaleMRP;
    private  JLabel retailMRPLabel;
    private  JTextField retailMRP;

    public Box getMRPGUI(){

        MRPBox = Box.createHorizontalBox();
        outerBox = Box.createHorizontalBox();
        wholeSaleMRPLabel = new JLabel("WholeSale : ");
        wholesaleMRP = new JTextField();
        retailMRPLabel = new JLabel("Retail : ");
        retailMRP = new JTextField();
        //MRPBox.add(wholeSaleMRPLabel);
        MRPBox.add(wholesaleMRP);
        //
        // MRPBox.add(retailMRPLabel);
        MRPBox.add(retailMRP);

        wholesaleMRP.setBorder(BorderFactory.createTitledBorder(null,
                "Wholesale",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION));

        retailMRP.setBorder(BorderFactory.createTitledBorder(null,
                "Retail ",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION));

        MRPBox.setBorder(BorderFactory.createTitledBorder(null,
                "MRP ",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION));

        outerBox.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        outerBox.add(MRPBox);

        return outerBox;
    }

    public float getWholeSaleMRP(){
        String mrp = (String)wholesaleMRP.getText();
        if(!checkForFormat(mrp)){
            AddForm.areDetailsCorrect =false;
            AddForm.formatErrorMsg+="\nWholeSale MRP:"+mrp+"  [Error: Incorrect format...!]";
            return Float.parseFloat("0.0");
        }


        if(mrp.length()==0)mrp="0.0";
        return  Float.parseFloat(mrp);
    }


    public float getRetailMRP(){
        String mrp = (String)retailMRP.getText();
        if(!checkForFormat(mrp)){
            AddForm.areDetailsCorrect=false;
            AddForm.formatErrorMsg+="\nRetail MRP:"+mrp+"  [Error: Incorrect format...!]";
            return Float.parseFloat("0.0");
        }



        if(mrp.length()==0)mrp="0.0";
        return  Float.parseFloat(mrp);
    }

    private boolean checkForFormat(String str){
        boolean flag = false;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)=='.' && !flag){
                flag = true;
                continue;
            }
            else if(str.charAt(i)>'9' || str.charAt(i)<'0'){
                return false;
            }
        }
        return true;
    }

}
