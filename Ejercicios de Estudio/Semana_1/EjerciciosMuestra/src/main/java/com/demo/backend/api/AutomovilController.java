package com.demo.backend.api;

import com.demo.backend.dto.AutomovilDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/automovil")
public class AutomovilController {

  /** Devuelve un texto con la info; no guarda nada. */
  @PostMapping(value = "/mostrar", produces = "text/plain;charset=UTF-8")
  public String mostrar(@RequestBody AutomovilDto a) {
    return "Marca: " + nv(a.marca) + ", Año: " + nn(a.anio)
         + ", Color: " + nv(a.color) + ", Modelo: " + nv(a.modelo);
  }

  /** Simula 'arrancar' y responde con un mensaje. */
  @PostMapping(value = "/arrancar", produces = "text/plain;charset=UTF-8")
  public String arrancar(@RequestBody AutomovilDto a) {
    return "El automóvil " + nv(a.marca) + " " + nv(a.modelo) + " ha arrancado.";
  }

  private String nv(String s){ return s == null ? "" : s.trim(); }
  private int nn(Integer i){ return i == null ? 0 : i; }
}
