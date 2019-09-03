import java.io.*;
import java.util.*;

public class CataloguerTester {

    public static void main(String[] args){
      BookCataloguer e;

 //BookCataloguer e = new BookCataloguer(args[1]);
       try {
            System.out.print("\nThis program creates a catalog of any book's diction – you can either view a list of all words used, or search for a specific word. If this is your first time using this program, I recommend choosing 'odyssey.txt' and searching for the usages of 'ulysses'.\n\n");
            e = new BookCataloguer(args[0]);
            Scanner s = new Scanner(System.in);
            while (true) {
               System.out.println("You've chosen " + args[0] + ". Type: ");
               System.out.println("      'a' to search for a word or phrase");
               System.out.println("      'b' to see a catalog of the book by number of occurrences");
               System.out.println("      'c' to exit program");
               String option = s.nextLine();
               if (option.equals("a")) { e.epithetCounter(); }
               if (option.equals("b")) { e.hashTheText(); }
               if (option.equals("c")) { System.exit(1); }
            }
        }
        catch (Exception ex) {
              if (args[0] == null) {
                  System.out.println("\n\nTO RUN CORRECTLY, type 'java CataloguerTester TEXTFILE.txt'\n");
                  System.exit(0);
              }
        }
      }
    }
