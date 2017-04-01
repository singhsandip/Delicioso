package com.example.sandeep.myapplication.BackgroundWork;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.sandeep.myapplication.Interface.Get_Jason_Data;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by sandeep on 19-01-2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String>
{

    Context context;
    AlertDialog alertDialog;
    Get_Jason_Data get_jason_data;
    public BackgroundWorker(Context c, Get_Jason_Data get_jason_data)
    {
       context = c;
        this.get_jason_data = get_jason_data;
    }

    @Override
    protected String doInBackground(String... params)
    {
     //   String resulttype = "";
        String url = "http://singh0396.esy.es/actual_insert.php";
        String url_feedback = "http://singh0396.esy.es/feedback.php";
        String url_getdata = "http://singh0396.esy.es/getdata.php";
        String type = params[0];
        /*if (type.equals("feedback"))
        {
            try {
                String phone = params[1];
                String feedback = params[2];
                URL url1 = new URL(url_feedback);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url1.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String postdata =URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("feedback","UTF-8")+"="+URLEncoder.encode(feedback,"UTF-8");
                 bufferedWriter.write(postdata);

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                //resulttype = "feedback";
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("complaints"))
        {
            try {
                String name = params[1];
                String email = params[2];
                String details = params[3];
                URL url1 = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postdata = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                        + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                        + URLEncoder.encode("details", "UTF-8") + "=" + URLEncoder.encode(details, "UTF-8");
                bufferedWriter.write(postdata);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }*/
         if(type.equals("getdata"))
        {
            try
            {
                URL url1 = new URL(url_getdata);
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet request = new HttpGet(String.valueOf(url1));
                BasicResponseHandler handler = new BasicResponseHandler();

                String result = httpClient.execute(request,handler);

                return result;
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(type.equals("special"))
        {
            try {
                URL url1 = new URL(url_getdata);
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet request = new HttpGet(String.valueOf(url1));
                BasicResponseHandler handler = new BasicResponseHandler();

                String result = httpClient.execute(request,handler);

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute()
    {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Add Complaits Status");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result)
    {
        //alertDialog.setMessage(result);
        //alertDialog.show();
       //get_jason_data = (Get_Jason_Data) this;
       get_jason_data.sendJasonData(result);

        //Log.d("myresult",""+result);

    }
}
