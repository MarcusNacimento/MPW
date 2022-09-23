package model;
// Generated 25/09/2017 16:05:29 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Peca generated by hbm2java
 */
@Entity
@Table(name = "peca")
public class Peca implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_peca;
    private Integer Id_tipo_peca;
    private Integer Id_loja;
    private Integer id_perfil;

    private String Nome;
    private String Certificado;
    private String Potencia;
    private Float Preco;
    private String Geracao;
    private String Tamanho_gabinete;
    private String Consumo;
    private Integer Nucleos;
    private String Chipset;
    private String Armazenamento;
    private String Clock_processador;
    private String Rpm;
    private String Cor;
    private String Socket_placa_mae;
    private String Socket_mem_ram;
    private String Capacidade_ram;
    private Integer Qnt_slot_mem;
    private Integer mem_max_placa_mae;
    private Integer Memoria_maxima_arm;

    public Peca() {
    }

    public Peca(Integer id_tipo_peca) {
        this.Id_tipo_peca = id_tipo_peca;
    }

    public Integer getId_peca() {
        return id_peca;
    }

    public void setId_peca(Integer id_peca) {
        this.id_peca = id_peca;
    }

    public Integer getId_tipo_peca() {
        return Id_tipo_peca;
    }

    public void setId_tipo_peca(Integer Id_tipo_peca) {
        this.Id_tipo_peca = Id_tipo_peca;
    }

    public Integer getId_loja() {
        return Id_loja;
    }

    public void setId_loja(Integer Id_loja) {
        this.Id_loja = Id_loja;
    }

    public Integer getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Integer id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCertificado() {
        return Certificado;
    }

    public void setCertificado(String Certificado) {
        this.Certificado = Certificado;
    }

    public String getPotencia() {
        return Potencia;
    }

    public void setPotencia(String Potencia) {
        this.Potencia = Potencia;
    }

    public Float getPreco() {
        return Preco;
    }

    public void setPreco(Float Preco) {
        this.Preco = Preco;
    }

    public String getGeracao() {
        return Geracao;
    }

    public void setGeracao(String Geracao) {
        this.Geracao = Geracao;
    }

    public String getTamanho_gabinete() {
        return Tamanho_gabinete;
    }

    public void setTamanho_gabinete(String Tamanho_gabinete) {
        this.Tamanho_gabinete = Tamanho_gabinete;
    }

    public String getConsumo() {
        return Consumo;
    }

    public void setConsumo(String Consumo) {
        this.Consumo = Consumo;
    }

    public Integer getNucleos() {
        return Nucleos;
    }

    public void setNucleos(Integer Nucleos) {
        this.Nucleos = Nucleos;
    }

    public String getChipset() {
        return Chipset;
    }

    public void setChipset(String Chipset) {
        this.Chipset = Chipset;
    }

    public String getArmazenamento() {
        return Armazenamento;
    }

    public void setArmazenamento(String Armazenamento) {
        this.Armazenamento = Armazenamento;
    }

    public String getClock_processador() {
        return Clock_processador;
    }

    public void setClock_processador(String Clock_processador) {
        this.Clock_processador = Clock_processador;
    }

    public String getRpm() {
        return Rpm;
    }

    public void setRpm(String Rpm) {
        this.Rpm = Rpm;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public String getSocket_placa_mae() {
        return Socket_placa_mae;
    }

    public void setSocket_placa_mae(String Socket_placa_mae) {
        this.Socket_placa_mae = Socket_placa_mae;
    }

    public String getSocket_mem_ram() {
        return Socket_mem_ram;
    }

    public void setSocket_mem_ram(String Socket_mem_ram) {
        this.Socket_mem_ram = Socket_mem_ram;
    }

    public String getCapacidade_ram() {
        return Capacidade_ram;
    }

    public void setCapacidade_ram(String Capacidade_ram) {
        this.Capacidade_ram = Capacidade_ram;
    }

    public Integer getQnt_slot_mem() {
        return Qnt_slot_mem;
    }

    public void setQnt_slot_mem(Integer Qnt_slot_mem) {
        this.Qnt_slot_mem = Qnt_slot_mem;
    }

    public Integer getMemoria_maxima_arm() {
        return Memoria_maxima_arm;
    }

    public void setMemoria_maxima_arm(Integer Memoria_maxima_arm) {
        this.Memoria_maxima_arm = Memoria_maxima_arm;
    }

    public Integer getMem_max_placa_mae() {
        return mem_max_placa_mae;
    }

    public void setMem_max_placa_mae(Integer mem_max_placa_mae) {
        this.mem_max_placa_mae = mem_max_placa_mae;
    }

}
