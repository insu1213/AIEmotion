package naver.next.aiemotion

import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Url

interface RetrofitAPI {
    // as we are making get request so we are displaying
    // GET as annotation.
    // and inside we are passing last parameter for our url.
    @Headers(
        "X-NCP-APIGW-API-KEY-ID: ol0csp9ndf",
        "X-NCP-APIGW-API-KEY: iRBWG21osYU4bQwAAAGPxJ1EbZd7zg4ffGCROVYF",
        "Content-Type: application/json"
    )
    @POST("sentiment-analysis/v1/analyze")
    suspend fun postData(@Body content: EmotionBody): retrofit2.Response<EmotionDTO>
}
