package main;


import java.util.ArrayList;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.stream.Collectors;
import main.Pracownik.Stanowisko;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Firma implements Iterable<Pracownik>{
    //Zadanie 4
    public ArrayList<Pracownik> Pracownicy = new ArrayList<>();
    public Firma()
    {
        
    }
    public Firma(ArrayList<Pracownik> pracownicy)
    {
        Pracownicy=pracownicy;
    }
    
    
    public void DodajPracownika(Pracownik NowyPracownik)
    {
        Pracownicy.add(NowyPracownik);
        System.out.println("Dodano pracownika: "+NowyPracownik);
    }
        
    public int LiczbaPracownikow()
    {
        int LP=0;
        LP=Pracownicy.size();
        return LP;
    }
    
    public void WypiszPracownikow()
    {
        for (int i=0; i<Pracownicy.size(); i++)
        {
            System.out.println(Pracownicy.get(i).toString());
        }
    }
    
    Iterator<Pracownik> it = Pracownicy.iterator();
   

    //Zadanie 5
    public Iterator<Pracownik> iterator() {
        return Pracownicy.iterator();
    }
    //Zadanie 6
    public Iterator <Pracownik> iterator(Pracownik.Stanowisko s)
    {
        var it = this.Pracownicy.stream()
                .filter(P->P.STanowisko==s)
                .collect(Collectors.toList());
        //System.out.println(it);
        
        return it.iterator();
    }
    
    //Zadanie 7
    //W klasie Firma, korzystając z iteratorów z poprzednich zadań, zaimplementuj metodę
    //obliczającą średnią pensję:
    //a) wszystkich pracowników, oraz
    //b) pracowników tylko dla wskazanego stanowiska
    public float SredniaPensja()
    {
        float SumaPensji=0;
        for (Pracownik pracownik: Pracownicy)
        {
            SumaPensji+=pracownik.Pensja;
        }
        return SumaPensji/Pracownicy.size();
    }
    
    public float SredniaPensjaStanowiska(Pracownik.Stanowisko s)
    {
        float SumaPensji=0;
        Iterator<Pracownik> it = iterator(s);
        int IloscPracownikow=0;
        while(it.hasNext())
        {
            SumaPensji+=it.next().Pensja;
            IloscPracownikow++;
        }
        
        return SumaPensji/IloscPracownikow;
    }
    
}
