package ca.sheridancollege.gollej.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Author: Jacob Golle
//Student Number: 991 429 916
//Date: Fri, March 10, 2023

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phonecase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    private String employeeName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "police_phonecase", joinColumns = @JoinColumn(name = "phonecase_id"), inverseJoinColumns = @JoinColumn(name = "police_id"))
    private Police police;

}
