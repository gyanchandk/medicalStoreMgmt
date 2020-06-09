import javax.swing.*;

public class WrongFormatDialog {
    JFrame frame;
    private int reply;
    public WrongFormatDialog(String message){
        frame = new JFrame();
        Object[] options = {"OK"};

        reply = JOptionPane.showOptionDialog(frame,
                message,
                "Form details acknowledgement",
                JOptionPane.YES_OPTION,
                JOptionPane.ERROR_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title


        if(reply==JOptionPane.YES_OPTION){
            System.out.println("confirmed!");
        }
        else if(reply == JOptionPane.NO_OPTION){
            System.out.println("rejected!!!!!!!!!");
        }
    }

    public static void main(String args[]){
        new WrongFormatDialog("wrong retail mrp");
    }
}
