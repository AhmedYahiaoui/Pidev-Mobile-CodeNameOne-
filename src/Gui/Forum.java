package Gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;

public class Forum extends Form{

    /*   public Forum() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
        public Forum(com.codename1.ui.util.Resources resourceObjectInstance) {}
     */
    private Form current;
    private Resources theme;
    Form f;

    public void start() throws IOException {
        if (current != null) {
            current.show();
            return;
        }
        f = new Form();

        Form home = new Form("home page", new FlowLayout(CENTER, CENTER));
        
        Form AppelOfrre = new Form("AppelOfrre", new FlowLayout(CENTER, CENTER));
        Form Produit = new Form("Produit", new FlowLayout(CENTER, CENTER));
        Form forum = new Form("forum", new FlowLayout(CENTER, CENTER));
        Form shop = new Form("shop page", new FlowLayout(CENTER, CENTER));

        
        Form about = new Form("about page", new FlowLayout(CENTER, CENTER));
        Form exit = new Form("exit page", new FlowLayout(CENTER, CENTER));
        Form deconnecter = new Form("deconnecter page", new FlowLayout(CENTER, CENTER));

        Toolbar tb = home.getToolbar();
              
        Container cn1 = BorderLayout.west(new Label());
        cn1.add(BorderLayout.SOUTH, new Label("Cup Cake"));
        tb.addComponentToSideMenu(cn1);

          Produit.getToolbar().addCommandToRightBar("back", null,b -> home.showBack());
          AppelOfrre.getToolbar().addCommandToRightBar("back", null,b -> home.showBack());
          forum.getToolbar().addCommandToRightBar("back", null,b -> home.showBack());
          shop.getToolbar().addCommandToRightBar("back", null,b -> home.showBack());
          about.getToolbar().addCommandToRightBar("back", null,b -> home.showBack());
         // deconnecter.
        //  exit.getToolbar().closeSideMenu();
        //
        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> home.show());
        tb.addMaterialCommandToSideMenu("Nos Produit", FontImage.MATERIAL_PRINT, e -> Produit.show());
        tb.addMaterialCommandToSideMenu("Nos Appel d'offre", FontImage.MATERIAL_PHONELINK_RING, e -> AppelOfrre.show());
        tb.addMaterialCommandToSideMenu("Forum", FontImage.MATERIAL_MESSAGE, e -> forum.show());
        tb.addMaterialCommandToSideMenu("Shop", FontImage.MATERIAL_SHOP, e -> shop.show());

        tb.addMaterialCommandToSideMenu("About", FontImage.MATERIAL_WEB, e -> about.show());
        tb.addMaterialCommandToSideMenu("deconnecter", FontImage.MATERIAL_WIDGETS, e -> deconnecter.show());
        tb.addMaterialCommandToSideMenu("Quitter", FontImage.MATERIAL_EXIT_TO_APP, e -> exit.show());

        
        //About
        Container c2 = new Container();
        ImageViewer im = new ImageViewer(Image.createImage("/nader.jpg"));
        Label l1 = new Label("c'est votre profile M.nader ");
        SpanLabel sp = new SpanLabel(" c'est votre profile M.nader c'est votre profile M.nader "
                + "c'est votre profile M.nader  c'est votre profile M.nader  c'est votre profile M.nader "
                + "c'est votre profile M.nader  c'est votre profile M.nader  c'est votre profile M.nader "
                + "c'est votre profile M.nader c'est votre profile M.nader  ");

        c2.add(l1);
        c2.add(im);
        c2.add(sp);
        about.add(c2);
       
// Forum
        Container cf = new Container();
        Button Recette = new Button("Nos Recette Ici");
        Button Categorie = new Button("Nos Categorie Ici");
        cf.add(Recette);
        cf.add(Categorie);
        forum.add(cf);      
        
             Recette.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new Nos_recettes().getF().show();
            }
        });
        
             Categorie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new Nos_categories().getF().show();
            }
        });             
        
        
        /*       
                Recette.addActionListener((e)->{
        Nos_recettes a=new Nos_recettes();
        a.getF().show();
        });
  
             Recette.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    Nos_recettes a=new Nos_recettes();
        a.getF().show();
            }
        });
        */
        
        
        home.show();
    }
    
        public Form getF() {
        return f;
    }
}
