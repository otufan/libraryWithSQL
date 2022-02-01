package Library;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="kitaplar")
@Cacheable
@Cache(region="Books", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Books {
	
	@Id
	private int kitapId;
	
	
	private String kitapIsmi;
	
	
	private String kitapDil;
	
	@ManyToOne
	@JoinColumn(name="yazar_ID")
	private Autor yazar;
	
	@ManyToOne
	@JoinColumn(name="ziyaretci_ID")
	private Visitor ziy;
		
	public Books() {}

	public Books(int kitapId, String kitapIsmi, String kitapDil) {
		super();
		this.kitapId = kitapId;
		this.kitapIsmi = kitapIsmi;
		this.kitapDil = kitapDil;
	}

	public int getKitapId() {
		return kitapId;
	}

	public void setKitapId(int kitapId) {
		this.kitapId = kitapId;
	}

	public String getKitapIsmi() {
		return kitapIsmi;
	}

	public void setKitapIsmi(String kitapIsmi) {
		this.kitapIsmi = kitapIsmi;
	}

	public String getKitapDil() {
		return kitapDil;
	}

	public void setKitapDil(String kitapDil) {
		this.kitapDil = kitapDil;
	}

	
	public Autor getYazar() {
		return yazar;
	}

	public void setYazar(Autor yazar) {
		this.yazar = yazar;
	}

	public Visitor getZiy() {
		return ziy;
	}

	public void setZiy(Visitor ziy) {
		this.ziy = ziy;
	}

	@Override
	public String toString() {
		return "Books [kitapId=" + kitapId + ", kitapIsmi=" + kitapIsmi + ", kitapDil=" + kitapDil + "]";
	}
	
	
}
