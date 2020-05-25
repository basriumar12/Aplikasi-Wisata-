package id.co.blogbasbas.wisatasemarang.network

import id.co.blogbasbas.wisatasemarang.Konstanta
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by idn on 10/30/2017.
 */
object RetrofitConfig {
    //.baseUrl("http://52.187.117.60/wisata_semarang/wisata/")
    //                .client(client)
    private val retrofit: Retrofit
        private get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60L, TimeUnit.SECONDS)
                    .writeTimeout(60L, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build()
            return Retrofit.Builder() //.baseUrl("http://52.187.117.60/wisata_semarang/wisata/")
                    .client(httpClient)
                    .baseUrl(Konstanta.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create()) //                .client(client)
                    .build()
        }

    @JvmStatic
    val apiServices: ApiServices
        get() = retrofit.create(ApiServices::class.java)
}