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
@Table(name="yazarlar")
@Cacheable
@Cache(region="Autor", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Autor {
	
	@Id
	private int yazarId;
	private String yazarIsim;
	
	@OneToMany(mappedBy = "yazar")
	private List<Books> kitapBilgi=new ArrayList<>();
	
	public Autor() {}

	public Autor(int yazarId, String yazarIsim) {
		
		this.yazarId = yazarId;
		this.yazarIsim = yazarIsim;
	}

	public int getYazarId() {
		return yazarId;
	}

	public void setYazarId(int yazarId) {
		this.yazarId = yazarId;
	}

	public String getYazarIsim() {
		return yazarIsim;
	}

	public void setYazarIsim(String yazarIsim) {
		this.yazarIsim = yazarIsim;
	}

	public List<Books> getKitapBilgi() {
		return kitapBilgi;
	}

	public void setKitapBilgi(List<Books> kitapBilgi) {
		this.kitapBilgi = kitapBilgi;
	}

	@Override
	public String toString() {
		return "Autor [yazarId=" + yazarId + ", yazarIsim=" + yazarIsim + ", kitapBilgi=" + kitapBilgi + "]";
	}

}
