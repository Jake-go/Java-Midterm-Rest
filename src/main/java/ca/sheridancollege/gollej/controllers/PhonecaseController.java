package ca.sheridancollege.gollej.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.gollej.beans.Phonecase;
import ca.sheridancollege.gollej.repositories.PhonecaseRepository;
import ca.sheridancollege.gollej.repositories.PoliceRepository;
import lombok.AllArgsConstructor;

//Author: Jacob Golle
//Student Number: 991 429 916
//Date: Fri, March 10, 2023

@RestController
@AllArgsConstructor
@RequestMapping("/phonecase")
public class PhonecaseController {

    private PhonecaseRepository phonecaseRepository;
    private PoliceRepository policeRepository;

    @GetMapping(value = { "/", "" })
    public List<Phonecase> getPhonecaseCollection() {
        return phonecaseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Phonecase getPhonecaseById(@PathVariable Long id) {
        Optional<Phonecase> phonecase = phonecaseRepository.findById(id);
        if (phonecase.isPresent()) {
            return phonecase.get();
        } else {
            return null;
        }
    }

    @PostMapping(value = { "/", "" }, headers = "Content-type=application/json")
    public Phonecase postPhonecaseCollection(@RequestBody Phonecase phonecase) {
        phonecase.setId(null);
        phonecase.setPolice(policeRepository.findByName(phonecase.getEmployeeName()));
        return phonecaseRepository.save(phonecase);
    }

    @PutMapping(value = "/{id}", headers = "Content-type=application/json")
    public Long putPhonecaseCollection(@PathVariable Long id, @RequestBody Phonecase phonecase) {
        phonecase.setId(id);
        phonecase.setPolice(policeRepository.findByName(phonecase.getEmployeeName()));
        phonecaseRepository.save(phonecase);
        return id;
    }

    @DeleteMapping("/{id}")
    public String deletePhonecaseById(@PathVariable Long id) {
        phonecaseRepository.deleteById(id);
        System.out.println("Phonecase with id " + id + " has been deleted.");
        return "Phonecase with id " + id + " has been deleted.";
    }
}
