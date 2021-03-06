package it.uniroma3.siw.taskmanager.controller.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.taskmanager.model.Project;

@Component
public class ProjectValidator implements Validator {
	
	
	final Integer MAX_NAME_LENGTH = 100;
    final Integer MIN_NAME_LENGTH = 2;
    final Integer MAX_DESC_LENGTH = 100;
	@Override
	public void validate(Object o,Errors errors) {
		Project project=(Project)o;
		String nome=project.getNome().trim();
		String description= project.getDescription();
		if(nome.isBlank())
			errors.rejectValue("nome","required");
		if(nome.length()< MIN_NAME_LENGTH || nome.length()>MAX_NAME_LENGTH)
			errors.rejectValue("nome","size");
		if(description.length()>MAX_DESC_LENGTH)
			errors.rejectValue("description", "size");
		
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.equals(clazz)
;	}

}
