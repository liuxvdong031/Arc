package me.hgj.jetpackmvvm.binding.image;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import me.hgj.jetpackmvvm.util.GlideEngine;


/**
 * Created by goldze on 2017/6/18.
 */
public final class ViewAdapter {
    @BindingAdapter(value = {"url", "placeholderRes", "errorRes", "imgCorner", "imgCornerTopLeft",
            "imgCornerTopRight", "imgCornerBottomLeft", "imgCornerBottomRight", "isCircle"}, requireAll = false)
    public static void setImageUrl(ImageView imageView, String url, int placeholderRes, int errorRes,
                                   int imgCorner, boolean imgCornerTopLeft, boolean imgCornerTopRight,
                                   boolean imgCornerBottomLeft, boolean imgCornerBottomRight, boolean isCirCle) {
        if (!TextUtils.isEmpty(url)) {
            if (isCirCle) {//如果是圆形图片
                GlideEngine.INSTANCE.displayCircleImage(imageView, url, placeholderRes, errorRes);
            } else {
                if (imgCorner == 0) {//如果圆角=0 则是正常图片
                    GlideEngine.INSTANCE.displayImage(imageView, url, placeholderRes, errorRes);
                    //如果有任意一个角需要变圆 则是不规则的圆角图片
                } else if (imgCornerTopLeft || imgCornerBottomRight || imgCornerTopRight || imgCornerBottomLeft) {
                    GlideEngine.INSTANCE.displayCustomCornerImage(imageView, url, placeholderRes, errorRes, imgCorner,
                            imgCornerTopLeft, imgCornerTopRight, imgCornerBottomLeft, imgCornerBottomRight);
                } else {//否则是圆角矩形图片
                    GlideEngine.INSTANCE.displayRoundedRectangleImage(imageView, url, placeholderRes, errorRes,imgCorner);
                }
            }
        }
    }
}

