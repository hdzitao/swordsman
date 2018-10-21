package hdzi.swordsman.java.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterChain {
    private List<Filter> filters = Collections.emptyList();
    private int i = 0;

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public void doFilter() {
        if (i == filters.size()) return;

        filters.get(i++).doFilter(this);
    }

    public static void main(String[] args) {
        List<Filter> filters = new ArrayList<>();
        filters.add(filterChain -> {
            System.out.println("0");
            filterChain.doFilter();
        });

        filters.add(filterChain -> {
            System.out.println("1");
            //filterChain.doFilter();
        });

        filters.add(filterChain -> {
            System.out.println("2");
            filterChain.doFilter();
        });

        FilterChain filterChain = new FilterChain();
        filterChain.setFilters(filters);

        filterChain.doFilter();
    }
}
