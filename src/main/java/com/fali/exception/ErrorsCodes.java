package com.fali.exception;

public enum ErrorsCodes {

    ARTICLE_NOT_FOUND(1000),
    CATEGORY_NOT_FOUND(2000),
    CLIENT_NOT_FOUND(3000),
    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_CLIENT_NOT_VALID(4001),

    FOURNISSEUR_NOT_FOUND(5000),
    COMMANDE_FOURNISSEUR_NOT_FOUND(6000),
    COMMANDE_FOURNISSEUR_NOT_VALID(6001),
    LIGNR_COMMANDE_CLIENT_NOT_FOUND(7000),
    LIGNR_COMMANDE_CLIENT_NOT_VALID(7001),
    LIGNR_COMMANDE_FOURNISSEUR_NOT_FOUND(8000),
    LIGNR_VENTE_NOT_FOUND(9000),
    MVT_STK_NOT_FOUND(11000),
    UTILISATEUR_NOT_FOUND(12000),
    VENTE_NOT_FOUND(13000);






    private int code;

    ErrorsCodes(int code){
        this.code=code;
    }

    public int getCode(){
        return code;
    }
}
