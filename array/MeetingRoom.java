package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoom {

    public static void main(String[] args) {
        int start []={1, 3, 0, 5, 8, 5};
        int end [] ={2, 4, 6, 7, 9, 9};

        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meetings.add(new Meeting(start[i],end[i]));

        }

        Collections.sort(meetings, (m1,m2)-> {
            //@Override
           // public int compare(Meeting m1, Meeting m2) {
                if(m1.end - m2.end <0) return -1;
                else if(m1.end == m2.end) return 0;
                else return 1;
          //  }
        });

       // meetings.forEach(e-> System.out.println(e.start +" "+e.end));

        List<Meeting> maxMeeting = new ArrayList<>();
        maxMeeting.add(meetings.get(0));

        for(int i=1;i<meetings.size();i++){
            Meeting temp = maxMeeting.get(maxMeeting.size()-1);
            if(meetings.get(i).start > temp.end ){
                maxMeeting.add(meetings.get(i));
            }
        }

        maxMeeting.forEach(e-> System.out.println(e.start +" "+e.end));
    }
}


class Meeting{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}