package entities;

import com.opencsv.bean.CsvBindByName;

import java.util.Date;

public class RoomHistory extends Entity {

    @CsvBindByName(column = "client's id", required = true)
    private Integer clientId;
    @CsvBindByName(column = "room's id", required = true)
    private Integer roomId;

    @CsvBindByName(column = "date of eviction", required = true)
    private Date dateEviction;
    @CsvBindByName(column = "date of settle", required = true)
    private Date dateOfSettle;

    public RoomHistory(Integer clientId, Integer roomId, Date dateEviction, Date dateOfSettle) {
        this.clientId = clientId;
        this.roomId = roomId;
        this.dateEviction = dateEviction;
        this.dateOfSettle = dateOfSettle;
    }

    public RoomHistory() {

    }


    @Override
    public String getStringForPrintInFile() {
        return null;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Date getDateEviction() {
        return dateEviction;
    }

    public void setDateEviction(Date dateEviction) {
        this.dateEviction = dateEviction;
    }

    public void setDateOfSettle(Date dateOfSettle) {
        this.dateOfSettle = dateOfSettle;
    }

    public Date getDateOfSettle() {
        return dateOfSettle;
    }
}
