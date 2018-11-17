package edu.matko.soric.demo.kontakti.aplikacija.repositories;

import edu.matko.soric.demo.kontakti.aplikacija.entities.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactsRepository extends CrudRepository <Contact, Integer> {
}
