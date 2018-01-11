package com.indra.pjsevilla.miwok;

/**
 * Created by pjsevilla on 29/11/2017.
 */

public class Word {

    private static final int NO_AUDIO_PROVIDED = -1;
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mAudioId = NO_AUDIO_PROVIDED;
    private int mImageId = NO_IMAGE_PROVIDED;


    public Word(String defaultWord, String miwokWord) {
        mDefaultTranslation = defaultWord;
        mMiwokTranslation = miwokWord;
    }

    public Word(String defaultWord, String miwokWord, int audioId) {
        mDefaultTranslation = defaultWord;
        mMiwokTranslation = miwokWord;
        mAudioId = audioId;
    }

    public Word(String defaultWord, String miwokWord, int audioId, int imageId) {
        mDefaultTranslation = defaultWord;
        mMiwokTranslation = miwokWord;
        mAudioId = audioId;
        mImageId = imageId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getAudioId() {
        return mAudioId;
    }

    public boolean hasAudio() {
        return (mAudioId != NO_AUDIO_PROVIDED);
    }

    public int getImageId() {
        return mImageId;
    }

    public boolean hasImage() {
        return (mImageId != NO_IMAGE_PROVIDED);
    }

}
