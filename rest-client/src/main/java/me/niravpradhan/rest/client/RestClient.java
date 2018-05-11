package me.niravpradhan.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Map;
import java.util.Objects;

/**
 * A Rest Client
 * @author NP00473521
 */
public class RestClient {

    private Client client = Client.create();

    public <T> T get(String url, Map<String, String> headers, Map<String, String> queryParams, int status, Class<T> classType) {
        WebResource wr = createWebResource(url);
        if(Objects.nonNull(headers) && !headers.isEmpty()) {
            headers.forEach((k, v) -> wr.header(k, v));
        }
        if(Objects.nonNull(queryParams) && !queryParams.isEmpty()) {
            MultivaluedMap mvm = new MultivaluedMapImpl();
            queryParams.forEach(mvm::put);
            wr.queryParams(mvm);
        }
        ClientResponse clientResponse = wr.get(ClientResponse.class);
        handleException(clientResponse, status);
        return clientResponse.getEntity(classType);
    }

    public <T> T post(String url, Map<String, String> headers, int status, Class<T> classType, T t) {
        WebResource wr = createWebResource(url);
        if(Objects.nonNull(headers) && !headers.isEmpty()) {
            headers.forEach((k, v) -> wr.header(k, v));
        }
        ClientResponse clientResponse = wr.post(ClientResponse.class, t);
        handleException(clientResponse, status);
        return clientResponse.getEntity(classType);
    }

    private void handleException(ClientResponse clientResponse, int status) {
        if(clientResponse.getStatus() != status) {
            throw new RuntimeException("Failed : HTTP error code : " + clientResponse.getStatus());
        }
    }

    private WebResource createWebResource(String url) {
        return client.resource(url);
    }
}
