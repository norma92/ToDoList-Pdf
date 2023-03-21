package it.softwareInside.NoteAppLezione22.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.NoteAppLezione22.models.ToDoList;
import it.softwareInside.NoteAppLezione22.repository.ToDoListRepository;
import jakarta.validation.Valid;

@Service
public class ToDoListService {

	@Autowired
	ToDoListRepository toDoR;
	
	/**
	 * metodo che aggiunge un elemento ToDoList passato come parametro
	 * controllando che i valori degli attributi siano validi
	 * 
	 * stampa un messaggio affermativo nel caso in cui l'aggiunta sia andata a buon fine
	 * altrimenti entra nel catch e stampa un messaggio negativo
	 * 
	 * @param list
	 * @return
	 */
	public String addList(@Valid ToDoList list) {
		try {
			toDoR.save(list);
			return "nota aggiunta";
		} catch (Exception e) {
			System.out.println("errore" + e);
			return "non è stato possibile aggiungere la nota";
		}
	}
	
	/**
	 * metodo che modifica un elemento presente nel database
	 * passo in rested il valore di tutti gli attributi dell'oggetto
	 * compreso l'id che ha l'elemento all'interno del database
	 * 
	 * invoco il metodo addList fatto precedentemente
	 * 
	 * stampo una stringa affermativa nel caso in cui l'operazione vada a buon fine, 
	 * ne stampo una negativa nel caso in cui si sta verificato qualche errore
	 * 
	 * @param list
	 * @return
	 */
	public String updateList(@Valid ToDoList list) {
		try {
			addList(list);
			return "nota modificata";
		} catch (Exception e) {
			return "non è stato possibile modificare la nota";
		}
	}
	
	/**
	 * il metodo restituisce l'elemento ToDoList del database,
	 * corrispondente all'id passato come parametro
	 * 
	 * se tutto va a buon fine viene restituito il valore dell'elemento cercato
	 * altrimenti viene stampato in console il tipo di errore
	 * e viene restituito un null (es non esiste l'id passato)
	 * 
	 * @param id
	 * @return
	 */
	public ToDoList findList(Integer id) {
		try {
			return toDoR.findById(id).get();
		} catch (Exception e) {
			System.out.println("errore" + e);
			return null;
		}
	}
	
	/**
	 * questo metodo restituisce i toString degli elementi presenti nel database
	 * 
	 * restituisce la lista nel caso sia andato tutto a buon fine,
	 * altrimenti restituisce un null
	 * 
	 * @return
	 */
	public Iterable<ToDoList> printAll(){
		try {
			 return toDoR.findAll();
				
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * il metodo elimina dal database l'elemento associato all'id passato come parametro
	 * 
	 * nel caso in cui l'operazione sia andata a buon fine viene stampato un messaggio positivo,
	 * altrimenti viene stampato un messaggio negativo
	 * 
	 * @param id
	 * @return
	 */
	public String deleteList(Integer id) {
		try {
			toDoR.deleteById(id);
			return "nota eliminata";
		} catch (Exception e) {
			return "non è stato possibile eliminare la nota";
		}
	}
	
	/**
	 * il metodo cancella tutti gli elementi presenti nel database
	 * e restituisce una stringa con l'esito dell'operazione
	 * 
	 * @return
	 */
	public String deleteAll() {
		try {
			toDoR.deleteAll();
			return "tutte gli elementi del database sono stati rimossi";
		} catch (Exception e) {
			return "non è stato possibile eliminare gli elementi";
		}
	}

}
