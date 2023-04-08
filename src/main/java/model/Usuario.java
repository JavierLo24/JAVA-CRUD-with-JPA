package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id //llave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //autoincrementable
	private int id;

	private String email;

	private String nombre;

	private String pais;

	public Usuario(String email, String nombre, String pais) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.pais = pais;
	}
	
	

//si la tabla tiene otro nombre en la bd ponemos @Table y el nombre de la tabla de la bd
//si alguna columna tiene otro nombre en la bd ponemos @Column y el nombre de la columna de la bd	
}