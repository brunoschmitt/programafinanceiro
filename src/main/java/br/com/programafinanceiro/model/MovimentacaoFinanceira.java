package br.com.programafinanceiro.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class MovimentacaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double valor;
    private TipoValor tipoValor;
    private TipoMovimentacao tipo;

    @ManyToOne
    @JoinColumn(name = "conta_numeroconta")
    private Conta conta;

    @DateTimeFormat
    private Date data;

    private String descricao;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoValor getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(TipoValor tipoValor) {
        this.tipoValor = tipoValor;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "MovimentacaoFinanceira [id=" + id + ", valor=" + valor + ", tipoValor=" + tipoValor + ", tipo=" + tipo
                + ", data=" + data + ", descricao=" + descricao + ", getId()=" + getId() + ", getValor()=" + getValor()
                + ", getTipoValor()=" + getTipoValor() + ", getTipo()=" + getTipo() + ", getData()=" + getData()
                + ", getDescricao()=" + getDescricao() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }
}
