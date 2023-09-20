package me.hgj.jetpackmvvm.base.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import me.hgj.jetpackmvvm.callback.livedata.event.EventLiveData

/**
 * 作者　: hegaojian
 * 时间　: 2019/12/12
 * 描述　: ViewModel的基类 使用ViewModel类，放弃AndroidViewModel，原因：用处不大 完全有其他方式获取Application上下文
 */
open class BaseViewModel : ViewModel() {

    companion object {
        const val CLASS = "CLASS"
        const val BUNDLE = "BUNDLE"
        const val RESULT_CODE = "resultCode"
    }

    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }
    val activityChange: ActivityChange by lazy { ActivityChange() }

    /**
     * 内置封装好的可通知Activity/fragment 显示隐藏加载框 因为需要跟网络请求显示隐藏loading配套才加的，不然我加他个鸡儿加
     */
    inner class UiLoadingChange {
        //显示加载框
        val showDialog by lazy { EventLiveData<String>() }

        //隐藏
        val dismissDialog by lazy { EventLiveData<Boolean>() }

    }

    inner class ActivityChange {
        //启动Activity
        val startActivity by lazy { EventLiveData<MutableMap<String, Any>>() }
        //启动Activity带返回结果
        val startActivityFroResult by lazy { EventLiveData<MutableMap<String, Any>>() }
        //关闭activity
        val finishActivity by lazy { EventLiveData<Boolean>() }
    }

    open fun startActivity(clz: Class<*>, bundle: Bundle?) {
        val params: MutableMap<String, Any> = java.util.HashMap()
        params[CLASS] = clz
        if (bundle == null) {
            params[BUNDLE] = Bundle()
        }
        activityChange.startActivity.postValue(params)
    }

    open fun startActivityFroResult(clz: Class<*>, bundle: Bundle?,resultCode:Int) {
        val params: MutableMap<String, Any> = java.util.HashMap()
        params[CLASS] = clz
        if (bundle != null) {
            params[BUNDLE] = bundle
            params[RESULT_CODE] = resultCode
        }
        activityChange.startActivityFroResult.postValue(params)
    }

    open fun finishActivity(){
        activityChange.finishActivity.postValue(true)
    }
}