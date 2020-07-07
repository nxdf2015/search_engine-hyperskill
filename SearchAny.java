package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SearchAny implements Search{
    private List<String> data;

    @Override
    public Function<String,Boolean> find(String query) {

        return line -> {
            boolean result = false;
            for(String q : query.toLowerCase().split(" "))
            result = result || line.toLowerCase().contains(q);
            return  result;
        };
    }

    @Override
    public void setData(List<String> data) {
        this.data = data;
    }
}
