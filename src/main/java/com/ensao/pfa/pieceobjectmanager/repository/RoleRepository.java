package com.ensao.pfa.pieceobjectmanager.repository;


import com.ensao.pfa.pieceobjectmanager.models.ERole;
import com.ensao.pfa.pieceobjectmanager.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
