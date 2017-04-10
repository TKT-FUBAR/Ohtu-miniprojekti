/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.fubar.bibtex.util;

/**
 *
 * @author saskeli
 */
public class StringUtils {
    
    public static String actualOrDefault(String field) {
        return (field == null || field.isEmpty()) ? "N/A" : field;
    }

    public static void optional(StringBuilder sb, String fieldName, String fieldValue) {
        if (fieldValue == null || fieldValue.isEmpty()) {
            return;
        }
        sb.append(",\n").append(fieldName).append(" = {").append(fieldValue).append("}");
    }

    public static String escapeScandics(String texString) {
        texString = texString.replace("ä", "\\\"{a}");
        texString = texString.replace("ö", "\\\"{o}");
        texString = texString.replace("Ä", "\\\"{A}");
        return texString.replace("Ö", "\\\"{O}");
    }
}
