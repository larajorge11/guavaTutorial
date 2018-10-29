package guava.FluentIterable;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FirstMatch {

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
    public void testFirstMatch() {
        // Returns an optional containing the first element in this fluent iterable that satisfies the given predicate
        String element = null;
        Optional<String> result = FluentIterable.from(cities).firstMatch(predicateCities("P"));
        if (result.isPresent()) {
            element = result.get();
        }

        assertTrue(result.isPresent());
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
