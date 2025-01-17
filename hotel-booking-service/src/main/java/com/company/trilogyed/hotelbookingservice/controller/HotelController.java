package com.company.trilogyed.hotelbookingservice.controller;

import com.company.trilogyed.hotelbookingservice.model.RoomViewModel;
import com.company.trilogyed.hotelbookingservice.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HotelController {



    @Autowired
    private Service service;

    public HotelController(Service service) {
        this.service = service;
    }

    //Pretend this looks good.
    //Sorry Barbara.
    @RequestMapping(value="/hotelRewards/{roomId}",
            method = RequestMethod.GET)
   @ResponseStatus(HttpStatus.FOUND)
    public RoomViewModel createRoomViewModel(@PathVariable int roomId,
                                             @RequestParam(required= false, defaultValue = "false",name = "rewardMember") Boolean rewardMember,
                                             @RequestParam(required= false, defaultValue = "false", name = "doubleBonusDay") Boolean doubleBonusDay)
    {

        return service.getViewModelInfo(roomId,rewardMember,doubleBonusDay);
        
    }


}
