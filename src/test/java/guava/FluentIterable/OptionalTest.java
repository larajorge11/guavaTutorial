package guava.FluentIterable;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OptionalTest {

    @Test
    public void testOptional() {
        Optional<List<String>> fromNull = Optional.fromNullable(getList());
        assertFalse(fromNull.isPresent());
    }

    @Test
    public void testOptionalAbsent() {
        Optional<List<String>> fromNull = Optional.fromNullable(getListAbsent().orNull());
        assertFalse(fromNull.isPresent());
    }

    @Test
    public void testOptionalAbsentUsingOr() {
        Optional<List<String>> fromNull = Optional.fromNullable(getListAbsent().or(new ArrayList<String>()));
        assertTrue(fromNull.isPresent());
    }

    @Test
    public void testOptionalgetData() {
        Optional<List<String>> data = Optional.fromNullable(getData()).orNull();
        assertTrue(data.isPresent());
    }

    private static List<String> getList() {
        return null;
    }

    private static Optional<List<String>> getListAbsent() {
        return Optional.absent();
    }

    private static Optional<List<String>> getData() {
        return Optional.of(ImmutableList.<String>builder().add("Java")
                .add("C++")
                .add("Phyton").build().asList());
    }
}
