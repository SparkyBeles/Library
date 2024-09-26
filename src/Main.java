import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // List for books
        ArrayList<Book> bookLoanedList = new ArrayList<>();

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The life of Jessy", "Jessy", "20217"));
        bookList.add(new Book("Java for Dummies", "Dummies", "2020"));
        bookList.add(new Book("I am ZLATAN", "ZLATAN", "2025"));


        // Loop for user input and decision-making of books
        while (true){
            System.out.println("vad vill du göra! 1:Låna  2:Lämna  0:Avsluta ");
            for (int i = 0; i <bookList.size() ; i++) {
                System.out.println((i + 1) + ": " + bookList.get(i));
            }

            int choice;

            //keeps looping with the condition 0 to break it!
            try {
                choice = sc.nextInt();
                if (choice == 0){
                    break;
                }

                if (choice < 1 || choice > bookList.size()){
                System.out.println("Utanför lista, försök igen! ");
                continue;
                }


                if (choice == 1){
                    loanBook(sc, bookLoanedList, bookList);
                }
                else if (choice == 2){
                    returnBook(sc, bookLoanedList, bookList);
                }

                }catch (InputMismatchException e){
                System.out.println("Ogilitig val försök igen eller 0 för avsluta!");
                sc.nextLine();
            }

        }




    }

    private static void loanBook(Scanner sc, ArrayList<Book> bookList, ArrayList<Book> bookLoanedList) {
        System.out.println("Vilken bok vill du låna? 0 för att avsluta! ");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println((i + 1) + ": " + bookList.get(i));

            int choice = sc.nextInt();
            if (choice == 0){
                return;
            }
            if (choice == 1){
                bookLoanedList.add(bookList.get(choice));
                bookList.remove(choice);
                System.out.println("Bok "+ choice + "har du lånat");
            }


        }

       }


       private static void returnBook(Scanner sc, ArrayList<Book> bookList, ArrayList<Book> bookLoanedList) {
           System.out.println("Vilken bok vill du lämna? 0 för att avsluta! ");
           for (int i = 0; i < bookLoanedList.size(); i++) {
               System.out.println((i + 1) + ": " + bookLoanedList.get(i));



            try {
                int choice = sc.nextInt();
                if (choice == 0){
                    return;
                }
                if (choice > 0 || choice <= bookLoanedList.size()){
                    System.out.println("Ogiligitg val!!");
                }
                if (choice == 1){
                    bookLoanedList.remove(choice);
                    bookList.add(bookLoanedList.get(choice));
                    System.out.println("Du har lämnat boken " + choice);
                }
                if (choice == 2){
                    return;
                }

            }catch (InputMismatchException e){
                System.out.println("Fel input försök igen eller 0");
            }

           }

    }
}