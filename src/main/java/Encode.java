import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encode {

    public static String encoding(String source) {


        StringBuffer bff = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;

            while (i + 1 < source.length()
                    && source.charAt(i) == source.charAt(i + 1)) {


                runLength++;//some comment here
                i++;
            }

            if ( runLength>9){

                int r = runLength-9;
                bff.append(source.charAt(i)).append(9).append(source.charAt(i)).append(runLength-9);

            }
            if (runLength<10){
                bff.append(source.charAt(i)).append(1).append(runLength);
            }

        }

        return bff.toString();
    }

    public static String decoding(String source) {
        StringBuffer bff = new StringBuffer();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            matcher.find();
            while (number-- != 0) {

                bff.append(matcher.group());
            }
        }

        return bff.toString();
    }

    public static void main(String[] args) throws NumberFormatException {






        String str = "jughuu89ukm88";

        try {


            System.out.println(decoding(str));
            System.out.println(encoding(decoding(str)));


        }        catch(NumberFormatException e){

            System.out.println("NumberFormatException has been detected");
        }

    }

}
