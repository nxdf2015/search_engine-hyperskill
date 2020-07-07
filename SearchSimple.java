package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchSimple implements Search{
    private List<String> data;
    @Override
    public Function<String,Boolean> find(  String query) {

        Pattern pattern = Pattern.compile(query,Pattern.CASE_INSENSITIVE);

        return line -> {
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
        };
    }

    @Override
    public void setData(List<String> data) {

    }


}
