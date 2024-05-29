import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * package sample;
 * <p>
 * import java.time.LocalDate;
 * import java.util.Collection;
 * import java.util.List;
 * <p>
 * /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    private static final String TARGET_SYMBOL = "r";

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> listDatesWithSymbol = unsortedDates.stream()
                .filter(this::containsSymbol)
                .sorted()
                .toList();
        List<LocalDate> listDatesWithoutSymbol = unsortedDates.stream()
                .filter(date->!containsSymbol(date))
                .sorted(Comparator.reverseOrder())
                .toList();
        return Stream.concat(listDatesWithSymbol.stream(),listDatesWithoutSymbol.stream()).toList();
    }

    private boolean containsSymbol(LocalDate date) {
        Month month = date.getMonth();
        String displayName = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        return displayName.contains(TARGET_SYMBOL);
    }


}