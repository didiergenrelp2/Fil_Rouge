package co.simplon.filrouge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "arme", 
uniqueConstraints=
@UniqueConstraint(columnNames= {"marque", "modele", "numero_serie"})))
public class Arme extends Objet {

	@Size(max = 100)
	private String calibre;
	@Size(max = 100)
	private String numero_serie;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "arme")
	@JsonIgnore
	private Set<Affaire> affaire = new HashSet<>();

	public Arme() {
		super();
	}

	public Arme(String calibre, String numero_serie) {
		super();
		this.calibre = calibre;
		this.numero_serie = numero_serie;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public String getNumero_serie() {
		return numero_serie;
	}

	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}

}
