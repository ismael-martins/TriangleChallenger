package br.com.conquest1.b2w.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.conquest1.b2w.controller.TriangleController;

@RestController
public class TriangleResource {

	@RequestMapping(value = "/triangle/{values}", method = RequestMethod.GET)
    public int calculateMaximumTriangleValue(@PathVariable(value="values") String values) {

		int retorno = 0;
    	
		TriangleController controller = new TriangleController();
		retorno = controller.calculateTriangle(values);
    	
        return retorno;
    }
}
