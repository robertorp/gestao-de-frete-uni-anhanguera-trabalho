package br.com.ads.gestaodefrete.converters;
import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.ads.gestaodefrete.controle.CategoriaVeiculoControle;
import br.com.ads.gestaodefrete.fabricas.FabricaControle;
import br.com.ads.gestaodefrete.modelo.CategoriaVeiculo;

@FacesConverter(forClass = CategoriaVeiculo.class)
public class CategoriaVeiculoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		CategoriaVeiculo categoriaVeiculo = null;
		
		if(value != null && value.trim().length() > 0) {
			Integer idCategoriaVeiculo = Integer.valueOf(value);
			try {
				CategoriaVeiculoControle categoriaVeiculoControle = FabricaControle.getCategoriaVeiculoControle();
				categoriaVeiculo = categoriaVeiculoControle.buscar(idCategoriaVeiculo);
				categoriaVeiculoControle.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
		return categoriaVeiculo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		CategoriaVeiculo categoriaVeiculo = (CategoriaVeiculo) value;

		if(categoriaVeiculo.getId() == null) {
			return "";
		}
		
		return categoriaVeiculo.getId().toString();
	}

}
