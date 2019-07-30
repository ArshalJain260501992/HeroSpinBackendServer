package app.herospin.movie.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Belongs_to_collection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7717629331745630598L;

	private String backdrop_path;

	private String name;

	private String id;

	private String poster_path;
}