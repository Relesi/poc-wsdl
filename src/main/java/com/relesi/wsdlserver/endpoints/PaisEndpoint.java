package com.relesi.wsdlserver.endpoints;


import com.relesi.wsdlserver.assets.GetPaisRequest;
import com.relesi.wsdlserver.assets.GetPaisResponse;
import com.relesi.wsdlserver.repositories.PaisRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaisEndpoint {
    private static final String NAMESPACE_URI = "http://relesi.com/wsdlserver/assets";

    private final PaisRepository paisRepository;

    public PaisEndpoint(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisRequest")
    @ResponsePayload
    public GetPaisResponse getCountry(@RequestPayload GetPaisRequest request) {
        GetPaisResponse response = new GetPaisResponse();
        response.setPais(paisRepository.buscarPorPais(request.getNome()));

        return response;
    }
}
