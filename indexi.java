import java.util.*;
import java.io.*;

public class indexi{

private String isbn;
private long index;
private boolean delete;


//object
public indexi(String t, long i, boolean d){
isbn = t;
index = i;
delete = d;
}


//accessor
public String getISBN(){
   return isbn;
}

public long getIndex(){
   return index;
}
public boolean isDeleted(){
   return delete;
}

public String toString(){
return (isbn + " " +index+ " " + delete);
}
}