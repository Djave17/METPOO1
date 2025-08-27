package com.demo.backend.api;

import com.demo.backend.dto.LibroDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libro")
public class LibroController {

  @PostMapping(value = "/mostrar", produces = "text/plain;charset=UTF-8")
  public String mostrar(@RequestBody LibroDto l){
    return "Nombre: " + nv(l.nombre) + ", Autor: " + nv(l.autor)
        + ", Sinopsis: " + nv(l.sinopsis)
        + ", Año de Publicación: " + nn(l.anioPublicacion)
        + ", Número de Páginas: " + nn(l.numeroPaginas);
  }

  private String nv(String s){ return s == null ? "" : s.trim(); }
  private int nn(Integer i){ return i == null ? 0 : i; }
}
