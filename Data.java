package search;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Data {
    private List<String> data;

    public Data() {
        data = new ArrayList<>();
    }

    public void add(String line) {
        data.add(line);
    }

    public List<String> find(String query){
        Pattern pattern = Pattern.compile(query,Pattern.CASE_INSENSITIVE);
        List<String>result  = new ArrayList<>();

        for(int i =0  ; i < data.size() ; i++){
            Matcher matcher = pattern.matcher(data.get(i));
            if(matcher.find()){
                result.add(data.get(i));
            }

        }
        return result;
    }

    public List<String> getAll() {
        return data;
    }

    public void load(String nameFile) {
        try(BufferedReader reader =new BufferedReader(new FileReader(new File(nameFile)))){
            data = reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
