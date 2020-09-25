package com.twuc.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Item;
import com.twuc.shopping.service.ItemService;
import org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ItemService itemService;
    Item item;
    @Autowired
    ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        item=new Item("可乐",3,5,"kele.png");
    }
    @Test
    void should_add_item() throws Exception{
        String jsonString = objectMapper.writeValueAsString(item);
        mockMvc.perform(post("/item").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void should_not_add_item_when_exits_this_item()throws Exception{
        String jsonString = objectMapper.writeValueAsString(item);
        mockMvc.perform(post("/item").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
        mockMvc.perform(get("/items")).andExpect(jsonPath("$",hasSize(1)))
        .andExpect(status().isOk());
    }
    @Test
    void should_return_item_list() throws Exception{
        String jsonString = objectMapper.writeValueAsString(item);
        mockMvc.perform(post("/item").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/items"))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("可乐")))
                .andExpect(jsonPath("$[0].num",is(5)))
                .andExpect(status().isOk());
    }
}