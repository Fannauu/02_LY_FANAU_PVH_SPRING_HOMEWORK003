package org.example.homeowork003.model.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {
    @NotBlank(message = "Attendee name can't be blank")
    @Size(min = 3, max = 10, message = "Characters should be greater than 3 !!!")
    private String attendeeName;
    @NotBlank(message = "Email can't be blank")
    @Email(message = "Email should be valid")
    private String email;
}
