import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        ArrayList<Book> bok_list = new ArrayList<>();
        bok_list.add(new Book("The life of Jessy ", " Jessy "," 20217"));
        bok_list.add(new Book("Java for dummies "," Dummies "," 2020"));
        bok_list.add(new Book("I am ZLATAN "," ZLATAN "," 2025"));




        System.out.println("Vilken bok vill du låna?");
        for (int i = 0;i < bok_list.size();i++){
            System.out.println((i+1)+"."+bok_list.get(i));
        }
        String book_user_want = sc.nextLine();

        System.out.println("Du valde att låna" + book_user_want);


        }


   }
