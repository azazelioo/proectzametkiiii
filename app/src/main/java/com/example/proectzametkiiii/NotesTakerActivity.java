package com.example.proectzametkiiii;

import static com.example.proectzametkiiii.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.proectzametkiiii.Models.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {
    EditText editText_title, editText_notes;
    ImageView imageView_save;

    Notes notes;
    boolean isOldNote = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);
        imageView_save = findViewById(R.id.imageView_save);
        editText_notes = findViewById(R.id.editText_notes);
        editText_title = findViewById(R.id.editText_title);

        notes = new Notes();
        try {


            notes = (Notes) getIntent().getSerializableExtra("old_notes");

            editText_title.setText(notes.getTitle());
            editText_notes.setText(notes.getNotes());
            isOldNote = true;
        }catch (Exception e){
            e.printStackTrace();
        }





        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editText_title.getText().toString();
                String description = editText_notes.getText().toString();
                if (description.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this,"Please, enter description", Toast.LENGTH_LONG).show();
                    return;
                }
                SimpleDateFormat formater= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date date = new Date();
                if (!isOldNote){
                    notes = new Notes();
                }

                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(formater.format(date));
                Intent intent = new Intent();
                intent.putExtra("notes", notes);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}