package me.hgj.jetpackmvvm.demo.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.blankj.utilcode.util.ClickUtils
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.demo.app.base.BaseActivity
import me.hgj.jetpackmvvm.demo.databinding.ActivityDebugBinding
import me.hgj.jetpackmvvm.demo.viewmodel.DebugViewModel

/**
 * Created by xvDong on 2023/8/25.
 */
class DebugActivity : BaseActivity<DebugViewModel, ActivityDebugBinding>() {

    private val debugViewModel:DebugViewModel by viewModels()

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.viewModel = debugViewModel
        initListener()


    }

    private fun initListener(){
        ClickUtils.applySingleDebouncing(mDatabind.btnClose) {
            val code = intent.extras?.getInt(BaseViewModel.RESULT_CODE)!!
            setResult(code,intent)
            finish()
        }
    }

}