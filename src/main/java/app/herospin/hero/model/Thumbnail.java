package app.herospin.hero.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Thumbnail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6244564613949085450L;

	private String path;

	private String extension;

}
