package app.herospin.hero.model;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Events implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4405076823423082224L;

	private int available;

	private String collectionURI;

	private List<Object> items;

	private int returned;

}
