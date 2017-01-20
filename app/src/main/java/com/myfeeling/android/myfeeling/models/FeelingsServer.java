package com.myfeeling.android.myfeeling.models;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static android.R.attr.port;

/**
 * Created by fcng1847 on 20/01/17.
 */

public class FeelingsServer {
    final URI uri;
    final static int SUCCESS = 1;
    final static int FAILURE = 0;

    FeelingsServer(URI uri){
        this.uri = uri;
    }

    int postFeeling(Feeling feeling){

        return FAILURE;
    }


    /**
     * from :
     * <a href="https://developer.android.com/training/basics/network-ops/connecting.html">android tuto</a>
     * and
     * https://developer.android.com/reference/java/net/HttpURLConnection.html
     * @param url
     * @return
     * @throws IOException
     */
    private String PutUrl(URL url) throws IOException {
        InputStream stream = null;
        HttpsURLConnection connection = null;
        String result = null;
        try {
            connection = (HttpsURLConnection) url.openConnection(); // todo no https at first
            // Timeout for reading InputStream arbitrarily set to 3000ms.
            connection.setReadTimeout(5000);
            // Timeout for connection.connect() arbitrarily set to 3000ms.
            connection.setConnectTimeout(5000);
            // For this use case, set HTTP method to PUT.
            connection.setRequestMethod("PUT");
            // Already true by default but setting just in case; needs to be true since this request
            // is carrying an input (response) body.
            connection.setDoOutput(true); // todo server response body will be timestamp ?
            connection.setFixedLengthStreamingMode(sizeof(OBJECTTOSEND))

            try {
                urlConnection.setDoOutput(true);
                urlConnection.setChunkedStreamingMode(0);

                OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                writeStream(out);

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                readStream(in);
            } finally {
                urlConnection.disconnect();
            }



            // Open communications link (network traffic occurs here).
            connection.connect();
            //publishProgress(DownloadCallback.Progress.CONNECT_SUCCESS);
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpsURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code: " + responseCode);
            }
            // Retrieve the response body as an InputStream.
            stream = connection.getInputStream();
            publishProgress(DownloadCallback.Progress.GET_INPUT_STREAM_SUCCESS, 0);
            if (stream != null) {
                // Converts Stream to String with max length of 500.
                result = readStream(stream, 500);
            }
        } finally {
            // Close Stream and disconnect HTTPS connection.
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }



}
