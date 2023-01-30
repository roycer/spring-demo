package pe.gob.contraloria.demo.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "BLD_MENU")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NMEN_CODIGO", unique=true, nullable=false, precision=10)
	@JsonProperty("id")
	private long nmenCodigo;
	
	@Column(name="NPER_CODIGO", nullable=true, precision=10)
	@JsonProperty("code")
	private long nperCodigo;
	
	@Column(name="CMEN_NOMBRE", nullable=false, length=50)
	@JsonProperty("name")
	private String cmenNombre;
	
	@Column(name="CMEN_ASOCIADO", nullable=true, length=200)
	@JsonProperty("associate")
	private String cmenAsociado;
	
	@Column(name="CMEN_SEQUENCIA", nullable=true, precision=10)
	@JsonProperty("order")
	private long cmenSecuencia;
	
	@Column(name="CMEN_ICONO", nullable=true, length=400)
	@JsonProperty("image")
	private String cmenIcono;
	
	@Column(name="CMEN_VINCULO", nullable=true, length=200)
	@JsonProperty("link")
	private String cmenVinculo;
	
	@Column(name="CMEN_ESTADO", nullable=true, length=1)
	@JsonProperty("allow")
	private String cmenEstado;

	public Menu() {
		super();
	}

	public Menu(long nmenCodigo, long nperCodigo, String cmenNombre, String cmenAsociado, long cmenSecuencia,
			String cmenIcono, String cmenVinculo, String cmenEstado) {
		super();
		this.nmenCodigo = nmenCodigo;
		this.nperCodigo = nperCodigo;
		this.cmenNombre = cmenNombre;
		this.cmenAsociado = cmenAsociado;
		this.cmenSecuencia = cmenSecuencia;
		this.cmenIcono = cmenIcono;
		this.cmenVinculo = cmenVinculo;
		this.cmenEstado = cmenEstado;
	}

	@Override
	public String toString() {
		return "BldMenu [nmenCodigo=" + nmenCodigo + ", nperCodigo=" + nperCodigo + ", cmenNombre=" + cmenNombre
				+ ", cmenAsociado=" + cmenAsociado + ", cmenSecuencia=" + cmenSecuencia + ", cmenIcono=" + cmenIcono
				+ ", cmenVinculo=" + cmenVinculo + ", cmenEstado=" + cmenEstado + "]";
	}

	public long getNmenCodigo() {
		return nmenCodigo;
	}

	public void setNmenCodigo(long nmenCodigo) {
		this.nmenCodigo = nmenCodigo;
	}

	public long getNperCodigo() {
		return nperCodigo;
	}

	public void setNperCodigo(long nperCodigo) {
		this.nperCodigo = nperCodigo;
	}

	public String getCmenNombre() {
		return cmenNombre;
	}

	public void setCmenNombre(String cmenNombre) {
		this.cmenNombre = cmenNombre;
	}

	public String getCmenAsociado() {
		return cmenAsociado;
	}

	public void setCmenAsociado(String cmenAsociado) {
		this.cmenAsociado = cmenAsociado;
	}

	public long getCmenSecuencia() {
		return cmenSecuencia;
	}

	public void setCmenSecuencia(long cmenSecuencia) {
		this.cmenSecuencia = cmenSecuencia;
	}

	public String getCmenIcono() {
		return cmenIcono;
	}

	public void setCmenIcono(String cmenIcono) {
		this.cmenIcono = cmenIcono;
	}

	public String getCmenVinculo() {
		return cmenVinculo;
	}

	public void setCmenVinculo(String cmenVinculo) {
		this.cmenVinculo = cmenVinculo;
	}

	public String getCmenEstado() {
		return cmenEstado;
	}

	public void setCmenEstado(String cmenEstado) {
		this.cmenEstado = cmenEstado;
	}
	
	
	
}

