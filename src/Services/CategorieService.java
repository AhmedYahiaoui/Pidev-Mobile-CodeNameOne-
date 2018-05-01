/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entites.Categorie;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entites.Recette;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ahmed
 */
public class CategorieService {
 
        public void ajoutTask(Categorie ta) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev/web/app_dev.php/forum/ajout?nom="+ta.getNom();
        con.setUrl(Url);
        //System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
 
            public ArrayList<Categorie> getListTask(String json) {
        ArrayList<Categorie> listRecettes = new ArrayList<>();
        try {
            System.out.println(json);
            JSONParser j = new JSONParser();
            Map<String, Object> recettes = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(recettes);

            List<Map<String, Object>> list = (List<Map<String, Object>>) recettes.get("root");

            for (Map<String, Object> obj : list) {
                Categorie e = new Categorie();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
//                float duree = Float.parseFloat(obj.get("duree").toString());

                System.out.println(id);
                e.setId((int) id);
                e.setNom(obj.get("nom").toString());
//                e.setNom_image(obj.get("nom_image").toString());
                System.out.println(e);
                listRecettes.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listRecettes);
        return listRecettes;
    }

    ArrayList<Categorie> listTasks = new ArrayList<>();
    public ArrayList<Categorie> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev/web/app_dev.php/forum/Affich1");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                CategorieService ser = new CategorieService();
                listTasks = ser.getListTask(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
        
        
}
