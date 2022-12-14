package com.example.krymov.views;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CodeView extends WebView {

    private String code = "";
    private String escapeCode;
    private float fontSize = 16;
    private ProgrammingLanguage language;
    private int startLineNumber = 1;
    private int lineCount = 0;

    public CodeView(@NonNull Context context) {
        super(context);
    }

    public CodeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CodeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    //! Some setters and getters
    public float getFontSize() {
        return fontSize;
    }

    public String getCode() {
        return code;
    }

    public CodeView setCode(String code) {
        if (code == null)
            code = "";
        this.code = code;
        this.escapeCode = Html.escapeHtml(code);
        return this;
    }

    public ProgrammingLanguage getLanguage() {
        return language;
    }

    public CodeView setLanguage(ProgrammingLanguage language) {
        this.language = language;
        return this;
    }

    public CodeView setStartLineNumber(int startLineNumber) {
        if (startLineNumber < 0)
            startLineNumber = 1;
        this.startLineNumber = startLineNumber;
        return this;
    }

    public int getStartLineNumber() {
        return startLineNumber;
    }
}
