package edu.matko.soric.demo.kontakti.aplikacija.services;

import edu.matko.soric.demo.kontakti.aplikacija.entities.Contact;

import java.util.Optional;

public interface ContactsService {

    Iterable<Contact> listAllContacts ();

    Optional<Contact> getContactById (Integer id);

    Contact saveContact (Contact contact);

    void deleteContact (Integer id);

}
