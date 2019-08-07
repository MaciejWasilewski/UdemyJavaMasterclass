package com.example.mwasilewski;

import javafx.css.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String string = "I am a astring. Yes, I am.";
//        System.out.println(string);
//        String yourString=string.replaceAll("I", "You");
//        System.out.println(yourString);

        String alphanumeric = "abcDeeeeF12Ghhuuuhjl99z";
//        System.out.println(alphanumeric.replaceAll("","Y"));
//        System.out.println(alphanumeric.replaceAll("[aei][Fj]","Y"));
//        System.out.println("Harry or harry".replaceAll("[Hh]arry","Barry"));
//        System.out.println(" Harry likes me".replaceAll("(?!\\b)\\w+?\\b", "X"));
//        System.out.println("123\\".replaceAll("\\\\","\\\\"));

//        System.out.println(alphanumeric.replaceAll("(abcDe{2}|u{3})", "Y"));
//        System.out.println(alphanumeric.replaceAll("(abcDe+|u{3})", "Y"));
//
//        System.out.println(alphanumeric.replaceAll("(abcDef+|u{3})", "Y"));
//        System.out.println(alphanumeric.replaceAll("(abcDef*|u{3})", "Y"));
//        alphanumeric = "1223465822";
//        System.out.println(alphanumeric.replaceAll("\\d2{2}", "***"));
//
//        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
//        htmlText.append("<h2>Sub-heading</h2>");
//        htmlText.append("<p>This is paragraph</p>");
//        htmlText.append("<p>This is another paragraph.</p>");
//        htmlText.append("<h2>Summary</h2>");
//        htmlText.append("<p>This is summary</p>");
//
//        Pattern pattern = Pattern.compile("<h2>(.*?)</h2>");
//        Matcher matcher = pattern.matcher(htmlText.toString());
//
//        while (matcher.find()) {
//            System.out.println(matcher.groupCount());
//            System.out.println(matcher.group(matcher.groupCount()));
//        }
//        int i = 0;
//        while (matcher.find()) {
//            i++;
//            System.out.println(i + ": " + matcher.start() + " " + matcher.end());
//
//            System.out.println(htmlText.toString().substring(matcher.start(), matcher.end()));
//        }


//        Challenge 1
        System.out.println("I want a bike.".matches("I want a bike\\."));
//        Challnege 2
        String regEx = "I want a b\\w{3}\\.";
        System.out.println(("I want a bike.".matches(regEx) && "I want a bike.".matches(regEx)));
//        Challenge 3
        System.out.println(Pattern.compile(regEx).matcher("I want a bike.").matches());
//Challenge 4
        System.out.println(Pattern.compile(" ")
                .matcher("Replace all blanks with underscores.")
                .replaceAll("_"));
//        Challenge 5
        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
//        Challenge 7
        String regEx7 = "^\\D+?\\.\\d+?$";
        System.out.println("abcd.135".matches(regEx7));
        System.out.println("f5.12a".matches(regEx7));

        //        Challenge 8
        String regEx8 = "[a-zA-Z]+?\\.(\\d+?)(?:[a-zA-Z]|$)";
        Matcher matcher = Pattern.compile(regEx8).matcher("abcd.135uvqz.7tzik.999");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
        System.out.println();

//Challenge 9 & 10
        String regEx9 = "(?:^?)[a-zA-Z]*?\\.(\\d+?)(?:\\t|\\n$)";
        matcher = Pattern.compile(regEx9).matcher("abcd.135\tuvqz.7\tzik.999\n");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.start(1) + " " + (matcher.end(1) - 1) + "\n\n");
        }

//        Challenge 11
        String regEx11 = "\\{(\\d),\\s*?(\\d)\\}";
        matcher = Pattern.compile(regEx11).matcher("{0, 2}, {0,5}, {1, 3},{2, 4}");
        while (matcher.find()) {
            if (matcher.groupCount() == 2) {
                System.out.println(matcher.group(1) + "\t" + matcher.group(2));
            }
        }
//Challenge 12 & 13
        String rexEx12="^\\d{5}(-\\d{4})?$";
        System.out.println("11111".matches(rexEx12));
        System.out.println("11111-1111".matches(rexEx12));
    }
}
