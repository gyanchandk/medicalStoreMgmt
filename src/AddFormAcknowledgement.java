import javax.swing.*;

public class AddFormAcknowledgement  {
    private JFrame frame;
    private int reply;
    public AddFormAcknowledgement(String message,String productDetail){
        frame = new JFrame();
        Object[] options = {"Yes, please",
                "Go back"};

         reply = JOptionPane.showOptionDialog(frame,
                message,
                "Form details acknowledgement",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title


        if(reply==JOptionPane.YES_OPTION){
            System.out.println("confirmed");
            FileUtilty.writeToFile("./src/productDetail.txt",productDetail);
            new NumberOfRecords().incrementNumberOfRecords();
            AddForm.frame.dispose();

        }
        else if(reply == JOptionPane.NO_OPTION){
            System.out.println("rejected!!!!!!!!!");
        }

    }

    public static void main(String args[]){
        //new AddFormAcknowledgement("Form details are :","xxxx");
    }


}
