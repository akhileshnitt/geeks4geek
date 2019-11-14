package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSequencingUnionFind {

    public static void main(String[] args) {

        List<Job> jobList = new ArrayList<>();

       /* jobList.add(new Job('a',4,20));
        jobList.add(new Job('b',1,10));
        jobList.add(new Job('c',1,40));
        jobList.add(new Job('d',1,30));*/


       // 0 ,1 ,2, 3, 4
       // 0, 1 ,1, 3, 4

        jobList.add(new Job('a',2,100));
        jobList.add(new Job('b',1,19));
        jobList.add(new Job('c',2,27));
        jobList.add(new Job('d',1,25));
        jobList.add(new Job('e',3,15));

      /*  Collections.sort(jobList, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.profit -o2.profit <0 ?1:-1;
            }
        });*/

        Collections.sort(jobList,(Job o1,Job o2)-> o1.profit -o2.profit <0 ?1:-1);

        System.out.println(jobList);


        int parent [] = new int[jobList.size()+1];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }

        int maxProfit=0;

        for(Job job : jobList){
            int deadLine = job.deadline;

            int availableSlot = find(parent,deadLine);
            if(availableSlot >0){
                maxProfit+=job.profit;
                System.out.print(job.jobId+",");
                //merge
                parent[availableSlot] = parent[availableSlot-1];
            }

        }

        System.out.println();
        System.out.println(maxProfit);
    }

    private static int find(int[] parent, int deadLine) {

       if(parent[deadLine] == deadLine){
           return deadLine;
       }
       return  find(parent,parent[deadLine]);
    }
}

class Job{
    char jobId;
    int deadline;
    int profit;

    public Job(char jobId, int deadline, int profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }


    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}
