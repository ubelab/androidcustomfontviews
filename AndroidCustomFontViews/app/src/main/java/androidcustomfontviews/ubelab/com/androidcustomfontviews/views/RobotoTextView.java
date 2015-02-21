package androidcustomfontviews.ubelab.com.androidcustomfontviews.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidcustomfontviews.ubelab.com.androidcustomfontviews.R;

/**
 * Created by Marco Uberti on 21/02/15.
 */
public class RobotoTextView extends TextView {

    public RobotoTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RobotoView,
                0, 0);

        try {
            int fontName = a.getInt(R.styleable.RobotoView_customFont, 0);
            setTypeFace(context, fontName);
        } finally {
            a.recycle();
        }

    }

    public RobotoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RobotoView,
                0, 0);

        try {
            int fontName = a.getInt(R.styleable.RobotoView_customFont, 0);
            setTypeFace(context, fontName);
        } finally {
            a.recycle();
        }
    }

    public RobotoTextView(Context context) {
        super(context);
        setTypeFace(context,0);
    }

    private void setTypeFace(Context context, int fontType){
        if(isInEditMode()) return;//avoid preview errors

        String fontName;
        switch (fontType){
            case 0:
                fontName = "Roboto-Regular";
                break;
            case 1:
                fontName = "Roboto-Light";
                break;
            case 2:
                fontName = "Roboto-Bold";
                break;
            default:
                fontName = "Roboto-Regular";
                break;
        }
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), fontName + ".ttf"));
    }

}
