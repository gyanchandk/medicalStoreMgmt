import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ExpiryDate {
    private String expiryMonth;
    private int expiryYear;
    private  Box expiryDateBox;
    private Box outerBox;
    private  JLabel expiryDateLabel;

    public ExpiryDate(){
        this.setExpiryYear(-1);
        this.setExpiryMonth("xxxxxx");
    }

    public Box getExpiryDateGUI(){
        expiryDateBox = Box.createHorizontalBox();
        outerBox = Box.createHorizontalBox();
        expiryDateLabel = new JLabel("Expiry Date: ");
        //expiryDateBox.add(expiryDateLabel);

        MonthList monthListGUI = new MonthList();
        expiryDateBox.add(monthListGUI.getMonthListGUI());

        YearList yearListGUI = new YearList();
        expiryDateBox.add(yearListGUI.getYearListGUI());

        expiryDateBox.setBorder(BorderFactory.createTitledBorder(null,
                "Expiry date",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION));

        outerBox.add(expiryDateBox);

        outerBox.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        return outerBox;

    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

}
