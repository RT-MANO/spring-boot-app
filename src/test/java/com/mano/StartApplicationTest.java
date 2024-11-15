package com.mano;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.ui.Model;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

@WebMvcTest(StartApplication.class)
public class StartApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StartApplication startApplication;

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("title", "I have deployed a sprint boot application using GITOPS CI/CD"))
                .andExpect(model().attribute("msg", "This application is deployed on to Minikube K38 cluster using Argo CD"));
    }

    @Test
    public void testIndex1() {
        Model model = null; // Mock Model if needed
        ModelAndView mv = startApplication.index(model);

        // Verify view name
        assertEquals("index", mv.getViewName());

        // Verify model attributes
        assertThat(mv.getModel(), hasEntry("title", "I have deployed a sprint boot application using GITOPS CI/CD"));
        assertThat(mv.getModel(), hasEntry("msg", "This application is deployed on to Minikube K38 cluster using Argo CD"));
    }
    }