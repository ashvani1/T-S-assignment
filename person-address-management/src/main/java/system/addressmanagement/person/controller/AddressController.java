package system.addressmanagement.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.addressmanagement.person.model.Address;
import system.addressmanagement.person.services.AddressService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/address-management")
public class AddressController {

    @Autowired
    AddressService addressService;


    @PostMapping("/address")
    public ResponseEntity<Address> storePersonAddress(@RequestBody Address address) {
        addressService.storePersonAddress(address);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/address/{addressId}")
    public ResponseEntity<Address> getAddressDetailsById(@PathVariable("addressId") Long addressId) {
        try {
            Address address = addressService.getAddressDetailsById(addressId);
            return ResponseEntity.ok(address);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("address/{addressId}")
    public ResponseEntity<Address> updateAddressDetails(@RequestBody Address address, @PathVariable("addressId") Long addressId) {
        Address oldAddress = addressService.updateAddressDetails(address, addressId);
        return ResponseEntity.ok(oldAddress);
    }

    @DeleteMapping("address/{addressId}")
    public ResponseEntity<String> deleteAddressDetails(@PathVariable("addressId") Long addressId) {
        addressService.deleteAddressDetails(addressId);
        return ResponseEntity.ok("address with id " + addressId + " have been removed");
    }
}
