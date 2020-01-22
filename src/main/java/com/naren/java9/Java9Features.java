package com.naren.java9;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Set;

public class Java9Features {

    public static void main(String...a) throws Exception
    {
        Set<String> stringSet = Set.of("","");
        List<String> stringList = List.of("","");

        //HTTP client
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder(URI.create("http://www.google.com")).header("User-Agent","Java").GET().build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
    }
}


//Private method in interface
interface I {
    private void call(){

    }
}
