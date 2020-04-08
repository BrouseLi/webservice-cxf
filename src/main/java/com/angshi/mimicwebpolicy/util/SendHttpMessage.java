package com.angshi.mimicwebpolicy.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class SendHttpMessage {
    public static String sendMessage(String url,String policy) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url+"?policy="+policy).get().build();
        Response response=okHttpClient.newCall(request).execute();
        return response.body().string();
    }
    public static String softUpdate(String ip,String name) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://"+ip+":8080/setupSoft?fileName="+name).get().build();
        Response response=okHttpClient.newCall(request).execute();
        return response.body().string();
    }
}
