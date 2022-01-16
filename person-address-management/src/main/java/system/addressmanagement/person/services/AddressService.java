package system.addressmanagement.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.addressmanagement.person.mapper.MapAddressDetails;
import system.addressmanagement.person.model.Address;
import system.addressmanagement.person.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    MapAddressDetails mapAddressDetails;

    public void storePersonAddress(Address address) {
        addressRepository.save(address);
    }

    public List<Address> getAddressByPersonId(Long personId) {
        return addressRepository.getAddressByPersonId(personId);
    }

    public Address getAddressByAddressId(Long addressId) {
        return addressRepository.getById(addressId);
    }

    public Address updateAddressDetails(Address newAddress, Long addressId) {
        Address oldAddress = getAddressByAddressId(addressId);
        oldAddress = mapAddressDetails.mapAddressDetails(oldAddress, newAddress);
        addressRepository.save(oldAddress);
        return oldAddress;
    }

    public void deleteAddressDetails(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    public void deleteAllAddress(List<Address> addressList) {
        for (Address address : addressList) {
            addressRepository.delete(address);
        }
    }

    public Address getAddressDetailsById(Long addressId) {
        return addressRepository.getById(addressId);
    }
}
