package one.digitalinnovation.personapi.dto;

import one.digitalinnovation.personapi.entities.Phone;
import one.digitalinnovation.personapi.enums.PhoneType;

public class PhoneDTO {

    public PhoneDTO(){
        
    }

    public PhoneDTO(Phone phone){
        this.type = phone.getType();
        this.number = phone.getNumber();
    }

    private PhoneType type;

    private String number;

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



}
