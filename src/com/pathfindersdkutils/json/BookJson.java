package com.pathfindersdkutils.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.Book;
import com.pathfindersdk.prerequisites.Prerequisite;

/**
 * This class reads/writes Book objetcs from/to a JSON file.
 */
public class BookJson
{
  private Gson gson;
  
  public BookJson()
  {
    GsonBuilder builder = new GsonBuilder();
    
    // Register adapters (for polymorphism)
    builder.registerTypeAdapter(Bonus.class, new BonusAdapter());
    builder.registerTypeAdapter(Prerequisite.class, new PrerequisiteAdapter());
    
    // Set output as pretty print
    builder.setPrettyPrinting();
    
    // Instantiate Gson
    gson = builder.create();
  }
  
  public Book read(String fileName)
  {
    Book book = null;
    String booksPath = "books\\" + fileName;
    
    try
    {
      BufferedReader buffer = new BufferedReader(new FileReader(booksPath));
      book = gson.fromJson(buffer, Book.class);
      book.updateIndexes();
      
      System.out.println(book.getName() + " has been read from [" + booksPath + "]");
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    }
    
    return book;
  }
  
  public void write(Book book, String fileName)
  {
    String booksPath = "books\\" + fileName;

    try 
    {
      FileWriter writer = new FileWriter(booksPath);
      writer.write(gson.toJson(book));
      writer.close();
      
      System.out.println(book.getName() + " has been written into [" + booksPath + "]");
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
