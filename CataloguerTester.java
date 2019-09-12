import java.io.*;
import java.util.*;

public class CataloguerTester {

    public static void main(String[] args){
        
       try {
            System.out.println("\n*********************************************************************");
            System.out.println("BOOK CATALOGUER");
            System.out.println("*********************************************************************");
            System.out.println("This program creates a catalog of any book's diction – you can either view a list of all words used, or search for a specific word. If this is your first time using this program, I recommend choosing 'odyssey.txt' and searching for the usages of 'swift ship'.\n");
            System.out.print("-----> Type a txt filename to proceed (eg. odyssey.txt): ");
            
            // Scan book and choice selections
            Scanner s = new Scanner(System.in);
            String book = s.nextLine();
            BookCataloguer e = new BookCataloguer(book);
            while (true) {
               System.out.println("\nYou've chosen " + book + ". Type: ");
               System.out.println("------->'a' to search for a word or phrase");
               System.out.println("------->'b' to see a catalog of the book by number of occurrences");
               System.out.println("------->'c' to exit program");
               String option = s.nextLine();
               if (option.equals("a")) { e.epithetCounter(); }
               if (option.equals("b")) { e.hashTheText(); }
               if (option.equals("c")) { System.exit(1); }
            }
        }
        
        // args exception
        catch (Exception ex) {
              if (args[0] == null) {
                  System.out.println("\n\nTO RUN CORRECTLY, type 'java CataloguerTester TEXTFILE.txt'\n");
                  System.exit(0);
              }
        }
      }
    }
