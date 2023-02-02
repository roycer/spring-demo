package pe.gob.contraloria.demo.persistence.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SSC_ABD_MENU")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CMEN_CODIGO", unique=true, nullable=false, precision=40)
	private String code;
	
	@Column(name="CPER_CODIGO", nullable=false, precision=8)
	private String codeAllow;
	
	@Column(name="CMEN_CODINTERNO", nullable=false, precision=40)
	private String codeIntern;
	
	@Column(name="CMEN_NOMBRE", nullable=false, length=100)
	private String name;
	
	@Column(name="CMEN_ORDEN", nullable=false)
	private Integer order;
	
	@Column(name="CMEN_ESTADO", nullable=false, precision=1)
	private String state;
	
	@Column(name="DMEN_FEC_ELI", nullable=true)
	private Timestamp deleted;
	
	public Menu() {
		super();
	}

	@Override
	public String toString() {
		return "Menu [code=" + code + ", codeAllow=" + codeAllow + ", codeIntern=" + codeIntern + ", name=" + name
				+ ", order=" + order + ", state=" + state + ", deleted=" + deleted + "]";
	}

	public String getCodeAllow() {
		return codeAllow;
	}

	public void setCodeAllow(String codeAllow) {
		this.codeAllow = codeAllow;
	}

	public String getCodeIntern() {
		return codeIntern;
	}

	public void setCodeIntern(String codeIntern) {
		this.codeIntern = codeIntern;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Timestamp getDeleted() {
		return deleted;
	}

	public void setDeleted(Timestamp deleted) {
		this.deleted = deleted;
	}


	
	
	
	
}

