package pe.glowchemicaleirl.repository.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.glowchemicaleirl.repository.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findByNameLike(String name);
}
