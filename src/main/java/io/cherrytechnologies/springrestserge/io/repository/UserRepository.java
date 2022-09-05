package io.cherrytechnologies.springrestserge.io.repository;

import io.cherrytechnologies.springrestserge.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UUID, UserEntity> {

}