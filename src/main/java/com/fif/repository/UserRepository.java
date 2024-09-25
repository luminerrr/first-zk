package com.fif.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fif.entity.User;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        Query query = em.createQuery("SELECT u FROM users u");
        List<User> res = query.getResultList();
        System.out.println(res);
        return res;
    }

    @Transactional
    public User saveUser(User user) {
        em.persist(user);
        em.flush();
        return user;
    }

    @Transactional
    public User getUserById(Integer id) {
        return em.find(User.class, id);
    }

    @Transactional
    public User deleteUserById(Integer id) {
        User selectedUser = getUserById(id);
        if(selectedUser  != null) {
            em.remove(selectedUser);
        }

        return selectedUser;
    }

    @Transactional
    public User editUser(User user) {
        System.out.println(user.getId());
        User selectedUser = getUserById(user.getId());
        if(selectedUser != null) {
            selectedUser.setName(user.getName());
            selectedUser.setBirthday(user.getBirthday());
            selectedUser.setGender(user.getGender());
            selectedUser.setJob(user.getJob());
            em.merge(selectedUser);
        } 

        return selectedUser;
    }

    @Transactional
    public List<User> getAllUsersByName(String name) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM users u WHERE LOWER(u.name) LIKE LOWER(:name)", User.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

}
