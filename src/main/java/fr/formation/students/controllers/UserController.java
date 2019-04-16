package fr.formation.students.controllers;

import fr.formation.students.dtos.UserCreateDto;
import fr.formation.students.dtos.UserUpdateDto;
import fr.formation.students.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    //On met protected pour des questions de sécurité, on accede pas à la methode de l'extérieur
    //@RequestBody va chercher le corps de la requête
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    protected void create(@Valid @RequestBody UserCreateDto user) { //Le @Valid permet à spring d'appliquer les contraintes dans le DTO
        service.create(user);
    }

   /* @PutMapping("/{id}")
    protected void update(@PathVariable("id") Long id,
                          @Valid @RequestBody UserUpdateDto user) {
        service.update(user);
    }

 /*   @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") Long id, UserDeleteDto user) {
        service.delete(user);
    } */

  /*  @GetMapping("/{id}")
    protected void getUser(@PathVariable("id") Long id, UserReadDto user) {
        service.read(user);
    } */


}
