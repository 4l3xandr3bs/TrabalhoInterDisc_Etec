package br.com.clininin.clinicar.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
     
   private Integer idConsulta;
   private LocalDateTime datahoraConsulta;
   @Column(nullable = false, length = 900)
   private String tipoConsulta;

   @ManyToOne
@JoinColumn(name = "idMedico-fk")
private Medico medico;
@ManyToOne
@JoinColumn(name = "idCliente-fk")
private Cliente cliente;
}
