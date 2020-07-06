import java.util.ArrayList;
import java.util.Collections;
import java.lang.String;

/* This class makes a count of the occurrance of words of length >=4
 * in a text and reports on the n most frequent words, where n is an integer passed 
 * in to the constructor. 
 * Note only words of length > 4 are counted. Words are also "stopped" by removing
 * an 's' if it is the last character in the word before counting.This is because in
 * English and some other languages, the trailing letter s is a plural version of the 
 * same word, and we want to count the singular and plural versions as the same word. 
 * For example, in the text: "The hound was one of the hounds.",
 * The word "hound" is counted twice because "hounds" is counted as "hound"
 * (the word "hounds" is not counted seperately).
 * This class maintains a list of words that have been observed in the text along with
 * a count of the number of times that word has been observed.
 * The WordCount class may be used to keep track of the words that have been observed 
 * and their number of occurences in the lines of text.
 * 
*/
public class MostFrequentWordsAnalyzer implements TextAnalyzer {

   //TODO3: write the rest of this class. Declare any instance variables you need
   //       and implement the TextAnalyzer methods.
   //       Hint: You will need an ArrayList, an int, and a String Array

private ArrayList<WordCount> masterList; 
private WordCount[] topWordList;
private int numTopWords;

   
   /* Implement the constructor which takes an int parameter to initialize the number
    * of top words.
   */
   public MostFrequentWordsAnalyzer(int numTopWords){
   topWordList = new WordCount[numTopWords];
   masterList = new ArrayList<WordCount>();
   this.numTopWords = numTopWords; 
   }
   
   /** Implement analyzeData:
   *  This method processes the lines of test, where each line of text is processed
   *  in the following manner:
   *  1) It tokenizes the line of text by calling the String method split with this 
   *     argument:  line.split("[,.;:?!() ]")
   *     Each token is a "word", which is a String in the array returned from the call to split. 
   *  2) The token should be checked for an ending letter "s", which
   *     is removed if it exists.   
   *  3) After removing a trailing 's', the word length should be > 4. 
   *  4) The list of words that have been observed is checked to see if the current word 
   *     has been seen before. If so, its count is incremented. If not, the word is added to the
   *     list along with a count of 1.
   **/
   
   // Suggestion1: write an analyzeLine helper method to process each line.**
   // Suggestion2: write a helper method to remove the trailing 's' froma word.
   // Suggestion3: write a helper method that given a word, look for it in the 
   //              list of WordCounts and returns that object if found, otherwise 
   //              returns null if that word is not on the list. 
   
   public void analyzeData(String[] textData){
      int curMost = 0;
      WordCount currLargest = null;
      for(String str:textData){
         breakDownStr(str);
      }
      ArrayList<WordCount> tempList = masterList; 
      for(int i=0;i < numTopWords;i++){
         for(WordCount currWord:tempList){
            if(currWord.getCount() > curMost){
               currLargest = currWord;
               curMost = currWord.getCount();
            }
            continue;
            }
       topWordList[i] = currLargest;
       removeFromList(currLargest,tempList); 
       currLargest = null;  
       curMost = 0;
      }
   }

   
  /* Implement getResultData:
   * Return an array with data from the result of the analysis.
   * In this case, the array will contain only the n most frequently observed words
   * in the text in descending order: the most frequently observed word first, etc. 
   * Note the array will contain only the words and not the counts. 
   */
   public String[] getResultData(){
   String[] tempArr;
   int printable = 0;
   for(int j=0;j < topWordList.length;j++){
      if(!(topWordList[j] == null))printable++;
   }
   tempArr = new String[printable];
   
   for(int i=0; i<printable;i++){
      tempArr[i] = topWordList[i].getWord();
   }
   return tempArr;
   }
   
  /* Implement getReportStr:
   * Assembles and returns the report as a String of the top n most commonly 
   * occurring words in this format:
   *          Top N most common words of length >= 4.
   *          word1 count1 
   *          word2 count2
   *          etc...
   *          wordN countN
   * -where N is the number passed in to this constructor.
   * See the documentation for examples.
  */  
   public String getReportStr(){
   String report = "Top "+numTopWords+" most common words of length > 4.\n";
   
   for(int i=0;i<topWordList.length;i++){
      if(topWordList[i] == null)continue; 
      if(i == topWordList.length){
         report += topWordList[i].toString();
      }
   
   report += topWordList[i].toString() + "\n";
   }
   
   return report;}
   
   private void breakDownStr(String str){ //breaks down the string and calls the addToList method 
      String[] tempArr = str.split("[,.;:?!() ]");
      
      for(String string:tempArr){
         if(string.length() > 4){
            if(string.charAt(string.length()-1)=='s' && string.length() == 5){
               continue; 
            }
            if(string.charAt(string.length()-1)=='s'){
               addToList(string.substring(0,string.length()-1));
            }else{
               addToList(string);
            }   
         }
      }
   }
   
   private void addToList(String str){
      if(masterList.size() == 0){
      masterList.add(new WordCount(str));
      return;
      }
      for(WordCount word:masterList){
         if(word.containsWord(str)){
            word.incCount();
            return; 
         }
      }
      masterList.add(new WordCount(str));
      return; 
   }
   
   private void removeFromList(WordCount currLargest,ArrayList<WordCount> tempList){
      for(int i=0;i < tempList.size();i++){
         if(currLargest.getWord().equalsIgnoreCase(tempList.get(i).getWord())){
            tempList.remove(i);
            return; 
         }
      }
   }
}
