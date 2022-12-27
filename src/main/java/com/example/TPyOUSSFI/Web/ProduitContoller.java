package com.example.TPyOUSSFI.Web;

import com.example.TPyOUSSFI.Entities.Produit;
import com.example.TPyOUSSFI.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ProduitContoller {
    @Autowired
    private ProduitRepository produitRepository;
    @GetMapping(path = "/index")
    public String index(){
        return "index";
    }
    @GetMapping(path = "/produits")
    public String produits(Model model){
        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("ListeProduits",produits);
        return "produits";
    }

}
