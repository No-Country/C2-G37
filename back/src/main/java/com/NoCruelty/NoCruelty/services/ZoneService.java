package com.NoCruelty.NoCruelty.services;

import com.NoCruelty.NoCruelty.models.Zone;
import com.NoCruelty.NoCruelty.repositories.ZoneRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Transactional
    public List<Zone> listar() {
        return zoneRepository.findAll();
    }

    @Transactional
    public Zone searchZone(String province, String country) throws Exception {
        Zone zone = zoneRepository.searchForProvinceCountry(province, country);
        return zone;
    }

    @Transactional(readOnly = true)
    public void modifyZone(String id, String province, String country) {

        validate(province, country);

        Optional<Zone> answer = zoneRepository.findById(id);
        if (answer.isPresent()) {
            Zone zone = zoneRepository.findById(id).get();

            zone.setProvince(province);
            zone.setCountry(country);

            zoneRepository.save(zone);
        } else {
            throw new Error("Nose encontro la zona solicitada");
        }
    }

    @Transactional
    private void validate(String province, String country) throws Error {

        if (province == null || province.isEmpty()) {
            throw new Error("la provincia del usuario no puede ser nulo");
        }

        if (country == null || country.isEmpty()) {
            throw new Error("la departamento del usuario no puede ser nulo");
        }

    }

    public void delete(String id) {
        Optional<Zone> answer = zoneRepository.findById(id);
        if (answer.isPresent()) {
            Zone zone = answer.get();
            zoneRepository.delete(zone);
        }
    }    
}