package app.herospin.hero.model;
import java.io.Serializable;
import java.util.List;

import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
public class Data implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -782924046055535250L;
	
	private int offset;

	private int limit;

	private int total;

	private int count;

	private List<Results> results;

}
