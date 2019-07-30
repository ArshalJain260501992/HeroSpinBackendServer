package app.herospin.hero.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Urls implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1948470327334715920L;

	private String type;
	
	private String url;

}
