import java.util.HashMap;
import java.util.Map;

public class ExceltoColumn {


    public static void main(String[] args) {
        findColumn(26);
        findColumn(51);
        findColumn(52);
        findColumn(80);
        findColumn(676);
        findColumn(702);
        findColumn(705);


        /**
         * Input          Output
         *  26             Z
         *  51             AY
         *  52             AZ
         *  80             CB
         *  676            YZ
         *  702            ZZ
         *  705            AAC
         */

    }

    private static void findColumn(int number) {
        int columnNo = number;


        Map<Integer,String> map = new HashMap<>();
        for(int i=1;i<=26;i++)
            map.put(i,String.valueOf((char) (65+i-1)));

        StringBuffer sb = new StringBuffer();

        while(columnNo > 0){
          int rem = columnNo % 26;
          if(rem == 0){
              sb.append('Z');
              columnNo = columnNo/26   -1;

          }
          else {
              sb.append(map.get(rem));
              columnNo = columnNo/26;
          }
        }
        System.out.println(sb.reverse().toString());
    }


}
