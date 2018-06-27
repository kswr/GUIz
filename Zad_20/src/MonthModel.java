import java.time.LocalDate;
import java.util.ArrayList;

public class MonthModel extends javax.swing.AbstractListModel{
    private LocalDate now = LocalDate.now();
    private ArrayList<String> dates;



    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Object getElementAt(int index) {
        return null;
    }
}
