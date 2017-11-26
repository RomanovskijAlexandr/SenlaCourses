package entities;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Room extends Entity implements IRoom, Cloneable {
    @CsvBindByName(column = "price", required = true)
    private Integer number;
    @CsvBindByName(column = "price", required = true)
    private Integer price;
    @CsvBindByName(column = "free", required = true)
    private Boolean free = true;
    @CsvBindByName(column = "repair", required = true)
    private Boolean repair = false;
    @CsvBindByName(column = "capacity", required = true)
    private Integer capacity;
    @CsvBindByName(column = "number of stars", required = true)
    private Integer numOfStars;
    @CsvBindByName(column = "date of eviction")
    @CsvDate("dd-MM-yyyy")
    private Date dateEviction;
    @CsvBindByName(column = "date of settle")
    @CsvDate("dd-MM-yyyy")
    private Date dateOfSettle;
    transient private ArrayList<Opportunity> opportunities;

    public Room(Integer number, Integer price, Integer capacity, Integer numOfStars, Date dateEviction, Date dateOfSettle) {
        this.number = number;
        this.price = price;
        this.capacity = capacity;
        this.numOfStars = numOfStars;
        this.dateEviction = dateEviction;
        this.dateOfSettle = dateOfSettle;
        opportunities = new ArrayList<>();
    }

    public Room() {
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

    public Room clone() throws CloneNotSupportedException {
        return (Room) super.clone();
    }
}
