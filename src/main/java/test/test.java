package test;

import model.Usuario;
import services.UsuarioDao;

public class test {
	public static void main(String[] args) {
		
		UsuarioDao udao = new UsuarioDao();
		Usuario u = new Usuario();
		
		//System.out.println(u.calcularProm(3, 4)); 
		
		for(Usuario s: udao.list()) {
			System.out.println(s.toString());
		}
		
		Usuario u4 = udao.find(3);
		u4.calcularProm();
		System.out.println(u4);
		udao.update(u4);
		
	}
}
