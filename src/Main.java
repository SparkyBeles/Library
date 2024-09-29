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

        try {
            while (true) {
                System.out.println("vad vill du göra! 1:lämna  2:låna  0:Avsluta ");
                int choice = sc.nextInt();

                switch (choice) {

                        case 0:
                             {
                                System.out.println("Bye");
                                return;

                            }
                            case 1:
                                 {
                                    loanBook(sc, bookLoanedList, bookList);
                                    break;
                                }
                                case 2:
                                    returnBook(sc, bookLoanedList, bookList);
                                    break;


                                default:
                                    System.out.println("Invalid choice");

                }




            }

        }catch (InputMismatchException e){
            System.out.println("Please enter a valid number");
            sc.nextLine();
          }



    }

    private static void loanBook(Scanner sc, ArrayList<Book> bookList, ArrayList<Book> bookLoanedList) {
        if (bookList.isEmpty()){
            System.out.println("Alla böcker är utlånade!");
            return;
        }

        DisplayAvailableBooks(sc, bookList, bookLoanedList);


        try {
            int choice = sc.nextInt();
            int bookIndex = choice -1;
            if (bookIndex >= 0 && bookIndex < bookList.size()){
                Book chosenBook = bookList.get(bookIndex);
                bookLoanedList.add(chosenBook);
                bookList.remove(chosenBook);
                System.out.println("Du har lånad boken " + chosenBook.title);
            }
            else if (choice == 0) {
                return;



            }


        }catch (InputMismatchException e){
            System.out.println("Ogiltigt val 1:låna 2:lämna  0:Avsluta ");
            sc.nextLine();
        }

       }


       private static void returnBook(Scanner sc, ArrayList<Book> bookList, ArrayList<Book> bookLoanedList) {
         if (bookLoanedList.isEmpty()){
             System.out.println("Inga böcker lånade!");
             return;
         }

         DisplayLoanedBooks(sc, bookList, bookLoanedList);



            try {

                int choice = sc.nextInt();
                int bookIndex = choice - 1;
                if (choice == 0){
                    return;
                }

                else if (bookIndex >= 0 && bookIndex < bookLoanedList.size()){
                    Book chocedBook =bookLoanedList.get(bookIndex);
                    bookLoanedList.add(chocedBook);
                    bookList.remove(chocedBook);
                    System.out.println("Du har lånat boken: " + chocedBook.title);
                }

            }catch (InputMismatchException e){
                System.out.println("Fel input försök igen eller 0");
                sc.nextLine();
            }

           }


           private static void DisplayLoanedBooks (Scanner sc, ArrayList<Book> bookList, ArrayList<Book> bookLoanedList) {
               for (int i = 0; i < bookLoanedList.size() ; i++) {
                   System.out.println((i+1) +"." + "Tillgängliga böcker är! " + bookLoanedList.get(i).title);
                   
               }

               
        

           }
           
           private static void DisplayAvailableBooks(Scanner sc, ArrayList<Book> bookList, ArrayList<Book> bookLoanedList) {
               for (int i = 0; i < bookList.size() ; i++) {
                   System.out.println((i+1) +"."+ "Lånade böcker är! " + bookList.get(i).title);

               }

           }

}