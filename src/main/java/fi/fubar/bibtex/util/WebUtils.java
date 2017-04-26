package fi.fubar.bibtex.util;

public class WebUtils {

    public static String getACMData(String url) {
        //TODO: fetch bibtex data from acm.
        System.out.println(url);
        String testdata = "@inproceedings{Vihavainen:2011:EAM:1953163.1953196,\n"
                + " author = {Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti},\n"
                + " title = {Extreme Apprenticeship Method in Teaching Programming for Beginners},\n"
                + " booktitle = {Proceedings of the 42Nd ACM Technical Symposium on Computer Science Education},\n"
                + " series = {SIGCSE '11},\n"
                + " year = {2011},\n"
                + " isbn = {978-1-4503-0500-6},\n"
                + " location = {Dallas, TX, USA},\n"
                + " pages = {93--98},\n"
                + " numpages = {6},\n"
                + " url = {http://doi.acm.org/10.1145/1953163.1953196},\n"
                + " doi = {10.1145/1953163.1953196},\n"
                + " acmid = {1953196},\n"
                + " publisher = {ACM},\n"
                + " address = {New York, NY, USA},\n"
                + " keywords = {best practices, cognitive apprenticeship, continuous feedback, course material, instructional design, learning by doing, motivation, programming education},\n"
                + "} ";

        return testdata;
    }

}
