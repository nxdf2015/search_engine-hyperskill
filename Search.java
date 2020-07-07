package search;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface Search {
    public Function<String ,Boolean > find( String query);
    public void setData(List<String> data);
}
