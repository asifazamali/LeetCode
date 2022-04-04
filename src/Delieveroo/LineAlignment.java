package Delieveroo;
import java.util.*;
// word list , n
//["the", "quick", "fox", "jumps", "over", "the", "lazy", "dog"]
// n = 13
// output:
// ["the-quick-fox",
// "over-the-lazy",
// "dog"]

public class LineAlignment {
        public static void main(String[] argv) {
            String[] lines = {"The", "day", "began", "as", "still", "as",  "the","night" ,"abruptly", "lighted", "with",
                    "brilliant" ,"flame"};
            int testReflowWidth1 = 24;
            int testReflowWidth2 = 25;
            int testReflowWidth3 = 26;
            int testReflowWidth4 = 40;
            int testReflowWidth5 = 14;


            List<String> res= process(lines, testReflowWidth1);
            System.out.println(res);
            // List<String> res6= process(words1, lineLength1_2);
            // System.out.println(res6);
            // List<String> res2= process(words2, lineLength2_1);
            // System.out.println(res2);
            //  List<String> res3= process(words3, lineLength3_1);
            // System.out.println(res3);
            //  List<String> res4= process(words4, lineLength4_1);
            // System.out.println(res4);
            //  List<String> res5= process(words5, lineLength5_1);
            // System.out.println(res5);

        }


        private static List<String> process(String[] words, int limit){
            int available = limit;
            List<String> list = new ArrayList();
            StringBuilder sb = new StringBuilder();
            int wordCounter = 0;
            for(int i = 0; i < words.length;) {
                if(available >= words[i].length()){
                    sb.append(words[i]);
                    sb.append('-');
                    wordCounter++;
                    available -= words[i].length() + 1;
                    i++;
                }else{
                    if(sb.length() > 0)
                        sb.setLength(sb.length()-1);
                    String formattedString = formatString1(sb.toString(), wordCounter, available, limit);
                    list.add(formattedString);
                    sb = new StringBuilder();
                    available = limit;
                }
            }
            sb.setLength(sb.length()-1);
            String formattedString = formatString1(sb.toString(), wordCounter, available, limit);
            list.add(formattedString);
            return list;
        }

        private static String formatString1(String str, int cnt, int available, int limit){
            // A-B-C cnt = 3, a = 5, limit = 10
            // cnt > 0
            // spaces = 10 -5 = 15/4 = 3
            // rem = 15 % 4 = 3
            String[] strArr = str.split("-");
            int spaces = available;
            StringBuilder sb  = new StringBuilder();
            int eachSpace = 0;
            int remSpace = 0;
            if(cnt > 0){
                eachSpace = spaces/(cnt-1);
                remSpace =  spaces % (cnt-1);
            }
            for(int i = 0; i < strArr.length-1; i++){
                sb.append(strArr[i]);
                sb.append('-');
                for(int j = 0; j < eachSpace; j++){
                    sb.append('-');
                }
                if(remSpace >0){
                    sb.append('-');
                    remSpace--;
                }
            }
            sb.append(strArr[strArr.length-1]);
            return sb.toString();
        }

    }

