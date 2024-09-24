import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        //List for books
        ArrayList<Book> bok_list = new ArrayList<>();
        bok_list.add(new Book("The life of Jessy ", " Jessy "," 20217"));
        bok_list.add(new Book("Java for dummies "," Dummies "," 2020"));
        bok_list.add(new Book("I am ZLATAN "," ZLATAN "," 2025"));




        //Loop for user input and decision-making of books
       while (true){
           System.out.println("Vilken bok vill du låna? (1/2/3 tryck (0) för att avsluta): " + bok_list);

           try{
           int val = sc.nextInt();
           if (val == 0){
               break;
           }

           switch (val) {
               case 1:
                   System.out.println("Du valde att låna bok 1 " + bok_list.get(0));
                   break;


               case 2:
                   System.out.println("DU valde att låna bok 2 " + bok_list.get(1));
                   break;

               case 3:
                   System.out.println("Du valde att låna bok 3 " + bok_list.get(2));
                   break;

               default:
                   System.out.println("Ogiltigt val välje igen eller tryck 0 för att avsluta !!!");

           }


           //
       } catch (InputMismatchException e){
           System.out.println("Enbart sifror som val 1/2/3 eller 0 för att avsluta");
           sc.next();
           }
       }






        }


   }
