package ec.com.learning.java8.dateAoi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    public void verify(int version) {
        if (version == 7) {
            Calendar date1 = Calendar.getInstance();
            Calendar date2 = Calendar.getInstance();
            date1.set(1991, 0, 21);
            System.out.println("After: " + date1.after(date2));
        } else if (version == 8) {
            LocalDate date1 = LocalDate.of(1991, 01, 21);
            LocalDate date2 = LocalDate.now();
            System.out.println("isAfter LocalDate: " + date1.isAfter(date2));
            System.out.println("isBefore LocalDate: " + date1.isBefore(date2));

            LocalTime time1 = LocalTime.of(22, 30, 50);
            LocalTime time2 = LocalTime.now();
            System.out.println("isAfter LocalTime: " + time1.isAfter(time2));
            System.out.println("isBefore LocalTime: " + time1.isBefore(time2));

            LocalDateTime dateTime1 = LocalDateTime.of(1991, 01, 21, 22, 30, 5);
            LocalDateTime dateTime2 = LocalDateTime.now();
            System.out.println("isAfter LocalDateTime: " + dateTime1.isAfter(dateTime2));
            System.out.println("isBefore LocalDateTime: " + dateTime1.isBefore(dateTime2));
        }
    }

    // currentTimeMillis
    public void measureTime(int version) throws InterruptedException {
        if (version == 7) {
            long init = System.currentTimeMillis();
            Thread.sleep(1000);
            long end = System.currentTimeMillis();
            System.out.println(end - init);
        } else if (version == 8) {
            Instant init = Instant.now();
            Thread.sleep(1000);
            Instant end = Instant.now();
            System.out.println(Duration.between(init, end).toMillis());
        }
    }

    public void periodBetweenDates(int version) {
        if (version == 7) {
            Calendar birth = Calendar.getInstance();
            Calendar now = Calendar.getInstance();

            birth.set(1991, 0, 21);
            now.set(2022, 10, 18);

            int years = 0;

            while (birth.before(now)) {
                birth.add(Calendar.YEAR, 1);
                if (birth.before(now)) {
                    years++;
                }
            }
            System.out.println(years);
        } else if (version == 8) {
            LocalDate birth = LocalDate.of(1991, Month.JANUARY, 21);
            LocalDate now = LocalDate.now();

            Period period = Period.between(birth, now);
            System.out.println("It've been " + period.getYears() + " years, " + period.getMonths() + " months and " + period.getDays() + " days since " + birth + " and " + now);
        }
    }

    public void convert(int version) throws ParseException {
        if (version == 7) {
            String date = "01/01/2000";
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date newDate = formatter.parse(date);
            System.out.println(newDate);

            Date nowDate = Calendar.getInstance().getTime();
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            String dateString = formatter.format(nowDate);
            System.out.println(dateString);
        } else if (version == 8){
            String date = "21/01/1991";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            System.out.println(localDate);
            
            formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            System.out.println(formatter.format(localDate));
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        // app.verify(8);
        try {
            app.measureTime(8);
            app.periodBetweenDates(8);
            app.convert(8);
        } catch (InterruptedException | ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
