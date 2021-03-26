package edu.escuelaing.arep.App;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;




public class App 
{
    
    public static void main(String[] args) {
    	System.out.println(readURL("http://localhost:8080/cos?value=10"));
    	System.out.println(readURL("http://localhost:8080/atan?value=9"));
	}
	
    
    public static String readURL(String as_site) {
		String ls_resData;
		ls_resData = null;
		try {
			URL lu_siteURL;

			lu_siteURL = new URL(as_site);

			if (lu_siteURL != null) {
				URLConnection luc_urlConnection;

				luc_urlConnection = lu_siteURL.openConnection();

				if (luc_urlConnection != null) {
					InputStreamReader lis_input;

					lis_input = new InputStreamReader(luc_urlConnection.getInputStream());

					if (lis_input != null) {
						BufferedReader lbr_reader;

						lbr_reader = new BufferedReader(lis_input);

						if (lbr_reader != null) {
							String ls_line;

							ls_line = null;

							ls_resData = "";

							while ((ls_line = lbr_reader.readLine()) != null)
								ls_resData += ls_line;

						}
					}

				}
			}
			
		} catch (IOException x) {
			ls_resData = "";
			x.printStackTrace();
		}
		
		return ls_resData;
	}
    
}
