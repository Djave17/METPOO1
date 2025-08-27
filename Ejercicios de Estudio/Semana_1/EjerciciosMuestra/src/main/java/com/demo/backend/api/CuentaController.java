package com.demo.backend.api;

import com.demo.backend.dto.CuentaOperacionDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {

  /** Calcula sin guardar nada: saldo nuevo, validando que no quede negativo en retiro. */
  @PostMapping(value = "/aplicar", produces = "text/plain;charset=UTF-8")
  public String aplicar(@RequestBody CuentaOperacionDto op){
    double saldo = nz(op.saldoActual);
    double monto = Math.max(0, nz(op.monto));

    if ("RETIRO".equalsIgnoreCase(op.tipo)) {
      if (monto > saldo) return "Saldo insuficiente. Saldo actual: " + f(saldo);
      return "Retiro OK. Nuevo saldo: " + f(saldo - monto);
    } else { // DEPOSITO (default)
      return "Depósito OK. Nuevo saldo: " + f(saldo + monto);
    }
  }

  private double nz(Double d){ return d == null ? 0.0 : d; }
  private String f(double v){ return String.format("%.2f", v); }
}
