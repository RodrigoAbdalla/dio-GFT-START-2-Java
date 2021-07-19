package one.digitalinnovation.personapi.dto;

import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.entities.Phone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String cpf;

    private LocalDate birthDate;

    private List<Phone> phones = new ArrayList<>();

    public PersonDTO(){

    }

    public PersonDTO(Person person){
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.cpf = person.getCpf();
        this.birthDate = person.getBirthDate();
        this.phones = person.getPhones();
        this.id = person.getId();
    }

    


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    
    

}
