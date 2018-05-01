package Gui;    
import Services.CategorieService;
import Services.CommentaireService;
import Services.RecetteService;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import static com.codename1.io.Log.e;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import entites.Commentaire;
import entites.Recette;
import java.io.IOException;
import java.util.ArrayList;
public class Affichage_Recette {

    Form f;
    SpanLabel lb, lb1, lb2, lb3, lb4;
    Label lb5;
    Resources theme;
    Label lblDate = new Label();

    private void initStarRankStyle(Style s, Image star) {
        s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
        s.setBorder(Border.createEmpty());
        s.setBgImage(star);
        s.setBgTransparency(0);
    }

    private Slider createStarRankSlider() {
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(0);
        starRank.setMaxValue(10);
        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
        return starRank;
    }

    public Affichage_Recette() throws IOException {

        //Recette eve;
        f = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        lb = new SpanLabel("");
        
        Recette eve = new Recette();
        
        RecetteService serviceTask = new RecetteService();
        ArrayList<Recette> ListRecettes = serviceTask.getList2();

        int deviceWidth = Display.getInstance().getDisplayWidth();
        int deviceHeight = Display.getInstance().getDisplayHeight();
        Image placeholder = Image.createImage(deviceWidth, deviceHeight - 100, 0xbfc9d2);
        EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);

        Recette rec = new Recette();
        //Recette eve ;
        
// ArrayList<Recette> Listpays = new ArrayList<>();
        for (Recette p : ListRecettes) {
            int id1=rec.getId();
            int id2=p.getId();
            Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

            URLImage url = URLImage.createToStorage(encImage, p.getNomImage()
                    + "", "http://localhost/pidev/web/images/" + p.getNomImage());

            ScaleImageLabel sl = new ScaleImageLabel(url);
            sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

            SpanLabel l = new SpanLabel(p.getNom());
            SpanLabel l4 = new SpanLabel(p.getBN());
            Label l8 = new Label("-------------------------------------------------------------");
            Label detail = new Label("Voir detail ... ");
// details            
            detail.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Form f2 = new Form(new BoxLayout(BoxLayout.Y_AXIS));

                    URLImage url = URLImage.createToStorage(encImage, p.getNomImage() + "", "http://localhost/pidev/web/images/" + p.getNomImage());
                    ScaleImageLabel sl = new ScaleImageLabel(url);
                    sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

                    Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    Container Commentaire = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    Container Affiche_Commentaire = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    
                    
//preparer les separator dans details
                    Label separator = new Label("______________");
                    Label separator1 = new Label("______________");
                    Label separator02 = new Label("______________");
                    Label separator2 = new Label("__________________________________________");

//preparer les Label dans details
                    Label pre1 = new Label("Preparation :");
                    Label bes1 = new Label("Les Besoins :");
                    Label bn1 = new Label("Les Ingrédiants :");
                    Label dure = new Label("Durée");
                    Label com = new Label("Les Commentaires");
                    Label supp = new Label("Suprimer cette recette");
//preparer les Span dans details
                    Label nom = new Label("");
                    SpanLabel pre = new SpanLabel("");
                    SpanLabel bes = new SpanLabel("");
                    SpanLabel duree = new SpanLabel("");
                    SpanLabel bn = new SpanLabel("");
//l'ajout dans les span dans details
                    nom.setText(p.getNom());
                    pre.setText(p.getPreparation());
                    bes.setText(p.getBesoin());
                    bn.setText(p.getBN());
                    pre.setText(p.getPreparation());
                    duree.setText(Integer.toString(p.getDuree()));
                    
                    
//Pour le Commentaire
                    
                    TextField Comment = new TextField("","Inserer Votre Commentaire ici");
                    Button valider = new Button("Valider");
                    Label Affichesuite = new Label("Afficher les Commentaires ..");
// ajout Un commentaire        
                    valider.addActionListener((e) -> {
                       CommentaireService ser = new CommentaireService();
//                       Recette eve= new Recette();
//                       Commentaire c = new Commentaire(Comment.getText(),rec);
//          // new Recette(tnom.getText());
//            System.out.println("Prepaaaaaa");
//            
//            ser.ajoutTask(c,rec.getId());
//                        System.out.println("Done");
                       
                       /* Commentaire t =new Commentaire(Comment.getText());
                        System.out.println("Ajout Commentaire en cours");
                        ser.ajoutTask(t);
                        System.out.println("Ajout commentaire ça marche");*/
                    //ArrayList<Commentaire> Listcommentaire = ser.getList2();
                   Commentaire t =new Commentaire();
                   t.setContenu(Comment.getText());
                   t.setRecette(eve);
                   ser.ajoutTask(t,id2);
                  // t.setUser_id();
                  
                  
                  
                    });
                    
                Container tous = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                
//Afficher le suite dans la page Details
                Affichesuite.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                  //  CommentaireService ser = new CommentaireService();
                  //  ArrayList<Commentaire> Listcommentaire = ser.getList2();
                  
                             ArrayList<Commentaire> p;
          CommentaireService ser = new CommentaireService();
         p= ser.getList2Commentaire(id2);
                  Label separator4 = new Label("______________");
                    //int i=0;
                             for(int i = 0 ; i < p.size(); i++){
            Commentaire commentaire=p.get(i);

             Label comments = new Label(commentaire.getContenu());

                  //  for (Commentaire p : Listcommentaire) {
                    /*    i++;
                  
                        Container uncommentaire = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Container lecommentaire = new Container(new BoxLayout(BoxLayout.X_AXIS));
                        Container leButton = new Container(new BoxLayout(BoxLayout.X_AXIS));                        
                       Label nombre= new Label();
                       Label contenuCommentaire = new Label();
                       Button SupprimeCommentaire = new Button("Supprime ton Commentaire");
                       
                       contenuCommentaire.setText(p.getContenu());
                       nombre.setText(Integer.toString(i));
                       lecommentaire.add(FlowLayout.encloseCenter(contenuCommentaire));
                       leButton.add(FlowLayout.encloseCenter(SupprimeCommentaire));
                       
                       uncommentaire.add(lecommentaire);
                       uncommentaire.add(leButton);*/
                       tous.add(comments);
                    
                    
                    
                    
                    }
                }
            });
                    
