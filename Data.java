package search;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Data {
    private List<String> data;
    private Map<String,List<Integer>> index;
    private Search search;


    public Data() {
        data = new ArrayList<>();
        index = new HashMap<>();
    }

    public void add(String line) {
        data.add(line);
    }

    public void setStrategy(Search search){
        search.setData(data);
        this.search = search;

    }

    public  List<String> find(String query){
       return   data.stream()
                 .filter( line -> search.find(query).apply(line))
                 .collect(Collectors.toList());



    }

    public List<String> findByIndex(String query){
        if(index.isEmpty()){
            getInvertedIndex();
        }

        List<Integer> selected = new ArrayList<>();
        if(!((selected = index.get(query)) == null)){
            return selected
                    .stream()
                    .map(i ->data.get(i))
                    .collect(Collectors.toList());
        }
        else {
            return List.of();
        }
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

    public void getInvertedIndex(){
       for(int  i = 0 ; i < data.size();i++){
           String line = data.get(i);
           for(String word : line.split(" ")){
               int id = i;
               index.compute(word, (key,values) -> {
                   if (values == null) {
                       values = new ArrayList<>();
                   }
                   values.add(id);
                   return values;
               } );
           }
       }

    }
}
