package az.orient.client.service.impl;

import az.orient.client.dto.response.RespAccount;
import az.orient.client.dto.response.RespCustomer;
import az.orient.client.dto.response.Response;
import az.orient.client.service.AccountService;
import az.orient.client.util.Utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:config.properties")
public class AccountServiceImpl implements AccountService {

    private final Utility utility;

    @Value("${api.url}")
    private String apiUrl;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response<List<RespAccount>> getAccountList(Long customerId) {
        Response<List<RespAccount>> response = null;
        try {
            String url = apiUrl+"account/GetAccountListByCustomerId/"+customerId;
            String result = utility.sendGet(url);
            response = objectMapper.readValue(result, new TypeReference<Response<List<RespAccount>>>() {});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
