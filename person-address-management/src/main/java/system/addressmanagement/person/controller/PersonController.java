package system.addressmanagement.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.addressmanagement.person.model.Person;
import system.addressmanagement.person.services.PersonService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/address-management")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> storePersonDetails(@RequestBody Person person) {
        personService.storePersonDetails(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<Person> getPersonDetailsById(@PathVariable("personId") Long personId) {
        try {
            Person person = personService.getPersonDetailsById(personId);
            return ResponseEntity.ok(person);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("person/{personId}")
    public ResponseEntity<Person> updatePersonDetails(@RequestBody Person person, @PathVariable("personId") Long personId) {
        Person oldPerson = personService.updatePersonDetails(person, personId);
        return ResponseEntity.ok(oldPerson);
    }


    @DeleteMapping("person/{personId}")
    public ResponseEntity<String> deletePersonDetails(@PathVariable("personId") Long personId) {
        personService.deletePersonDetails(personId);
        return ResponseEntity.ok("person with id " + personId + " and it's all associated address have been removed");
    }
}
