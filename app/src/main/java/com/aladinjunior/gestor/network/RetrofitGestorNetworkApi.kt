package com.aladinjunior.gestor.network


import androidx.tracing.trace
import com.aladinjunior.gestor.BuildConfig
import com.aladinjunior.gestor.people.domain.model.Person
import kotlinx.serialization.Serializable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private interface RetrofitGestorNetworkApi {

    @GET("api/Pessoa/primeiroNome")
    suspend fun getPeopleByFirstName(
        @Query("primeiroNome") firstName: String?
    ) : List<Person>

}


private const val GESTOR_BASE_URL = BuildConfig.BASE_URL


@Serializable
private data class NetworkResponse<T>(
    val data: T
)

internal class RetrofitGestorNetwork() : GestorNetworkDataSource {


    private val networkApi = trace("RetrofitGestorNetworkApi") {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(GESTOR_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitGestorNetworkApi::class.java)
    }

    override suspend fun getPeopleByFirstName(firstName: String?): List<Person> {
        return networkApi.getPeopleByFirstName(firstName)
    }
}

