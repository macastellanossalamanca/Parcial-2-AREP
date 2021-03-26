package edu.escuelaing.arep.App;

import static spark.Spark.get;
import static spark.Spark.port;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import spark.Request;
import spark.Response;

public class Servicio {


	/**
	 * Main class that starts the main thread of the service.
	 * 
	 * @param args String array
	 */
	public static void main(String[] args) {
		port(getPort());
		get("/atan", (req, res) -> {
			res.type("application/json");
			String ls_res;
			ls_res = "";
			ls_res = computo("atan", Double.parseDouble(req.queryParams("value")));
			return ls_res;

		});
		get("/cos", (req, res) -> {
			res.type("application/json");
			String ls_res;
			ls_res = "";
			ls_res = computo("cos", Double.parseDouble(req.queryParams("value")));
			return ls_res;

		});
	}
	
	/**
	 * Specifies the port on which the service will run.
	 * 
	 * @return The port where the service will be run.
	 */
	public static int getPort() {    
		if (System.getenv("PORT") != null)
		{            
			return Integer.parseInt(System.getenv("PORT"));      
		} 
		return 8080; 
	}
	
	/**
	 * Method in charge of generating the values of the mean and the standard deviation.
	 * 
	 * @param am_model Data that will be passed to the template.
	 * @param ar_req Request received by the server
	 * @param ar_res Server response.
	 * @return Returns if it was possible to calculate the data with the information entered.
	 */
	private static String resultData(Request ar_req, Response ar_res){
		String ls_values;
		String ls_res;
		String ls_opera;
		
		ls_values = ar_req.queryParams("value");
		ls_opera = ar_req.queryParams("operacion");
		if (ls_values == null)
			return "";
		ls_res = computo(ls_opera, Double.parseDouble(ls_values));
		
		
		return ls_res;
	}
	
	public static String computo(String fun, double num) {
		String resultado = "{'Operation': '"+fun+"', \n 'Input': " +num+", \n 'Output': ";
		if (fun.equals("cos")){
			resultado += Double.toString(Math.cos(num));
		} else if (fun.equals("sin")){
			resultado += Double.toString(Math.sin(num));
		} else if (fun.equals("tan")){
			resultado += Double.toString(Math.tan(num));
		} else if (fun.equals("ln")){
			resultado += Double.toString(Math.log(num));
		} else if (fun.equals("log")){
			resultado += Double.toString(Math.log10(num));
		} else if (fun.equals("acos")){
			resultado += Double.toString(Math.acos(num));
		}	else if (fun.equals("asin")){
			resultado += Double.toString(Math.asin(num));
		} else if (fun.equals("atan")){
			resultado += Double.toString(Math.atan(num));
		} else if (fun.equals("sqrt")){
			resultado += Double.toString(Math.sqrt(num));
		} 
		
		resultado += "}";
		
		return resultado;
	}
	
}
