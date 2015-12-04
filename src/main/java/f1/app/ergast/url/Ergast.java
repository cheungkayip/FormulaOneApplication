package f1.app.ergast.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by kayipcheung on 01-12-15.
 */

public class Ergast {

    public String callUrlToGetJSONData(String myURL) throws IOException {
    StringBuilder sb = new StringBuilder();
    URLConnection urlConn = null;
    InputStreamReader in = null;
    try{
        URL url = new URL(myURL);
        urlConn = url.openConnection();
        if(urlConn != null){
            urlConn.setReadTimeout(60 * 1000);
        }
        if(urlConn != null && urlConn.getInputStream() != null){
            in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if(bufferedReader != null){
                int cp;
                while((cp = bufferedReader.read()) != -1){
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
        }
        in.close();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    return sb.toString();
}


}
