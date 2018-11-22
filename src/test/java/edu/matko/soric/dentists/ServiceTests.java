package edu.matko.soric.dentists;

import edu.matko.soric.dentists.entities.Dentist;
import edu.matko.soric.dentists.services.DentistsService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"security.basic.enabled=false", "management.security.enabled=false"})
public class ServiceTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Autowired
    private DentistsService dentistsService;


    @Test
    public void serviceWriteAndRead() throws Exception {

        Dentist dentist = new Dentist("matko", "sorić", "091/555-555", "soric.matko@gmail.com", 2000);
        dentistsService.saveDentist(dentist);
        Optional<Dentist> dentistReturned = dentistsService.getDentistById(dentist.getId());

        assertThat (dentist.equals(dentistReturned));

    }


    @Test
    public void serviceListAllDentists() throws Exception{

        assertThat(this.dentistsService).isNotNull();

        Iterable<Dentist> dentistList = dentistsService.listAllDentists();

        mockMvc.perform(get("/dentists"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("text/html;charset=UTF-8"))
                    .andExpect(view().name("dentists"))
                    .andExpect(model().attributeExists("dentists"))
                    .andExpect(model().size(1))
                    .andExpect(content().string(Matchers.containsString("matko")))
                    .andDo(print());
    }


}
