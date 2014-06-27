package com.komodo.timesheet.rest;

import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by david on 27/06/14.
 */
public class RestClient {

    public JSONObject getAsObject(String url, String username, String pass)
    {
        System.out.println("GET URL: " + url);
        try {
            return new JSONObject(getAction(url, username, pass));

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public JSONArray getAsArray(String url, String username, String pass){
        try {
            return new JSONArray(getAction(url, username, pass));

        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    private String getAction(String url, String username, String pass) throws Exception
    {
        System.out.println("GET URL: " + url);

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        /*httpGet.addHeader(BasicScheme.authenticate(
            new UsernamePasswordCredentials(username, pass), "UTF-8", false));*/
        HttpResponse response = httpClient.execute(httpGet);

        if (response.getStatusLine().getStatusCode() != 200){
            return null;
        }

        return EntityUtils.toString(response.getEntity());
    }
}
