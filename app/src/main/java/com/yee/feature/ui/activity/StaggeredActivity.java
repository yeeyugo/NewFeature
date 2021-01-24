package com.yee.feature.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.yee.feature.R;

public class StaggeredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);

        int[] images = {
                R.drawable.meijing1,
                R.drawable.meijing2,
                R.drawable.meijing3,
                R.drawable.meijing4,
                R.drawable.meijing5,
                R.drawable.meijing6,
                R.drawable.meijing7,
                R.drawable.meijing8,
                R.drawable.meijing9,
                R.drawable.meijing10,
                R.drawable.meijing11,
                R.drawable.meijing12,
                R.drawable.meijing13,
                R.drawable.meijing14,
                R.drawable.meijing15,
                R.drawable.meijing16,
                R.drawable.meijing17,
                R.drawable.meijing18,
                R.drawable.meijing19,
                R.drawable.meijing20,
                R.drawable.meijing21,
                R.drawable.meijing22,
                R.drawable.meijing23,
                R.drawable.meijing24,
                R.drawable.meijing25,
                R.drawable.meijing26,
                R.drawable.meijing27,
                R.drawable.meijing28,
                R.drawable.meijing29,
                R.drawable.meijing30,
                R.drawable.meijing31,
                R.drawable.meijing32,
                R.drawable.meijing33,
                R.drawable.meijing34,
                R.drawable.meijing35,
                R.drawable.meijing36,
                R.drawable.meijing37,
                R.drawable.meijing38,
                R.drawable.meijing39,
                R.drawable.meijing40,
                R.drawable.meijing41,
                R.drawable.meijing42,
                R.drawable.meijing43,
                R.drawable.meijing44,
                R.drawable.meijing45,
                R.drawable.meijing46,
                R.drawable.meijing47,
                R.drawable.meijing48,
                R.drawable.meijing49,
                R.drawable.meijing50,
                R.drawable.meijing51,
                R.drawable.meijing52,
                R.drawable.meijing53,
                R.drawable.meijing54,
                R.drawable.meijing55,
                R.drawable.meijing56,
                R.drawable.meijing57,
                R.drawable.meijing58,
                R.drawable.meijing59,
                R.drawable.meijing60,
                R.drawable.meijing61,
                R.drawable.meijing62,
                R.drawable.meijing63,
                R.drawable.meijing64,
                R.drawable.meijing65,
                R.drawable.meijing66,
                R.drawable.meijing67,
                R.drawable.meijing68,
                R.drawable.meijing69,
                R.drawable.meijing70,
                R.drawable.meijing71,
                R.drawable.meijing72,
                R.drawable.meijing73,
                R.drawable.meijing74,
                R.drawable.meijing75,
                R.drawable.meijing76,
                R.drawable.meijing77,
                R.drawable.meijing78,
                R.drawable.meijing79,
                R.drawable.meijing80
        };
        RecyclerView rvStaggered = findViewById(R.id.rv_wrapper);
    }
}