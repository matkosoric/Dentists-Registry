package edu.matko.soric.dentists.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min=2, max=30, message = "Field 'Name' - inadequate number of characters (2-30)")
    private String name;

    @Size(min=2, max=45, message = "Field 'Surname' - inadequate number of characters  (2-45)")
    @NotNull
    private String surname;

    @Size(min=2, max=30, message = "Field 'City' - inadequate number of characters  (2-30)")
    @NotNull
    private String city;

    @Size(min=2, max=50, message = "Field 'Street' - inadequate number of characters  (2-50)")
    @NotNull
    private String street;

    @Max(value = 10000, message = "Field 'Number of patients' - Too many patients (Maximum 10 000)")
    @Min(value = 1, message = "Field 'Number of patients' - Too few patients (Minimum 1)")
    @NotNull
    private Integer number_of_patients;

    public Dentist() { }

    public Dentist(String name, String surname, String city, String street, Integer number_of_patients) {

        this.name = name;
        this.surname = surname;
        this.city = city;
        this.street = street;
        this.number_of_patients = number_of_patients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber_of_patients() {
        return number_of_patients;
    }

    public void setNumber_of_patients(Integer number_of_patients) {
        this.number_of_patients = number_of_patients;
    }
}
