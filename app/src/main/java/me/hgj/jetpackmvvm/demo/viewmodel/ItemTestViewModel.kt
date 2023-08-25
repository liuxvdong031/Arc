package me.hgj.jetpackmvvm.demo.viewmodel

import android.view.View
import androidx.databinding.ObservableField
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.base.viewmodel.MultiItemViewModel

/**
 * Created by xvDong on 2023/8/24.
 */
class ItemTestViewModel(baseViewModel: BaseViewModel) : MultiItemViewModel<BaseViewModel>(baseViewModel) {

    val text: ObservableField<String> = ObservableField("测试数据")
    private var count: Int = 0
    fun onItemClick() {
        ToastUtils.showLong("itemClick")
        count++
        LogUtils.d("点击了$count 次")
    }

}