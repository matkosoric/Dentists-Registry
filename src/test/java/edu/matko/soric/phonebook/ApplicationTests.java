package edu.matko.soric.phonebook;

import edu.matko.soric.phonebook.controllers.ContactsController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"security.basic.enabled=false", "management.security.enabled=false"})
public class ApplicationTests {

	private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ContactsController()).build();
    }
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ContactsController contactsController;


	@Test
	public void testIndex() throws Exception{
		this.mockMvc.perform(get("/"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/contacts"))
				.andDo(print());
	}

}
