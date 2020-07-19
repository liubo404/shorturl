package ot.devops.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ot.devops.utils.UrlConstants.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShortUrlControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void queryTest() throws Exception {

        mockMvc.perform(get("/shortUrl/query")
                .param("url", SHORT_DOMAIN + EXIST_CODE))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        mockMvc.perform(post("/shortUrl/save")
                .param("url", LONG_URL+ UUID.randomUUID().toString()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
