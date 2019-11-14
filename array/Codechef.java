package array;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        openAndClosePrices("26-March-2001", "15-August-2001", "Wednesday");
    }

    static void openAndClosePrices(String firstDate, String lastDate, String weekDay) throws Exception{
        Date fDate = new SimpleDateFormat("d-MMMM-yyyy").parse(firstDate);
        Date lDate = new SimpleDateFormat("d-MMMM-yyyy").parse(lastDate);
        StringBuilder result = new StringBuilder();
       // String urlToRead = "https://jsonmock.hackerrank.com/api/stocks/?page=1";

        String urlToRead = "https://jsonmock.hackerrank.com/api/stocks";

        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

       // System.out.println(result);
        Gson gson = new Gson();
        Res obj2 = gson.fromJson(result.toString(), Res.class);

        int totalPages = Integer.valueOf(obj2.total_pages);

      //  System.out.println(obj2.total_pages);




        for(int i=2;i<=totalPages;i++){
            String urlToRead1 = "https://jsonmock.hackerrank.com/api/stocks/?page="+i;
            StringBuilder result1 = new StringBuilder();
            URL url1 = new URL(urlToRead1);
            HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
            conn1.setRequestMethod("GET");
            BufferedReader rd1 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
            String line1;
            while ((line1 = rd1.readLine()) != null) {
                result1.append(line1);
            }
            rd1.close();
            obj2.data.addAll(gson.fromJson(result1.toString(), Res.class).data);
        }




        for(Map<String, String> data : obj2.data){
            Date date=new SimpleDateFormat("d-MMMM-yyyy").parse(data.get("date"));
            SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");


            if(date.compareTo(fDate) >= 0 && date.compareTo(lDate) <= 0 && simpleDateformat.format(date).toLowerCase().equalsIgnoreCase(weekDay)){
                System.out.println(data.get("date") + " " + data.get("open") + " " + data.get("close"));
            }

        }
    }
}

class Res {
    String page;
    String per_page;
    String total;
    String total_pages;
    List<Map<String, String>> data;
}

class Data {
    List<Map<String, String>> data;
}