package com.indra.pjsevilla.miwok;

/**
 * Created by pjsevilla on 29/11/2017.
 */

public class Word {

    private static final int NO_IMAGE_PROVIDED = -1;
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageId = NO_IMAGE_PROVIDED;


    public Word(String defaultWord, String miwokWord) {
        mDefaultTranslation = defaultWord;
        mMiwokTranslation = miwokWord;
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

    public int getImageId() {
        return mImageId;
    }

    public boolean hasImage() {
        return (mImageId != NO_IMAGE_PROVIDED);
    }
}
