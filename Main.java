package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words  = scanner.nextLine().split(" ");
        String word = scanner.nextLine();
        int i = 0;
        while( i < words.length && !words[i ].equals(word)){
            i++;
        }
        if(i <words.length){
            System.out.println(i+1);
        }
        else {
            System.out.println("Not Found");
        }

    }
}
