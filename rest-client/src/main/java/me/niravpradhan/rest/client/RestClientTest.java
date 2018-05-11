package me.niravpradhan.rest.client;

import me.niravpradhan.common.Account;

import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RestClientTest {
    public static void main(String[] args) {
        RestClient rc = new RestClient();

        Account account = new Account("Nirav Pradhan", new Date(), 50000);

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", MediaType.APPLICATION_JSON);
        headers.put("Content-Type", MediaType.APPLICATION_JSON);
        account = rc.post("http://localhost:8080/rest-server-1.0-SNAPSHOT/rest-resources/HelloWorld", headers, 200, Account.class, account);
        System.out.printf("%s%n", account);
    }
}
