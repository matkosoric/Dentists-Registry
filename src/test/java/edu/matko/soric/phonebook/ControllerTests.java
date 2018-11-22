package edu.matko.soric.phonebook;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@TestPropertySource(properties = {"security.basic.enabled=false", "management.security.enabled=false"})
public class ControllerTests {


    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void redirectContacts() throws Exception{
        this.mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/contacts"))
                .andDo(print());
    }

    @Test
    public void contactsList() throws Exception{
        this.mockMvc.perform(get("/contacts"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("contacts"))
                .andDo(print());
    }

    @Test
    public void newContact() throws Exception{
        this.mockMvc.perform(get("/contact/new"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("contactForm"))
                .andDo(print());
    }


    @Test
    public void editContact() throws Exception{
        this.mockMvc.perform(get("/contact/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("showContact"))
                .andDo(print());
    }


}
