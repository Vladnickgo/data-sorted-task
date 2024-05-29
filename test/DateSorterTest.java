import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateSorterTest {
    private final DateSorter dateSorter = new DateSorter();

    @Test
    void testEmptyList() {
        List<LocalDate> emptyList = Collections.emptyList();
        Collection<LocalDate> sortedDates = dateSorter.sortDates(emptyList);
        assertTrue(sortedDates.isEmpty());
    }

    @Test
    public void testListWithSymbolDates() {
        LocalDate date1 = LocalDate.of(2024, Month.SEPTEMBER, 22); // "September"
        LocalDate date2 = LocalDate.of(2024, Month.APRIL, 10); // "April"
        LocalDate date3 = LocalDate.of(2024, Month.MARCH, 15); // "March"

        List<LocalDate> unsortedDates = Arrays.asList(date1, date2, date3);
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        List<LocalDate> expectedList = Arrays.asList(date3, date2, date1);
        assertEquals(expectedList, sortedDates);
    }

    @Test
    public void testListWithoutSymbolDates() {
        LocalDate date1 = LocalDate.of(2024, Month.MAY, 22); // "September"
        LocalDate date2 = LocalDate.of(2024, Month.JULY, 10); // "April"
        LocalDate date3 = LocalDate.of(2024, Month.JUNE, 15); // "March"

        List<LocalDate> unsortedDates = Arrays.asList(date1, date2, date3);
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        List<LocalDate> expectedList = Arrays.asList(date2, date3, date1);
        assertEquals(expectedList, sortedDates);
    }

    @Test
    public void testListWithMixedDates() {
        LocalDate date1 = LocalDate.of(2004, Month.JULY, 1);
        LocalDate date2 = LocalDate.of(2005, Month.JANUARY, 2);
        LocalDate date3 = LocalDate.of(2007, Month.JANUARY, 1);
        LocalDate date4 = LocalDate.of(2032, Month.MAY, 3);

        List<LocalDate> unsortedDates = Arrays.asList(date1, date2, date3, date4);
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        List<LocalDate> expectedList = Arrays.asList(date2, date3, date4, date1);
        assertEquals(expectedList, sortedDates);
    }
}