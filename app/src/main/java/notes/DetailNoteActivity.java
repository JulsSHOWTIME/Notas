package notes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.notas.BaseActivity;
import com.example.notas.Constants;
import com.example.notas.R;

public class DetailNoteActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_note_detail);

        String noteTitle = getIntent().getStringExtra(Constants.EXTRA_NOTE_TITLE);
        String noteBody = getIntent().getStringExtra(Constants.EXTRA_NOTE_BODY);

        TextView tvNoteTitle = findViewById(R.id.tvNoteTitle);
        TextView tvNoteBody = findViewById(R.id.tvNoteBody);

        tvNoteTitle.setText(noteTitle);
        tvNoteBody.setText(noteBody);

    }
}
