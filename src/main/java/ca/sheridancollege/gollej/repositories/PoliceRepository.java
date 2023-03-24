package ca.sheridancollege.gollej.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.gollej.beans.Police;

//Author: Jacob Golle
//Student Number: 991 429 916
//Date: Fri, March 10, 2023

public interface PoliceRepository extends JpaRepository<Police, Long> {
    public Police findByName(String name);
}
