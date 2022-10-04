import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        LocalDate currentDate = LocalDate.now();
        Date date = java.sql.Date.valueOf(currentDate);
        long realtime = date.getTime() + 604800000;
        System.out.println(formatter.format(date));
        System.out.println(realtime);
    }
}
