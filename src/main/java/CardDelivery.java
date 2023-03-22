import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CardDelivery {
    public static String generateDate(long addDays, String pattern) {
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        return LocalDate.now(zoneId).plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }
}
