package com.by.myapp.util;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.request.target.ImageViewTarget;

public class TransformationUtils extends ImageViewTarget<Bitmap> {
    private ImageView target;
    public TransformationUtils(ImageView target) {
        super(target);
        this.target = target;
    }
    @Override
    protected void setResource(Bitmap resource) {
        view.setImageBitmap(resource);
        //获取原图的宽高
        int width = resource.getWidth();
        int height = resource.getHeight();
        //获取imageView的宽
        int imageViewWidth = target.getWidth();
        //计算缩放比例
        float sy = (float) (imageViewWidth * 0.1) / (float) (width * 0.1);
        //计算图片等比例放大后的高
        int imageViewHeight = (int) (height * sy);
//        int imageViewHeight = target.getHeight();
        ViewGroup.LayoutParams params = target.getLayoutParams();
        params.height = 100;
        params.width = 100;
        target.setLayoutParams(params);
    }

    public ImageView getTarget() {
        return target;
    }
}
