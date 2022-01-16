package system.addressmanagement.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.addressmanagement.person.mapper.MapPersonDetails;
import system.addressmanagement.person.model.Address;
import system.addressmanagement.person.model.Person;
import system.addressmanagement.person.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    MapPersonDetails mapPersonDetails;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressService addressService;

    public void storePersonDetails(Person person) {
        personRepository.save(person);
    }

    public Person getPersonDetailsById(Long personId) {
        Person person = personRepository.getById(personId);
        List<Address> addressList = addressService.getAddressByPersonId(personId);
        person.setAddress(addressList);
        return person;
    }

    public Person updatePersonDetails(Person newPerson, Long personId) {
        Person currentPerson = personRepository.getById(personId);
        Person oldPerson = mapPersonDetails.mapPerson(newPerson, currentPerson);
        personRepository.save(oldPerson);
        return oldPerson;
    }

    public void deletePersonDetails(Long personId) {
        Person person = personRepository.getById(personId);
        List<Address> addressList = person.getAddress();
        addressService.deleteAllAddress(addressList);
        personRepository.delete(person);
    }
}
