package Gui;


import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.util.Resources;
import entites.Recette;
import java.io.IOException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class supprimer {
    public void SuppTNR(Recette t) throws IOException
    {
        
         ConnectionRequest req = new ConnectionRequest();
                                 
                req.setUrl("http://localhost/pidev/web/app_dev.php/forum/supprime/?nom=" +t.getNom());
                System.out.println(t.getNom()+"********************");
                 NetworkManager.getInstance().addToQueue(req);
        //Resources theme = null;
            //  new Affichage_Recette().show();
    }
    
}
