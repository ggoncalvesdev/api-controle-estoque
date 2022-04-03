package com.controleestoque.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controleestoque.domain.exception.NegocioException;
import com.controleestoque.domain.exception.UsuarioNaoEncontradoException;
import com.controleestoque.domain.model.Usuario;
import com.controleestoque.domain.repository.UsuarioRepository;

@Service
public class CadastroUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	@Autowired
//	private CadastroGrupoService cadastroGrupo;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
		
		Optional<Usuario> usuarioExistente = usuarioRepository.findByLogin(usuario.getLogin());
		
		if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
			throw new NegocioException(
					String.format("Já existe um usuário cadastrado com o e-mail %s", usuario.getLogin()));
		}
		
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
		Usuario usuario = buscarOuFalhar(usuarioId);
		
		if (usuario.senhaNaoCoincideCom(senhaAtual)) {
			throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
		}
		
		usuario.setSenha(novaSenha);
	}

//	@Transactional
//	public void desassociarGrupo(Long usuarioId, Long grupoId) {
//		Usuario usuario = buscarOuFalhar(usuarioId);
//		Grupo grupo = cadastroGrupo.buscarOuFalhar(grupoId);
//		
//		usuario.removerGrupo(grupo);
//	}
//	
//	@Transactional
//	public void associarGrupo(Long usuarioId, Long grupoId) {
//		Usuario usuario = buscarOuFalhar(usuarioId);
//		Grupo grupo = cadastroGrupo.buscarOuFalhar(grupoId);
//		
//		usuario.adicionarGrupo(grupo);
//	}
	
	public Usuario buscarOuFalhar(Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
			.orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
	}
	
}
