package Library;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="zirayetciler")
@Cacheable
@Cache(region="Visitor", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Visitor {

	@Id
	private int ziyaretciId;
	
	
	private String ziyIsim;
	
	
	private int kitapSayi;
	
	@OneToMany(mappedBy = "ziy")
	private List<Books> kitapBilgiZyr=new ArrayList<>();
	
	
	public Visitor() {}

	public Visitor(int ziyaretciId, String ziyIsim, int kitapSayi) {
		
		this.ziyaretciId = ziyaretciId;
		this.ziyIsim = ziyIsim;
		this.kitapSayi = kitapSayi;
	}

	public int getZiyaretciId() {
		return ziyaretciId;
	}

	public void setZiyaretciId(int ziyaretciId) {
		this.ziyaretciId = ziyaretciId;
	}

	public String getZiyIsim() {
		return ziyIsim;
	}

	public void setZiyIsim(String ziyIsim) {
		this.ziyIsim = ziyIsim;
	}

	public int getKitapSayi() {
		return kitapSayi;
	}

	public void setKitapSayi(int kitapSayi) {
		this.kitapSayi = kitapSayi;
	}

	public List<Books> getKitapBilgiZyr() {
		return kitapBilgiZyr;
	}

	public void setKitapBilgiZyr(List<Books> kitapBilgiZyr) {
		this.kitapBilgiZyr = kitapBilgiZyr;
	}

	@Override
	public String toString() {
		return "Visitor [ziyaretciId=" + ziyaretciId + ", ziyIsim=" + ziyIsim + ", kitapSayi=" + kitapSayi
				+ ", kitapBilgiZyr=" + kitapBilgiZyr + "]";
	}

	


	
	
	
}
