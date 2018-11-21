package edu.matko.soric.phonebook.controllers;

import edu.matko.soric.phonebook.entities.Contact;
import edu.matko.soric.phonebook.services.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @RequestMapping("/")
    String index() {
        return "redirect:/contacts";
    }

    @RequestMapping (value = "/contacts", method = RequestMethod.GET)
    public String listAll (Model model) {
        model.addAttribute("contacts", contactsService.listAllContacts());
        return "contacts";
    }

    @RequestMapping (value= "contact/{id}", method=RequestMethod.GET)
    public String showContact (@PathVariable Integer id, Model model) {
        model.addAttribute("contact", contactsService.getContactById(id));
        return "showContact";
    }

    @RequestMapping (value = "contact/edit/{id}", method=RequestMethod.GET)
    public String edit (@PathVariable Integer id, Model model) {
        model.addAttribute("contact", contactsService.getContactById(id));
        return "contactForm";
    }

    @RequestMapping (value = "contact/new")
    public String newContact (Model model) {
        model.addAttribute("contact", new Contact());
        return "contactForm";
    }

    @RequestMapping (value = "contact/edit/{id}", method = RequestMethod.POST)
    public String saveContact ( @Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult, ModelMap model) {

        Integer id = contact.getId();
        if (bindingResult.hasErrors()) {
            model.addAttribute("id", id);
            return "contactForm";
        }
        contactsService.saveContact(contact);
        return "redirect:/contact/edit/" + contact.getId();
    }

    @RequestMapping (value = "contact/delete/{id}")
    public String deletecontact (@PathVariable Integer id) {
        contactsService.deleteContact(id);
        return "redirect:/contacts";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}



