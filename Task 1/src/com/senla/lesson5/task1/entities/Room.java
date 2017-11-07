package com.senla.lesson5.task1.entities;

import com.senla.lesson5.task1.handlers.ArrayHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room extends Entity {
    private Integer number;
    private Integer price;
    private Boolean free = true;
    private Boolean repair = false;
    private Integer capacity;
    private Integer numOfStars;
    private Date dateEviction;
    private Date dateOfSettle;
    private Opportunity[] opportunities;
    static int lasdIdRoom = 0;

    public Room(Integer number, Integer price, Integer capacity, Integer numOfStars, Date dateEviction, Date dateOfSettle, int numOfOpportunities) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.numOfStars = numOfStars;
        this.dateEviction = dateEviction;
        this.dateOfSettle = dateOfSettle;
        opportunities = new Opportunity[numOfOpportunities];
        setId(generateId(lasdIdRoom));
        lasdIdRoom++;
    }

    public Room() {
        setId(generateId(lasdIdRoom));
        lasdIdRoom++;
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

    public Opportunity[] getOpportunities() {
        return opportunities;
    }

    public void setOpportunity(Opportunity opportunity) {
        new ArrayHandler().checkArrayForNewElement(this.opportunities);
        this.opportunities[new ArrayHandler().getPosition(this.opportunities)] = opportunity;
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
