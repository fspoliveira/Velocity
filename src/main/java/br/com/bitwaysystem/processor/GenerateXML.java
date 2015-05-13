package br.com.bitwaysystem.processor;

import java.io.StringWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class GenerateXML
{
    public static void main( String[] args )
        throws Exception
    {
        /*
         *   first, get and initialize an engine
         */

        VelocityEngine ve = new VelocityEngine();
        ve.init();

        /*
         *   organize our data 
         */

        ArrayList<Map> list = new ArrayList<Map>();
        Map<String, String> map = new HashMap<String, String>();

        map.put("name", "Cow");
        map.put("price", "$100.00");
        list.add( map );
 
        map = new HashMap<String, String>();
        map.put("name", "Eagle");
        map.put("price", "$59.99");
        list.add( map );

        map = new HashMap<String, String>();
        map.put("name", "Shark");
        map.put("price", "$3.99");
        list.add( map );

        /*
         *  add that list to a VelocityContext
         */

        VelocityContext context = new VelocityContext();
        context.put("petList", list);

        /*
         *   get the Template  
         */

        Template t = ve.getTemplate( "generateXML.vm" );

        /*
         *  now render the template into a Writer, here 
         *  a StringWriter 
         */

        StringWriter writer = new StringWriter();

        t.merge( context, writer );

        /*
         *  use the output in the body of your emails
         */

        System.out.println( writer.toString() );
    }
}
