package br.com.programafinanceiro.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.programafinanceiro.model.MovimentacaoFinanceira;

@Component
public class MovimentacaoValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MovimentacaoFinanceira.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valor", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "data", "field.required");

	}

}
