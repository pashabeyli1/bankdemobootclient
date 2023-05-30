package az.orient.client.controller;

import az.orient.client.dto.response.RespAccount;
import az.orient.client.dto.response.RespCustomer;
import az.orient.client.dto.response.Response;
import az.orient.client.service.AccountService;
import az.orient.client.service.CustomerService;
import az.orient.client.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final AccountService accountService;

    private final CustomerService customerService;

    @GetMapping({"/","/GetCustomerList"})
    public ModelAndView getCustomerList() {
        ModelAndView model = new ModelAndView("index");
        Response<List<RespCustomer>> result = customerService.getCustomerList();
        if (result.getStatus().getCode() == 1) {
            model.addObject("result",result.getT());
        } else {
            model.addObject("msg",result.getStatus().getMessage());
        }
        return model;
    }


    @GetMapping("/GetAccountList/{customerId}")
    public ModelAndView getAccountList(@PathVariable Long customerId) {
        ModelAndView model = new ModelAndView("account");
        Response<List<RespAccount>> result = accountService.getAccountList(customerId);
        if (result.getStatus().getCode() == 1) {
            model.addObject("result",result.getT());
        } else {
            model.addObject("msg",result.getStatus().getMessage());
        }
        return model;
    }


}
