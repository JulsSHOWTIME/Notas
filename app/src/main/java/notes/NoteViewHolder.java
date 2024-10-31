package notes;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notas.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    LinearLayout llNoteContainer;

    TextView tvNote;

    public NoteViewHolder(@NonNull View v) {
        super(v);

        llNoteContainer = v.findViewById(R.id.llNoteContainer);
        tvNote = v.findViewById(R.id.tvNote);

    }
}
