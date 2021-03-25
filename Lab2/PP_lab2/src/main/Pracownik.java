package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Pracownik extends Osoba{
    //Zadanie 3
    public enum Stanowisko {
        
        DYREKTOR ("Dyrektor",1,"Zarzadza firma"),
        KIEROWNIK ("Kierownik",2,"Zarzadza zespolem"),
        ASYSTENT ("Asystent",3,"Pomaga");
    
        final String Nazwa;
        final int Poziom;
        final String Opis;
        
            Stanowisko(String nazwa, int poziom, String opis)
         {
             Nazwa=nazwa;
             Poziom=poziom;
             Opis=opis;
         }  
            
            
            
            
    }
    
    
    public Stanowisko STanowisko;
    public int Pensja;
    
    
    //Zadanie 2
    public Pracownik(String imie, String nazwisko, Stanowisko stanowisko, int pensja)
    {
        super(imie,nazwisko);
        STanowisko=stanowisko;
        Pensja=pensja;
    }
    
    //Zadanie 4
    @Override
    public String toString() {
        return (Imie+" "+Nazwisko+" "+STanowisko+" "+Pensja); 
    }
   
            
    
    
    
}
