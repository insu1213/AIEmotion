package naver.next.aiemotion

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class SentimentRequest(val content: String)

data class SentimentResponse(
    @SerializedName("label") val label: String,
    @SerializedName("score") val score: Double
)

interface NaverSentimentAnalysisService {
    @Headers(
        "X-NCP-APIGW-API-KEY-ID: ol0csp9ndf",
        "X-NCP-APIGW-API-KEY: iRBWG21osYU4bQwAAAGPxJ1EbZd7zg4ffGCROVYF",
        "Content-Type: application/json"
    )
    @POST("sentiment-analysis/v1/analyze")
    fun analyzeSentiment(@Body request: SentimentRequest): Call<SentimentResponse>
}

fun main() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://naveropenapi.apigw.ntruss.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(NaverSentimentAnalysisService::class.java)

    val content = "싸늘하다. 가슴에 비수가 날아와 꽂힌다."
    val request = SentimentRequest(content)

    val call = service.analyzeSentiment(request)

    val response = call.execute()

    if (response.isSuccessful) {
        val sentimentResponse = response.body()
        println("Sentiment Label: ${sentimentResponse?.label}")
        println("Sentiment Score: ${sentimentResponse?.score}")
    } else {
        println("Error: ${response.errorBody()?.string()}")
    }
}