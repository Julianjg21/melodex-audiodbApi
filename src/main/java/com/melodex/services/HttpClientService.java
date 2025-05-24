package com.melodex.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientService {

    //Method that performs a GET request and returns the body of the response as string
    public static String sendGetRequest(String urlStr) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Open http connection

            //Configurer get method
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            //Get the response code
            int responseCode = connection.getResponseCode();

            //Verify the response code
            if (responseCode == HttpURLConnection.HTTP_OK) {
                //Read the content of the response if the code is 200
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );

                String inputLine;
                // Read each line and append it to the response
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                //Close the bufferedReader
                in.close();

            } else {
                response.append("Error: Response code: ").append(responseCode);
            }
            // Disconnect the HTTP connection
            connection.disconnect();

        } catch (Exception e) {
            // Print stack trace and return the exception message
            e.printStackTrace();
            response.append("Exception: ").append(e.getMessage());
        }

        //Return the complete response as a String
        return response.toString();


    }
}
