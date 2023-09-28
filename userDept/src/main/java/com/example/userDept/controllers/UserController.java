package com.example.userDept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userDept.entities.User;
import com.example.userDept.repositories.UserRepository;

//	ENDPOINT PARA BUSCAR USUÁRIOS DO BANCO DE DADOS

@RestController
@RequestMapping(value = "/users")
public class UserController {

	//injeta dependencia usando mecanismo do framework
	@Autowired
	private UserRepository repository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	
	//endpoint para pegar todos os usuários
	@GetMapping // indica que é uma requisição onde verbo http é get
	public List<User> findAll(){
		//findAll manda consulta para banco de dados e retorna lista
		List<User> result = repository.findAll();
		return result;
	}
	//endpoint para pegar um único usuário
	@GetMapping(value = "/{id}")//caminho agora terá /users + numero do id
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;
	}
	@PostMapping
	public User insert(@RequestBody User user) {
		User result = repository.save(user);//manda objeto para banco de dados ja convertido
		//e retorna nova referência para objeto salvo
		return result;
	}
}
