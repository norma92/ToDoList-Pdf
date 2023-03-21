package it.softwareInside.NoteAppLezione22.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.softwareInside.NoteAppLezione22.models.ToDoList;

@Repository
public interface ToDoListRepository extends CrudRepository<ToDoList, Integer>{

}
