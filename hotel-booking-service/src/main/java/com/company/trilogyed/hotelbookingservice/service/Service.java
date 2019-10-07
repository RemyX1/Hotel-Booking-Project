package com.company.trilogyed.hotelbookingservice.service;


import com.company.trilogyed.hotelbookingservice.model.RoomViewModel;
import com.company.trilogyed.hotelbookingservice.util.feign.RewardsFeignClient;
import com.company.trilogyed.hotelbookingservice.util.feign.RoomFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {


    private RewardsFeignClient rewardsClient;
    private RoomFeignClient roomClient;

    @Autowired
    public Service(RewardsFeignClient rewardsClient, RoomFeignClient roomClient) {
        this.rewardsClient = rewardsClient;
        this.roomClient = roomClient;
    }


    public RoomViewModel getViewModelInfo(int roomId, boolean rewardsMember, boolean doubleDayBonus)    {

        return null;

    }









}
