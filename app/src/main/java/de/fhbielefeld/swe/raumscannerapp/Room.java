package de.fhbielefeld.swe.raumscannerapp;

import java.util.Objects;
import java.util.UUID;

public class Room {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room1 = (Room) o;
        return seat_count == room1.seat_count && table_count == room1.table_count && Objects.equals(id, room1.id) && Objects.equals(roomnumber, room1.roomnumber) && Objects.equals(specials, room1.specials) && Objects.equals(building, room1.building) && Objects.equals(section, room1.section) && Objects.equals(floor, room1.floor) && Objects.equals(room, room1.room) && Objects.equals(damagenote, room1.damagenote) && Objects.equals(alias, room1.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomnumber, seat_count, table_count, specials, building, section, floor, room, damagenote, alias);
    }

    private UUID id;
    private String roomnumber;
    private int seat_count;
    private int table_count;
    private String specials;
    private String building;
    private String section;
    private String floor;
    private String room;
    private String damagenote;
    private String alias;

    public Room(UUID id, String roomnumber, int seat_count, int table_count, String specials, String building, String section, String floor, String room, String damagenote, String alias) {
        this.id = id;
        this.roomnumber = roomnumber;
        this.seat_count = seat_count;
        this.table_count = table_count;
        this.specials = specials;
        this.building = building;
        this.section = section;
        this.floor = floor;
        this.room = room;
        this.damagenote = damagenote;
        this.alias = alias;
    }

    //Getter Setter:
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public int getSeat_count() {
        return seat_count;
    }

    public void setSeat_count(int seat_count) {
        this.seat_count = seat_count;
    }

    public int getTable_count() {
        return table_count;
    }

    public void setTable_count(int table_count) {
        this.table_count = table_count;
    }

    public String getSpecials() {
        return specials;
    }

    public void setSpecials(String specials) {
        this.specials = specials;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDamagenote() {
        return damagenote;
    }

    public void setDamagenote(String damagenote) {
        this.damagenote = damagenote;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }



}
