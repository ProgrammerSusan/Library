import java.io.*;
import java.io.Serializable;
@SuppressWarnings("serial")
public class Book implements Serializable{

private String title;
private String author;
private String genre;
private String isbn;

//default constructor
public Book(){
   title = "No Title";
   author = "Unknown";
   genre = "None";
   isbn = "0";
}
//populated constructor
public Book(String t, String a, String g, String i){
      title = t;
      author = a;
      genre = g;
      isbn = i;
      
   }
   
   
   //accessor methods
   public String getTitle(){
      return title;
   }
   
   public String getAuthor(){
      return author;
   }
   
   public String getGenre(){
      return genre;
   }
   public String getISBN(){
      return isbn;
   }
   
   //set methods
   public void setTitle(String t){
      title = t;
   }
   public void setAuthor(String a){
      author = a;
   }
   public void setGenre(String g){
      genre=g;
   }
   public void setISBN(String i){
      isbn=i;
   }
   

   //mutator methods
   public void changeTitle(Book b, String title){
      this.title=title;
   }
   public void changeAuthor(Book b, String author){
      this.author=author;
   }
   public void changeGenre(Book b, String genre){
      this.genre=genre;
   }
   public void changeISBN(Book b, String isbn){
      this.isbn=isbn;
   }
   
   
   //toString
  public String toString(){
      return "Title: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nISBN: " + isbn;
   }



}