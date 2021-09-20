package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;

import java.util.List;

public interface BioskopService {
  void addBioskop(BioskopModel bioskopModel);
  List<BioskopModel> getBioskopList();
  BioskopModel getBioskopByIdBioskop(String idBioskop);
}
