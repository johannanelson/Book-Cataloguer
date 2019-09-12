import java.io.*;
import java.util.*;
import java.lang.Object;

public class BookCataloguer {

private ArrayList<String> textFile = new ArrayList<String>();

    public BookCataloguer(String f) {

      //Read and process txt file
      try{
          File inFile = new File(f);
          Scanner s = new Scanner(inFile);
          int lineNumber = 0;

          while (s.hasNextLine()) {
              lineNumber++;
              String currentLine = s.nextLine();
              String[] words = currentLine.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");
              for (String i : words) {
                  textFile.add(i);
              }
          }
      }
      catch (Exception e){
          System.out.println("***ERROR: Check the input of your file name. ");
      }
  }

    public void epithetCounter() {
        try {
          int epithetCounter = 0;
          Scanner s = new Scanner(System.in);

          // Receive and format user input
          System.out.print("Enter word or phrase to search for: ");
          String e = s.nextLine();
          String[] epithet = e.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");

          // Search for text matches
          boolean match = false;
          LinkedList<String> lines = new LinkedList<>();

          for (int i = 0; i < textFile.size(); i++) {
              String curr_word;
              if ((curr_word = textFile.get(i)).equals(epithet[0])) {
                  int k = i;
                  for (int j = 0; j < epithet.length; j++) {
                      if (!(textFile.get(k).equals(epithet[j])))
                          match = false;
                        else {
                          match = true;
                          k++;
                        }
                    }
                    if (match == true) {
                      epithetCounter++;
                      String line = textFile.subList(i-10, i+epithet.length+10).toString().replace(",", "");
                      lines.add(line);
                     }
              }
            }
            System.out.println("The phrase '" + e + "' is used " + epithetCounter + " times.\n");

            System.out.println("Would you like to see the instances in a separate txt file? Type 'yes' or 'no'.");
            String answer = s.nextLine();
            if (answer.equals("yes")) {
                Iterator it = lines.iterator();
                PrintWriter output = new PrintWriter("line_instances.txt");
                int line_no = 0;
                while (it.hasNext()) {
                    output.print(Integer.toString(++line_no) + ": ");
                    output.println(it.next() + "\n");
                    System.out.print(Integer.toString(++line_no) + ": ");
                    System.out.println(it.next() + "\n");
                }
                output.close();
                System.out.println("\n\nThe instances have been printed here as well as outputted into 'line_instances.txt' for easier viewing.\n");
            }
          }
        catch(Exception e) {
              System.out.println("IOException. Check the input of your file name.");
        }
      }

        public void hashTheText() {
            HashMap<String, Integer> textMap = new HashMap<>();
            for (int i = 0; i < textFile.size(); i++) {
                String curr_word = textFile.get(i);

                if (textMap.containsKey(curr_word)) {
                    Integer n = textMap.get(curr_word);
                    textMap.put(curr_word, n+1);
                }
                else {
                    textMap.put(curr_word, 1);
                }
            }

            LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(textMap.entrySet());
            Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
            Collections.sort(list, comparator.reversed());
            System.out.print("\n\n");
            boolean line_brk = false;
            for (Map.Entry<String, Integer> e : list) {
                System.out.format("%14s%14d%5s", e.getKey(), e.getValue(), " ");
                if (line_brk == true) {
                    System.out.print("\n");
                    line_brk = false;
                }
                else { line_brk = true; }
            }

    }
}
