package me.hadi.springboothibernate.repository.impl;

import me.hadi.springboothibernate.entity.User;
import me.hadi.springboothibernate.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl() {
    }

    @Override
    public User save(User user) {
        entityManager.unwrap(Session.class).save(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return entityManager.unwrap(Session.class).find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> from = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(from);
        TypedQuery<User> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public User delete(User user) {
        entityManager.unwrap(Session.class).delete(user);
        return user;
    }
}
