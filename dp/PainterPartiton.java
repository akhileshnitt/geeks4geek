package dp;

import java.util.Arrays;

public class PainterPartiton {

    public static void main(String[] args) {
        int board [] =  {10,20,30,40};

        int noOfPainter = 2;
        int minTimeRequiredToPaint = Arrays.stream(board).sum();

        int low = board[board.length-1];
        int high = Arrays.stream(board).sum();

        while(low < high){
            int mid = low+ (high-low)/2;

            int neededPainter = findNoOfPainter(board,mid);
            if(neededPainter <= noOfPainter){
                if(mid <minTimeRequiredToPaint ){
                    minTimeRequiredToPaint = mid;

                }
                high = mid-1;
            }
            else{
                low = mid+1;
            }

            System.out.println("painter :"+neededPainter +" minTime :"+minTimeRequiredToPaint);


        }

        System.out.println("minTimeRequiredToPaint :"+minTimeRequiredToPaint);
    }

    private static int findNoOfPainter(int[] board, int mid) {
        int painter =1;

        int cost =0;
        for(int i=0;i<board.length;i++){
            if(cost+board[i] <=mid) {
                cost += board[i];
            }
            else{
                i--;
                cost =0;
                painter++;
            }
        }
        return painter;
    }
}
