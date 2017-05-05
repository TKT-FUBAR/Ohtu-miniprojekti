
package fi.fubar.bibtex.util;

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
        texString = texString.replace("å", "\\aa");
        texString = texString.replace("Å", "\\AA");
        texString = texString.replace("ä", "\\\"{a}");
        texString = texString.replace("ö", "\\\"{o}");
        texString = texString.replace("Ä", "\\\"{A}");
        return texString.replace("Ö", "\\\"{O}");
    }
    
    public static String scandicsBack(String texString) {
        texString = texString.replace("\\aa", "å");
        texString = texString.replace("\\AA", "Å");
        texString = texString.replace("\\\"{a}", "ä");
        texString = texString.replace("\\\"{o}", "ö");
        texString = texString.replace("\\\"{A}", "Ä");
        return texString.replace("\\\"{O}", "Ö");
    }
    
    public static String fixPagesSeparator(String pages) {
        if (pages.contains("-") && !pages.contains("--")) {
            return pages.replace("-", "--");
        }
        return pages;
    }
}
