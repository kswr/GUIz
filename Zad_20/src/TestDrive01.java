import java.time.*;
import java.util.ArrayList;
import java.util.Date;

public class TestDrive01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
//        Month month = now.getMonth();
//        System.out.println(now);
//        System.out.println(now.getDayOfMonth() + " " + now.getDayOfWeek().toString().toLowerCase());
//        System.out.println(now.lengthOfMonth());
//        LocalDate first = now.withDayOfMonth(1);
//        System.out.println(first);
        ArrayList<LocalDate> dates = new ArrayList<>();
        for (int i = 1; i <= now.lengthOfMonth(); i++) {
            dates.add(now.withDayOfMonth(i));
        }
        for (LocalDate date : dates) {
            System.out.println(date);
        }

    }
}
