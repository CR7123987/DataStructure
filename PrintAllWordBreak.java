	//Given a string s, break s such that every substring of the partition can be found in the dictionary. Return the minimum break needed. 
public class TreeNode{
  private TreeNode[] children;
  private boolean isEndOfWord;
  public TreeNode(){
    this.children = new TreeNode[26];
    for(int i=0;i<26;i++){
      this.children[i]=null;
    }
    this.isEndOfWord=false;
  }
  
  public void insert(TreeNode root,String word){
    TreeNode current=root;
    for(int i=0;i<word.length();i++){
      char ch=word.charAt(i);
      int index= ch-'a';
      if(current.children[index]==null){
        current.children[index]=ch;
      }
      current=current.children[index];
    }
    current.isEndOfWord=true;
  }
  
  public boolean search(TreeNode root,String word){
    TreeNode current=root;
    for(int i=0;i<word.length();i++){
      char ch=word.charAt(i);
      int index=ch-'a';
      if(current.children[index]!=null){
        current=current.children[index];
      }else{
        return false;
      }
      
      if(current!=null && current.isEndOfWord){
        return true;
      }
      
      return false;
    }
  }
  
  public void printAllwordBreak(String[] dict,String sent){
    TreeNode root=new TreeNode();
    for(int i=0i<dict.length;i++){
      insert(root,dict[i]]);
    }
    
    for(int i=0;i<sent.length();i++){
      if(search(root,sent.substring(0,i+1)){
        printAllwordBrealUtil(root,sent,sent.substring(0,i+1),i+1);
      }
    }
  }
 
  public void printAllwordBrealUtil(TreeNode root,String sent,String currentSentence,int nextwordsearchposition){
    if(nextwordsearchposition==sent.length()){
      System.out.println(currentSentence);
    }
    
    currentSentence=currentSentence+" ";
    
    for(int i=pos;i<sent.length();i++){
      if(search(root,sent.substring(pos,i+1)){
        printAllwordBrealUtil(root,sent,currentSentence+sent.substring(pos,i+1),i+1);
      }
    }
  }
  
  public static void main(String[] args){
    	      String[] dictionary = { "mobile", "samsung",  "sam",  "sung", "man",
	                "mango",  "icecream", "and",  "go",   "i",
	                "like",   "ice",      "cream" };
    
    String sentence="ilikeicecream";
    wordBreak(dictionary,senetence);    
  }
}
