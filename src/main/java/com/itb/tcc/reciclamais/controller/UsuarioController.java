package com.itb.tcc.reciclamais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.itb.tcc.reciclamais.model.Usuario;
import com.itb.tcc.reciclamais.repository.UsuarioRepository;
@Controller
@RequestMapping("/meioAmbiente/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	//carregar o formulario de cadastro
	@GetMapping("/novo-usuario")
	public String formNovoUsuario(Usuario usuario, Model model) {
		
		model.addAttribute("usuario", usuario);
		return "formulario";
	}
	
	//cadastrar o usuario
	
	@PostMapping("/add-usuario")
	public String addUsuario(Usuario usuario) {
		
		usuario.setCodStatusUsuario(true);
		Usuario usuarioDB = usuarioRepository.save(usuario);
		
		return "redirect:/meioAmbiente/usuario/login";
	}
	
	@GetMapping("/login")
	public String showFormLogin(Usuario usuario, Model model) {
		
		model.addAttribute("usuario", usuario);
		
		return"login";
	}
	
	
	@PostMapping("/login")
	public String logon(Usuario usuario) {
		String paginaPerfil = "redirect:/meioAmbiente/usuario/login";
		
		Usuario usuarioDb = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(usuarioDb.getEmail().equals(usuario.getEmail()) && usuarioDb.getSenha().equals(usuario.getSenha())) {
			paginaPerfil = "redirect:/meioAmbiente/usuario/perfil";
		}
		return paginaPerfil;
	}
	@GetMapping("/perfil")
	public String showPerfil() {
		
		return "perfil";
	}
	
	
}
