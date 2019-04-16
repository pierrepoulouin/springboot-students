package fr.formation.students.repository;

import fr.formation.students.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<Person, Long> {

}
