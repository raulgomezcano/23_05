package com.softtek.proyecto23_05.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Producto {
    @Id
    @Column(name = "product_id")
    private Short id;
    @Column(name = "product_name")
    private String nombre;
    @Column(name = "supplier_id")
    private Short proveedor;
    @Column(name = "category_id")
    private Short categoria;
    @Column(name = "quantity_per_unit")
    private String cantidadUnidades;
    @Column(name = "unit_price")
    private Double precioUnitario;
    @Column(name = "units_in_stock")
    private Short UnidadesExistencia;
    @Column(name = "units_on_order")
    private Short UnidadesOrdenar;
    @Column(name = "reorder_level")
    private Short nivelOrdenar;
    @Column(name = "discontinued")
    private int discontinuado;
}
