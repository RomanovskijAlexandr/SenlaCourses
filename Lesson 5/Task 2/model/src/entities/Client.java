package entities;

import api.IClient;

import static repositories.ClientRepository.lastIdClient;

public class Client extends Entity implements IClient {
    private String name;
    private Room room;

    public Client(String name) {
        this.name = name;
        setId(generateId(lastIdClient));
        lastIdClient++;
    }

    public Client() {
        setId(generateId(lastIdClient));
        lastIdClient++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Client name: ").append(this.name).append("   ID: ").append(getId());
        return stringBuilder.toString();
    }

    @Override
    public String getStringForPrintInFile() {
        return this.name;
    }
}
