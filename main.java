import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class main {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String args[]){
        String page = urlToString("http://erdani.com/tdpl/hamlet.txt");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String[] pageWords = page.split(" ");
        System.out.println(pageWords.length);
        int count = 0;
        for (int i=0; i<pageWords.length; i++){
            if(pageWords[i].toUpperCase().contains(word.toUpperCase())){
                count++;
            }
        }
        System.out.println(count);
    }
}