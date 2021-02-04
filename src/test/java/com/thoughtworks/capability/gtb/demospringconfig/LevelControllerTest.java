package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"levelNumber=1"})
public class LevelControllerTest {

    @Autowired
    private MockMvc mvc;

//    @Test
//    public void should_return_level_basic_when_Level_number_is_less_than_one() throws Exception {
//        MvcResult mvcResult = mvc.perform(get("/level")).andExpect(status().isOk()).andReturn();
//        assertEquals(mvcResult.getResponse().getContentAsString(), "basic");
//    }

    @Test
    public void should_return_level_basic_when_Level_number_is_greater_equal_than_one() throws Exception {
        MvcResult mvcResult = mvc.perform(get("/level")).andExpect(status().isOk()).andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(), "advanced");
    }
}
