//We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

//You're given the startTime, endTime and profit arrays, 
//return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

//If you choose a job that ends at time X you will be able to start another job that starts at time X.

//Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//Output: 120
//Explanation: The subset chosen is the first and fourth job. 
//Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

public class JobSchedulingForMaximumProfit{
  public static class Job{
    public int start;
    public int end;
    public int profit;
    
    public Job(int start,int end,int profit){
      this.start=start;
      this.end=end;
      this.profit=profit;
    }
  }
  
  public void maxProfit(int[] start,int[] end,int[] profit){
    Job[] jobs=new Job[start.length];
    for(int i=0;i<start.length;i++){
      Job job=new Job(start[i],end[i],profit[i]);
    }
    
    Comparator<Job> comp=new Comparator<>(){
      @Override
      public int compare(Job o1,Job o2){
        return o1.end-o2.end;
      }
    };
    
    Arrays.sort(jobs,comp);
    TreeMap<Integer,Integer> map=new TreeMap<>();
    map.put(0,0);
    for(int i=0;i<start.length;i++){
      int currentprofit= jobs[i].profit+map.floorEntry(jobs[i].start).getValue();
      if(currentprofit>map.lastEntry().getValue()){
        map.put(jobs[i].end,currentprofit);
      }
    }
    
    System.out.println("MaxProfit="+map.lastEntry().getValue();
  }
}

