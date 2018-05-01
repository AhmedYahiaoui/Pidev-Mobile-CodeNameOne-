/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Services.RecetteService;
import com.codename1.capture.Capture;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import entites.Recette;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Ahmed
 */
public class Nos_recettes {
  Form f;
    TextField tnom;
    TextField duree;
    TextField prep;
    TextField bn;
    TextField image;
    TextField besoin;
    Button btnajout,btnaff;
public Resources theme;
    public Nos_recettes() {
        f = new Form("home");
        
        tnom = new TextField("", "Nom");
        duree = new TextField("", "Duree");
        prep = new TextField("", "preparation");
        bn = new TextField("", "ingrediant");
        image = new TextField("", "nom du image");
        besoin = new TextField("", "besoin");
        
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        Button upload = new Button("upload");
        f.add(tnom);
        f.add(duree);      
        f.add(prep);
        f.add(bn);        
        f.add(besoin);
        f.add(image);
        f.add(upload);
        image.setEditable(true);
        f.add(btnajout);
        f.add(btnaff);
        
        upload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                
                String filePath = Capture.capturePhoto();
        if (filePath != null) {
            try {
                String pathToBeStored = FileSystemStorage.getInstance().getAppHomePath()+ System.currentTimeMillis() +  ".jpg";
                Image img = Image.createImage(filePath);
                OutputStream os = FileSystemStorage.getInstance().openOutputStream(pathToBeStored );
                ImageIO.getImageIO().save(img, os, ImageIO.FORMAT_JPEG, 0.9f);
                os.close();
                
                 image.setText(pathToBeStored);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    
} 
   });
        
        btnajout.addActionListener((e) -> {
            RecetteService ser = new RecetteService();
            Recette t = new Recette(tnom.getText(),Integer.parseInt(duree.getText())
                 ,besoin.getText(),prep.getText(),bn.getText(),image.getText());
          // new Recette(tnom.getText());
            System.out.println("Prepaaaaaa");
            
            ser.ajoutTask(t);
                        System.out.println("Done");
        tnom.clear();
        duree.clear();
        besoin.clear();
        prep.clear();
        bn.clear();
        image.clear();

        
        });
        btnaff.addActionListener((e)->{
            try {
                Affichage_Recette a =new Affichage_Recette();
                a.getF().show();
            } catch (IOException ex) {
            }
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
