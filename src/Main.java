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
                                case 2: {
                                    returnBook(sc, bookLoanedList, bookList);
                                    break;
                                }

                                default:
                                    System.out.println("Invalid choice");

                }




            }

        }catch (InputMismatchException e){
            System.out.println("Please enter a valid number");
            sc.nextLine();
          }



    }

    //Method for borrowing books!
    private static void loanBook(Scanner sc, ArrayList<Book> bookList, ArrayList<Book> bookLoanedList) {
        if (bookList.isEmpty()){
            System.out.println("Du har inga lånade böcker");
            return;
        }

        DisplayAvailableBooks(bookList);


        try {

            int choice = sc.nextInt();
            int bookIndex = choice -1;
            if (bookIndex >= 0 && bookIndex < bookList.size()){
                Book chosenBook = bookList.get(bookIndex);
                bookLoanedList.add(chosenBook);
                bookList.remove(chosenBook);
                System.out.println("Du har lämnat boken " + chosenBook.title);
            } else if (choice >0 && choice >= bookList.size()){
                System.out.println("fel försök igen!");
                sc.nextLine();
            }

        }catch (InputMismatchException e){


            System.out.println("Ogiltigt val 1:låna 2:lämna  0:Avsluta ");
            sc.nextLine();
         }

    }


       //Method for returning books
       private static void returnBook(Scanner sc, ArrayList<Book> bookList, ArrayList<Book> bookLoanedList) {
         if (bookLoanedList.isEmpty()){
             System.out.println("Alla böcker är utlånade!");
             return;
         }

         DisplayLoanedBooks(bookLoanedList);

         try {

                int choice = sc.nextInt();
                int bookIndex = choice - 1;
                if (choice == 0){
                }

                else if (bookIndex >= 0 && bookIndex < bookLoanedList.size()){
                    Book chosenBook =bookLoanedList.get(bookIndex);
                    bookList.add(chosenBook);
                    bookLoanedList.remove(chosenBook);
                    System.out.println("Du har lånat boken: " + chosenBook.title);
                } else if (choice >0 && choice >= bookLoanedList.size()) {
                    System.out.println("Ogiltig val försök igen!");

                }

         }catch (InputMismatchException e){
                System.out.println("Fel input försök igen eller 0 för avsluta ");
                sc.nextLine();
             }

    }


           //Method for displaying books loaned!
           private static void DisplayLoanedBooks (ArrayList<Book> bookLoanedList) {
               for (int i = 0; i < bookLoanedList.size() ; i++) {
                   System.out.println((i+1) +"." + "Lånad bok!:" + bookLoanedList.get(i).title);
                   
               }
    }

           //Method for displaying books available to loan
           private static void DisplayAvailableBooks(ArrayList<Book> bookList) {
               for (int i = 0; i < bookList.size() ; i++) {
                   System.out.println((i+1) +"."+ "Tillgänglig bok!:" + bookList.get(i).title);

               }

           }

}