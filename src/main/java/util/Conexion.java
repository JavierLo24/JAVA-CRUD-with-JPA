package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Conexion<T> {
	//método singleton que asegura una conexion a la vez por eso se inicializa el em
	private Class<T> c;
	private static EntityManager em = null;
	public static EntityManager getEm() {
		if(em==null) {
			EntityManagerFactory emf=
					Persistence.createEntityManagerFactory("testJPA");
			em = emf.createEntityManager();
		}
		return em;
	}
	//se van a traer el CRUD como clases genéricas donde primero hacemos la conexion y luego los métodos
	public Conexion() {
		em = this.getEm();
	}
	
	public Conexion(Class<T> c){
		em = this.getEm();
		this.c = c;
	}
	
	public void setC(Class<T> c) {
		this.c = c;
	}
	
	public <E> T find(E id) {
		//busca el dato en la c.generica que coincida con el id
		T object = (T) em.find(c, id);
		return object;
	}
	public List<T> list(){
		//lista todos los objetos y genera una lista genérica
		TypedQuery<T> consulta=
				em.createNamedQuery(c.getSimpleName()+
						".findAll", c);
		List<T> lista = (List<T>) consulta.getResultList();
		return lista;
	}
	public void insert(T o) {
		//registra un objeto en la clase genérica, el objeto se recibe y se persiste en la bd
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	public void update(T o) {
		//se actualiza un objeto de la clase genérica, el objeto se recibe y se actualiza en la bd
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	public void delete(T o) {
		//se elimina un objeto de la clase genérica, el objeto se recibe y se elimina en la bd
		try {
			em.getTransaction().begin();
			em.remove(o);
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
}
