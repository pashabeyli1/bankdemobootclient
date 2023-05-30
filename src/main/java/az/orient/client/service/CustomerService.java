package az.orient.client.service;

import az.orient.client.dto.response.RespCustomer;
import az.orient.client.dto.response.Response;

import java.util.List;

public interface CustomerService {

     Response<List<RespCustomer>> getCustomerList();


}
