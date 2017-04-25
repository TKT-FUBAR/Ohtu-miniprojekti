/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.fubar.bibtex.util;

import fi.fubar.bibtex.util.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author janantik
 */
public class StringUtilsTest {
    private StringUtils test;
    
    public StringUtilsTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    @Test
    public void actualOrDefaultNullReturnsNA() {
        String str = null;
        assertEquals("N/A", test.actualOrDefault(str));
    }
    @Test
    public void actualOrDefaultEmptyReturnsNA() {
        String str = "";
        assertEquals("N/A", test.actualOrDefault(str));
    }
    
    @Test
    public void actualOrDefaultReturnsField() {
        String str = "Test";
        assertEquals("Test", test.actualOrDefault(str));
    }
    
    @Test
    public void optionalTestFieldEmpty() {
        StringBuilder sb = new StringBuilder("Hellooo");
        test.optional(sb, "", "");
        assertEquals("Hellooo", sb.toString());
    }
    
    @Test
    public void optionalTest() {
        StringBuilder sb = new StringBuilder("");
        test.optional(sb, "author", "Marko Saari");
        String shouldbe = ",\nauthor = {Marko Saari}";
        assertEquals(shouldbe, sb.toString());
    }
    
    @Test
    public void escapeScandis() {
        String str = "ä ö Ä Ö";
        String shouldbe = "\\\"{a} \\\"{o} \\\"{A} \\\"{O}";
        str = test.escapeScandics(str);
        assertEquals(shouldbe, str);
        
    }
}
