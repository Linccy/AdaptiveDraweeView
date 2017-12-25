# AdaptiveDraweeView power by SimpleDraweeView

## 说明

这是一个基于Fresco的SimpleDraweeView的自定义View
支持根据网络图片的大小自适应宽高

## 范例

<com.linccy.adapterdraweeview.AdaptiveSimpleDraweeView
            android:id="@+id/img_big_adaptive"
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:layout_marginTop="10dp"
            app:maxSize="250dp"
            app:placeholderImage="@android:drawable/ic_menu_report_image" />

img.setImageURI(item.getImageUrl())

## preview

Image:

![Example Image](/doc/demo.gif?raw=true)