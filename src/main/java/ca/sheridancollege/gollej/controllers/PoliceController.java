package ca.sheridancollege.gollej.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.gollej.beans.Police;
import ca.sheridancollege.gollej.repositories.PoliceRepository;
import lombok.AllArgsConstructor;

//Author: Jacob Golle
//Student Number: 991 429 916
//Date: Fri, March 10, 2023

@RestController
@AllArgsConstructor
@RequestMapping("/police")
public class PoliceController {

    private PoliceRepository policeRepository;

    @GetMapping(value = { "/", "" })
    public List<Police> getPoliceCollection() {
        return policeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Police getPoliceById(@PathVariable Long id) {
        Optional<Police> police = policeRepository.findById(id);
        if (police.isPresent()) {
            return police.get();
        } else {
            return null;
        }
    }

    @PostMapping(value = { "/", "" }, headers = "Content-type=application/json")
    public Police postPoliceCollection(@RequestBody Police police) {
        police.setId(null);
        return policeRepository.save(police);
    }

}
