package edu.matko.soric.dentists;

import edu.matko.soric.dentists.entities.Dentist;
import edu.matko.soric.dentists.services.DentistsService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ControllerTests {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private DentistsService dentistsService;

    private MockMvc mockMvc;

    private Dentist dentistSaved;
    private Dentist dentistUnsaved;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        dentistSaved = new Dentist("Orin", "Scrivello", "Iver Heath", "007", 20);
        dentistUnsaved = new Dentist("Borat", "Sagdiyev", "Kuzcek", "51", 2103);
        dentistsService.saveDentist(dentistSaved);
    }

    @Test
    public void redirectRoot() throws Exception{
        this.mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/dentists"))
                .andDo(print());
    }

    @Test
    public void redirectIndex() throws Exception{
        this.mockMvc.perform(get("/index"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/dentists"))
                .andDo(print());
    }

    @Test
    public void dentistsList() throws Exception{
        this.mockMvc.perform(get("/dentists"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("dentists"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andDo(print());
    }


    @Test
    public void dentistsId() throws Exception{
        this.mockMvc.perform(get("/dentist/" + dentistSaved.getId()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("showDentist"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(content().string(Matchers.containsString(Integer.toString(dentistSaved.getId()))))
                .andExpect(content().string(Matchers.containsString(dentistSaved.getName())))
                .andExpect(content().string(Matchers.containsString(dentistSaved.getSurname())))
                .andExpect(content().string(Matchers.containsString(dentistSaved.getCity())))
                .andExpect(content().string(Matchers.containsString(dentistSaved.getStreet())))
                .andExpect(content().string(Matchers.containsString(Integer.toString(dentistSaved.getNumber_of_patients()))))
                .andDo(print());
    }

    @Test
    public void dentistsIdNonExisting() throws Exception{
        this.mockMvc.perform(get("/dentist/" + dentistUnsaved.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andDo(print());
    }

    @Test
    public void dentistsEdit() throws Exception{
        this.mockMvc.perform(get("/dentist/edit/" + dentistSaved.getId()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("dentistForm"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andDo(print());
    }

    @Test
    public void dentistsEditNonExisting() throws Exception{
        this.mockMvc.perform(get("/dentist/edit/" + dentistUnsaved.getId()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("error"))
                .andDo(print());
    }

    @Test
    public void newDentist() throws Exception{
        this.mockMvc.perform(get("/dentist/new"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("dentistForm"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andDo(print());
    }

    @Test
    public void dentistsEditSave() throws Exception{
        this.mockMvc.perform(post("/dentist/edit/" + dentistUnsaved.getId()))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("dentistForm"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andDo(print());
    }

    @Test
    public void dentistsDelete() throws Exception{
        this.mockMvc.perform(delete("/dentist/delete/" + dentistSaved.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/dentists"))
                .andDo(print());
    }

    @Test
    public void login() throws Exception{
        this.mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andDo(print());
    }

    @Test
    public void logout() throws Exception{
        this.mockMvc.perform(post("/logout"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andDo(print());
    }

}
