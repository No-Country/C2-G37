package com.NoCruelty.NoCruelty.DataBase;

import com.NoCruelty.NoCruelty.models.Zone;
import com.NoCruelty.NoCruelty.repositories.ZoneRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseZone implements CommandLineRunner{ 

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private final ZoneRepository zoneRepository;

    public DataBaseZone(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (zoneRepository.count() == 0) {
            crearZonasDefault();
        }
        System.out.println("numero de zonas:" + zoneRepository.count());
    }

    private void crearZonasDefault() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("country-province.csv");
        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                Zone zone = new Zone(
                        capitalizarPalabra(line.split(";")[0]),
                        capitalizarPalabra(line.split(";")[1]));
                zoneRepository.save(zone);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String capitalizarPalabra(String string) {
        String resultado = "";
        for (String p : string.split(" ")) {
            if (p.length() > 1) {
                resultado += " " + p.substring(0, 1).toUpperCase() + p.substring(1).toLowerCase();
            } else {
                resultado += " " + p.toUpperCase();
            }
        }
        return resultado.trim();
    }

}

