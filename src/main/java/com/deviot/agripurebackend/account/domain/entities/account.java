package com.deviot.agripurebackend.account.domain.entities;
import com.deviot.agripurebackend.account.domain.valueObjects.email;
import com.deviot.agripurebackend.account.domain.valueObjects.password;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//https://github.com/upc-pre-202302-si730-sw52/ACME.LearningPlatform.API
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="accounts")
public class account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(nullable = false)
    private email account_email;

    @Embedded
    @Column(nullable = false)
    private password account_password;
}
