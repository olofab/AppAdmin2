package com.example.andreasbergman.appadmin2;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by andreasbergman on 09/11/16.
 */

public class HttpConnect {
    String url;
    String result;

    public HttpConnect(){
    }

    public String runRequest(String url){
       new JSONTask().execute(url);
        return result;
    }


    public class JSONTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... urls) {
            HttpURLConnection connection = null;
            BufferedReader bufferedReader = null;

            try{
                URL url = new URL(urls[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    buffer.append(line);

                }
                String finalJSONString = buffer.toString();

                JSONArray pArray = new JSONArray(finalJSONString);

                String svar = "";

                for (int i = 0; i < pArray.length(); i++){
                    JSONObject e = pArray.getJSONObject(i);

                    svar += "ID: " + e.getInt("lockerId") + " ";

                }

                return finalJSONString;
            }catch (MalformedURLException e){

            }catch (IOException e){

            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection != null){
                    connection.disconnect();
                }

                try {
                    if (bufferedReader != null){
                        bufferedReader.close();
                    }
                } catch (IOException e) {

                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
             result = s;
        }
    }
}
