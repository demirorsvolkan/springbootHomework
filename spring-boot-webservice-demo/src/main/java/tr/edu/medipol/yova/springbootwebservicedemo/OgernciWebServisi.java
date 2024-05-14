package tr.edu.medipol.yova.springbootwebservicedemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ogrenci")
public class OgernciWebServisi {
	
	public record Ogrenci (String numara, String name) {}
	
	private static List<Ogrenci> OGRENCILER= new ArrayList<>();
	static {
		OGRENCILER.add(new Ogrenci("1", "Volkan"));
		OGRENCILER.add(new Ogrenci("2", "Esma"));
	}
	@GetMapping("/")
	public List<Ogrenci> listele() {
		return OGRENCILER;
	}
	
	@PostMapping("/")
	public void ekle(Ogrenci yeniOgrenci) {
		OGRENCILER.add(yeniOgrenci);
	}
	
	@DeleteMapping("/{numara}")
	public boolean sil(@PathVariable("numara") String numara) {
		for(Ogrenci ogrenci: OGRENCILER) {
			if(ogrenci.numara.equals(numara)) {
				OGRENCILER.remove(ogrenci);
				return true;

			}
		}
		return false;
	}
}
