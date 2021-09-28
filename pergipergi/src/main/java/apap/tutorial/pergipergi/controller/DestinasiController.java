package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.DestinasiModel;
import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.service.DestinasiService;
import apap.tutorial.pergipergi.service.TourGuideService;
import apap.tutorial.pergipergi.service.TravelAgensiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DestinasiController {

    @Qualifier("destinasiServiceImpl")
    @Autowired
    private DestinasiService destinasiService;

    @Qualifier("travelAgensiServiceImpl")
    @Autowired
    private TravelAgensiService travelAgensiService;

    @GetMapping("/destinasi/add")
    public String addDestinasiFormPage(Model model){
        List<TravelAgensiModel> listAgensi = travelAgensiService.getListAgensi();
        model.addAttribute("listAgensi", listAgensi);
        model.addAttribute("destinasi", new DestinasiModel());
        return "form-add-destinasi";
    }

    @PostMapping("/destinasi/add")
    public String addDestinasiSubmitPage(
            @ModelAttribute DestinasiModel destinasi,
            Model model
    ){
        destinasiService.addDestinasi(destinasi);
        model.addAttribute("noDestinasi", destinasi.getNoDestinasi());
        return "add-destinasi";
    }
}