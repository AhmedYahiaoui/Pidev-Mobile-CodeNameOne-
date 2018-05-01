package entites;

public class Commentaire {

    public int id;
    public String contenu;
    public Recette recette;
    public User user_id;

    public Commentaire(int id, String contenu, Recette recette) {
        this.id = id;
        this.contenu = contenu;
        this.recette = recette;
    }

    public Commentaire(String contenu, Recette recette) {
        this.contenu = contenu;
        this.recette = recette;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    
    
    
    
    
    
    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Commentaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", contenu=" + contenu + '}';
    }
}
