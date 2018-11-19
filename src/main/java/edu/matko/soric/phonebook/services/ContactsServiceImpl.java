package edu.matko.soric.phonebook.services;

import edu.matko.soric.phonebook.entities.Contact;
import edu.matko.soric.phonebook.repositories.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactsServiceImpl implements ContactsService {

    private ContactsRepository contactsRepository;

    @Autowired
    public void setContactsRepository (ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public Iterable<Contact> listAllContacts() {
        return contactsRepository.findAll();
    }

    @Override
    public Optional<Contact> getContactById(Integer id) {
        return contactsRepository.findById(id);
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactsRepository.save(contact);
    }

    @Override
    public void deleteContact(Integer id) {
        contactsRepository.deleteById(id);
    }
}
