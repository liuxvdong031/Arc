package me.hgj.jetpackmvvm.demo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.LogUtils
import kotlinx.android.synthetic.main.activity_test.*
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.demo.R
import me.hgj.jetpackmvvm.demo.app.base.BaseActivity
import me.hgj.jetpackmvvm.demo.app.ext.showMessage
import me.hgj.jetpackmvvm.demo.bean.TestBean
import me.hgj.jetpackmvvm.demo.databinding.ActivityTestBinding
import me.hgj.jetpackmvvm.demo.ui.adapter.TestAdapter
import me.hgj.jetpackmvvm.demo.viewmodel.TestViewModel
import me.hgj.jetpackmvvm.demo.viewmodel.request.RequestLoginRegisterViewModel
import me.hgj.jetpackmvvm.ext.parseState
import me.hgj.jetpackmvvm.ext.util.logd

/**
 * @author : hgj
 * @date   : 2020/8/26
 */

class TestActivity : BaseActivity<TestViewModel, ActivityTestBinding>() {

    val viewModel: RequestLoginRegisterViewModel by viewModels()

    override fun initView(savedInstanceState: Bundle?) {
        //强烈注意：使用addLoadingObserve 将非绑定当前activity的viewmodel绑定loading回调 防止出现请求时不显示 loading 弹窗bug
        addLoadingObserve(viewModel)
        val testBean = TestBean("https://static.runoob.com/images/demo/demo2.jpg","测试数据")
        mDatabind.bean = testBean
        mDatabind.viewModel = mViewModel
    }

    override fun createObserver() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        LogUtils.d("resultCode = $resultCode  ")
    }

}

