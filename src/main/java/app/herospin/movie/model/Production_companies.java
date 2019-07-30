package app.herospin.movie.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Production_companies implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6451008150145357214L;

	private String logo_path;

	private String name;

	private String id;

	private String origin_country;
}