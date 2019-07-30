package app.herospin.hero.model;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Stories implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1801158284482074714L;

	private int available;

	private String collectionURI;

	private List<Items> items;

	private int returned;

}
