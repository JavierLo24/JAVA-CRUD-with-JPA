package test;

import model.Usuario;
import services.UsuarioDao;

public class test {
	public static void main(String[] args) {
		
		UsuarioDao udao = new UsuarioDao();
		Usuario u = new Usuario();
		
		
		
		for(Usuario s: udao.list()) {
			System.out.println(s.toString());
		}
		
	}
}
