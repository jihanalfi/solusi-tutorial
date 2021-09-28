package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.DestinasiModel;
import apap.tutorial.pergipergi.repository.DestinasiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DestinasiServiceImpl implements DestinasiService{

    @Autowired
    DestinasiDb destinasiDb;

    @Override
    public void addDestinasi(DestinasiModel destinasi) {
        destinasiDb.save(destinasi);
    }
}
