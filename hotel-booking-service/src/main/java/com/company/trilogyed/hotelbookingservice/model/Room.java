package com.company.trilogyed.hotelbookingservice.model;


import java.util.Objects;

public class Room {

    private Integer number;
    private String roomType;
    private Float baseRate;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Float getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Float baseRate) {
        this.baseRate = baseRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(number, room.number) &&
                Objects.equals(roomType, room.roomType) &&
                Objects.equals(baseRate, room.baseRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, roomType, baseRate);
    }
}

