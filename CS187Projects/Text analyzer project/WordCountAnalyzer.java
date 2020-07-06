/* This class makes a count of the occurrance of all words of length >=4
 * in a text and reports on that count. 
 * Note only words of length > 4 are counted. 
 * 
*/

public class WordCountAnalyzer implements TextAnalyzer {

   //TODO2: write the rest of this class. Declare any instance variables you need
   //       and implement the TextAnalyzer methods.
   //       Hint: You will need a variable to count with and a String Array
   
   public int count; 
   
   /**Implement analyzeData:
   *  This method processes the lines of test, where each line of text is processed
   *  in the following manner:
   *  1) It tokenizes the line of text by calling the String method split with this 
   *     argument:  line.split("[,.;:?!() ]")
   *     Each token is a "word", which is a String in the array returned from the call to split. 
   *  2) Only words of length >=4 are considered in updating the word count.
   **/
   
    // Suggestion: write an analyzeLine helper method to process each line.
   public void analyzeData(String[] textData){
      count = 0;
   
      for(String line:textData){
         
         count += lineProcessor(line);
      
   }
   
   
   }
   
  /* Implement getResultData:
   * Returns an array with data from the result of the analysis.
   * In this case, there will be one value in this array. 
   * Note the array is of type String, so an int must be 
   * converted to a String before it can be placed on the array.
   */
   public String[] getResultData(){
      String[] resultData = new String[1];
      resultData[0] = count + "";
      return resultData;
   }
   
   /* Implement getReportStr:
    * For e.g. if the word count was 1543, return a count of the number of unique words in a text file
    * as a String in this format:
    * "Number of words of length >=4: 1543" 
    */ 
   public String getReportStr(){return "Number of words of length > 4: " + count;}
   
   private int lineProcessor(String line){
      int addToCount = 0;
      String[] tempArr = line.split("[,.;:?!() ]");
   
      for(String word:tempArr){
         if(word.length() > 4){
            addToCount += 1;
         }
      }
      
      return addToCount; 
   
   }
   
}

