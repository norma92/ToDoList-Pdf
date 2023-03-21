package it.softwareInside.NoteAppLezione22.restController;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.NoteAppLezione22.models.ToDoList;
import it.softwareInside.NoteAppLezione22.services.PdfService;
import it.softwareInside.NoteAppLezione22.services.ToDoListService;

@RestController
public class ToDoListRestController {

	@Autowired
	ToDoListService listS;
	
	@Autowired
	PdfService pdfS;
	
	
	@PostMapping("/add-list")
	public String add(@RequestBody ToDoList list) {
			
		return listS.addList(list);		
	}
	
	@PostMapping("/update-list")
	public String update(@RequestBody ToDoList list) {
		
		return listS.updateList(list);
	}
	
	@PostMapping("/find-list")
	public ToDoList find(@RequestParam Integer id) {
		
		return listS.findList(id);
	}
	
	@GetMapping("/all-list")
	public Iterable<ToDoList> printAll() {
		
		return listS.printAll();
	}
	
	@DeleteMapping("/remove")
	public String removeList(@RequestParam Integer id) {
		
		return listS.deleteList(id);
	}
	
	@DeleteMapping("/remove-all")
	public String removeAll() {
		
		return listS.deleteAll();
	}
	
	@RequestMapping(value = "/pdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> generaNota(@RequestParam("id") int id) {
    	
    	try {

            ByteArrayInputStream bis =  pdfS.generaPDF(id) ; 

            var headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=example.pdf");
    
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new InputStreamResource(bis));
    		
    	}catch (Exception e) {
			return null;
    	
    
    	}
	
    }
}
