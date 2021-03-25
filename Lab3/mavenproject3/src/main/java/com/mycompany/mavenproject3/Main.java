/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject3;

/*
Korzystając z Java Persistence API utwórz nowy model danych – obiekty POJO (entity classes) 
na podstawie wykorzystywanej wcześniej bazy danych. Napisz program, który
za pomocą EntityManager pobiera wybrane dane z bazy, modyfkuje je oraz dodaje nowe
rekordy, a na koniec utrwala zmiany w bazie danych. Przetestuj swoje rozwiązanie.
 */
public class Main {
    public static void main(String[] args) {
    database.getEntityManager().registerEntityClasses("com.orientechnologies.orient.test.domain");

        POJO pojo = new POJO();

    }
}
