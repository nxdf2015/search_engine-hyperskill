package search;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data data = new Data();

        if (args[0].equals("--data")){
            data.load(args[1]);
        }
        else {
            System.out.println("Enter the number of people:");
            int numberPeople = Integer.parseInt(scanner.nextLine());


            System.out.println("Enter all people:");
            for(int i = 0; i < numberPeople ; i++ ){
                data.add(scanner.nextLine());
            }
        }



//        System.out.println("Enter the number of search queries:");
//        int numberSearch = Integer.parseInt(scanner.nextLine());
        int selection = -1;
        boolean invalid;
        while (selection != 0){
            System.out.println("===Menu===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");

                selection = Integer.parseInt(scanner.nextLine());
                 invalid = selection<0 || selection>2;
                 if (invalid) {
                     System.out.println("Incorrect option! Try again.");

                 }
                 else {
                     switch(selection){
                         case 1 :
                             System.out.println("Enter a name or email to search all suitable people.");
                             String query = scanner.nextLine();
                             List<String> response = data.find(query);
                             response.stream()
                                     .forEach(System.out::println);
                             break;
                             case 2 :
                                 data.getAll()
                                 .stream()
                                         .forEach(System.out::println);
                                 break;

                     }
                 }
        }
        System.out.println("Bye!");
//        for(int i = 0 ; i < numberSearch ; i++ ){
//            System.out.println("Enter data to search people:");
//            String query = scanner.nextLine();
//            List<String> result = data.find(query);
//            if(result.isEmpty()){
//                System.out.println("No matching people found.");
//            }
//            else {
//                System.out.println("Found people:");
//                result.forEach(System.out::println);
//            }
//        }




    }
}
