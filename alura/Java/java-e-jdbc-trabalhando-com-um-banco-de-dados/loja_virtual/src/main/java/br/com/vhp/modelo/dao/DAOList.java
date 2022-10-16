package br.com.vhp.modelo.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;
import java.util.Optional;

@Builder
public class DAOList {

    private List<? extends DAOAbstract> daos;

    public <T extends DAOAbstract> T getDao(Class<T> daoClass) {
        return (T) daos.stream()
                .filter(d -> d.getClass().equals(daoClass))
                .findFirst()
                .orElse(null);
    }
}
