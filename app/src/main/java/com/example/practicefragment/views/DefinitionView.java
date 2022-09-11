package com.example.practicefragment.views;

import static com.example.practicefragment.utility.Utility.getUtility;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;

import com.example.practicefragment.R;
import com.example.practicefragment.utility.Utility;

public class DefinitionView extends ViewGroup {

    @ColorInt private int btnColor;
    @ColorInt private int defentionColor;

    @Px private int paddingLeft;
    @Px private int paddingTop;
    @Px private int paddingRight;
    @Px private int paddingBottom;

    @Dimension(unit = Dimension.SP) private float defTextSize;
    @Dimension(unit = Dimension.SP) private float btnTextSize;

    private Button btnAdd;
    private TextView definition;

    public DefinitionView(Context context) {
        super(context);
        init(context);
    }

    private void init(@NonNull Context context)
    {
        setClipToPadding(false);

        btnColor = ContextCompat.getColor(context, R.color.btnDefention);
        defentionColor = ContextCompat.getColor(context, R.color.textDefention);

        paddingLeft = getUtility().dpToPx(8);
        paddingTop = getUtility().dpToPx(8);
        paddingRight = getUtility().dpToPx(8);
        paddingBottom = getUtility().dpToPx(8);

        definition = new TextView(context);
        definition.setTextSize(defTextSize);
        definition.setTextColor(defentionColor);
        addView(definition);

        btnAdd = new Button(context);
        definition.setTextSize(btnTextSize);
        definition.setTextColor(defentionColor);
        btnAdd.setBackgroundColor(btnColor);
        addView(definition);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMeasureSpec = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);

        measureChild(definition, widthMeasureSpec, heightMeasureSpec);
        final int bodyTextWidth = widthMeasureSpec - paddingRight;

        definition.setMaxWidth(bodyTextWidth);
        




    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onLayout(boolean b, int left, int top, int right, int bottom) {

    }
}
