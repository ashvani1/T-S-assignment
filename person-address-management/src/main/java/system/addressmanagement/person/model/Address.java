package system.addressmanagement.person.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long addressId;
    Long houseNo;
    String houseName;
    String streetName;
    String Area;
    Integer pinCode;
    String city;
    String district;
    String state;
    String country;

    Long personId;

    @ManyToOne
    //@JoinColumn(name = "book_id", referencedColumnName = "bookId")
    Person person;

   /* @ManyToMany(targetEntity = Person.class, cascade = CascadeType.ALL)
    List<Person> personList;*/
}
