package az.orient.client.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {

    @JsonProperty(value = "response")
    private T t;
    private RespStatus status;

}
