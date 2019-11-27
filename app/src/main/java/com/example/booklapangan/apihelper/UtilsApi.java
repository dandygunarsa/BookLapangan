package com.example.booklapangan.apihelper;

public class UtilsApi {

    public static final String BASE_URL_API = "https://shielded-lake-90482.herokuapp.com/api/";

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
