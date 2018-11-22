package edu.matko.soric.dentists;

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
    public void redirectDentists() throws Exception{
        this.mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/dentists"))
                .andDo(print());
    }

    @Test
    public void dentistsList() throws Exception{
        this.mockMvc.perform(get("/dentists"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("dentists"))
                .andDo(print());
    }

    @Test
    public void newDentist() throws Exception{
        this.mockMvc.perform(get("/dentist/new"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("dentistForm"))
                .andDo(print());
    }


    @Test
    public void editDentist() throws Exception{
        this.mockMvc.perform(get("/dentist/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("showDentist"))
                .andDo(print());
    }


}
