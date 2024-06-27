package pe.glowchemicaleirl.repository.role.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.glowchemicaleirl.repository.role.entity.RoleEntity;
import pe.glowchemicaleirl.util.EnumRole;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {

    Optional<RoleEntity> findByName(EnumRole name);
}
