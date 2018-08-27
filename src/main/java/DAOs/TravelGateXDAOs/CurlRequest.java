package DAOs.TravelGateXDAOs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static Helper.ProjectProperties.travelXGateApikey;

/**
 * Created by George on 04/07/2018.
 */
public class CurlRequest {


    public static String request(String request) {
        String response="";
        try {

            String url = "https://api.travelgatex.com";

            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Apikey "+travelXGateApikey);
           // conn.setRequestProperty("Accept-Encoding", "gzip");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(request);
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";

            while ((line = reader.readLine())!= null)
            {
                response=response+line + "\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
