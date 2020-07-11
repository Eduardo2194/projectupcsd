package com.upc.sistemasdistribuidos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.sistemasdistribuidos.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public Usuario findFirstByDniAndEstadoNotIn(String dni, List<Integer> estados);
	public Usuario findFirstByDniAndEstado(String dni, Integer estado);
	public Usuario findFirstByDni(String dni);
	public List<Usuario> findByCodigoTipoInAndEstadoIn(List<String> tipos, List<Integer> estados);

}
