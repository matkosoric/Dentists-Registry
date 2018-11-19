package edu.matko.soric.phonebook.services;

import edu.matko.soric.phonebook.entities.Contact;

import java.util.Optional;

public interface ContactsService {

    Iterable<Contact> listAllContacts ();

    Optional<Contact> getContactById (Integer id);

    Contact saveContact (Contact contact);

    void deleteContact (Integer id);

}
