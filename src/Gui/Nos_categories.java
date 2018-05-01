/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Services.CategorieService;
import Services.RecetteService;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import entites.Categorie;
import entites.Recette;

/**
 *
 * @author Ahmed
 */
public class Nos_categories {
    
    Form f;
    TextField tnom;

    Button btnajout,btnaff;

    public Nos_categories() {
        f = new Form("home");
        
        tnom = new TextField("", "Nom du Categorie");

        
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        
        f.add(tnom);
        f.add(btnajout);
        f.add(btnaff);
        
        
        btnajout.addActionListener((e) -> {
            CategorieService ser = new CategorieService();
            Categorie t = new Categorie(tnom.getText());
            System.out.println("Prepaaaaaa");
            
            ser.ajoutTask(t);
                        System.out.println("Done");
        });
        
 
        btnaff.addActionListener((e)->{
        Affichage_categorie a=new Affichage_categorie();
        a.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }
    
    
}
