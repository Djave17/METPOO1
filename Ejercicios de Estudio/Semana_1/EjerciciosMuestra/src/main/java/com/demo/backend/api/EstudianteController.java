package com.demo.backend.api;

import com.demo.backend.dto.EstudianteDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

  @PostMapping(value = "/info", produces = "text/plain;charset=UTF-8")
  public String info(@RequestBody EstudianteDto e){
    return "Estudiante: " + nv(e.nombre) + " (" + (e.edad == null ? "?" : e.edad) + ") — " + nv(e.carrera);
  }

  private String nv(String s){ return s == null ? "" : s.trim(); }
}
