package com.amarnath.bankingapp.Repository;

import com.amarnath.bankingapp.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {



}
