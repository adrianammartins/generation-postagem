package generation.postagem.service.impl;

import generation.postagem.domain.model.Tema;
import generation.postagem.domain.repository.TemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TemaService {
    private final TemaRepository temaRepository;

    public TemaService(TemaRepository temaRepository) {
        this.temaRepository = temaRepository;
    }

    public List<Tema> findAll() {
        return temaRepository.findAll();
    }

    public Tema findById(Long id) {
        return temaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Tema create(Tema create) {
        return temaRepository.save(create);
    }

    public Tema update(Tema obj) {
        return temaRepository.save(obj);
    }

    public boolean delete(Long idRequest) {
        Optional<Tema> usuarioBanco = temaRepository.findById(idRequest);
        if (usuarioBanco.isPresent()){
            temaRepository.delete(usuarioBanco.get());
            return true;
        }
        return false;
    }
}
