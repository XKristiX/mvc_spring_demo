package com.example.mvc_spring_demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.mvc_spring_demo.models.Address;
import com.example.mvc_spring_demo.repositories.AddressRepository;

@Controller
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/getAllAddresses")
    public String getAllAddresses(Model model) {
        addAddressModel(model);
        return "address";
    }

    private void addAddressModel(Model model) {
        Iterable<Address> addresses = addressRepository.findAll();
        model.addAttribute("address", addresses);
    }

    @PostMapping("/createNewAddress")
    public String createAddress(@RequestBody Address address, Model model) {
        addressRepository.save(address);
        addAddressModel(model);
        return "address";
    }

    @DeleteMapping("/deleteAddress/{id}")
    public String deleteAddress(@PathVariable Long id, Model model) {
        addressRepository.deleteById(id);
        addAddressModel(model);
        return "address";
    }

    @PutMapping("/updateAddress/{id}")
    public Boolean updateAddress(@RequestBody Address address,@PathVariable Long id, Model model) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
    
    if (optionalAddress.isPresent()) {
        Address oldAddress = optionalAddress.get();

        boolean newAddress = true;
        if (!areAddressesEqual(oldAddress, newAddress)) {

            addressRepository.save(oldAddress);
        }else {
            return true;
        }
    }
    return null;
    

}

private boolean areAddressesEqual(Address oldAddress, boolean newAddress) {
    return false;
}



}

