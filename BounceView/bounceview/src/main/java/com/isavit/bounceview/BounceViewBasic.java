package com.isavit.bounceview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class BounceViewBasic extends RelativeLayout {

    /**
     * Core Items
     */

    private Context mContext;
    private AttributeSet attrs;
    private int styleAttr;
    private View view;

    /**
     * Core Components
     */

    RelativeLayout header, body;
    TextView textBox;

    /**
     * Attributes
     */

    Drawable gradient;
    Drawable background;
    String text;
    float padding;

    private void initView() {
        this.view = this;

        //Inflating the XML view
        inflate(mContext, R.layout.bounce_view_layout, this);

        TypedArray arr = mContext.obtainStyledAttributes(
                attrs,
                R.styleable.BounceViewBasic,
                styleAttr,
                0);

        gradient = arr.getDrawable(R.styleable.BounceViewBasic_gradient);
        background = arr.getDrawable(R.styleable.BounceViewBasic_background);
        text = arr.getString(R.styleable.BounceViewBasic_android_text);
        padding = arr.getDimension(R.styleable.BounceViewBasic_android_padding, 0);

        //components
        textBox = findViewById(R.id.text_box);
        header = findViewById(R.id.header);
        body = findViewById(R.id.body);

        arr.recycle();
    }


    public BounceViewBasic(Context context) {
        super(context);
        this.mContext = context;
    }

    public BounceViewBasic(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.attrs = attrs;
    }

    public BounceViewBasic(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        this.attrs = attrs;
        this.styleAttr = defStyleAttr;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BounceViewBasic(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
