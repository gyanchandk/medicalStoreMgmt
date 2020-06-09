import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class YearList implements ActionListener {
    private  String[] yearList;
    public  final int yearRange = 20;
    private  JComboBox expiryYear;

    public YearList(){
        populateYearList();

    }
    private void populateYearList(){
        Calendar calendar = Calendar.getInstance();
        int startYear = calendar.get(Calendar.YEAR)-(yearRange/2);
        int endYear = startYear + yearRange ;

        yearList = new String[endYear-startYear];
        for (int i=endYear,j=0; i >startYear ; i--,j++) {
            yearList[j]= String.valueOf(i);
        };
    }
    public  String[] getYearList(){
        return yearList;
    }

    public JComboBox getYearListGUI(){
        expiryYear = new JComboBox(getYearList());
        expiryYear.addActionListener(this);
        expiryYear.setSelectedIndex(yearRange/2);

        int selectedYear = Integer.parseInt((String)expiryYear.getSelectedItem());
        AddForm.expiryDate.setExpiryYear(selectedYear);

        return expiryYear;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Selected year: "+expiryYear.getSelectedItem());
        int year = Integer.parseInt((String)expiryYear.getSelectedItem());
        AddForm.expiryDate.setExpiryYear(year);
    }
}
