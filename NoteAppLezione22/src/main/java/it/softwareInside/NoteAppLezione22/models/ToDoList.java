package it.softwareInside.NoteAppLezione22.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ToDoList {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@NotNull(message="il campo non può essere nullo")
	@NotEmpty(message="il campo non può essere lasciato vuoto")
	private String testo, autore;
	
	public ToDoList(@NotEmpty @NotNull String testo, @NotEmpty @NotNull String autore) {
		setTesto(testo);
		setAutore(autore);
	}
	 
}
