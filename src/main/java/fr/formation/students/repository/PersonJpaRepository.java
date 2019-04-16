package fr.formation.students.repository;

import fr.formation.students.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
// on communique avec la table Person dont la primary key est Long
public interface PersonJpaRepository extends JpaRepository<Person, Long> {
//Requete dérivée "findby" prefixe et ensuite les cibles accountusername
    Person findByUserAccountUsername( String username);
}
