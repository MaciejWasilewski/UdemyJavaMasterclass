package com.example.mwasilewski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        try {
            //            URI baseUri = new URI("http://username:password@myserver.com:5000");
            //            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            //            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            //            URI uri3 = new URI("/stores/locations?zip=12345");
            //            //            System.out.println("scheme = "+uri.getScheme());
            //            //            System.out.println("Scheme-specific part = "+uri.getSchemeSpecificPart());
            //            //            System.out.println("Authority = "+uri.getAuthority());
            //            //            System.out.println("User Info = "+uri.getUserInfo());
            //            //            System.out.println("Host = "+uri.getHost());
            //            //            System.out.println("Port = "+uri.getPort());
            //            //            System.out.println("Path = "+uri.getPath());
            //            //            System.out.println("Query = "+uri.getQuery());
            //            //            System.out.println("Fragment = "+uri.getFragment());
            //
            //            URL url = baseUri.resolve(uri1).toURL();
            //            System.out.println("URL = " + url);
            //            System.out.println(baseUri.resolve(uri2).toURL());
            //            System.out.println(baseUri.resolve(uri3).toURL());
            //            //relativization
            //            System.out.println(baseUri.relativize(baseUri.resolve(uri2)));
            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=velvia");
            //            URI uri = url.toURI();
            //            System.out.println("scheme = " + uri.getScheme());
            //            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            //            System.out.println("Authority = " + uri.getAuthority());
            //            System.out.println("User Info = " + uri.getUserInfo());
            //            System.out.println("Host = " + uri.getHost());
            //            System.out.println("Port = " + uri.getPort());
            //            System.out.println("Path = " + uri.getPath());
            //            System.out.println("Query = " + uri.getQuery());
            //            System.out.println("Fragment = " + uri.getFragment());
            //
            //            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()
            //            ))) {
            //                inputStream.lines().forEach(System.out::println);
            //            } catch (IOException e) {
            //                e.printStackTrace();
            //            }
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //            urlConnection.setDoOutput(true);
            //            urlConnection.connect();
            //            try (BufferedReader inputStream =
            //                         new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            //                Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            //                headerFields.entrySet().stream().map(e -> "Header: "+e.getKey() + e.getValue().stream()
            //                .reduce(
            //                        "\n\tField" +
            //                                ": ",
            //                        (i,s)->i.concat(s+" * "))).forEach(System.out::println);
            //                //                inputStream.lines().forEach(System.out::println);
            //            } catch (IOException e) {
            //                e.printStackTrace();
            //            }
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", "Chrome");
            int responseCode = urlConnection.getResponseCode();
            System.out.println(responseCode);
            urlConnection.setReadTimeout(30000);
            Pattern p = Pattern.compile("<link rel.+?href=\"(.+?\\.jpg)\"");
            //            Matcher m=p.matcher("<link rel=\"enclosure\" " +
            //                    "type=\"image/jpeg\" " +
            //                    "href=\"https://live.staticflickr.com/65535/48788081337_b18fcca3df_b.jpg\" />");
            //            m.matches()
            try (BufferedReader inputStream =
                         new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                inputStream.lines().map(p::matcher).filter(Matcher::find).forEach(m -> System.out.println(m.group(1)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
