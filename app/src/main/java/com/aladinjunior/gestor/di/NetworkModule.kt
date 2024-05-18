package com.aladinjunior.gestor.di

import androidx.tracing.trace
import com.aladinjunior.gestor.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Singleton
    @Provides
    fun okHttpCallFactory() : Call.Factory = trace("GestorOkHttpClient"){
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .apply {
                        if (BuildConfig.DEBUG) {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        }
                    },
            )
            .build()

    }

//    @Binds
//    fun bindsNetworkDataSource(
//        networkDataSource: RetrofitGestorNetwork
//    ) : GestorNetworkDataSource
}