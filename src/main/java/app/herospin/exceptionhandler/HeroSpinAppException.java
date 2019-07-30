package app.herospin.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class HeroSpinAppException extends Exception {

	/**
	 * Default Serialization ID
	 */
	private static final long serialVersionUID = 1L;

	@NonNull
	final String errorMessage;

}
