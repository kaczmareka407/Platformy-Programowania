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
public class Osoba {
    //Zadanie 1
    final String Imie;
    final String Nazwisko;
    
    Osoba (String imie, String nazwisko)
    {
        Imie=imie;
        Nazwisko=nazwisko;
        
        
    }

    //Zadanie 4
    @Override
    public String toString() {
        return (Imie+" "+Nazwisko); 
    }
    
    
    
    
}
