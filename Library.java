
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.Random;

public class Library{

   public static Scanner input = null; //global variables
   public static Scanner keyboard = new Scanner(System.in);
   public static PrintWriter out = null;
   public static PrintWriter output = null;
   public static Scanner in = null;
   public static void main(String[] args)throws IOException{
   
   //driver
   
      RandomAccessFile library = new RandomAccessFile("library.dat","rw");
   
   //menu options
      int response=1;
      while(response!=0){
         System.out.println("Please select what you would like to do:");
      
         System.out.println("0: Exit");
         System.out.println("1: Search for a book");
         System.out.println("2: Add a book");
         System.out.println("3: Delete a book");
         System.out.println("4: Display books by a certain author");
             
         response = keyboard.nextInt();
         int count = 0;
         switch(response){
            case 0:
               System.out.println("End of program.");
               library.close();
               break;
         
            case 1: 
               System.out.println("How would you like to search for the book?"); //selecting method of searching
               System.out.println("1: Title");
               System.out.println("2: ISBN");
               System.out.println("3: Quit");
               String choice;
               int search=keyboard.nextInt();
               while(search!=3){
                  switch(search){
                     case 1:
                        boolean hold = false; //used to check if book has been deleted
                        keyboard.nextLine();
                        System.out.println("Enter the title of the book you are searching for");
                        choice = keyboard.nextLine();
                        
                        int index = -1; //keeps track of index/file pointer
                        try{
                           input = new Scanner(new FileInputStream("titleIndex.txt"));
                           String temp = input.nextLine();
                          
                           while(input.hasNextLine()){
                              if(!(temp.equals(choice))){
                                  temp = input.nextLine();
                               }
                            if(temp.equals(choice)){
                                  temp = input.nextLine();
                                  index = Integer.parseInt(temp);
                                  temp = input.nextLine();
                              if(temp.equals("false")){
                                 hold = false;
                                  }
                               else{
                                 hold = true;
                               }
                              }
                           }
                         if(index>=0){
                           if(hold == false){
                          
                           
                           Book b1 = null;
                           library.seek(index);
                           b1 = readObject(library);
                           System.out.println(b1);
                           System.out.println();
                           }
                           else{
                              System.out.println("Book not found");
                           }
                          }
                          else{
                              System.out.println("Book not found");
                          }
                           
                        input.close();
                        }
                        catch(NoSuchElementException e){
                           System.out.println("Book not found");
                        }
                          
                        System.out.println("Continue? Type \"yes\" or \"no\" ");
                        choice = keyboard.next();
                        if(choice.equals("no")){
                           search = 3;
                        }
                        else{
                           search = 1;
                        }
                        break;
                     
                     case 2:
                        boolean holdPlace = false;
                        keyboard.nextLine();
                        System.out.println("Enter the ISBN of the book you are searching for");
                        choice = keyboard.nextLine();
                        
                        int location = -1;
                        try{
                           input = new Scanner(new FileInputStream("ISBNIndex.txt"));
                           String temporary = input.nextLine();
                          
                           while(input.hasNextLine()){
                              if(!(temporary.equals(choice))){
                                  temporary = input.nextLine();
                               }
                            if(temporary.equals(choice)){
                                  temporary = input.nextLine();
                                  location = Integer.parseInt(temporary);
                                  temporary = input.nextLine();
                              if(temporary.equals("false")){
                                 holdPlace = false;
                                  }
                               else{
                                 holdPlace = true;
                               }
                              }
                           }
                         if(location>=0){
                           if(holdPlace == false){
                          
                           
                           Book b2 = null;
                           library.seek(location);
                           b2 = readObject(library);
                           System.out.println(b2);
                           System.out.println();
                           }
                           else{
                              System.out.println("Book not found");
                           }
                          }
                         else{
                           System.out.println("Book not found");
                         }
                           
                        input.close();
                        }
                        catch(NoSuchElementException e){
                           System.out.println("Book not found");
                        }
                          
                        System.out.println("Continue? Type \"yes\" or \"no\" ");
                        choice = keyboard.next();
                        if(choice.equals("no")){
                           search = 3;
                        }
                        else{
                           search = 1;
                        }
                        break;
                        
                     default:
                        System.out.println("Not an option!");
                        break;
                  }
               }
               break;
                     
            case 2:
                 keyboard.nextLine();
                 System.out.println("Please enter the title of the book");
                 String t = keyboard.nextLine();
  
                 System.out.println("Please enter the author of the book");
                 String a = keyboard.nextLine();
  
                 System.out.println("Please enter the genre of the book");
                 String g = keyboard.nextLine();
 
                 System.out.println("Please enter the ISBN of the book");
                 String i = keyboard.nextLine();
                 
                 Book b = new Book(t,a,g,i);
                 
                 long location = library.length();
                                               
                 library.seek(location);
                 writeObject(library,b);
                 
                 indext hi = new indext(t,location,false);
                 indexi yo = new indexi(i,location,false);

                 
                 writeTitle(hi);
                 writeISBN(yo);
                 
                 
                
                 library.seek(location);
                 writeObject(library,b);
                 
                 Book m = null;
                 library.seek(location);
                 m=readObject(library);          
                 System.out.println("Book saved to database!");
                 
               break;
               
             case 3:
                 String res;
                 keyboard.nextLine();
                 System.out.println("Please enter the title of the book you would like to delete");
                 res = keyboard.nextLine();
                 int lo = 0;
                        try{
                           input = new Scanner(new FileInputStream("titleIndex.txt"));
                           String tempo = input.nextLine();
                          
                           while(!(tempo.equals(res))){
                           if(!(tempo.equals(res))){
                              tempo = input.nextLine();
                            }
                           }
                           lo = Integer.parseInt(input.nextLine());
                           long lul = lo;
                           
                           Book b2 = null;
                           library.seek(lul);
                           b2 = readObject(library);
                           System.out.println(b2);
                           System.out.println("Deleting from library");
                           
                           indext del = new indext(b2.getTitle(),lul,true);
                           indexi ete = new indexi(b2.getISBN(),lul,true);
                           
                           writeTitle(del);
                           writeISBN(ete);
                           
                        input.close();
                        }
                        catch(NoSuchElementException e){
                           System.out.println("Book not found");
                        }

                 break;
                 
            case 4:
               keyboard.nextLine();
               System.out.println("Please enter the author's name");
               String writer = keyboard.nextLine();
               
               break;
                                              
            default:
               System.out.println("This is not an option!");
               break;
         
         
         
         }
      }
   
   
   
   }

//-----------------------------------------------------------------------------------------Class----------------------------------------------------------------------------------
   //write title into index
   public static void writeTitle(indext t){
      try{
         out = new PrintWriter(new FileOutputStream("titleIndex.txt",true));

      }
      catch(IOException e){
         System.out.println("Problem writing to file");
      }
      out.println(t.getTitle());
      out.println(t.getIndex());
      out.println(t.isDeleted());
         out.close();

   }
   
   //write ISBN to index
   public static void writeISBN(indexi i){
      try{
         output = new PrintWriter(new FileOutputStream("ISBNIndex.txt",true));
         output.println(i.getISBN());
         output.println(i.getIndex());
         output.println(i.isDeleted());
         output.close();
      }
      catch(IOException e){
         System.out.println("Problem writing to file");
      }

   }
   
   //writes book into file
   public static void writeObject(RandomAccessFile f, Book b)throws IOException{
      f.writeUTF(b.getTitle());
      f.writeUTF(b.getAuthor());
      f.writeUTF(b.getGenre());
      f.writeUTF(b.getISBN());

   }
   public static void delete(RandomAccessFile f)throws IOException{
      f.writeUTF(null);
   }
   
   
   //reads books from file
   public static Book readObject(RandomAccessFile f)throws IOException{
      String t = f.readUTF();
      String a = f.readUTF();
      String g = f.readUTF();
      String i = f.readUTF();
      Book b = new Book(t,a,g,i);
      return b;
   }
  


}