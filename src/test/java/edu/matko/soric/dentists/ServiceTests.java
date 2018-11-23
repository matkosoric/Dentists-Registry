package edu.matko.soric.dentists;

import edu.matko.soric.dentists.entities.Dentist;
import edu.matko.soric.dentists.services.DentistsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private Dentist dentistSaved;
    private Dentist dentistUnsaved;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        dentistSaved = new Dentist("Stu", "Price", "Zagreb", "Trg Bana Jelačića 1", 2103);
        dentistUnsaved = new Dentist("Hulk", "Hogan", "Los Angeles", "Fairfax 41", 8000);
    }

    @Autowired
    private DentistsService dentistsService;


    @Test
    public void serviceWriteAndRead() throws Exception {

        dentistsService.saveDentist(dentistSaved);
        Optional<Dentist> dentistReturned = dentistsService.getDentistById(dentistSaved.getId());

        assertThat (dentistSaved.equals(dentistReturned));
    }


    @Test
    public void serviceDelete() throws Exception {

        dentistsService.saveDentist(dentistSaved);
        dentistsService.deleteDentist(dentistSaved.getId());

        Optional<Dentist> dentistReturned = dentistsService.getDentistById(dentistSaved.getId());

        assertThat (dentistReturned.equals(Optional.empty()));

    }

}
