package com.by.myapp.moudle

import android.util.Log
import com.by.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URLDecoder
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
//    internal fun provideService(baseUrl : String): ApiService =
//        createNetworkClient(baseUrl, BuildConfig.DEBUG)
//            .build()
//            .create(ApiService::class.java)
    private const val TAG = "NetworkModule"
    private const val DEFAULT_READ_TIMEOUT_MILLIS: Long = (15 * 1000).toLong()
    private  const val DEFAULT_WRITE_TIMEOUT_MILLIS = (20 * 1000).toLong()
    private const val DEFAULT_CONNECT_TIMEOUT_MILLIS = (20 * 1000).toLong()


    @Singleton
    @Provides
    fun provideOkHttp() : OkHttpClient {
        val interceptor = HttpLoggingInterceptor { message ->
            try {
                val text: String = URLDecoder.decode(message, "utf-8")
//                <-- HTTP FAILED: java.net.UnknownHostException: Unable to resolve host "howtodoandroid.com": No address associated with hostname
                Log.d("OKHttp ytf 请求成功-----", text)
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("OKHttp ytf 请求失败-----", message)
            }
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
//            .readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
//            .writeTimeout(DEFAULT_WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
//            .connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .build()
    }

    @Singleton
    @Provides
    @Named("loggingInterceptor")
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://howtodoandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideApiClient(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}