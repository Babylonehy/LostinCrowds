package com.example.lostincrowds;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

public class AutoImageView extends AppCompatImageView {

        public AutoImageView ( Context context) {
            super(context);
        }
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            Drawable drawable = getDrawable();
            if(drawable != null){
                int width = drawable.getMinimumWidth();
                int height = drawable.getMinimumHeight();
                float scale = (float)width/height;

                //强制根据图片原有比例，重新计算ImageView显示区域宽度
                int heightMeasure = MeasureSpec.getSize(heightMeasureSpec);
                int widthMeasure = (int)(heightMeasure * scale);

                //并设置为MeasureSpec.EXACTLY精确模式保证之后的super.onMeasure()不再调整
                widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthMeasure, MeasureSpec.EXACTLY);
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

}
