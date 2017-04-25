/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.fubar.bibtex.domain;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author janantik
 */
public class BookTest {

    private Book book;

    public BookTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
        book = new Book();
        book.setHandle("BA04");
        book.setAuthor("Beck, Kent and Andres, Cynthia");
        book.setTitle("Extreme Programming Explained: Embrace Change (2nd Edition)");
        book.setYear("2004");
        book.setPublisher("Addison-Wesley Professional");
        /*
        @book{BA04,
author = {Beck, Kent and Andres, Cynthia},
title = {Extreme Programming Explained: Embrace Change (2nd Edition)},
year = {2004},
publisher = {Addison-Wesley Professional},
}
         */
    }

    @Test
    public void testBibtex() {
        String shouldBe = "@book{BA04,\n"
                + "author = {Beck, Kent and Andres, Cynthia},\n"
                + "title = {Extreme Programming Explained: Embrace Change (2nd Edition)},\n"
                + "publisher = {Addison-Wesley Professional},\n"
                + "year = {2004}\n"
                + "}";
        String toBib = book.toBibTex();
        System.out.println(toBib);
//        System.out.println("Alhaalla oikea");
//        System.out.println(shouldBe);
        assertEquals(shouldBe, toBib);
    }

}
