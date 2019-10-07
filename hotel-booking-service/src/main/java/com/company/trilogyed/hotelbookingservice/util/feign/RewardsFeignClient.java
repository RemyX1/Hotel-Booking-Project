package com.company.trilogyed.hotelbookingservice.util.feign;

import com.company.trilogyed.hotelbookingservice.model.Rewards;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


public interface RewardsFeignClient {

    @RequestMapping(value = "/rewards/type/{roomType}", method = RequestMethod.GET)
    public Rewards getRewards(@PathVariable String roomType);

    @RequestMapping(value = "/rewards", method = RequestMethod.GET)
    public List<Rewards> getAllRewards();



}
