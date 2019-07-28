package app.herospin.hero.model;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 385366726045748571L;

	private int available;

	private String collectionURI;

	private List<Items> items;

	private int returned;

}
