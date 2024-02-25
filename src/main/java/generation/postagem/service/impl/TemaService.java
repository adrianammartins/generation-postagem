package generation.postagem.service.impl;

import generation.postagem.domain.model.Usuario;
import generation.postagem.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Usuario create(Usuario usuarioToCreate) {
        if (usuarioRepository.existsByEmail(usuarioToCreate.getEmail())) {
            throw new IllegalArgumentException("Este Usuário já está cadastrado");
        }
        return usuarioRepository.save(usuarioToCreate);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean delete(Long idRequest) {
        Optional<Usuario> usuarioBanco = usuarioRepository.findById(idRequest);
        if (usuarioBanco.isPresent()){
            usuarioRepository.delete(usuarioBanco.get());
            return true;
        }
        return false;
    }
}
