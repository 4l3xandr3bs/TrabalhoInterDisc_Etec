package br.com.clininin.clinicar.dto;
import java.time.LocalDateTime;

public class ConsultaDisp {
 
    private Integer idCliente;
    private  Integer idMedico;
    private LocalDateTime datahoraConsulta;
    private String tipoConsulta;
    public ConsultaDisp(String tipoConsulta, LocalDateTime  datahoraConsulta, Integer idCliente,Integer idMedico) {
        this.datahoraConsulta = datahoraConsulta;
        this.tipoConsulta = tipoConsulta;
        this.idCliente = idCliente;
        this.idMedico = idMedico;
    }
    public String getTipoConsulta() {
        return tipoConsulta;
    }
    public LocalDateTime  getDatahoraConsulta() {
        return datahoraConsulta;
    }
    public Integer getIdMedico() {
        return idMedico;
    }
    public Integer getIdCliente() {
        return idCliente;
    }

}
