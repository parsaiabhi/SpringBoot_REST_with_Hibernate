package com.matrix.rest.hibernate.REST_HIBERNATEExample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.rest.hibernate.REST_HIBERNATEExample.exception.ResourceNotFoundException;
import com.matrix.rest.hibernate.REST_HIBERNATEExample.model.Note;
import com.matrix.rest.hibernate.REST_HIBERNATEExample.repository.NoteRepository;

/**
 * @author abhishek
 *
 */
@RestController
@RequestMapping("/api")
public class NoteController {
// http://localhost:8808/api/notes
	
	@Autowired
	private NoteRepository noteRepository;

	@GetMapping("/notes")
	public List<Note> getAllNotes(){
		return noteRepository.findAll();
	}
	@PostMapping("/notes")
	public Note createNote(@Valid @RequestBody Note note){
		return noteRepository.save(note);
	}
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable("id")Long noteId){
		return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}
	
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable("id") Long noteId,@RequestBody Note noteDetails){
		
		Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note","id",noteDetails));
		
		note.setContent(noteDetails.getContent());
		note.setTitle(noteDetails.getTitle());
		
		Note updatedNote = noteRepository.save(note);
		return updatedNote;
		
	}

	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable("id") Long id){
		Note note = noteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
		noteRepository.delete(note);
		return ResponseEntity.ok().build();
		
	}
	
	
	
}
