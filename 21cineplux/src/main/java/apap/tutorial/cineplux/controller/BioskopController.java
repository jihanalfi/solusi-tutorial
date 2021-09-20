package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BioskopController {
  @Autowired
  private BioskopService bioskopService;

  //Routing URL yang diinginkan
  @RequestMapping("/bioskop/add")
  public String addBioskop(
      //Request parameter yang ingin digunakan
      @RequestParam(value = "idBioskop", required = true) String idBioskop,
      @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
      @RequestParam(value = "alamat", required = true) String alamat,
      @RequestParam(value = "noTelepon", required = true) String noTelepon,
      @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
      Model model
  ) {
    System.out.println(idBioskop);

    //Membuat objek BioskopModel
    BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

    //Menambahkan objek BioskopModel kedalam service
    bioskopService.addBioskop(bioskopModel);

    //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
    model.addAttribute("idBioskop", idBioskop);

    //Return view template yang digunakan
    return "add-bioskop";
  }

  @RequestMapping("/bioskop/viewall")
  public String listBioskop(Model model){
    //Mendapatkan semua bioskop
    List<BioskopModel> listBioskop = bioskopService.getBioskopList();

    //Add variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
    model.addAttribute("listBioskop", listBioskop);

    //Return view template yang diinginkan
    return "viewall-bioskop";
  }

  @RequestMapping("/bioskop/view")
  public String detailBioskop(
      @RequestParam(value = "idBioskop", required = true) String idBioskop,
      Model model
  ){
    //Mendapatkan bioskop sesuai dengan idBioskop
    BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

    //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
    model.addAttribute("bioskop", bioskopModel);

    return "view-bioskop";
  }

  @RequestMapping("/bioskop/view/id-bioskop/{idBioskop}")
  public String detailBioskopPath(
      @PathVariable(value = "idBioskop") String idBioskop,
      Model model
  ){
    if (bioskopService.getBioskopByIdBioskop(idBioskop) != null){
      //Mendapatkan bioskop sesuai dengan idBioskop
      BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

      //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
      model.addAttribute("bioskop", bioskopModel);

      return "view-bioskop";
    }
    return "error-notfound";
  }

  @RequestMapping("/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
  public String updateJumlahStudio(
      @PathVariable(value = "idBioskop") String idBioskop,
      @PathVariable(value = "jumlahStudio") int jumlahStudio,
      Model model
  ){
    if (bioskopService.getBioskopByIdBioskop(idBioskop) != null){
      BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
      bioskopModel.setJumlahStudio(jumlahStudio);

      model.addAttribute("bioskop", bioskopModel);

      return "update-bioskop";
    }

    return "error-notfound";
  }

  @RequestMapping("/bioskop/delete/id-bioskop/{idBioskop}")
  public String deleteBioskop(
      @PathVariable(value = "idBioskop") String idBioskop,
      Model model
  ){
    for (BioskopModel data:
         bioskopService.getBioskopList()) {
      if (data.getIdBioskop().equalsIgnoreCase(idBioskop)){
        BioskopModel bioskopModel = data;
        bioskopService.getBioskopList().remove(data);

        model.addAttribute("bioskop", bioskopModel);

        return "update-bioskop";
      }
    }

    return "error-notfound";
  }
}
