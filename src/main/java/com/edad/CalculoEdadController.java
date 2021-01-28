package com.edad;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class CalculoEdadController {
    
    @GetMapping(path = "/calcularEdad/{dia}/{mes}/{anio}")
    public String getEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        try{
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dateInput = sdf.parse(dia + "/" + mes + "/" + anio);

            Long edad =  ((date.getTime() / 1000 - dateInput.getTime() / 1000) / 31536000);
            if(dateInput.getTime() > date.getTime()) throw new IllegalArgumentException("La fecha ingresada es incorrecta");
            return Long.toString(edad);

        } catch(Exception e){
            return "La fecha ingresada es incorrecta";
        }
    }
    
}
