package guava.FluentIterable;

import java.util.ArrayList;
import java.util.List;

public class ListHolder {
    List<String> list = new ArrayList<>();

    public ListHolder(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
