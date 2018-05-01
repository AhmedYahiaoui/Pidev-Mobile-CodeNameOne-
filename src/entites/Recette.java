/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Ahmed
 */
public class Recette {

    public int id;
    public String nom;
    public int duree;
    public String besoin;
    public String preparation;
    public String BN;
    //public User user;
    public int likee =0;
    public int dislike=0;
    public String nomImage;

    public Recette(String nom, int duree, String besoin, String preparation, String BN, String nomImage) {
        this.nom = nom;
        this.duree = duree;
        this.besoin = besoin;
        this.preparation = preparation;
        this.BN = BN;
        this.nomImage = nomImage;
    }

    public Recette(int id) {
        this.id = id;
    }

    public Recette(int id, String nom, int duree, String besoin, String preparation, String BN, String nomImage) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
        this.besoin = besoin;
        this.preparation = preparation;
        this.BN = BN;
        this.nomImage = nomImage;
    }

    public Recette() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getBesoin() {
        return besoin;
    }

    public void setBesoin(String besoin) {
        this.besoin = besoin;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getBN() {
        return BN;
    }

    public void setBN(String BN) {
        this.BN = BN;
    }

    public int getLikee() {
        return likee;
    }

    public void setLikee(int likee) {
        this.likee = likee;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }




}
