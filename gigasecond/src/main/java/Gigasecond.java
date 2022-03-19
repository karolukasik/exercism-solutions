import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Gigasecond {
    final int GIGASECOND = 1000000000;
    LocalDateTime calculatedMoment;

    public Gigasecond(LocalDateTime moment) {
        this.calculatedMoment = moment.plus(GIGASECOND, ChronoUnit.SECONDS);
    }

    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public LocalDateTime getDateTime() {
        return this.calculatedMoment;
    }

}
