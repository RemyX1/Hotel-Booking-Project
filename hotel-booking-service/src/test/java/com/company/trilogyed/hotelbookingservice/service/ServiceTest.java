package com.company.trilogyed.hotelbookingservice.service;

import com.company.trilogyed.hotelbookingservice.model.Rewards;
import com.company.trilogyed.hotelbookingservice.model.Room;
import com.company.trilogyed.hotelbookingservice.model.RoomViewModel;
import com.company.trilogyed.hotelbookingservice.util.feign.RewardsFeignClient;
import com.company.trilogyed.hotelbookingservice.util.feign.RoomFeignClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {


    private Service service;
    private RoomFeignClient roomClient;
    private RewardsFeignClient rewardsClient;



    @Before
    public void setUp() throws Exception {

        setupRewardsClientMock();
        setupRoomClientMock();
        service = new Service(rewardsClient,roomClient);

    }

    @Test
    public void getViewModelInfo() {

        RoomViewModel rvm = new RoomViewModel(301,"King",true,true,
                new BigDecimal("229.00"), .20,300,true, new BigDecimal("183.20"),
                600);

        Room room = new Room();
        room.setBaseRate(229f);
        room.setNumber(rvm.getRoomNumber());
        room.setRoomType(rvm.getRoomType());

        Rewards rewards = new Rewards();
        rewards.setId(3);
        rewards.setRoomType(rvm.getRoomType());
        rewards.setCanDouble(rvm.isCanDouble());
        rewards.setPoints(rvm.getBaseRewardsPoints());
        rewards.setDiscount((float) rvm.getMemeberDiscount());



        //doReturn(rvm).when(service).getViewModelInfo(301,true,true);
        doReturn(room).when(roomClient).getRoom(room.getNumber());
        doReturn(rewards).when(rewardsClient).getRewards(rewards.getRoomType());

        RoomViewModel actualRVM  = service.getViewModelInfo(room.getNumber(),rvm.isRewardsMember(),rvm.isDoubleBonusday());

        //assertEquals(rvm,actualRVM);

        assertEquals(rvm.getFinalcost(),actualRVM.getFinalcost());

    }


    public void setupRoomClientMock(){

        roomClient = mock(RoomFeignClient.class);



    }

    public void setupRewardsClientMock(){

        rewardsClient = mock(RewardsFeignClient.class);



    }


}