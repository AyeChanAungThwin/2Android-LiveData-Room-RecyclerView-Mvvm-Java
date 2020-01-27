package com.acat.java.livedata.room.recyclerview.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.acat.java.livedata.room.recyclerview.entity.Note;
import com.acat.java.livedata.room.recyclerview.repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepo;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepo = new NoteRepository(application);
        allNotes = noteRepo.findAll();
    }

    public void insert(Note note) {
        noteRepo.save(note);
    }

    public void update(Note note) {
        noteRepo.update(note);
    }

    public void delete(Note note) {
        noteRepo.delete(note);
    }

    public void deleteAllNotes() {
        noteRepo.deleteAll();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
