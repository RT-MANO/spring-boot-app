package com.mano;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class StartApplicationTest {

    @Autowired
    private MockMvc mockMvc;
/*
    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) // HTTP 200 status
                .andExpect(view().name("index")) // View name
                .andExpect(model().attribute("title", "I have deployed a sprint boot application using GITOPS CI/CD"))
                .andExpect(model().attribute("msg", "This application is deployed on to Minikube K38 cluster using Argo CD"));
    }*/
}