package generation.postagem.service.impl;

import generation.postagem.domain.model.Postagem;
import generation.postagem.domain.repository.PostagemRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostagemService {
    private final PostagemRepository postagemRepository;

    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public List<Postagem> findAll() {
        return postagemRepository.findAll();
    }

    public Postagem findById(Long id) {
        return postagemRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Postagem create(Postagem create) {
        create.setDataInclusao(new Date());
        return postagemRepository.save(create);
    }

    public Postagem update(Postagem obj) {
        return postagemRepository.save(obj);
    }

    public boolean delete(Long idRequest) {
        Optional<Postagem> postagemBanco = postagemRepository.findById(idRequest);
        if (postagemBanco.isPresent()){
            postagemRepository.delete(postagemBanco.get());
            return true;
        }
        return false;
    }
}
