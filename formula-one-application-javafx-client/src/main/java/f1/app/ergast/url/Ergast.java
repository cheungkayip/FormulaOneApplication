package f1.app.ergast.url;

import f1.app.global.GlobalF1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by kayipcheung on 01-12-15.
 */

public class Ergast {

    public String callUrlToGetJSONData(String incomingJSONUrl) throws IOException {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn;
        InputStreamReader in = null;
        try {
            URL url = new URL(incomingJSONUrl);
            urlConn = url.openConnection();
            if (urlConn != null) {
                urlConn.setReadTimeout(60 * 1000);
            }
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
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

    public String decideTheRightJSON(String resource, String incomingJSONUrl) throws IOException {
        String output = null;
        switch (incomingJSONUrl) {
            case GlobalF1.DRIVERS_JSON:
                if(resource.equals(GlobalF1.SAVED_JSON_DIR_TEST)){
                    output = checkFile(incomingJSONUrl, GlobalF1.SAVED_JSON_DIR_TEST + "drivers.json");
                }else{
                    output = checkFile(incomingJSONUrl, GlobalF1.SAVED_JSON_DIR + "drivers.json");
                }
                break;
            case GlobalF1.DRIVER_STANDINGS_JSON:
                if(resource.equals(GlobalF1.SAVED_JSON_DIR_TEST)){
                    output = checkFile(incomingJSONUrl, GlobalF1.SAVED_JSON_DIR_TEST + "driverStandings.json");
                }else{
                    output = checkFile(incomingJSONUrl, GlobalF1.SAVED_JSON_DIR + "driverStandings.json");
                }
                break;
            case GlobalF1.CONSTRUCTORS_JSON:
                if(resource.equals(GlobalF1.SAVED_JSON_DIR_TEST)){
                    output = checkFile(incomingJSONUrl, GlobalF1.SAVED_JSON_DIR_TEST + "Constructors.json");
                }else{
                    output = checkFile(incomingJSONUrl, GlobalF1.SAVED_JSON_DIR + "Constructors.json");
                }
                break;
            case GlobalF1.CONSTRUCTORS_STANDINGS_JSON:
                if(resource.equals(GlobalF1.SAVED_JSON_DIR_TEST)){
                    output = checkFile(incomingJSONUrl, GlobalF1.SAVED_JSON_DIR_TEST + "constructorStandings.json");
                }else{
                    output = checkFile(incomingJSONUrl, GlobalF1.SAVED_JSON_DIR + "constructorStandings.json");
                }
                break;
            case GlobalF1.CIRCUITS_JSON:
                if(resource.equals(GlobalF1.SAVED_JSON_DIR_TEST)){
                    output = checkFile(incomingJSONUrl, GlobalF1.SAVED_JSON_DIR_TEST + "circuits.json");
                }else{
                    output = checkFile(incomingJSONUrl, GlobalF1.SAVED_JSON_DIR + "circuits.json");
                }
                break;
            default:
                System.out.println("No Json Url Found");
                break;
        }

        return output;
    }

    public String checkFile(String incomingJSONUrl, String fileName) throws IOException {
        File file = new File(fileName);
        String result = "";
        if (file.exists()) {
            System.out.println(fileName + " File existed so the data is read from the JSON File");
            // read from JSON File instead of URL
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } else {
            System.out.println(fileName + " File not found! So we create the File and write the data to it");
            result = callUrlToGetJSONData(incomingJSONUrl);
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(result);
            bw.close();
        }
        return result;
    }
}
