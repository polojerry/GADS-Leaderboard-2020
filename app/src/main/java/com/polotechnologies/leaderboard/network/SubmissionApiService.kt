package com.polotechnologies.leaderboard.network

import com.polotechnologies.leaderboard.util.Constants.END_POINT_SUBMISSION
import com.polotechnologies.leaderboard.util.Constants.FIELD_EMAIL_ADDRESS
import com.polotechnologies.leaderboard.util.Constants.FIELD_FIRST_NAME
import com.polotechnologies.leaderboard.util.Constants.FIELD_LAST_NAME
import com.polotechnologies.leaderboard.util.Constants.FIELD_PROJECT_LINK
import com.polotechnologies.leaderboard.util.Constants.SUBMISSION_FORM_BASE_URL
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
    .baseUrl(SUBMISSION_FORM_BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(clientBuilder.build())
    .build()


interface SubmissionApiService {

    @POST(END_POINT_SUBMISSION)
    @FormUrlEncoded
    suspend fun submitProject(
        @Field(FIELD_FIRST_NAME) firstName: String,
        @Field(FIELD_LAST_NAME) lastName: String,
        @Field(FIELD_EMAIL_ADDRESS) emailAddress: String,
        @Field(FIELD_PROJECT_LINK) projectLink: String,
    )

}

object SubmissionApi {
    val retrofitService: SubmissionApiService by lazy {
        retrofit.create(SubmissionApiService::class.java)
    }
}




