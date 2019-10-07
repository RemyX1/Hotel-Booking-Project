package com.company.trilogyed.hotelbookingservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rewards {

    private Integer id;
    private String roomType;
    private Float discount;
    private Integer points;
    private Boolean canDouble;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Boolean getCanDouble() {
        return canDouble;
    }

    public void setCanDouble(Boolean canDouble) {
        this.canDouble = canDouble;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return Objects.equals(id, rewards.id) &&
                Objects.equals(roomType, rewards.roomType) &&
                Objects.equals(discount, rewards.discount) &&
                Objects.equals(points, rewards.points) &&
                Objects.equals(canDouble, rewards.canDouble);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomType, discount, points, canDouble);
    }
}
