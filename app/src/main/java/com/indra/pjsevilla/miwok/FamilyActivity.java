package com.indra.pjsevilla.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    public WordAdapter mWordAdapter;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            } else if ((focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) ||
                    (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                if (mMediaPlayer != null) {
                    mMediaPlayer.start();
                }
            }
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("father", "әpә", R.raw.family_father, R.drawable.family_father));
        words.add(new Word("mother", "әṭa", R.raw.family_mother, R.drawable.family_mother));
        words.add(new Word("son", "angsi", R.raw.family_son, R.drawable.family_son));
        words.add(new Word("daughter", "tune", R.raw.family_daughter, R.drawable.family_daughter));
        words.add(new Word("older brother", "taachi", R.raw.family_older_brother, R.drawable.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.raw.family_younger_brother, R.drawable.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.raw.family_older_sister, R.drawable.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.raw.family_younger_sister, R.drawable.family_younger_sister));
        words.add(new Word("grandmother ", "ama", R.raw.family_grandmother, R.drawable.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.raw.family_grandfather, R.drawable.family_grandfather));

        mWordAdapter = new WordAdapter(this, words, R.color.category_family);

        releaseMediaPlayer();

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(mWordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, mWordAdapter.getItem(position).getAudioId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
