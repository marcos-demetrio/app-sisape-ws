package com.tcc.sisape.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.sisape.domain.Usuario;
import com.tcc.sisape.repository.UsuariosRepository;

@Service("segurancaService")
public class SegurancaServiceImpl /*implements UserDetailsService*/{
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	public void setUsuarioRepository(UsuariosRepository usuariosDao){
		this.usuariosRepository = usuariosDao;
	}
	
	/*@Override
	public UserDetails loadUserByUsername(String userName)
		throws UsernameNotFoundException{
		Usuario usuario = usuariosRepository.findByNomeContaining(userName);
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return usuario;
	}*/
}
