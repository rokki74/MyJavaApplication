
package com.example.myjavaapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    // my path to students: http://192.168.43.75:3000/api/students
    //https://jsonplaceholder.typicode.com/
    private static final String BASE_URL = "http://192.168.43.75:3000";

         // Use 10.0.2.2 for localhost in emulator
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}