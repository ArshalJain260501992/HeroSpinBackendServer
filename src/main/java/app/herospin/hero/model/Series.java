package app.herospin.hero.model;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Series implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4281156533716828102L;

	private int available;

	private String collectionURI;

	private List<Items> items;

	private int returned;

}
