package com.example.TPyOUSSFI;

import com.example.TPyOUSSFI.Entities.Produit;
import com.example.TPyOUSSFI.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class TPyOussfiApplication implements CommandLineRunner {
	@Autowired
	private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(TPyOussfiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	produitRepository.save(new Produit(null,"Laptop",6500,54));
	produitRepository.save(new Produit(null,"Desktop",6500,78));
	produitRepository.save(new Produit(null,"Phone",6500,30));
	Page<Produit> produits = produitRepository.findByDesignationContains("L",PageRequest.of(0,2));
	 	System.out.println(produits.getSize());
		System.out.println(produits.getTotalElements());
		System.out.println(produits.getTotalPages());
	produitRepository.findAll().forEach(produit->{
		System.out.println(produit.toString());
		});
	}
}
