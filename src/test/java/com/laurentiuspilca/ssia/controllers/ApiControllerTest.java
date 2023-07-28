package com.laurentiuspilca.ssia.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laurentiuspilca.ssia.model.CreateResourceRequest;
import com.laurentiuspilca.ssia.model.GetResource200Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateResource() throws Exception {
        CreateResourceRequest request = new CreateResourceRequest();
        request.setName("test");

        GetResource200Response response = new GetResource200Response();
        response.setId(123);
        response.setName("test");

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/v1/mypath")
                        .header("Request-Id", "1")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        // Add more assertions if needed
    }

    @Test
    void testGetResource() throws Exception {
        GetResource200Response response = new GetResource200Response();
        response.setId(123);
        response.setName("Example Name");

        mockMvc.perform(get("/api/v1/mypath").header("Request-Id", "1")).andExpect(status().isOk());
        // Add more assertions if needed
    }
}
