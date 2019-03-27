package br.com.programafinanceiro.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.programafinanceiro.model.Usuario;

@Component
public class UsuarioValidation implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "login", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senha", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "nome","field.required");

	}

}
