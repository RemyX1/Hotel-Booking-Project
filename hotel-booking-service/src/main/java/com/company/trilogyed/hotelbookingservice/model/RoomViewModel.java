package com.company.trilogyed.hotelbookingservice.model;

import java.math.BigDecimal;
import java.util.Objects;

public class RoomViewModel {


    private int roomNumber;
    private String roomType;
    private boolean rewardsMember;
    private boolean doubleBonusday;
    private BigDecimal baserate;
    private double memeberDiscount;
    private int baseRewardsPoints;
    private boolean canDouble;
    private BigDecimal finalcost;
    private int totalRewardsPoints;


    public RoomViewModel() {
    }

    public RoomViewModel(int roomNumber, String roomType,
                         boolean rewardsMember, boolean doubleBonusday,
                         BigDecimal baserate, double memeberDiscount,
                         int baseRewardsPoints, boolean canDouble,
                         BigDecimal finalcost, int totalRewardsPoints) {

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.rewardsMember = rewardsMember;
        this.doubleBonusday = doubleBonusday;
        this.baserate = baserate;
        this.memeberDiscount = memeberDiscount;
        this.baseRewardsPoints = baseRewardsPoints;
        this.canDouble = canDouble;
        this.finalcost = finalcost;
        this.totalRewardsPoints = totalRewardsPoints;

    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomViewModel setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public String getRoomType() {
        return roomType;
    }

    public RoomViewModel setRoomType(String roomType) {
        this.roomType = roomType;
        return this;
    }

    public boolean isRewardsMember() {
        return rewardsMember;
    }

    public RoomViewModel setRewardsMember(boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
        return this;
    }

    public boolean isDoubleBonusday() {
        return doubleBonusday;
    }

    public RoomViewModel setDoubleBonusday(boolean doubleBonusday) {
        this.doubleBonusday = doubleBonusday;
        return this;
    }

    public BigDecimal getBaserate() {
        return baserate;
    }

    public RoomViewModel setBaserate(BigDecimal baserate) {
        this.baserate = baserate;
        return this;
    }

    public double getMemeberDiscount() {
        return memeberDiscount;
    }

    public RoomViewModel setMemeberDiscount(double memeberDiscount) {
        this.memeberDiscount = memeberDiscount;
        return this;
    }

    public int getBaseRewardsPoints() {
        return baseRewardsPoints;
    }

    public RoomViewModel setBaseRewardsPoints(int baseRewardsPoints) {
        this.baseRewardsPoints = baseRewardsPoints;
        return this;
    }

    public boolean isCanDouble() {
        return canDouble;
    }

    public RoomViewModel setCanDouble(boolean canDouble) {
        this.canDouble = canDouble;
        return this;
    }

    public BigDecimal getFinalcost() {
        return finalcost;
    }

    public RoomViewModel setFinalcost(BigDecimal finalcost) {
        this.finalcost = finalcost;
        return this;
    }

    public int getTotalRewardsPoints() {
        return totalRewardsPoints;
    }

    public RoomViewModel setTotalRewardsPoints(int totalRewardsPoints) {
        this.totalRewardsPoints = totalRewardsPoints;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomViewModel that = (RoomViewModel) o;
        return roomNumber == that.roomNumber &&
                rewardsMember == that.rewardsMember &&
                doubleBonusday == that.doubleBonusday &&
                Double.compare(that.memeberDiscount, memeberDiscount) == 0 &&
                baseRewardsPoints == that.baseRewardsPoints &&
                canDouble == that.canDouble &&
                totalRewardsPoints == that.totalRewardsPoints &&
                Objects.equals(roomType, that.roomType) &&
                Objects.equals(baserate, that.baserate) &&
                Objects.equals(finalcost, that.finalcost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomType, rewardsMember, doubleBonusday, baserate, memeberDiscount, baseRewardsPoints, canDouble, finalcost, totalRewardsPoints);
    }
}
