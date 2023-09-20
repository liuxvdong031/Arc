package me.hgj.jetpackmvvm.music.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import me.hgj.jetpackmvvm.demo.app.base.BaseActivity
import me.hgj.jetpackmvvm.demo.databinding.ActivityMusicBinding
import me.hgj.jetpackmvvm.music.vm.MusicViewModel

/**
 * Created by xvDong on 2023/9/19.
 */
class MusicActivity : BaseActivity<MusicViewModel, ActivityMusicBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.root.visibility = View.VISIBLE
        mViewModel.getMusicList("凤凰传奇")
    }

    override fun createObserver() {
        super.createObserver()
    }
}