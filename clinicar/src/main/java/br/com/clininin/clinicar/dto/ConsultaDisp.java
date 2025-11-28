package br.com.clininin.clinicar.dto;

import java.time.LocalDateTime;

public class ConsultaDisp {
    private LocalDateTime datahoraConsulta;
    private String tipoConsulta;
    public ConsultaDisp(String tipoConsulta, LocalDateTime  datahoraConsulta) {
        this.datahoraConsulta = datahoraConsulta;
        this.tipoConsulta = tipoConsulta;
    }
    public String getTipoConsulta() {
        return tipoConsulta;
    }
    public LocalDateTime  getDatahoraConsulta() {
        return datahoraConsulta;
    }
    public Integer getMedicoId() {
        return null;
    }
    public Integer getClienteId() {
        return null;
    }

}
