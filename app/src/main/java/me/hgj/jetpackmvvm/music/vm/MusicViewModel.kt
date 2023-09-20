package me.hgj.jetpackmvvm.music.vm

import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.demo.app.network.musicApiService
import me.hgj.jetpackmvvm.demo.app.network.stateCallback.ListDataUiState
import me.hgj.jetpackmvvm.demo.data.model.bean.AriticleResponse
import me.hgj.jetpackmvvm.ext.request
import me.hgj.jetpackmvvm.ext.requestNoCheck
import me.hgj.jetpackmvvm.music.model.WYAudio

/**
 * Created by xvDong on 2023/9/19.
 */
class MusicViewModel : BaseViewModel() {

    var mSongsLiveData: MutableLiveData<List<WYAudio.ResultBean.SongsBean>> = MutableLiveData()

    fun getMusicList(name: String) {
        requestNoCheck({ musicApiService.getMusicList(name)}, {
            LogUtils.json(it)
            val songsBean = it?.data?.result?.songs
            mSongsLiveData.value = songsBean
        })
    }
}