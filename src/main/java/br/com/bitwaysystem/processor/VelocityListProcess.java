package br.com.bitwaysystem.processor;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.*;
import org.apache.velocity.app.*;

public class VelocityListProcess
{
	public static void main(String args[]) throws Exception
	{
		// inicializando o velocity
		VelocityEngine ve = new VelocityEngine();
		ve.init();

		// criando o contexto que liga o java ao template
		VelocityContext context = new VelocityContext();

		// escolhendo o template
		Template t = ve.getTemplate("template1.vm");
	
		// variavel que sera acessada no template:
		List<String> list = new ArrayList<String>();
		list.add("Item 1");
		list.add("Item 2");
		list.add("Item 3");
		list.add("Item 4");
		list.add("Item 5");
		
		context.put("lista", list);	
		StringWriter writer = new StringWriter();
	
		t.merge(context, writer);

		System.out.println(writer.toString());
	}
}
