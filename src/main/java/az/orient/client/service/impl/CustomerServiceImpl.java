package az.orient.client.service.impl;

import az.orient.client.dto.request.ReqLogin;
import az.orient.client.dto.response.RespCustomer;
import az.orient.client.dto.response.RespUser;
import az.orient.client.dto.response.Response;
import az.orient.client.service.CustomerService;
import az.orient.client.service.UserService;
import az.orient.client.util.Utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:config.properties")
public class CustomerServiceImpl implements CustomerService {


    private final Utility utility;

    private final UserService userService;

    @Value("${api.url}")
    private String apiUrl;

    @Value("${api.usr}")
    private String apiUsr;

    @Value("${api.pwd}")
    private String apiPwd;

    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public Response<List<RespCustomer>> getCustomerList() {
        Response<List<RespCustomer>> resp = new Response<>();
        try {
            ReqLogin reqLogin = new ReqLogin();
            reqLogin.setUsername(apiUsr);
            reqLogin.setPassword(apiPwd);
            String reqLoginJson = objectMapper.writeValueAsString(reqLogin);
            String result = utility.sendPost(apiUrl+"user/login",reqLoginJson);
            Response<RespUser> response = objectMapper.readValue(result,new TypeReference<Response<RespUser>>() {});
            if (response.getStatus().getCode() != 1) {
                resp.setStatus(response.getStatus());
                return resp;
            }
            String reqTokenJson = objectMapper.writeValueAsString(response.getT().getRespToken());
            String customerListResult = utility.sendPost(apiUrl+"customer/GetCustomerList",reqTokenJson);
            resp = objectMapper.readValue(customerListResult, new TypeReference<Response<List<RespCustomer>>>() {});
            System.out.println(resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp;
    }
}
