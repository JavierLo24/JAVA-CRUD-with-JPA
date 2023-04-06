package services;

import model.Usuario;
import util.Conexion;

public class UsuarioDao 
extends Conexion<Usuario> 
implements GenericDao<Usuario> {
	public UsuarioDao() {
		super(Usuario.class);
	}
}
//implementacion al dao del entity del genericdao y de la conexion