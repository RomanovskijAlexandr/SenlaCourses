package annotationsimpl;

import annotations.CsvEntity;
import handlers.csv.CsvWriter;
import repository.ClientRepository;
import repository.OpportunityRepository;
import repository.RoomHistoryRepository;
import repository.RoomRepository;

import java.io.IOException;

public class CsvEntityImpl {
    private CsvWriter csvWriter = new CsvWriter();
    private RoomRepository roomRepository = RoomRepository.getInstance();
    private ClientRepository clientRepository = ClientRepository.getInstance();
    private OpportunityRepository opportunityRepository = OpportunityRepository.getInstance();
    private RoomHistoryRepository roomHistoryRepository = RoomHistoryRepository.getInstance();

    public CsvEntityImpl() throws IOException {
    }

    public void writeByAnnotation(Class<?> entity){
        if(entity.isAnnotationPresent(CsvEntity.class)){
            if(entity.getClass().getName().equals("Client")){
                csvWriter.writeClients(clientRepository.findAll(), entity.getAnnotation(CsvEntity.class).filename());
            }
            if(entity.getClass().getName().equals("Room")){
                csvWriter.writeRooms(roomRepository.findAll(), entity.getAnnotation(CsvEntity.class).filename());
            }
            if(entity.getClass().getName().equals("Opportunity")){
                csvWriter.writeOpportunities(opportunityRepository.findAll(), entity.getAnnotation(CsvEntity.class).filename());
            }
            if(entity.getClass().getName().equals("RoomHistory")){
                csvWriter.writeRoomHistories(roomHistoryRepository.findAll(), entity.getAnnotation(CsvEntity.class).filename());
            }
        }
    }
}
