package system.addressmanagement.person.mapper;

import org.springframework.stereotype.Component;
import system.addressmanagement.person.model.Person;

import static java.util.Objects.nonNull;

@Component
public class MapPersonDetails {

    public Person mapPerson(Person newPerson, Person oldPerson) {
        if (nonNull(newPerson.getFirstName())) {
            oldPerson.setFirstName(newPerson.getFirstName());
        }

        if (nonNull(newPerson.getLastName())) {
            oldPerson.setLastName(newPerson.getLastName());
        }


        if (nonNull(newPerson.getGender())) {
            oldPerson.setGender(newPerson.getGender());
        }


        if (nonNull(newPerson.getMobileNo())) {
            oldPerson.setMobileNo(newPerson.getMobileNo());
        }

        return oldPerson;
    }
}
