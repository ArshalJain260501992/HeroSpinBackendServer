package app.herospin.movie.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Production_countries implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6177943754543593462L;

	private String iso_3166_1;

	private String name;
}