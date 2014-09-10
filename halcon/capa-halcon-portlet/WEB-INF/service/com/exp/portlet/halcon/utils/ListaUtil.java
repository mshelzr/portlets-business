package com.exp.portlet.halcon.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.exception.TraductorDeExcepciones;

public class ListaUtil {

	private static final String SET_NUMERO_FILA = "setNumeroFila";

	public static List agregarNumeracion(List lista) throws BusinessException {
		return agregarNumeracion(lista, SET_NUMERO_FILA);
	}
	
	public static List agregarNumeracion(List lista, String metodoNombre) throws BusinessException {
		if (lista != null) {
			for (Integer i = 0; i < lista.size(); i++) {
				Object objeto = lista.get(i);
				Method metodo;
				try {
					metodo = objeto.getClass().getMethod(metodoNombre, new Class[] { Integer.class });
					metodo.invoke(objeto, new Object[] { i + 1 });
				} catch (SecurityException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (NoSuchMethodException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (IllegalArgumentException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (IllegalAccessException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (InvocationTargetException e) {
					TraductorDeExcepciones.traducir(e);
				}
			}
		}
		return lista;
	}

	public static boolean contieneAlgo(List lista) {
		if(lista!=null) return 0<lista.size(); 		
		return false;
	}

	@SuppressWarnings("unchecked")
	public static void eliminar(List lista, Integer[] posicion) {
		if(lista!=null && posicion!=null)
			if(0<lista.size() && 0<posicion.length) {
				List listaDesechable = new ArrayList();				
				for (Integer indice : posicion) 
					listaDesechable.add(lista.get(indice));							
				lista.removeAll(listaDesechable);
			}		
	}

	@SuppressWarnings("unchecked")
	public static void diferencia(List minuendo, List sustraendo) {
		if(minuendo!=null && sustraendo!=null)
			if(0<minuendo.size() && 0<sustraendo.size())
				minuendo.removeAll(sustraendo);
	}

	@SuppressWarnings("unchecked")
	public static List ordenar(List lista, Comparator comparador) {
		if(contieneAlgo(lista)) {
			if(comparador==null) Collections.sort(lista);
			if(comparador!=null) Collections.sort(lista, comparador);
		}
		return lista;
	}

	public static Object obtener(List lista, String nombreMetodoGetId, Object id) throws BusinessException {
		if(contieneAlgo(lista) && TextoUtil.contieneAlgo(nombreMetodoGetId) && id!=null) {
			boolean encontrado = false;
			Method metodoGetId;
			for (Integer i = 0; i < lista.size() && !encontrado; i++) {
				Object objeto = lista.get(i);		
				try {
					metodoGetId = objeto.getClass().getMethod(nombreMetodoGetId);
					if(id.equals(metodoGetId.invoke(objeto))){
						encontrado = true;
						return objeto;
					}
				} catch (SecurityException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (NoSuchMethodException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (IllegalArgumentException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (IllegalAccessException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (InvocationTargetException e) {
					TraductorDeExcepciones.traducir(e);
				}				
			}
		}
		return null;
	}

	public static boolean contieneObjetoPersistente(List lista, Object objetoPersistente, String nombreMetodoGetId) throws BusinessException {
		if(contieneAlgo(lista) && objetoPersistente!=null && TextoUtil.contieneAlgo(nombreMetodoGetId)) {
			Method metodoGetId = null;
			for (Integer i = 0; i < lista.size(); i++) {
				Object objeto = lista.get(i);	
				try {
					metodoGetId = objeto.getClass().getMethod(nombreMetodoGetId);
					if(metodoGetId.invoke(objetoPersistente).equals(metodoGetId.invoke(objeto)))
						return true;				
				} catch (IllegalAccessException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (InvocationTargetException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (SecurityException e) {
					TraductorDeExcepciones.traducir(e);
				} catch (NoSuchMethodException e) {
					TraductorDeExcepciones.traducir(e);
				}		
			}
		}
		return false;
	}
	
	 @SuppressWarnings("unchecked")
	public static List subtraer(final List lista1, final List lista2) {
		 final ArrayList resultado = new ArrayList(lista1);
	     final Iterator iterador = lista2.iterator();
	     while (iterador.hasNext()) {
	      	resultado.remove(iterador.next());
	     }
	     return resultado;
	}
	 
	 @SuppressWarnings("unchecked")
		public static List subtraerModificandoLista(final List lista1, final List lista2) {
		     final Iterator iterador = lista2.iterator();
		     while (iterador.hasNext()) {
		    	 lista1.remove(iterador.next());
		     }
		     return lista1;
		}

	 @SuppressWarnings("unchecked")
	public static List interseccion(final List lista1, final List lista2) {
        final ArrayList resultado = new ArrayList();
        final Iterator iterador = lista2.iterator();
        while (iterador.hasNext()) {
            final Object o = iterador.next();
            if (lista1.contains(o)) {
            	resultado.add(o);
            }
        }
        return resultado;
    }

	 @SuppressWarnings("unchecked")
	public static List union(final List lista1, final List lista2) {
	   final ArrayList result = new ArrayList(lista1);
	   result.addAll(lista2);
	   return result;
	}

	 public static List suma(final List lista1, final List lista2) {
	     return subtraer(union(lista1, lista2), interseccion(lista1, lista2));
    }

}
