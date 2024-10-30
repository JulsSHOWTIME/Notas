package com.example.notas;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DetailNoteActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_note_detail);

        String note = getIntent().getStringExtra(Constants.EXTRA_NOTE);

        TextView tvNote = findViewById(R.id.tvNote);

        tvNote.setText(note);

    }
}
