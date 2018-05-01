/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import entites.Commentaire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ahmed
 */
public class CommentaireService {
    
        public void ajoutTask(Commentaire ta,int id) {
        ConnectionRequest con = new ConnectionRequest();
//String Url = "http://localhost/pidev/web/app_dev.php/forum/ajout_commentaire/"+15+"&contenu=" + ta.getContenu()+ "&recette_id=" + ta.getRecette_id();
    //    String Url = "http://localhost/pidev/web/app_dev.php/forum/ajout_commentaire/?id="+id+"?contenu=" + ta.getContenu()+ "& recette_id="+  ta.getRecette_id();
//  String Url = "http://localhost/pidev/web/app_dev.php/forum/ajout2?nom=" + ta.getContenu();
      String Url = "http://localhost/pidev/web/app_dev.php/forum/ajout_commen/"+id+"?contenu=" + ta.getContenu()+ "&recette="+  ta.getRecette();

      
      
        con.setUrl(Url);
        //System.out.println("tt");
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public ArrayList<Commentaire> getListTask(String json) {

        ArrayList<Commentaire> listEtudiants = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(etudiants);

            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
                Commentaire e = new Commentaire();
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                e.setContenu(obj.get("contenu").toString());
                //e.setRecette_id(obj.get());
                System.out.println(e);
                listEtudiants.add(e);
            }

        } catch (IOException ex) {
        }
        System.out.println(listEtudiants);
        return listEtudiants;

    }

    ArrayList<Commentaire> listTasks = new ArrayList<>();
    public ArrayList<Commentaire> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev/web/app_dev.php/forum/affiche_commentaire");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Services.CommentaireService ser = new CommentaireService();
                listTasks = ser.getListTask(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }

    
    
    
    
    
    
    
    
    
    /*    ArrayList<Commentaire> listCommentaire_evenement = new ArrayList<>();
     public ArrayList<Commentaire> getList2Commentaire(int id1){       
        ConnectionRequest con = new ConnectionRequest();
       con.setUrl("http://localhost/pidev/web/app_dev.php/forum/commentaire"+id1);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                CommentaireService ser = new CommentaireService();
                listCommentaire_evenement = ser.getListCommentaire_evenement(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCommentaire_evenement;
    }
     */
         ArrayList<Commentaire> listCommentaire_evenement = new ArrayList<>();
    public ArrayList<Commentaire> getList2Commentaire(int id1) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pidev/web/app_dev.php/forum/commentaire/"+id1);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Services.CommentaireService ser = new CommentaireService();
                listCommentaire_evenement = ser.getListCommentaire_evenement(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCommentaire_evenement;
    }
     
     
     
       public ArrayList<Commentaire> getListCommentaire_evenement(String json) {

        ArrayList<Commentaire> listEtudiants = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(etudiants);

            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
                Commentaire e = new Commentaire();
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                e.setContenu(obj.get("contenu").toString());
                //e.setRecette_id(obj.get());
                System.out.println(e);
                listEtudiants.add(e);
            }

        } catch (IOException ex) {
        }
        System.out.println(listEtudiants);
        return listEtudiants;

    }
 /*   public ArrayList<Commentaire> getListCommentaire_evenement(String json) {
        ArrayList<Commentaire> listCommentaire_evenement = new ArrayList<>();
        try {
            JSONParser jss = new JSONParser();
            Map<String, Object> Commentaire_evenements = jss.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list4 = (List<Map<String, Object>>) Commentaire_evenements.get("root");
            for (Map<String, Object> obj : list4) {
                Commentaire e = new Commentaire();
                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                e.setContenu(obj.get("contenu").toString());
                listCommentaire_evenement.add(e);
            }
        } catch (IOException ex) {
        }
        System.out.println(listCommentaire_evenement);
        return listCommentaire_evenement;}
    
    
    }
    */
    
   
}