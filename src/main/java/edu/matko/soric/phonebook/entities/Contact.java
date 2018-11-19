package edu.matko.soric.phonebook.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min=2, max=50, message = "Polje 'Ime' - neispravan broj znakova (2-50)")
    private String name;
    @Size(min=2, max=50, message = "Polje 'Prezime' - neispravan broj znakova (2-50)")
    @NotNull
    private String surname;
    @Size(min=5, max=25, message = "Polje 'Telefonski broj' - neispravan broj znakova (5-25)")
    @NotNull
    private String phoneNumber;
    @javax.validation.constraints.Email (message = "Polje 'E-mail' - neispravan format")
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public Contact() {
        this.creationDate = LocalDate.now();
    }

    public Contact(String name, String surname, String phoneNumber, String email) {

        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creationDate = LocalDate.now();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
