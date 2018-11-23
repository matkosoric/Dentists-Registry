package edu.matko.soric.dentists.controllers;

import edu.matko.soric.dentists.entities.Dentist;
import edu.matko.soric.dentists.services.DentistsService;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes
public class DentistsController {

    @Autowired
    private DentistsService dentistsService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/dentists";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "redirect:/dentists";
    }

    @RequestMapping (value = "/dentists", method = RequestMethod.GET)
    public String listAll (Model model) {
        model.addAttribute("dentists", dentistsService.listAllDentists());
        return "dentists";
    }

    @RequestMapping (value= "dentist/{id}", method=RequestMethod.GET)
    public String showDentist (@PathVariable Integer id, Model model) {
        model.addAttribute("dentist", dentistsService.getDentistById(id));
        return "showDentist";
    }

    @RequestMapping (value = "dentist/edit/{id}", method=RequestMethod.GET)
    public String edit (@PathVariable Integer id, Model model) {
        model.addAttribute("dentist", dentistsService.getDentistById(id));
        return "dentistForm";
    }

    @RequestMapping (value = "dentist/new", method=RequestMethod.GET)
    public String newDentist (Model model) {
        model.addAttribute("dentist", new Dentist());
        return "dentistForm";
    }

    @RequestMapping (value = "dentist/edit/{id}", method = RequestMethod.POST)
    public String saveDentist (@Valid @ModelAttribute("dentist") Dentist dentist, BindingResult bindingResult, ModelMap model) {

        Integer id = dentist.getId();
        if (bindingResult.hasErrors()) {
            model.addAttribute("id", id);
            return "dentistForm";
        }
        dentistsService.saveDentist(dentist);
        return "redirect:/dentist/edit/" + dentist.getId();
    }

    @RequestMapping (value = "dentist/delete/{id}", method = RequestMethod.DELETE)
    public String deleteDentist (@PathVariable Integer id) {
        dentistsService.deleteDentist(id);
        return "redirect:/dentists";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response){
        HttpSession session;
        SecurityContextHolder.clearContext();
        session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

        return "redirect:/login";
    }

}



