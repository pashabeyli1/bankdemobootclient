package az.orient.client.dto.response;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespCustomer {

    private Long customerId;
    private String name;
    private String surname;
    private String address;
    private String pin;
    private String seria;
    private Date dob;
    private String phone;
    private String cif;

}
