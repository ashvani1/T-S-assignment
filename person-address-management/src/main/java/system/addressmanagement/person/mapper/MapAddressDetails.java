package system.addressmanagement.person.mapper;

import org.springframework.stereotype.Component;
import system.addressmanagement.person.model.Address;

import static java.util.Objects.nonNull;

@Component
public class MapAddressDetails {

    public Address mapAddressDetails(Address oldAddress, Address newAddress) {

        if (nonNull(newAddress.getArea())) {
            oldAddress.setArea(newAddress.getArea());
        }

        if (nonNull(newAddress.getCity())) {
            oldAddress.setCity(newAddress.getCity());
        }

        if (nonNull(newAddress.getArea())) {
            oldAddress.setArea(newAddress.getArea());
        }

        if (nonNull(newAddress.getCountry())) {
            oldAddress.setCountry(newAddress.getCountry());
        }

        if (nonNull(newAddress.getDistrict())) {
            oldAddress.setDistrict(newAddress.getDistrict());
        }

        if (nonNull(newAddress.getHouseName())) {
            oldAddress.setHouseName(newAddress.getHouseName());
        }

        if (nonNull(newAddress.getPinCode())) {
            oldAddress.setPinCode(newAddress.getPinCode());
        }

        if (nonNull(newAddress.getState())) {
            oldAddress.setState(newAddress.getState());
        }

        if (nonNull(newAddress.getStreetName())) {
            oldAddress.setStreetName(newAddress.getStreetName());
        }
        return oldAddress;
    }
}
