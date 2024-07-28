package com.example.proectzametkiiii;

import androidx.cardview.widget.CardView;

import com.example.proectzametkiiii.Models.Notes;

public interface NotesClickListener {
    void OnClick(Notes notes);
    void OnLongClick(Notes notes, CardView cardView);

}