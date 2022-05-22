import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    public static String getLocalDateTime(String date, String format) throws DateTimeParseException {
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(date, df1).format(df2);
    }

    public static String stringFormat() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formattedString = localDateTime.format(formatter);
        return formattedString;
    }

}
