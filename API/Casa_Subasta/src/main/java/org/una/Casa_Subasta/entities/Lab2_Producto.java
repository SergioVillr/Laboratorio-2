package org.una.Casa_Subasta.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author chris
 */
@Entity
@Table(name = "lab2_productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lab2_Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", length = 10)
    private String codigo;

    @Column(name = "nombre", length = 20)
    private String nombre;
    
    @Column(name = "descripcion", length = 70)
    private String descripcion;
    
    @Column(name = "fotografia", length = 100)
    private String fotografia;
    
    @ManyToOne 
    @JoinColumn(name="lab2_lotes_id")
    private Lab2_Lotes lotesId;

    @Column
    private boolean estado;
    
    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();
    }
}

