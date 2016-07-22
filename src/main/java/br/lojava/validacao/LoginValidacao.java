package br.lojava.validacao;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("login.UsuarioValidator")
public class LoginValidacao implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		
		String nome = (String) arg2;
		nome = nome.trim();
		
		if (nome == null || nome.isEmpty()){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de validação", " Nome precisa ser preenchido"));
		}
		
		if (arg2.equals("Joao")){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de validação", arg2 + " Não é um e-mail válido;"));
		}
		
	}

}
