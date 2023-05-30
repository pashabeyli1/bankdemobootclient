package az.orient.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespAccount {

    private Long id;
    private String name;
    private String accountNo;
    private String iban;
    private String currency;
    private Integer branchCode;
    private RespCustomer respCustomer;

}
