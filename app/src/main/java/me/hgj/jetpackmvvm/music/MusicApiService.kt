package me.hgj.jetpackmvvm.music

import me.hgj.jetpackmvvm.demo.data.model.bean.ApiResponse
import me.hgj.jetpackmvvm.music.model.LyricsBean
import me.hgj.jetpackmvvm.music.model.WYAudio
import me.hgj.jetpackmvvm.network.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by xvDong on 2023/9/19.
 */
interface MusicApiService {

    //根据ID获取歌词
    @GET("/lyric")
    suspend fun getLyricsById(@Query("id") id: String?): LyricsBean

    @GET("/search")
    suspend fun getMusicList(@Query("keywords") keywords: String?): ApiResponse<WYAudio?>?

    companion object {
        const val SERVER_URL = "http://iwenwiki.com:3000/"
    }
}