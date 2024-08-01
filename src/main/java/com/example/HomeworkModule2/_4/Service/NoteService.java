package com.example.HomeworkModule2._4.Service;

import com.example.HomeworkModule2._4.Entity.Note;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NoteService {
    private Map<Long,Note> notes = new HashMap<>();
    private long currentId = 1;
    public List<Note> listAll(){
        return new ArrayList<>(notes.values());
    }
    public Note add(Note note){

        note.setId(currentId);
        notes.put(currentId,note);
        currentId++;

        return note;
    }
    public void deleteById(long id){
        if(notes.containsKey(id)){
            notes.remove(id);
        }else {
            throw new NoSuchElementException("Note with id " + id + " not found.");
        }

    }
    public void update(Note note){
        long id = note.getId();
        if(notes.containsKey(id)){
            notes.replace(id ,notes.get(id),note);
        }else {
            throw new NoSuchElementException("Note with id " + id + " not found.");
        }
    }
    public Note getById(long id){
        if(notes.containsKey(id)){
            return notes.get(id);
        }else {
            throw new NoSuchElementException("Note with id " + id + " not found.");
        }

    }



}
