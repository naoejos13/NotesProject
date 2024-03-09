package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        validateNoteFields(note);
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id " + id));
    }

    @Override
    public Note updateNote(Long id, Note updatedNote) {
        validateNoteFields(updatedNote);
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id " + id));
        existingNote.setTitle(updatedNote.getTitle());
        existingNote.setBody(updatedNote.getBody());
        return noteRepository.save(existingNote);
    }

    @Override
    public void deleteNoteById(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id " + id));
        noteRepository.delete(note);
    }

    private void validateNoteFields(Note note) {
        if (note.getTitle() == null || note.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (note.getBody() == null || note.getBody().isEmpty()) {
            throw new IllegalArgumentException("Body cannot be empty");
        }
    }
}

