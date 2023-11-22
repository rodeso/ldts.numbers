package com.aor.numbers;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListFiltererTest {

    @Test
    public void testPositiveFilter() {
        GenericListFilter positiveFilter = new PositiveFilter();
        ListFilterer filterer = new ListFilterer(positiveFilter);

        List<Integer> inputList = List.of(-2, 0, 1, 3, 5, -10, 7);
        List<Integer> filteredList = filterer.filter(inputList);

        assertEquals(List.of(1, 3, 5, 7), filteredList);
    }

    @Test
    public void testDivisibleByFilter() {
        GenericListFilter divisibleByFilter = new DivisibleByFilter(3);
        ListFilterer filterer = new ListFilterer(divisibleByFilter);

        List<Integer> inputList = List.of(2, 3, 6, 9, 12, 15);
        List<Integer> filteredList = filterer.filter(inputList);

        assertEquals(List.of(3, 6, 9, 12, 15), filteredList);
    }

    @Test
    public void testListFiltererWithMock() {
        GenericListFilter mockFilter = mock(GenericListFilter.class);
        when(mockFilter.accept(3)).thenReturn(true);
        when(mockFilter.accept(4)).thenReturn(false);

        ListFilterer filterer = new ListFilterer(mockFilter);

        List<Integer> inputList = List.of(3, 4, 5);
        List<Integer> filteredList = filterer.filter(inputList);

        assertEquals(List.of(3), filteredList);
    }
}
