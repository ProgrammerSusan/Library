//creates objects to put in the title index

import java.util.*;
import java.io.*;

public class indext{

//private variables
private String title;
private long index;
private boolean delete;

//title index object
public indext(String t, long i, boolean d){
title = t;
index = i;
delete = d;
}

//accessor
public String getTitle(){
   return title;
}

public long getIndex(){
   return index;
}

public boolean isDeleted(){
   return delete;
}

public String toString(){
return (title + " " +index + " " + delete);
}
}