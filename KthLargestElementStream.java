//Design a class to efficiently find the Kth largest element in a stream of numbers.
public class KthLargestElementStream{
  private int[] array;
  private PriorityQueue<Integer> queue;
  private int size;
   public KthLargestElementStream(int[] array,k){
      this.array=array;
     this.size=k;
     queue=new PriorityQueue<>();
     for(int i=0;i<array.length;i++){
        queue.add(array[i]);
       if(queue.size()>size){
         //removing the smallest,only k elemnts are left in queue and kth largest element is the next smallest
        queue.poll();
       }
     }
   }
  
  public void add(int n){
    queue.add(n);
    if(queue.size()>size){
      //removing the smallest,only k elemnts are left in queue and kth largest element is the next smallest
      queue.poll();
    }
  }
  
  public int get(){
    return queue.peek();
  }
}
