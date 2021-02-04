package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="/application.properties")
public class LevelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_advanced_when_give_level_number_greater_equal_than_1() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/level")).andExpect(status().isOk()).andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(), "advanced");
    }

}
