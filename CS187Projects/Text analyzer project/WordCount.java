/*
 * This class encapsulates a word and the number of times it has been
 * observed.
 */
 
 public class WordCount implements Comparable {
   private String word;
   private int count;
   
   public WordCount(String wd){
      word=wd;
      count=1;  
      
   }
   /*
    * Returns true if this word is equal to the targetWd.
    */
   public boolean containsWord(String targetWd){
       return (word.equals(targetWd));
   }
   
   public String getWord(){return word;}
   
   public void incCount(){
      count++;
   }
   
   public int getCount(){
      return count;
   }
   
   /*
    * Compares this count to the other count.
    * Returns a positive int if this count 
    
    > other count,
    * returns a negative int if this count < other count,
    * returns 0 if this count = other count.
    */
   public int compareTo(Object other){
      WordCount otherCount = (WordCount)other;
      return this.count - otherCount.getCount();
   }
   
   public String toString(){
      return word+" "+count;
   }
}