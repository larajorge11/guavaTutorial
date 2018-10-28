package guava.FluentIterable;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

import java.util.List;

public class FluentIterableApi {

    public List<String> allStrings(List<ListHolder> inList) {
        List<String> allString = FluentIterable
                .from(inList)
                .transformAndConcat(
                        new Function<ListHolder, List<String>>() {
                            @Override
                            public List<String> apply(final ListHolder listHolder) {
                                return listHolder.getList();
                            }
                        }
                ).toList();
        return allString;
    }

    public boolean transformVehicules(List<Vehicules> vehicules) {
        boolean users = FluentIterable
                .from(vehicules)
                .transformAndConcat(
                        new Function<Vehicules, List<User>>() {
                            @Override
                            public List<User> apply(Vehicules input) {
                                return input.getUsers();
                            }
                }).anyMatch(new Predicate<User>() {
                    @Override
                    public boolean apply(User input) {
                        return Payment.NA == input.getPayment();
                    }
                });

        return users;
    }
}
