package com.company.trilogyed.hotelbookingservice.controller;

import com.company.trilogyed.hotelbookingservice.model.RoomViewModel;
import com.company.trilogyed.hotelbookingservice.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static com.sun.deploy.cache.Cache.exists;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    @Autowired
    private Service service;

    static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCreateViewModel() throws Exception {
        RoomViewModel rvm = new RoomViewModel(301,"King",true,true,
                new BigDecimal("229.00"), .20,300,true, new BigDecimal("183.20"),
                600);

        when(service.getViewModelInfo(rvm.getRoomNumber(),rvm.isRewardsMember(),rvm.isDoubleBonusday()))
                .thenReturn(rvm);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/hotelRewards/" + 301 + "?rewardsMember=true&doubleBonusDay=true"))
                .andDo(print()).andExpect(status().isFound());
//                .content(asJsonString( new RoomViewModel(301,"King",true,true,
//                       new BigDecimal("229.00"), .20,300,true, new BigDecimal("183.20"),
//                        600)))
//                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
               // .accept(MediaType.APPLICATION_JSON_UTF8))
                     //  .andDo(print()).andExpect(status().isOk());
                //.andExpect(content().json(outputJson));

    }


}