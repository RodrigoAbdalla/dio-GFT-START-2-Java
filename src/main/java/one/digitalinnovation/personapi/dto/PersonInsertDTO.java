package one.digitalinnovation.personapi.dto;

import one.digitalinnovation.personapi.entities.Person;

import java.time.LocalDate;

public class PersonInsertDTO {

    private String firstName;

    private String lastName;

    private String cpf;

    private LocalDate birthDate;

    public PersonInsertDTO(){

    }

    public PersonInsertDTO(Person person){
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.cpf = person.getCpf();
        this.birthDate = person.getBirthDate();
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

    


}
