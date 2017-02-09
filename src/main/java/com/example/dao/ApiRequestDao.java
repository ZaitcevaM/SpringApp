package com.example.dao;

import com.example.model.ApiRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ApiRequestDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(ApiRequest apiRequest) {
        entityManager.persist(apiRequest);
    }

    public void update(ApiRequest apiRequest) {
        entityManager.merge(apiRequest);
    }

    public void delete(long id) {
        ApiRequest apiRequest = getApiRequestById(id);
        if (apiRequest != null) {
            entityManager.remove(apiRequest);
        }
    }

    public ApiRequest getApiRequestById(long id) {
        return entityManager.find(ApiRequest.class, id);
    }
}
