package com.softtek.proyecto23_05.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Orden {
    @Id
    @Column(name = "order_id")
    private Short id;
    @Column(name = "customer_id")
    private String cliente;
    @Column(name = "employee_id")
    private Short empleado;
    @Column(name = "order_date")
    private Date fechaOrden;
    @Column(name = "required_date")
    private Date fechaRequerida;
    @Column(name = "shipped_date")
    private Date fechaEntrega;
    @Column(name = "ship_via")
    private Short via;
    @Column(name = "freight")
    private Double transporte;
    @Column(name = "ship_name")
    private String nombreTransporte;
    @Column(name = "ship_address")
    private String direccionTransporte;
    @Column(name = "ship_city")
    private String ciudadTransporte;
    @Column(name = "ship_region")
    private String regionTransporte;
    @Column(name = "ship_postal_code")
    private String codigoPostalTransporte;
    @Column(name = "ship_country")
    private String paisTransporte;
}
