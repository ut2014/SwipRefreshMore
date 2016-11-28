package com.it5.swiprefreshmore.demo.model;

import android.text.TextUtils;

/**
 * Created by IT5 on 2016/11/25.
 */

public class OpenProjectModel implements CursorModel{
    public static final String MORE_CURSOR="more_cursor";

    private String mCursor;
    private String mTitle;
    private String mContent;
    private String mAuthor;
    private String mColor;

    public OpenProjectModel(String mTitle, String mContent, String mAuthor, String mColor) {
        this.mCursor = MORE_CURSOR;
        this.mTitle = mTitle;
        this.mContent = mContent;
        this.mAuthor = mAuthor;
        this.mColor = mColor;
    }

    public OpenProjectModel(String mTitle, String mContent, String mColor) {
        this(mTitle, mContent, "dinus", mColor);
    }

    @Override
    public boolean hasMore() {
        return !TextUtils.isEmpty(mCursor);
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public String getColor() {
        return mColor;
    }

    public String getAuthor() {
        return mAuthor;
    }
}
