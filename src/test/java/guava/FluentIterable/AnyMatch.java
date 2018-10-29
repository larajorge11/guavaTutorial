package guava.FluentIterable;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AnyMatch {

    private ImmutableList<String> cities;

    @Before
    public void setUp() {
        cities = ImmutableList.<String>builder().add("Bogota")
                        .add("Medellin")
                        .add("Cartagena")
                        .add("Manizales")
                        .add("Cali")
                        .add("Barraquilla")
                        .add("Pasto")
                        .add("Tunja").build();
    }

    @Test
    public void testAnyMatchOK() {
        // Returns true if any element in this fluent iterable satisfies the predicate
        boolean anyMatchCities = FluentIterable.from(cities).anyMatch(predicateCities("M"));
        assertTrue(anyMatchCities);
    }

    @Test
    public void testAnyMatchFail() {
        // Returns true if any element in this fluent iterable satisfies the predicate
        boolean anyMatchCities = FluentIterable.from(cities).anyMatch(predicateCities("Z"));
        assertFalse(anyMatchCities);
    }

    private Predicate predicateCities(String in) {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.startsWith(in);
            }
        };
    }
}
