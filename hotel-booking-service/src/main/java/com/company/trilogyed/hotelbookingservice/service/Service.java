package com.company.trilogyed.hotelbookingservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.company.trilogyed.hotelbookingservice.model.Rewards;
import com.company.trilogyed.hotelbookingservice.model.Room;
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

    public RoomViewModel getViewModelInfo(int roomId, boolean rewardsMember, boolean doubleDayBonus) {

        Room roomInfo = roomClient.getRoom(roomId);

        RoomViewModel rmv = new RoomViewModel();

        //set room info
        rmv.setRoomNumber(roomId);
        rmv.setRoomType(roomInfo.getRoomType());

        if(rewardsMember){
            Rewards rewardInfo = rewardsClient.getRewards(roomInfo.getRoomType());
            System.out.println(rewardInfo); 

            // assign the rewards member value
            rmv.setRewardsMember(rewardsMember);
            // assign the doubleBonusDay value
            rmv.setDoubleBonusday(doubleDayBonus);
            // assing the baseRate value
            rmv.setBaserate(new BigDecimal(roomInfo.getBaseRate()));
            // assign the member discount value
            rmv.setMemeberDiscount((double) rewardInfo.getDiscount());
            // assign the base rewards point value
            rmv.setBaseRewardsPoints(rewardInfo.getPoints());
            // assign the canDouble value
            rmv.setCanDouble(rewardInfo.getCanDouble());
            // do calculations to get the discount price and assign value
            BigDecimal discount = new BigDecimal(1).subtract(new BigDecimal(rmv.getMemeberDiscount()));
            BigDecimal afterDiscountTotal = new BigDecimal(roomInfo.getBaseRate()).multiply(discount);
            rmv.setFinalcost(afterDiscountTotal.setScale(2, RoundingMode.HALF_UP));
            // calculate totalRewards points and assign value
            if(doubleDayBonus){
                rmv.setTotalRewardsPoints(rewardInfo.getPoints() * 2);
            }else{
                rmv.setTotalRewardsPoints(rewardInfo.getPoints());
            }

            return rmv;
        }else{

             // assign the rewards member value
             rmv.setRewardsMember(rewardsMember);
             // assign the doubleBonusDay value
             rmv.setDoubleBonusday(doubleDayBonus);
             // assing the baseRate value
             rmv.setBaserate(new BigDecimal(roomInfo.getBaseRate()));
             // assign the member discount value
             rmv.setMemeberDiscount(0);
             // assign the base rewards point value
             rmv.setBaseRewardsPoints(0);
             // assign the canDouble value
             rmv.setCanDouble(false);

             rmv.setFinalcost(new BigDecimal(roomInfo.getBaseRate()).setScale(2, RoundingMode.HALF_UP));

             rmv.setTotalRewardsPoints(0);

            System.out.println(roomInfo);
            return rmv;
        }
    }
}
