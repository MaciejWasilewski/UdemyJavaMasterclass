package com.example.mwasilewski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

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
            URL url = new URL("https://example.org");
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
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            try (BufferedReader inputStream =
                         new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                inputStream.lines().forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
