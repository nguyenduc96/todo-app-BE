package com.nguyenduc.repositories;

import com.nguyenduc.models.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
