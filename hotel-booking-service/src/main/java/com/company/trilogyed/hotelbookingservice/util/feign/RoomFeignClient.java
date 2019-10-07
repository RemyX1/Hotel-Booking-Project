package com.company.trilogyed.hotelbookingservice.util.feign;

import com.company.trilogyed.hotelbookingservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "room-service:8234")
public interface RoomFeignClient {


    @RequestMapping(value = "/room/{number}", method = RequestMethod.GET)
    public Room getRoom(@PathVariable int number);

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public List<Room> getAllRooms();



}
