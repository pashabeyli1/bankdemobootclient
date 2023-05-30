package az.orient.client.service;

import az.orient.client.dto.response.RespAccount;
import az.orient.client.dto.response.Response;

import java.util.List;

public interface AccountService {

     Response<List<RespAccount>> getAccountList(Long customerId);

}
