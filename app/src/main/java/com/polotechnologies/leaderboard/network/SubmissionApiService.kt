package com.polotechnologies.leaderboard.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val loggingInterceptor = HttpLoggingInterceptor()
    .setLevel(HttpLoggingInterceptor.Level.BODY)
private val clientBuilder = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)

private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://docs.google.com/forms/d/e/")
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(clientBuilder.build())
    .build()


interface SubmissionApiService {

    /*@POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    suspend fun submitProject(
        @Field("entry.1877115667") firstName : String,
        @Field("entry.2006916086") lastName : String,
        @Field("entry.1824927963") emailAddress : String,
        @Field("entry.284483984") projectLink : String,
    ): Void*/


    @POST("1FAIpQLSfacPHKi4PiLt0NzxgI8KY3aQDE1dTWoUaSOA_iJLJWwWdmHA/formResponse")
    @FormUrlEncoded
    suspend fun submitProject(
        @Field("entry.1405768637") firstName: String,
        @Field("entry.182464250") lastName: String,
        @Field("entry.690369363") emailAddress: String,
        @Field("entry.1405045665") projectLink: String,
    )

}

object SubmissionApi {
    val retrofitService: SubmissionApiService by lazy {
        retrofit.create(SubmissionApiService::class.java)
    }
}




