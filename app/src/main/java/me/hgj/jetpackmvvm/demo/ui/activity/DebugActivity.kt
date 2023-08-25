package me.hgj.jetpackmvvm.demo.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.blankj.utilcode.util.ClickUtils
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.demo.app.base.BaseActivity
import me.hgj.jetpackmvvm.demo.databinding.ActivityDebugBinding
import me.hgj.jetpackmvvm.demo.generated.callback.OnClickListener
import me.hgj.jetpackmvvm.demo.viewmodel.DebugViewModel

/**
 * Created by xvDong on 2023/8/25.
 */
class DebugActivity : BaseActivity<DebugViewModel, ActivityDebugBinding>() {

    private val debugViewModel: DebugViewModel by viewModels()

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.viewModel = debugViewModel
        initListener()
    }

    private fun initListener() {
        val onClickListener: (View) -> Unit = {
            val extras = intent.extras
            if (extras != null) {
                val code = extras.getInt(BaseViewModel.RESULT_CODE, 0)
                setResult(code, intent)
                finish()
            }
        }
        antiShakeClick(mDatabind.btnClose, onClickListener)
    }

}