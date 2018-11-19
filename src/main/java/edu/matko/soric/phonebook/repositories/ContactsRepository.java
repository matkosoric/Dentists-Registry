package edu.matko.soric.phonebook.repositories;

import edu.matko.soric.phonebook.entities.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactsRepository extends CrudRepository <Contact, Integer> {
}
