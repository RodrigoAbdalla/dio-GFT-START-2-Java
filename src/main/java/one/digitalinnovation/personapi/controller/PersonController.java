package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.services.PersonService;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService service;  

    @GetMapping
    public List<PersonDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDTO> getAdminById(@PathVariable Long id){
        PersonDTO dto = service.getPersonById(id);
        return ResponseEntity.ok().body(dto);
    }


    // ------- 

    @PostMapping
	public ResponseEntity<PersonDTO> insert(@RequestBody PersonDTO personDTO){
		PersonDTO dto = service.insert(personDTO); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

    @DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}
    
    @PutMapping("{id}")
	public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO updateDto, @PathVariable Long id){
		PersonDTO dto = service.update(id, updateDto); 
		return ResponseEntity.ok().body(dto);
	}
}
