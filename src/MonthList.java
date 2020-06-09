import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class MonthList implements ActionListener {

    private  JComboBox expiryMonth;
    private final String[] monthList={
            "JANUARY",
            "FEBRUARY",
            "MARCH",
            "APRIL",
            "MAY",
            "JUNE",
            "JULY",
            "AUGUST",
            "SEPTEMBER",
            "OCTOBER",
            "NOVEMBER",
            "DECEMBER"
    };
    public static final int monthIndex = Calendar.MONTH;

    public MonthList(){

    }
    public String[] getMonthList(){
        return monthList;
    }

    public  JComboBox getMonthListGUI(){
        expiryMonth = new JComboBox(getMonthList());
        expiryMonth.setSelectedIndex(monthIndex);

        String selectedMonth = (String) expiryMonth.getSelectedItem();
        AddForm.expiryDate.setExpiryMonth(selectedMonth);

        expiryMonth.addActionListener(this);
        return expiryMonth;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("selected month: "+expiryMonth.getSelectedItem());
        String month = (String) expiryMonth.getSelectedItem();
        AddForm.expiryDate.setExpiryMonth(month);
    }
}
