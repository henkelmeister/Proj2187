import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;

/* 
 * This class reads the contents of a text file and produces the data 
 * as a String array, where each cell in the array containa a line
 * of text fro the file.
 */
 
public class TextFileReaderWriter {
  
   private ArrayList<String> lines;
  
   public TextFileReaderWriter(){
      lines = new ArrayList<String>();
   }

   /*
    * Attempts to find and open the file, then puts each line of text
    * into an ArrayList.
   */ 
   public void processFile(String inputFileName) throws IOException { 
    Scanner scan = new Scanner(new FileReader(inputFileName));
    while(scan.hasNext()){
       lines.add(scan.nextLine());
    }
    scan.close();
  }
  
  /*
   * Returns an array of Strings which are the lines in the text file.
   */
   public String[] getLines(){
      String[] strArr = new String[lines.size()]; 
      return lines.toArray(strArr); 
   }
  
    /*
   * Writes the report string to the specified file.
   */
  public void writeToFile(String report, String outputFileName) throws IOException{
		PrintWriter pw = new PrintWriter(outputFileName);
      pw.print(report);
      pw.close();
   }  
 }