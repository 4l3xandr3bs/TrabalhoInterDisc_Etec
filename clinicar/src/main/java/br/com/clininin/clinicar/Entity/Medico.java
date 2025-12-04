package br.com.clininin.clinicar.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     
    private Integer idMedico;
    @Column(nullable = false, length = 40)
    private String nomeMedico;
     @Column(nullable = false, length = 40)
    private String especialMedico;
    @Column(nullable = false, length = 6)
    private Integer crmMedico;
}
