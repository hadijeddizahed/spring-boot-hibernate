package me.hadi.springboothibernate.service.impl;

import me.hadi.springboothibernate.entity.Address;
import me.hadi.springboothibernate.service.AddressRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Address address) {
        entityManager.unwrap(Session.class).save(address);
    }

    public Address find(Long id) {
        return entityManager.unwrap(Session.class).find(Address.class, id);
    }
}
