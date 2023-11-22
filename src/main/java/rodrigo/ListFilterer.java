package rodrigo;

import java.util.ArrayList;
import java.util.List;

// Interface for the filter logic
interface GenericListFilter {
    boolean accept(Integer number);
}

// Filter for positive numbers
class PositiveFilter implements GenericListFilter {
    @Override
    public boolean accept(Integer number) {
        return number > 0;
    }
}

// Filter for numbers divisible by a specific value
class DivisibleByFilter implements GenericListFilter {
    private int divisor;

    public DivisibleByFilter(int divisor) {
        this.divisor = divisor;
    }

    @Override
    public boolean accept(Integer number) {
        return number % divisor == 0;
    }
}

// ListFilterer class with filter method
public class ListFilterer {
    private GenericListFilter filter;

    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> filteredList = new ArrayList<>();
        for (Integer number : list) {
            if (filter.accept(number)) {
                filteredList.add(number);
            }
        }
        return filteredList;
    }
}

