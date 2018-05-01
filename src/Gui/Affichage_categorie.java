/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Services.CategorieService;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import entites.Recette;
import java.util.ArrayList;
import entites.Categorie;



/**
 *
 * @author Ahmed
 */
public class Affichage_categorie {
    
    
     Form f;
    SpanLabel lb;
  
    public Affichage_categorie() {
        
        f = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        lb = new SpanLabel("");
        f.add(lb);
        CategorieService serviceTask=new CategorieService();        
        ArrayList<Categorie> ListRecettes = serviceTask.getList2();

                for (Categorie p : ListRecettes) {

            Container c2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
     //       ImageViewer img1 = new ImageViewer(new Image(""));
     //       Label l = new Label(p.getNom());
       lb = new SpanLabel(p.getNom());
      //      c2.add(img1);
            c2.add(lb);
            f.add(c2);
                }
      //  lb.setText(serviceTask.getList2().toString());

        f.show();
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{Nos_categories h=new Nos_categories();
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
