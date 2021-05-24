package Lib;

public class Support {

    public static String[] breakString(String string, String separate ) {
        return string.split(separate);
    }

    public static String returnOnlyNumbers(String text)
    {
        return text.replaceAll("[^\\d]", "");
    }
}
