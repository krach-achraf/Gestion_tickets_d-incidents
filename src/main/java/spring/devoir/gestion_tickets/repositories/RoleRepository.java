package spring.devoir.gestion_tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.devoir.gestion_tickets.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByNom(String nom);
}