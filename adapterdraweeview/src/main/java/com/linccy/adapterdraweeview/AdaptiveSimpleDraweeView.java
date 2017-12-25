package com.linccy.adapterdraweeview;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/**
 * 自适应图片大小的SimpleDraweeView
 */

public class AdaptiveSimpleDraweeView extends SimpleDraweeView {
    private int maxSize;

    public AdaptiveSimpleDraweeView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
    }

    public AdaptiveSimpleDraweeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        maxSize = (int) context.obtainStyledAttributes(attrs, R.styleable.AdaptiveSimpleDraweeView).
                getDimension(R.styleable.AdaptiveSimpleDraweeView_maxSize, 720);
    }

    public AdaptiveSimpleDraweeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        maxSize = (int) context.obtainStyledAttributes(attrs, R.styleable.AdaptiveSimpleDraweeView).
                getDimension(R.styleable.AdaptiveSimpleDraweeView_maxSize, 720);
    }

    @Override
    public void setImageURI(Uri uri, @Nullable Object callerContext) {
        super.setImageURI(uri, callerContext);
        setControllerListener(this, uri, maxSize);
    }

    /**
     * 通过maxSize 的最大宽高，自动适应高宽高
     * * @param simpleDraweeView view
     * * @param imagePath  Uri
     * * @param maxSize max size
     */
    public static void setControllerListener(final SimpleDraweeView simpleDraweeView, Uri uri, final int maxSize) {
        final ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable anim) {
                if (imageInfo == null || layoutParams == null) {
                    return;
                }
                int height = imageInfo.getHeight();
                int width = imageInfo.getWidth();
                if (width > height) {
                    layoutParams.width = maxSize;
                    layoutParams.height = (int) ((float) (maxSize * height) / (float) width);
                } else {
                    layoutParams.height = maxSize;
                    layoutParams.width = (int) ((float) (maxSize * width) / (float) height);
                }
                simpleDraweeView.setLayoutParams(layoutParams);
            }

            @Override
            public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
                Log.d("TAG", "Intermediate image received");
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                throwable.printStackTrace();
            }
        };
        DraweeController controller = Fresco.newDraweeControllerBuilder().setControllerListener(controllerListener).setUri(uri).build();
        simpleDraweeView.setController(controller);
    }
}
