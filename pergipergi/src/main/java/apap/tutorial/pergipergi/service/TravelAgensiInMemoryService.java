package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TravelAgensiModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelAgensiInMemoryService implements TravelAgensiService{

    private List<TravelAgensiModel> listAgensi;

    //Constructor
    public TravelAgensiInMemoryService(){
        listAgensi = new ArrayList<>();
    }

    @Override
    public void addAgensi(TravelAgensiModel travelAgensi) {
        listAgensi.add(travelAgensi);
    }

    @Override
    public List<TravelAgensiModel> getListAgensi() {
        return listAgensi;
    }

    @Override
    public TravelAgensiModel getAgensiByidAgensi(String idAgensi) {

        for(int i = 0; i < listAgensi.size(); i++){
            if(listAgensi.get(i).getIdAgensi().equals(idAgensi)){
                return listAgensi.get(i);
            }
        }
        return null;
    }

    //Latihan
    @Override
    public void updateNomorTelepon(TravelAgensiModel travelAgensi, String nomorTelepon) {
        travelAgensi.setNoTelepon(nomorTelepon);
    }


    @Override
    public void deleteAgensi(TravelAgensiModel travelAgensi) {
        listAgensi.remove(travelAgensi);
    }
}