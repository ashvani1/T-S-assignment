package system.addressmanagement.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import system.addressmanagement.person.model.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "SELECT u FROM Address u WHERE u.personId = ?1")
    List<Address> getAddressByPersonId(Long personId);
}
