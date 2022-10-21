package com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
