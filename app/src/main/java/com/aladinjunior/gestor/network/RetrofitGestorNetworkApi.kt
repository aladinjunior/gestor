package com.aladinjunior.gestor.network


import androidx.tracing.trace
import com.aladinjunior.gestor.BuildConfig
import com.aladinjunior.gestor.feature.people.Person
import kotlinx.serialization.Serializable
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

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

@Singleton
internal class RetrofitGestorNetwork @Inject constructor(
    okHttpCallFactory: dagger.Lazy<Call.Factory>,
) : GestorNetworkDataSource {


    private val networkApi = trace("RetrofitGestorNetworkApi") {


        Retrofit.Builder()
            .baseUrl(GESTOR_BASE_URL)
            .callFactory{ okHttpCallFactory.get().newCall(it) }
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitGestorNetworkApi::class.java)
    }

    override suspend fun getPeopleByFirstName(firstName: String?): List<Person> {
        return networkApi.getPeopleByFirstName(firstName)
    }
}

