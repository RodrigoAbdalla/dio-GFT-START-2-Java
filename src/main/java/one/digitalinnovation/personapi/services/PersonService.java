package one.digitalinnovation.personapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.dto.PersonInsertDTO;
import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.repositories.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;



    public List<PersonDTO> listAll() {
        List<PersonDTO> listDTO = new ArrayList<>();
        List<Person> list = repo.findAll();     
        for (Person person : list) {
            listDTO.add(new PersonDTO(person));
        }
        return listDTO;  
    }


    public PersonDTO getPersonById(Long id) {
        Optional<Person> op = repo.findById(id);
        Person person = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"));
        return new PersonDTO(person);
    }

    public PersonDTO insert(PersonInsertDTO personDTO) {
        if( 
            personDTO.getCpf()                  == ""    ||                 // Logica para o programa nao aceitar nomes, descrições e nem lugares vazios / nulos
            personDTO.getFirstName()            == ""    || 
            personDTO.getLastName()             == ""    || 
            personDTO.getFirstName()            == null  || 
            personDTO.getLastName()             == null  || 
            personDTO.getBirthDate()            == null  ||
            personDTO.getCpf()                  == null
            
        ){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Please fill in all the required fields");
        }


        Person entity = new Person(personDTO);
        entity = repo.save(entity);
        return new PersonDTO(entity);
    }

    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } 
        catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }
    }

    public PersonDTO update(Long id, PersonInsertDTO personDTO) {
        try {

            Person person = repo.getOne(id);
            person.setBirthDate(personDTO.getBirthDate());
            person.setCpf(personDTO.getCpf());
            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setPhones(personDTO.getPhones());

            person = repo.save(person);
            return new PersonDTO(person);
        } 
        catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }
    }

}
