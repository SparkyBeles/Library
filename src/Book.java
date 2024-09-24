public class Book {
    String title;
    String author;
    String published_year;


    public Book(String title,String author,String published_date){
        this.title = title;
        this.author = author;
        this.published_year = published_date;

    }


    @Override
    public String toString() {
        return "\"" + title + "\"by " + author + "("+ published_year +")";
    }
}
