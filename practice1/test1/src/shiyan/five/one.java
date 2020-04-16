package shiyan.five;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName one.java
 * @Description TODO
 * @Date 2019/11/13 22:06
 */
public class one {

    @Test
    public void formatPrint() {
        LocalDate date = LocalDate.of(2019, 11, 01);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);// 20191101
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);// 2019-11-01

        LocalDate date1 = LocalDate.parse("20191101", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2019-11-01", DateTimeFormatter.ISO_LOCAL_DATE);

        // 自定义格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);
        System.out.println(formattedDate);// 01/11/2019
        LocalDate date3 = LocalDate.parse(formattedDate, formatter);

        // 带时区的日期(本地化)
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        String formattedDate2 = date.format(italianFormatter);
        LocalDate date4 = LocalDate.parse(formattedDate2, italianFormatter);
    }
}
