package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BioskopInMemoryService implements BioskopService{
  private List<BioskopModel> listBioskop;

  public BioskopInMemoryService(){
    listBioskop = new ArrayList<>();
  }

  @Override public void addBioskop(BioskopModel bioskopModel) {
    listBioskop.add(bioskopModel);
  }

  @Override public List<BioskopModel> getBioskopList() {
    return listBioskop;
  }

  @Override public BioskopModel getBioskopByIdBioskop(String idBioskop) {
    for (BioskopModel bioskop:
         listBioskop) {
      if (bioskop.getIdBioskop().equalsIgnoreCase(idBioskop)) return bioskop;
    }
    return null;
  }
}
