package builder;

import actions.BackAction;
import actions.ExitAction;
import actions.clients.*;
import actions.clients.CreateClientAction;
import actions.clients.PrintClientsAction;
import actions.opportunities.ChangePriceAction;
import actions.opportunities.CreateOpportunityAction;
import actions.opportunities.PrintOpportunitiesAction;
import actions.opportunities.SortByPriceAction;
import actions.rooms.*;
import menus.Menu;
import menus.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private Menu rootMenu;

    public Menu buildMenu() {
        Menu mainMenu = new Menu();
        mainMenu.setName("main menu");
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
        exitItem.setAction(new ExitAction());

        mainMenuItems.add(clientItem);
        mainMenuItems.add(roomItem);
        mainMenuItems.add(opportunityItem);
        mainMenuItems.add(exitItem);

        mainMenu.setMenuItems(mainMenuItems);

        return mainMenu;
    }

    public Menu buildClientMenu() {
        Menu clientMenu = new Menu();
        clientMenu.setName("client menu");
        List<MenuItem> clientMenuItems = new ArrayList<>();

        MenuItem newClient = new MenuItem();
        newClient.setTitle(" Create client");
        newClient.setAction(new CreateClientAction());

        MenuItem printerClient = new MenuItem();
        printerClient.setTitle(" Print clients");
        printerClient.setAction(new PrintClientsAction());

        MenuItem threeLastClients = new MenuItem();
        threeLastClients.setTitle(" Get last three clients");
        threeLastClients.setAction(new LastClientAction());

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

        MenuItem backAction = new MenuItem();
        backAction.setTitle(" back");
        backAction.setAction(new BackAction());

        clientMenuItems.add(newClient);
        clientMenuItems.add(printerClient);
        clientMenuItems.add(threeLastClients);
        clientMenuItems.add(opportunityClient);
        clientMenuItems.add(settleClient);
        clientMenuItems.add(moveOutClient);
        clientMenuItems.add(sorterByNameClient);
        clientMenuItems.add(sorterByDateClient);
        clientMenuItems.add(backAction);

        clientMenu.setMenuItems(clientMenuItems);

        return clientMenu;
    }

    public Menu buildRoomMenu() {
        Menu roomMenu = new Menu();
        List<MenuItem> roomMenuItems = new ArrayList<>();

        MenuItem newRoom = new MenuItem();
        newRoom.setTitle(" Create room");
        newRoom.setAction(new CreateRoomAction());

        MenuItem printerRoom = new MenuItem();
        printerRoom.setTitle(" Print clients");
        printerRoom.setAction(new PrintRoomsAction());

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

        MenuItem backAction = new MenuItem();
        backAction.setTitle(" back");
        backAction.setAction(new BackAction());

        roomMenuItems.add(newRoom);
        roomMenuItems.add(printerRoom);
        roomMenuItems.add(showFreeRooms);
        roomMenuItems.add(roomDetails);
        roomMenuItems.add(repairStatus);
        roomMenuItems.add(priceRoom);
        roomMenuItems.add(newOpportunity);
        roomMenuItems.add(sorterByPrice);
        roomMenuItems.add(sorterByCapacity);
        roomMenuItems.add(sorterByStars);
        roomMenuItems.add(backAction);

        roomMenu.setMenuItems(roomMenuItems);

        return roomMenu;
    }

    public Menu buildOpportunityMenu() {
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

        MenuItem backAction = new MenuItem();
        backAction.setTitle(" back");
        backAction.setAction(new BackAction());

        opportunityMenuItems.add(newOpportunity);
        opportunityMenuItems.add(printerOpportunity);
        opportunityMenuItems.add(changePrice);
        opportunityMenuItems.add(sorterByPrice);
        opportunityMenuItems.add(backAction);

        opportunityMenu.setMenuItems(opportunityMenuItems);

        return opportunityMenu;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}