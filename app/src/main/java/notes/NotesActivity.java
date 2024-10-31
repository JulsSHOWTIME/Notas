package notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notas.BaseActivity;
import com.example.notas.Constants;
import com.example.notas.LoginActivity;
import com.example.notas.R;

import java.util.ArrayList;

import notes.models.Note;

public class NotesActivity extends BaseActivity {

    RecyclerView rvNotes;
    ArrayList <Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setRecycleViewData();

        setLogoutEvent();

    }

    private void populateNoteList(){

        noteList = new ArrayList<>();


        noteList.add(new Note("Ha habido una tormenta", "deberíamos de tener cuidado con este temporal"));
        noteList.add(new Note("No debemos utilizar el vehículo", "es una decisión peligrosa"));
        noteList.add(new Note("Buscar un lugar alto", "esto podría evitar peligro con las crecidas del río"));
        noteList.add(new Note("No importa lo material", "lo primero es ponerse a salvo"));

    }

    private void setRecycleViewData() {

        rvNotes = findViewById(R.id.rvNotes);

        populateNoteList();

        NotesAdapter adapter = new NotesAdapter(noteList, NotesActivity.this);

        rvNotes.setAdapter(adapter);

        rvNotes.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(NotesActivity.this);

        rvNotes.setLayoutManager(manager);

    }

    private void setLogoutEvent() {
        Button btLogOut = findViewById(R.id.btLogout);

        btLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prefs.setPref(Constants.PREFS_USER, false);
                Intent intent = new Intent(NotesActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}