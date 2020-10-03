package org.una.Casa_Subasta.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "lab2_cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lab2_Lote implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_catalogo", length = 30)
    private String nombreCatalogo;
    
    @Column(name = "precio_salida")
    private float preciosalida;

    @Column( name = "mayor_puja")
    private double mayorpuja;
    
    @Column(name = "hora_subasta")
    private int horasubasta;
    
    @Column (name = "hora_inicio")
    private Time horainicio;
    
    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "estado")
    private boolean estado;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();
        
    }
    
}
