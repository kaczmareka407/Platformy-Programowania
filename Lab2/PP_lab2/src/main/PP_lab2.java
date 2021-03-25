/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import static java.util.Arrays.stream;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class PP_lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Zadanie 4
        
        Pracownik Pracownik1 = new Pracownik("Jan","Kowalski",Pracownik.Stanowisko.DYREKTOR, 5000);
        Pracownik Pracownik2 = new Pracownik("Anna","Nowak",Pracownik.Stanowisko.KIEROWNIK, 4000);
        Pracownik Pracownik3 = new Pracownik("Izabela","Krawczyk",Pracownik.Stanowisko.ASYSTENT, 3000);
        Pracownik Pracownik4 = new Pracownik("Piotr","Jakis",Pracownik.Stanowisko.ASYSTENT, 5000);
        
        
        Firma firma = new Firma();
        System.out.println("Liczba pracownikow: "+firma.LiczbaPracownikow());
        
        System.out.println("Dodanie pracownikow");
        firma.DodajPracownika(Pracownik1);
        firma.DodajPracownika(Pracownik2);
        firma.DodajPracownika(Pracownik3);
        firma.DodajPracownika(Pracownik4);
        System.out.println("");
        
        System.out.println("Pracownicy: ");
        firma.WypiszPracownikow();
        
        System.out.println("");
        System.out.println("Liczba pracownikow: "+firma.LiczbaPracownikow());
        
        
        
        
        //Zadanie 5
        System.out.println("Pracownicy wyswietleni przy pomocy iteratora: ");
        for (Pracownik p: firma)
        {
            System.out.println(p);
        }
        System.out.println("");

        
        //Zadanie 6  
        Iterator<Pracownik> it = firma.iterator(Pracownik.Stanowisko.ASYSTENT);
        System.out.println("Asystenci: ");
        while(it.hasNext())
        {
          System.out.println(it.next());
        }        
        System.out.println("");

       
       //Zadanie 7 
        System.out.println("Srednia pensja wszystkich pracownikow: "+firma.SredniaPensja());
        System.out.println("Srednia pensja pracownikow na poszczegolnym stanowisku: "+firma.SredniaPensjaStanowiska(Pracownik.Stanowisko.ASYSTENT));
       
       
        
    }
    
}
