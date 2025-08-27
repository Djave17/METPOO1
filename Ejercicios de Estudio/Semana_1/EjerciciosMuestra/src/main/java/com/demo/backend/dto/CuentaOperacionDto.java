package com.demo.backend.dto;

/** Operación stateless para CuentaBancaria: calcula el nuevo saldo y lo devuelve. */
public class CuentaOperacionDto {
  public String titular;
  public Double saldoActual;
  public Double monto;       // puede ser 0 o positivo
  public String tipo;        // "DEPOSITO" o "RETIRO"
}
