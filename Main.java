package search;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people:");
        int numberPeople = Integer.parseInt(scanner.nextLine());

        Data data = new Data();
        System.out.println("Enter all people:");
        for(int i = 0; i < numberPeople ; i++ ){
            data.add(scanner.nextLine());
        }
        System.out.println("Enter the number of search queries:");
        int numberSearch = Integer.parseInt(scanner.nextLine());
        for(int i = 0 ; i < numberSearch ; i++ ){
            System.out.println("Enter data to search people:");
            String query = scanner.nextLine();
            List<String> result = data.find(query);
            if(result.isEmpty()){
                System.out.println("No matching people found.");
            }
            else {
                System.out.println("Found people:");
                result.forEach(System.out::println);
            }
        }




    }
}
