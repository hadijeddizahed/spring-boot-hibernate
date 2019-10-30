package me.hadi.springboothibernate.service;

import me.hadi.springboothibernate.entity.Address;

public interface AddressRepository {

    void save(Address address);

    Address find(Long id);
}
