package br.com.sielanis.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaudacaoController {

	private static final String template = "Olá, %s!";
	private final AtomicLong contador = new AtomicLong();
	
	@RequestMapping("/saudacao")
	public Saudacao saudacao(@RequestParam(value="nome", defaultValue = "Mundo") String nome) {
		return  new Saudacao(contador.incrementAndGet(), String.format(template, nome));
	}
}
