package com.everton.algafood.infrastructure.repository;

import com.everton.algafood.domain.model.Cozinha;
import com.everton.algafood.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> listar() {
        return manager.createQuery("from Cozinha", Cozinha.class)
                .getResultList();
    }

    @Override
    public List<Cozinha> consultarPorNome(String nome) {
//        return manager.createQuery("from Cozinha where nome = :nome", Cozinha.class)
//                .setParameter("nome",  nome)
//                .getResultList();
        return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }


    @Override
    public Cozinha buscar(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Override
    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    @Transactional
    public void remover(Long cozinhaId) {
        Cozinha cozinha = buscar(cozinhaId);
        if(cozinha == null) {
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(cozinha);
    }
}
