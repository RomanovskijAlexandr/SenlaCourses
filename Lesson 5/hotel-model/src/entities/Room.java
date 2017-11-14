package entities;

import api.IRoom;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static repositories.RoomRepository.lastIdRoom;

public class Room extends Entity implements IRoom{
    private Integer number;
    private Integer price;
    private Boolean free = true;
    private Boolean repair = false;
    private Integer capacity;
    private Integer numOfStars;
    private Date dateEviction;
    private Date dateOfSettle;
    private ArrayList<Opportunity> opportunities;

    public Room(Integer number, Integer price, Integer capacity, Integer numOfStars, Date dateEviction, Date dateOfSettle) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.numOfStars = numOfStars;
        this.dateEviction = dateEviction;
        this.dateOfSettle = dateOfSettle;
        opportunities = new ArrayList<>();
        setId(generateId(lastIdRoom));
        lastIdRoom++;
    }

    public Room() {
        setId(generateId(lastIdRoom));
        lastIdRoom++;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Boolean getRepair() {
        return repair;
    }

    public void setRepair(Boolean repair) {
        this.repair = repair;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getNumOfStars() {
        return numOfStars;
    }

    public void setNumOfStars(Integer numOfStars) {
        this.numOfStars = numOfStars;
    }

    public Date getDateEviction() {
        return dateEviction;
    }

    public void setDateEviction(Date dateEviction) {
        this.dateEviction = dateEviction;
    }

    public Date getDateOfSettle() {
        return dateOfSettle;
    }

    public void setDateOfSettle(Date dateOfSettle) {
        this.dateOfSettle = dateOfSettle;
    }

    public ArrayList<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunities.add(opportunity);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Room number is: ").append(this.number).append("   Room price is: ").append(this.price).
                append("   Room capacity is: ").append(this.capacity).append("   Room is free: ").
                append(this.free).append("   Room has stars: ").append(this.numOfStars);
        return stringBuilder.toString();
    }

    @Override
    public String getStringForPrintInFile() {
        String pattern = "yyyy-MM-dd";
        String dateEv = new SimpleDateFormat(pattern).format(dateEviction);
        String dateSet = new SimpleDateFormat(pattern).format(dateOfSettle);

        StringBuilder sb = new StringBuilder();
        sb.append(this.number).append(" ").append(this.price).append(" ").append(this.free).append(" ").
                append(this.repair).append(" ").append(this.capacity).append(" ").
                append(this.numOfStars).append(" ").append(dateEv).
                append(" ").append(dateSet);
        return sb.toString();
    }
}
