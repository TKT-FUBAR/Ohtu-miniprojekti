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
public class inProceedingsTest {

    private InProceedings ip;

    public inProceedingsTest() {

        /*
        @inproceedings{HM06,
author = {Hassinen, Marko and M\"{a}yr\"{a}, Hannu},
title = {Learning programming by programming: a case study},
booktitle = {Baltic Sea '06: Proceedings of the 6th Baltic Sea conference on Computing education research: Koli Calling 2006},
year = {2006},
pages = {117--119},
publisher = {ACM},
}
         */
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
        ip = new InProceedings();
        ip.setHandle("HM06");
        ip.setAuthor("Hassinen, Marko and Mäyrä, Hannu");
        ip.setTitle("Learning programming by programming: a case study");
        ip.setBooktitle("Baltic Sea '06: Proceedings of the 6th Baltic Sea conference on Computing education research: Koli Calling 2006");
        ip.setYear("2006");
        ip.setPages("117--119");
        ip.setPublisher("ACM");
    }

    @Test
    public void bibTexTest() {
        String shouldBe = "@inproceedings{HM06,\n"
                + "author = {Hassinen, Marko and M\\\"{a}yr\\\"{a}, Hannu},\n"
                + "title = {Learning programming by programming: a case study},\n"
                + "booktitle = {Baltic Sea '06: Proceedings of the 6th Baltic Sea conference on Computing education research: Koli Calling 2006},\n"
                + "year = {2006},\n"
                + "pages = {117--119},\n"
                + "publisher = {ACM}\n"
                + "}";
        assertEquals(shouldBe, ip.toBibTex());
        
    }

}
