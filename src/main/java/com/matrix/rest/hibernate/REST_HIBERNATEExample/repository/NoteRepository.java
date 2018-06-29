package com.matrix.rest.hibernate.REST_HIBERNATEExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrix.rest.hibernate.REST_HIBERNATEExample.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long>{
	

}