// Label supp = new Label("Suprimer cette recette");
            supp.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/pidev/web/app_dev.php/forum/supprime/" +p.getId();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            System.out.println(p.getNom()+"preparation");
        });
                    System.out.println(p.getNom()+"saye");
        NetworkManager.getInstance().addToQueueAndWait(con);  
        System.out.println("saye");
       // f.refreshTheme();
                }
            });
                    Comment.clear();                    
                    //c2.refreshTheme();

                    //ajout dans le container de details
                    c2.add(FlowLayout.encloseCenter(nom));
                    c2.add(sl);
                    c2.add(FlowLayout.encloseCenter(pre1));
                    c2.add(pre);
                    c2.add(separator);
                    c2.add(FlowLayout.encloseCenter(bes1));
                    c2.add(bes);
                    c2.add(separator1);
                    c2.add(FlowLayout.encloseCenter(bn1));
                    c2.add(bn);
                    c2.add(separator02);
                    c2.add(FlowLayout.encloseCenter(dure));
                    
                    Container dureeContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Label Minutes =new Label("  Minutes");
                    dureeContainer.add(duree);
                    dureeContainer.add(Minutes);
                    c2.add(dureeContainer);
                    
                    c2.add(separator2);                    
                    c2.add(FlowLayout.encloseCenter(supp));
                    c2.add(FlowLayout.encloseCenter(com));
                    c2.add(tous);
                    
                    //ajout dans le container de commentaire
                    Commentaire.add(Comment);
                    Commentaire.add(valider);
                    Commentaire.add(Affichesuite);                 
                    
                    f2.add(c2);
                    f2.add(Commentaire);
                    f2.show();

                    //Back 
                    f2.getToolbar().addCommandToLeftBar("Back", null, e -> {
                        f.showBack();
                    });
                }
            });



            c2.add(FlowLayout.encloseCenter(l));
            c2.add(sl);
            c2.add(l4);            
            c2.add(FlowLayout.encloseCenter(createStarRankSlider()));
            c2.add(FlowLayout.encloseCenter(detail));
            c2.add(l8);
            f.add(c2);
        }

        f.show();
        f.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            Nos_recettes h = new Nos_recettes();
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
