package app.herospin.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class HeroSpinAppException extends Exception {

	/**
	 * Default Serialization ID
	 */
	private static final long serialVersionUID = 1L;

	@NonNull
	final String errorMessage;
}
