package guava.FluentIterable;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FluentIterableApiTest {

    @Test
    public void testAllString() {
        ListHolder listHolder1 = new ListHolder(Arrays.asList("String 1", "String 2"));
        ListHolder listHolder2 = new ListHolder(Arrays.asList("String 3", "String 4"));
        List<ListHolder> holders = Arrays.asList(listHolder1, listHolder2);

        FluentIterableApi fluentIterableApi = new FluentIterableApi();
        List<String> result = fluentIterableApi.allStrings(holders);

        assertThat(result.size(), is(4));
    }

    @Test
    public void testVehicules() {

        User user1 = new User("JORGE", Payment.CREDIT_CARD);
        User user2 = new User("STEFANI", Payment.POINTS);
        List<User> users1 = Arrays.asList(user1, user2);

        Vehicules vehicule1 = new Vehicules("Renault", "Twingo", Color.BLUE, users1);

        User user3 = new User("JORGE", Payment.NA);
        User user4 = new User("STEFANI", Payment.CREDIT_CARD);
        User user5 = new User("BRANDON", Payment.CREDIT_CARD);
        List<User> users2 = Arrays.asList(user3, user4, user5);

        Vehicules vehicule2 = new Vehicules("Chevrolet", "Spark", Color.BLACK, users2);

        User user6 = new User("ZULAY", Payment.NA);
        User user7 = new User("NANES", Payment.CREDIT_CARD);
        User user8 = new User("BRANDON", Payment.FREE);
        User user9 = new User("DANIEL", Payment.POINTS);
        List<User> users3 = Arrays.asList(user6, user7, user8, user9);

        Vehicules vehicule3 = new Vehicules("Hyundai", "i25", Color.GREEN, users3);

        List<Vehicules> empresa = Arrays.asList(vehicule1, vehicule2, vehicule3);

        FluentIterableApi fluentIterableApi = new FluentIterableApi();
        boolean result = fluentIterableApi.transformVehicules(empresa);

        assertTrue(result);

    }

    @Test
    public void testImmutableListUsingFluentIterable() {
        final ImmutableList<String> cities =
                ImmutableList.<String>builder().add("Bogota")
                .add("Medellin")
                .add("Cartagena")
                .add("Manizales")
                .add("Cali")
                .add("Barraquilla")
                .add("Pasto")
                .add("Tunja").build();

        List<String> filterCities = FluentIterable
                .from(cities)
                .filter(predicateFilterCities()).toList();

        assertThat(filterCities.size(), is(2));
    }

    @Test
    public void testImmutableListUsingIterables() {
        final ImmutableList<String> cities =
            ImmutableList.<String>builder().add("Bogota")
                    .add("Medellin")
                    .add("Cartagena")
                    .add("Manizales")
                    .add("Cali")
                    .add("Barraquilla")
                    .add("Pasto")
                    .add("Tunja").build();

        Iterable<String> result = Iterables.filter(cities, predicateFilterCities());
    }

    @Test
    public void testImmutableListUsingCollections2() {
        final ImmutableList<String> cities =
                ImmutableList.<String>builder().add("Bogota")
                        .add("Medellin")
                        .add("Cartagena")
                        .add("Manizales")
                        .add("Cali")
                        .add("Barraquilla")
                        .add("Pasto")
                        .add("Tunja").build();

        Collection<String> result = Collections2.filter(cities, predicateFilterCities());
        assertThat(result.size(), is(2));
    }

    private Predicate predicateFilterCities() {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.startsWith("B");
            }
        };
    }
}
