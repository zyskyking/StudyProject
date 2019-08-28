package com.example.myrecyclerviewdemo.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.myrecyclerviewdemo.InterFace.IndexViewTouchCallBack;
import com.example.myrecyclerviewdemo.R;

public class IndexView extends View {

    private static final String TAG = IndexView.class.getSimpleName();
    /**索引列表*/
    private String[] mLetters;
    /**view高度*/
    private int mViewHeight;
    /**view宽度*/
    private int mViewWidth;
    /**单个索引高度*/
    private float singleHeiht;
    /**当前显示的索引*/
    private String mCurrentTouchLetter;
    /**当前显示索引的下标*/
    private int mCurrentTouchIndex;

    private Paint mLetterPaint;
    private Paint mLetterLightPaint;

    private float textSize = 24;
    /**触摸事件回调接口*/
    private IndexViewTouchCallBack touchCallBack;

    public void setTouchCallBack(IndexViewTouchCallBack touchCallBack) {
        this.touchCallBack = touchCallBack;
    }

    public IndexView(Context context) {
        this(context,null);
    }



    public IndexView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public IndexView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initCustomAttrs(context,attrs);
    }



    public IndexView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initCustomAttrs(context,attrs);
    }

    private void initCustomAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IndexView);
        textSize = typedArray.getDimension(R.styleable.IndexView_text_size, 16);
        int color = typedArray.getColor(R.styleable.IndexView_text_color, Color.WHITE);
        int colorLight = typedArray.getColor(R.styleable.IndexView_text_light_color, Color.WHITE);
        typedArray.recycle();
        mLetterPaint.setColor(color);
        mLetterLightPaint.setColor(colorLight);
    }

    public String[] getmLetters() {
        return mLetters;
    }

    public void setmLetters(String[] mLetters) {
        this.mLetters = mLetters;
//        invalidate();
    }


    private void init() {
        mLetterPaint = new Paint();
        mLetterPaint.setColor(getResources().getColor(R.color.colorAccent));
        mLetterPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mLetterPaint.setAntiAlias(true);
        mLetterPaint.setStrokeWidth(1);
        mLetterPaint.setTextSize(textSize);

        mLetterLightPaint = new Paint();
        mLetterLightPaint.setColor(getResources().getColor(R.color.cardview_light_background));
        mLetterLightPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mLetterLightPaint.setAntiAlias(true);
        mLetterLightPaint.setStrokeWidth(1);
        mLetterLightPaint.setTextSize(textSize);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //循环绘制
        for (int i = 0; i < mLetters.length; i++) {
            String letter = mLetters[i];

            //设置文字大小
            float size = textSize / letter.length();
            mLetterPaint.setTextSize(size);
            mLetterLightPaint.setTextSize(size);

            // 获取字体的宽度
            float textWidth = mLetterPaint.measureText(letter);
            // 获取内容的宽度
            int contentWidth = getWidth() - getPaddingLeft() - getPaddingRight();
            float x = getPaddingLeft() + (contentWidth - textWidth) / 2;
            // 计算基线位置
            Paint.FontMetrics fontMetrics = mLetterPaint.getFontMetrics();
            float baseLine  = singleHeiht / 2 + (singleHeiht * i) + (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;

            //高亮显示
            if (i == mCurrentTouchIndex){
                canvas.drawText(letter, x, baseLine, mLetterLightPaint);
            }else{
                canvas.drawText(letter, x, baseLine, mLetterPaint);
            }
        }

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mViewWidth = MeasureSpec.getSize(widthMeasureSpec);
        mViewHeight = MeasureSpec.getSize(heightMeasureSpec);
        //单个索引高度
        if (mLetters!=null){
            singleHeiht = (float)(mViewHeight / mLetters.length);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                //获取当前触摸位置
                float fingerY = event.getY();
                //判断当前指向的索引位置
                int position = (int)(fingerY / singleHeiht);
                //只有指向索引发生变化才进行处理
                if (mLetters!=null&&position<mLetters.length&&position>-1&&!mLetters[position].equals(mCurrentTouchLetter)){
                    mCurrentTouchLetter = mLetters[position];
                    mCurrentTouchIndex = position;
                    invalidate();
                    if (touchCallBack!=null){
                        touchCallBack.onTouchChanged(position,mLetters[position]);
                    }
                }
                break;
        }
        return true;
    }
}
