package system.addressmanagement.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import system.addressmanagement.person.model.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT u FROM Person u WHERE u.firstName = ?1")
    List<Person> getByFirstName(String firstName);
}
