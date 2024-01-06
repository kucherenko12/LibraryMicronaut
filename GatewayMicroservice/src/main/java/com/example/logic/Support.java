package com.example.logic;

import java.net.HttpURLConnection;
import java.net.URL;

public class Support
{
    public static HttpURLConnection ConstuctHttpURLConnection(String URLString, String type)
    {
        try
        {
            final URL url = new URL(URLString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(type);
            //connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(50000); //set timeout to 50 seconds
            connection.setReadTimeout(50000); //set timeout to 50 seconds
            return connection;
        }
        catch (final Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
