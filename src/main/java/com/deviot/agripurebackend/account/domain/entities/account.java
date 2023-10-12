package com.deviot.agripurebackend.account.domain.entities;
import com.deviot.agripurebackend.account.domain.valueObjects.Email;
import com.deviot.agripurebackend.account.domain.valueObjects.Password;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//https://github.com/upc-pre-202302-si730-sw52/ACME.LearningPlatform.API
import javax.persistence.*;


@NoArgsConstructor
@Table(name="accounts")
public class account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(nullable = false)
    private Email account_email;

    @Embedded
    @Column(nullable = false)
    private Password account_password;

    public account(String email,String password){
        account_email=new Email(email);
        account_password=new Password(password);
    }

    public void changeEmail(String email){
        account_email=new Email(email);
    }

    public void changePassword(String password){
        account_password=new Password(password);
    }

    public String getEmail(){
        return account_email.email();
    }

    public String getPassword(){
        return account_password.password();
    }
}
