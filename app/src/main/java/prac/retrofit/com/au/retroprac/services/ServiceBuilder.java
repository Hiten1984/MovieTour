package prac.retrofit.com.au.retroprac.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import prac.retrofit.com.au.retroprac.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hbahri on 20/2/18.
 */

public class ServiceBuilder {

    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create());

    static Retrofit retrofit = builder.build();

    public static <S> S buildService(Class<S> serviceType) {
        return retrofit.create(serviceType);
    }


}
