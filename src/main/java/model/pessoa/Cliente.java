package model.pessoa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import contract.models.pessoa.ICliente;
import model.Endereco;

@Entity(name = "Cliente")
@DiscriminatorValue(value = "PessoaCliente")
public class Cliente extends Pessoa implements ICliente {

	@Column(name = "data_cadastro", nullable = true)
	private Date dataCadastro;

	public Cliente() {
	}

	public Cliente(Date dataCadastro, int id, String cpf, String nome, Date dataNascimento, Endereco endereco) {
		super(id, cpf, nome, dataNascimento, endereco);
		this.dataCadastro = dataCadastro;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String toString() {
		return "ID: " + getId() + ", CPF: " + getCpf();
	}
}
