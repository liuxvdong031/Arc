package me.hgj.jetpackmvvm.util

import android.widget.ImageView
import com.blankj.utilcode.util.SizeUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

/**
 * Created by xvDong on 2023/8/24.
 */
object GlideEngine {

    var mPlaceholderRes: Int = 0
    var mErrorRes: Int = 0

    fun displayImage(imageView: ImageView, url: String) {
        displayImage(imageView, url, mPlaceholderRes, mErrorRes)
    }

    fun displayImage(imageView: ImageView, url: String, placeholderRes: Int, errorRes: Int) {
        Glide.with(imageView)
            .load(url)
            .placeholder(placeholderRes)
            .error(errorRes)
            .into(imageView)
    }

    fun displayRoundedRectangleImage(
        imageView: ImageView,
        url: String,
        placeholderRes: Int,
        errorRes: Int,
        imgCorner: Int
    ) {
        Glide.with(imageView)
            .load(url)
            .transform(CenterCrop(), RoundedCorners(SizeUtils.dp2px(imgCorner.toFloat())))
            .placeholder(placeholderRes)
            .error(errorRes)
            .into(imageView)
    }


    fun displayCircleImage(imageView: ImageView, url: String, placeholderRes: Int, errorRes: Int) {
        Glide.with(imageView)
            .load(url)
            .transform(CircleCrop())
            .placeholder(placeholderRes)
            .error(errorRes)
            .into(imageView)
    }

    fun displayCustomCornerImage(
        imageView: ImageView, url: String, placeholderRes: Int, errorRes: Int, imgCorner: Int,
        imgCornerTopLeft: Boolean, imgCornerTopRight: Boolean, imgCornerBottomLeft: Boolean,
        imgCornerBottomRight: Boolean
    ) {
        val cornersTransform =
            RoundedCornersTransform(imageView.context, SizeUtils.dp2px(imgCorner.toFloat()))
        cornersTransform.setNeedCorner(
            imgCornerTopLeft,
            imgCornerTopRight,
            imgCornerBottomLeft,
            imgCornerBottomRight
        )
        Glide.with(imageView)
            .load(url)
            .transform(CenterCrop(), cornersTransform)
            .placeholder(placeholderRes)
            .error(errorRes)
            .into(imageView)
    }

}