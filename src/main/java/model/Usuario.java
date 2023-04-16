package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
	
	private int nota1;
	
	private int nota2;
	
	
	private float promedio;

	public Usuario(String email, String nombre, String pais) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.pais = pais;
	}

	public Usuario(String email, String nombre, String pais, int nota1, int nota2) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.pais = pais;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.promedio = 0;
	}
	
	public float calcularProm() {
		this.setPromedio(((float)(this.nota1 + this.nota2))/2);
		return promedio;
	}
	
//si la tabla tiene un @Transient ese atributo no es tenido en cuenta por la persistencia
//si la tabla tiene otro nombre en la bd ponemos @Table y el nombre de la tabla de la bd
//si alguna columna tiene otro nombre en la bd ponemos @Column y el nombre de la columna de la bd	
}