/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.fubar.bibtex.service;

import fi.fubar.bibtex.domain.Article;
import fi.fubar.bibtex.domain.Book;
import fi.fubar.bibtex.domain.InProceedings;
import fi.fubar.bibtex.domain.Reference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author janantik
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceServiceTest {

    @Autowired
    private ReferenceService rs;

    public ReferenceServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
        // rs = new ReferenceService();
        Book b = new Book();
        b.setHandle("Herra Ylppö");
        b.setTitle("Herra ylpön keittokirja");
        b.setAuthor("WIlkas");
        b.setEditor("Editor");
        b.setPublisher("Joo");
        b.setNote("Note");
        b.setSeries("Lol");
        b.setAddress("Osoite");
        b.setEdition("Kolmas");
        Article a = new Article();
        a.setHandle("Jouni Hynynen");
        InProceedings i = new InProceedings();
        i.setHandle("Maija Vilkkumaa");
        rs.save(a);
        rs.save(b);
        rs.save(i);
    }

    @Test
    public void findBook() {
        Reference tb = rs.findByTypeAndId("book", 1l);
        assertEquals("Herra Ylppö", tb.getHandle());

    }

    @Test
    public void findArticle() {
        Reference ta = rs.findByTypeAndId("article", 1l);
        assertEquals("Jouni Hynynen", ta.getHandle());
    }

    @Test
    public void findInproceedings() {
        Reference ti = rs.findByTypeAndId("inproceedings", 1l);
        assertEquals("Maija Vilkkumaa", ti.getHandle());
    }

    @Test
    public void findAllTest() {
        //     List<String> names = Arrays.asList("Herra Ylppö", "Jouni Hynynen", "Maija Vilkkumaa");
        List<Reference> refs = rs.findAll();
        assertEquals("Herra Ylppö", refs.get(1).getHandle());
    }

    @Test
    public void searchTestFound() {
        String test = "Herra";
        List<Reference> refs = new ArrayList<>();
        // refs.addAll(rs.search(test));
        refs = rs.search(test);
        if (refs.isEmpty()) {
            assertTrue(false);
        } else {
            assertEquals("Herra Ylppö", refs.get(0).getHandle());
        }
    
}
    @Test
    public void searchTestNotFound() {
        String test = "ETlöydä";
        List<Reference> refs = rs.search(test);
        assertTrue(refs.isEmpty());
    }

@Test
        public void bibTexTest() {
//        String shouldBe = "@book{Herra Ylpp\\\"{o},\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "publisher = {N/A},\n"
//                + "year = {N/A}\n"
//                + "}\n"
//                + "@book{Herra Ylpp\\\"{o},\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "publisher = {N/A},\n"
//                + "year = {N/A}\n"
//                + "}\n"
//                + "@book{Herra Ylpp\\\"{o},\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "publisher = {N/A},\n"
//                + "year = {N/A}\n"
//                + "}\n"
//                + "@book{Herra Ylpp\\\"{o},\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "publisher = {N/A},\n"
//                + "year = {N/A}\n"
//                + "}\n"
//                + "@book{Herra Ylpp\\\"{o},\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "publisher = {N/A},\n"
//                + "year = {N/A}\n"
//                + "}\n"
//                + "@article{Jouni Hynynen,\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "journal = {N/A},\n"
//                + "year = {N/A},\n"
//                + "volume = {N/A}\n"
//                + "}\n"
//                + "@article{Jouni Hynynen,\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "journal = {N/A},\n"
//                + "year = {N/A},\n"
//                + "volume = {N/A}\n"
//                + "}\n"
//                + "@article{Jouni Hynynen,\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "journal = {N/A},\n"
//                + "year = {N/A},\n"
//                + "volume = {N/A}\n"
//                + "}\n"
//                + "@article{Jouni Hynynen,\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "journal = {N/A},\n"
//                + "year = {N/A},\n"
//                + "volume = {N/A}\n"
//                + "}\n"
//                + "@article{Jouni Hynynen,\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "journal = {N/A},\n"
//                + "year = {N/A},\n"
//                + "volume = {N/A}\n"
//                + "}\n"
//                + "@inproceedings{Maija Vilkkumaa,\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "booktitle = {N/A},\n"
//                + "year = {N/A}\n"
//                + "}\n"
//                + "@inproceedings{Maija Vilkkumaa,\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "booktitle = {N/A},\n"
//                + "year = {N/A}\n"
//                + "}\n"
//                + "@inproceedings{Maija Vilkkumaa,\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "booktitle = {N/A},\n"
//                + "year = {N/A}\n"
//                + "}\n"
//                + "@inproceedings{Maija Vilkkumaa,\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "booktitle = {N/A},\n"
//                + "year = {N/A}\n"
//                + "}\n"
//                + "@inproceedings{Maija Vilkkumaa,\n"
//                + "author = {N/A},\n"
//                + "title = {N/A},\n"
//                + "booktitle = {N/A},\n"
//                + "year = {N/A}\n"
//                + "}";
//        assertEquals(shouldBe, rs.returnAllinBibTeXStrings());
    }
}
