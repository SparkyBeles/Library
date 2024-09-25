import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);




        //List for books
        ArrayList<Book>book_loaned_list = new ArrayList<>();

        ArrayList<Book> book_list = new ArrayList<>();
        book_list.add(new Book("The life of Jessy ", " Jessy "," 20217"));
        book_list.add(new Book("Java for dummies "," Dummies "," 2020"));
        book_list.add(new Book("I am ZLATAN "," ZLATAN "," 2025"));




        //Loop for user input and decision-making of books
       while (true){
           System.out.println("Vilken bok vill du låna? (1/2/3 tryck (0) för att avsluta): " + book_list);

           //Users choice of book with condition to break the loop with 0
           try{
           int choice = sc.nextInt();
           if (choice == 0){
               break;
           }
           if (choice >0 && choice <= book_list.size()){
               Book seleckted_book = book_list.get(choice -1);
               book_list.remove(seleckted_book);

           }else {
               System.out.println("boken är redan lånad välj ett annat bok eler tryck 0 för att avsluta");
           }
           switch (choice) {
               case 1:
                   if (book_list.size() >= 1){
                       Book selectedBook1 = book_list.get(0);
                       book_list.remove(selectedBook1);
                       System.out.println("Du valde att låna boken " + selectedBook1);

                   }else{
                       System.out.println("Bok 1 är redan lånad!!");
                   }
                   break;

               case 2:
                   if (book_list.size()>= 2){
                       Book bookSelected2 = book_list.get(1);
                       book_list.remove(1);
                       book_loaned_list.add(bookSelected2);
                       System.out.println("Du valde att låna bok 2 " + bookSelected2);
                   }else {
                       System.out.println("Bok 2 är redan lånad!!");
                   }
                   break;

               case 3:
                   if (book_list.size() >= 3){
                       Book selectedBook3 = book_list.get(2);
                       book_list.remove(selectedBook3);
                       book_loaned_list.add(selectedBook3);
                   }else {
                       System.out.println("Bok 3 är redan lånad!!");
                   }
                   break;

               default:
                   System.out.println("Ogiltigt val välje igen eller tryck 0 för att avsluta !!!");

           }


           //catch miss typed user input that is not number
       } catch (InputMismatchException e){
           System.out.println("Enbart sifror som val 1/2/3 eller 0 för att avsluta");
           sc.next();
           }
       }








        }


   }
