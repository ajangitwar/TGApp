package com.example.tgapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
//    @GET("register.php")
//    Call<User> performRegistration(@Query("name") String name, @Query("Uname") String Uname,@Query("upass") String upass);

    @GET("login.php")
    Call<User> performUserLogin(@Query("user_name")String uname,@Query("user_password") String pass);

}
