package builder;

import actions.BackAction;
import actions.clients.*;
import actions.opportunities.*;
import actions.rooms.*;
import menus.Menu;
import menus.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private Menu rootMenu;

    public Builder() {
        this.rootMenu = new Menu();
    }

    public Menu buildMenu() {
        this.rootMenu = new Menu();
        this.rootMenu.setName("main menu");
        List<MenuItem> mainMenuItems = new ArrayList<>();

        MenuItem clientItem = new MenuItem();
        clientItem.setTitle(" Clients");
        clientItem.setNextMenu(buildClientMenu());

        MenuItem roomItem = new MenuItem();
        roomItem.setTitle(" Rooms");
        roomItem.setNextMenu(buildRoomMenu());

        MenuItem opportunityItem = new MenuItem();
        opportunityItem.setTitle(" Opportunities");
        opportunityItem.setNextMenu(buildOpportunityMenu());

        MenuItem exitItem = new MenuItem();
        exitItem.setTitle(" Exit");

        mainMenuItems.add(clientItem);
        mainMenuItems.add(roomItem);
        mainMenuItems.add(opportunityItem);
        mainMenuItems.add(exitItem);

        this.rootMenu.setMenuItems(mainMenuItems);

        return this.rootMenu;
    }

    private Menu buildClientMenu() {
        Menu clientMenu = new Menu();
        clientMenu.setName("client menu");
        List<MenuItem> clientMenuItems = new ArrayList<>();

        MenuItem newClient = new MenuItem();
        newClient.setTitle(" Create client");
        newClient.setAction(new CreateClientAction());

        MenuItem printerClient = new MenuItem();
        printerClient.setTitle(" Print clients");
        printerClient.setAction(new PrintClientsAction());

        MenuItem opportunityClient = new MenuItem();
        opportunityClient.setTitle(" Get client's opportunities");
        opportunityClient.setAction(new OpportunityClientAction());

        MenuItem settleClient = new MenuItem();
        settleClient.setTitle(" Settle client in room");
        settleClient.setAction(new SettleAction());

        MenuItem moveOutClient = new MenuItem();
        moveOutClient.setTitle(" Move out client from room");
        moveOutClient.setAction(new MoveOutAction());

        MenuItem sorterByNameClient = new MenuItem();
        sorterByNameClient.setTitle(" Sort clients by name");
        sorterByNameClient.setAction(new SortNameAction());

        MenuItem sorterByDateClient = new MenuItem();
        sorterByDateClient.setTitle(" Sort client by date eviction");
        sorterByDateClient.setAction(new SortDateAction());

        MenuItem importClient = new MenuItem();
        importClient.setTitle(" Import in csv file");
        importClient.setAction(new ClientImportAction());

        MenuItem exportClient = new MenuItem();
        exportClient.setTitle(" Export from csv file");
        exportClient.setAction(new ClientExportAction());

        MenuItem backAction = new MenuItem();
        backAction.setTitle(" back");
        backAction.setAction(new BackAction());

        clientMenuItems.add(newClient);
        clientMenuItems.add(printerClient);
        clientMenuItems.add(opportunityClient);
        clientMenuItems.add(settleClient);
        clientMenuItems.add(moveOutClient);
        clientMenuItems.add(sorterByNameClient);
        clientMenuItems.add(sorterByDateClient);
        clientMenuItems.add(importClient);
        clientMenuItems.add(exportClient);
        clientMenuItems.add(backAction);

        clientMenu.setMenuItems(clientMenuItems);

        return clientMenu;
    }

    private Menu buildRoomMenu() {
        Menu roomMenu = new Menu();
        List<MenuItem> roomMenuItems = new ArrayList<>();

        MenuItem newRoom = new MenuItem();
        newRoom.setTitle(" Create room");
        newRoom.setAction(new CreateRoomAction());

        MenuItem updateRoom = new MenuItem();
        updateRoom.setTitle(" Update room");
        updateRoom.setAction(new CloneRoomAction());

        MenuItem printerRoom = new MenuItem();
        printerRoom.setTitle(" Print rooms");
        printerRoom.setAction(new PrintRoomsAction());

        MenuItem threeLastClients = new MenuItem();
        threeLastClients.setTitle(" Get last three clients");
        threeLastClients.setAction(new LastRoomClientsAction());

        MenuItem showFreeRooms = new MenuItem();
        showFreeRooms.setTitle(" Show free rooms");
        showFreeRooms.setAction(new ShowFreeRoomsAction());

        MenuItem roomDetails = new MenuItem();
        roomDetails.setTitle(" Show room details");
        roomDetails.setAction(new RoomDetailsAction());

        MenuItem repairStatus = new MenuItem();
        repairStatus.setTitle(" Change repair status");
        repairStatus.setAction(new RepairStatusAction());

        MenuItem priceRoom = new MenuItem();
        priceRoom.setTitle(" Change room's price");
        priceRoom.setAction(new PriceRoomAction());

        MenuItem newOpportunity = new MenuItem();
        newOpportunity.setTitle(" Add opportunity for room");
        newOpportunity.setAction(new AddOpportunityAction());

        MenuItem sorterByPrice = new MenuItem();
        sorterByPrice.setTitle(" Sort rooms by price");
        sorterByPrice.setAction(new SortPriceAction());

        MenuItem sorterByCapacity = new MenuItem();
        sorterByCapacity.setTitle(" Sort rooms by price");
        sorterByCapacity.setAction(new SortCapacityAction());

        MenuItem sorterByStars = new MenuItem();
        sorterByStars.setTitle(" Sort rooms by stars");
        sorterByStars.setAction(new SortStarsAction());

        MenuItem importRoom = new MenuItem();
        importRoom.setTitle(" Import in csv file");
        importRoom.setAction(new RoomImportAction());

        MenuItem exportRoom = new MenuItem();
        exportRoom.setTitle(" Export from csv file");
        exportRoom.setAction(new RoomExportAction());

        MenuItem backAction = new MenuItem();
        backAction.setTitle(" back");
        backAction.setAction(new BackAction());

        roomMenuItems.add(newRoom);
        roomMenuItems.add(updateRoom);
        roomMenuItems.add(printerRoom);
        roomMenuItems.add(showFreeRooms);
        roomMenuItems.add(roomDetails);
        roomMenuItems.add(repairStatus);
        roomMenuItems.add(threeLastClients);
        roomMenuItems.add(priceRoom);
        roomMenuItems.add(newOpportunity);
        roomMenuItems.add(sorterByPrice);
        roomMenuItems.add(sorterByCapacity);
        roomMenuItems.add(sorterByStars);
        roomMenuItems.add(importRoom);
        roomMenuItems.add(exportRoom);
        roomMenuItems.add(backAction);

        roomMenu.setMenuItems(roomMenuItems);

        return roomMenu;
    }

    private Menu buildOpportunityMenu() {
        Menu opportunityMenu = new Menu();
        List<MenuItem> opportunityMenuItems = new ArrayList<>();

        MenuItem newOpportunity = new MenuItem();
        newOpportunity.setTitle(" Create opportunity");
        newOpportunity.setAction(new CreateOpportunityAction());

        MenuItem printerOpportunity = new MenuItem();
        printerOpportunity.setTitle(" Print opportunities");
        printerOpportunity.setAction(new PrintOpportunitiesAction());

        MenuItem changePrice = new MenuItem();
        changePrice.setTitle(" Change opportunity's price");
        changePrice.setAction(new ChangePriceAction());

        MenuItem sorterByPrice = new MenuItem();
        sorterByPrice.setTitle(" Sort opportunities by price");
        sorterByPrice.setAction(new SortByPriceAction());

        MenuItem importOpportunity = new MenuItem();
        importOpportunity.setTitle(" Import in csv file");
        importOpportunity.setAction(new OpportunityImportAction());

        MenuItem exportOpportunity = new MenuItem();
        exportOpportunity.setTitle(" Export from csv file");
        exportOpportunity.setAction(new OpportunityExportAction());

        MenuItem backAction = new MenuItem();
        backAction.setTitle(" back");
        backAction.setAction(new BackAction());

        opportunityMenuItems.add(newOpportunity);
        opportunityMenuItems.add(printerOpportunity);
        opportunityMenuItems.add(changePrice);
        opportunityMenuItems.add(sorterByPrice);
        opportunityMenuItems.add(importOpportunity);
        opportunityMenuItems.add(exportOpportunity);
        opportunityMenuItems.add(backAction);

        opportunityMenu.setMenuItems(opportunityMenuItems);

        return opportunityMenu;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}