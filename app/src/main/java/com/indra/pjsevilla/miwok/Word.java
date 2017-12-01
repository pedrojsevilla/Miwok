package com.indra.pjsevilla.miwok;

/**
 * Created by pjsevilla on 29/11/2017.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageId;

    public Word(String defaultWord, String miwokWord) {
        mDefaultTranslation = defaultWord;
        mMiwokTranslation = miwokWord;
        mImageId = R.drawable.color_dusty_yellow;
    }

    public Word(String defaultWord, String miwokWord, int imageId) {
        mDefaultTranslation = defaultWord;
        mMiwokTranslation = miwokWord;
        mImageId = imageId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageId () {
        return mImageId;
    }
}
