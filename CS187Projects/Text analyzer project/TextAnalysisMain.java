import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class TextAnalysisMain{

   public static void main(String[] args) throws IOException{
  
      TextFileReaderWriter tfproc = new TextFileReaderWriter();
      ArrayList<TextAnalyzer> analyzers = getAnalyzers();
      String inputFileName, outputFileName;
      String[] textData = null;
      String reportStr = null;
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter a text file name to analyze: \nFormat as: Data\\FileName.extension");
      inputFileName = scan.nextLine();
      try{
         tfproc.processFile(inputFileName);
         textData = tfproc.getLines();
      }
      catch(IOException ioex){
          System.out.println("Error accessing file: "+inputFileName);
          System.out.println(ioex);
      }
      catch(Exception ex){
          System.out.println(ex);
      }
      if(textData!=null) {
         for(TextAnalyzer curAnalyzer : analyzers) {
            curAnalyzer.analyzeData(textData);
         }
      /************************/
        // To test the getResultData method uncoment:
        /*
            String[] resultArr=null;
            System.out.println("\nBEGIN testing getResultData:");
            for(TextAnalyzer curADnalyzer : analyzers)
              resultArr = curAnalyzer.getResultData();
              for(String curRes : resultArr)
                 System.out.println(curRes);
            System.out.println("END esting getResultData.\n");
         */
      /******************/
         System.out.println("Analyzed text: " + inputFileName);
         reportStr = getReportStr(analyzers);      
         System.out.println(reportStr);
         System.out.println("Enter a file to write report, N to skip. ");
         outputFileName = scan.nextLine();
         if(!outputFileName.equalsIgnoreCase("N"))
            try {
               tfproc.writeToFile(reportStr, outputFileName);
            }
            catch(IOException ioex){
                System.out.println("Error accessing file: "+outputFileName);
                System.out.println(ioex);
            }
      }// end if textData not null
   }//end main
   
   /* Creates a list of the text analyzers to be applied to the text file under analysis.
      Add any new analyzers here by adding an instance of the new analyzer class.
   */
   private static ArrayList<TextAnalyzer> getAnalyzers(){
      ArrayList<TextAnalyzer> analyzers = new ArrayList<TextAnalyzer>();
      analyzers.add(new LineCountAnalyzer());
      analyzers.add(new WordCountAnalyzer());
      analyzers.add(new MostFrequentWordsAnalyzer(5));
      return analyzers;
   }
   
   /* This method collects the reports from all of the analyzers and produces 
      a String for either printing or writing to a file.
    */
   private static String getReportStr(ArrayList<TextAnalyzer> analyzers){
      StringBuilder sb = new StringBuilder();
      for(TextAnalyzer curAnalyzer : analyzers) {
         sb.append(curAnalyzer.getReportStr());
         sb.append(System.getProperty("line.separator"));
      }
      return sb.toString();
   }
}