package com.example.notas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NotesActivity extends BaseActivity {

    ListView lvNotes;

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

        setListViewData();

        setLogoutEvent();

    }

    private void setListViewData() {

        lvNotes = findViewById(R.id.lvNotes);

        String[] notesList = new String[]{
                "Nota 1", "Nota 2", "Nota 3", "Nota nueva a agregar"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NotesActivity.this, android.R.layout.simple_list_item_1, notesList);

        lvNotes.setAdapter(adapter);

        lvNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NotesActivity.this, DetailNoteActivity.class);
                intent.putExtra(Constants.EXTRA_NOTE, notesList[position]);
                startActivity(intent);

            }
        });


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