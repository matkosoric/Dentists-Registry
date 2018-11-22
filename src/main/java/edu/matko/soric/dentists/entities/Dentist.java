package edu.matko.soric.dentists.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min=2, max=50, message = "Field 'Name' - inadequate number of characters (2-50)")
    private String name;
    @Size(min=2, max=50, message = "Field 'Surname' - inadequate number of characters  (2-50)")
    @NotNull
    private String surname;
    @Size(min=2, max=25, message = "Field 'City' - inadequate number of characters  (2-50)")
    @NotNull
    private String city;

//    @javax.validation.constraints.Email (message = "Field 'E-mail' - inadequate formatting")
    private String street;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Integer number_of_patients;

    public Dentist() {
//        this.number_of_patients = LocalDate.now();
    }

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
