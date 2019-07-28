package app.herospin.hero.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Items implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5323015887230994344L;

	private String resourceURI;

	private String name;

	private String type;

}
