package fr.laerce.lights.impl;

import java.util.Random;

import fr.laerce.lights.Eclairage;

/**
 * Implémentation et simulation d'une ampoule à LED dont la durée de vie est
 * très longue et donc la probabilité de panne très faible.
 *
 * @author fred
 *
 */
public class AmpouleLed implements Eclairage {


    /**
     * etat de la lampe : 0 éteinte, 10 allumée pleine intensité
     */
    private int etat;

    /**
     * Calcule la probabilité qu'une ampoule tombe en panne
     *
     * @return 0 l'ampoule fonctione, -1 l'ampoule est en panne
     */
    private int probaPanne() {
        // DONE implémenter la probabilité que l'ampoule LED tombe en panne à
        // l'allumage

        Random alea = new Random();
        if (alea.nextInt(100)<1){
            return -1;

        }
        return 0;
    }




    /**
     * Constructeur
     */
    public AmpouleLed() {
        // DONE initialiser la lampe
        etat=0;
    }

    /**
     * Allume l'ampoule à pleine puissance
     */
    public void allumer() {
        // DONE gérer la logique d'allumage
        if (etat==0){
            if (probaPanne()==-1){
                etat=-1;

            }
        }
        if (etat!=-1){
            etat =10;
        }
    }

    /**
     * Eteint l'ampoule
     */
    public void eteindre() {
        // DONE gérér la logique d'extinction
        if (etat !=-1)
            etat=0;

    }

    /**
     * Augmente l'intensité lumineuse de l'ampoule
     */
    public void intensifier() {
        // DONE gérer la logique d'augmentation de l'intensité
        if (etat==0)
            etat=probaPanne();
        if (etat !=-1 && etat<10)

            etat++;
    }

    /**
     * Diminuer l'intensité lumineuse de l'ampoule
     */
    public void diminuer() {
        // DONE gérer la logique de diminution de l'intensité lumineuse

        if (etat!=-1 && etat>0)
            etat--;


    }

    /**
     * Permet de connaître l'état de l'ampoule
     *
     * @return l'état de la lampe 0..10 ou -1 si en panne
     */
    public int etat() {
        // DONE retourner l'état effectif de l'ampoule

        return etat;
    }

    /**
     * @return l'état de l'objet sous la forme d'une chaîne de caractères
     */
    public String toString() {
        // DONE retourner dans la chaîne le nom de la classe et l'état de l'ampoule

        String nom=this.getClass().getName();
        return nom+" Etat : "+etat;

    }

}
