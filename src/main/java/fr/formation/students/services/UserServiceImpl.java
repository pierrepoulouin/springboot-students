package fr.formation.students.services;

import fr.formation.students.dtos.UserCreateDto;
import fr.formation.students.entities.Person;
import fr.formation.students.entities.UserAccount;
import fr.formation.students.repository.PersonJpaRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final PersonJpaRepository repo;

    public UserServiceImpl(PersonJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public void create(UserCreateDto dto) {
        Person person = new Person();
        person.setFirstname(dto.getFirstname());
        person.setLastname(dto.getLastname());
        person.setBirthdate(dto.getBirthdate());
        UserAccount account = new UserAccount();
        account.setUsername(dto.getUserAccount().getUsername());
        String decoded = dto.getUserAccount().getPassword();
        account.setPassword(decoded);
        person.setUserAccount(account);
        repo.save(person);
    }

   /* @Override
    public void update(UserUpdateDto dto) {
        Person person = new Person();
        if (person.getFirstname() != null) {
            dto.setFirstname(person.getFirstname());
        }
        if (person.getLastname() != null) {
            dto.setLastname(person.getLastname());
        }
        if (person.getBirthdate() != null) {
            dto.setBirthdate(person.getBirthdate());
        }
        if (!person.isActive()) {
            dto.setActive(person.isActive());
        }
        repo.save(person);
    }

  /*  @Override
    public void delete(UserDeleteDto dto) {

            Optional<Person> user = repo.findById(dto.getId());
            if (user.isPresent()) {
                repo.delete(user.orElse);
        }
    } */

    /*@Override
    public void read(UserReadDto dto) {
        Person user = new Person();
        dto.getId();
        dto.getFirstname();
        dto.getLastname();
        dto.getBirthdate();
        dto.isActive();
        repo.save(user)
    } */
}

