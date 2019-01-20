package com.udemy.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.util.ArrayList;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class tciTest implements FilenameFilter {
	/* obtener lista con filtro */
	String extension;
	tciTest(String extension) {
		this.extension = extension;
	}

	public static void main(String[] args) {
		convertBytetoString();
	}

	static void convertBytetoString() {
		File fichero = new File("D:/software/test/archivito.txt");

		/* Leer un file a Byte */
		StringBuilder sb = new StringBuilder();
		byte[] byteFile = new byte[(int) fichero.length()];
					
		try {
			FileInputStream fileInputStream = new FileInputStream(fichero);
			fileInputStream.read(byteFile);
			
			for(int i=0;i<byteFile.length;i++) {
				sb.append(byteFile[i]+" ");
			}
			System.out.println("BYTE2: "+sb);
						
			for (int i = 0; i < byteFile.length; i++) {
				System.out.print((char) byteFile[i]);
			}
			System.out.println("");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Error Reading The File.");
			e1.printStackTrace();
		}
		/* Fin - /*Leer un file a Byte */
		
		
		/*Capturar VALORES byte*/
		
		for(int i=0;i<byteFile.length;i++) {
			sb.append(byteFile[i]+" ");
		}
		System.out.println("BYTE: "+sb);
		
		ArrayList<Object> arraylist =  new ArrayList<Object>();
		for(byte b : byteFile) {
			  arraylist.add(new Byte(b));
			}
		System.out.println("arraylist"+arraylist);
		/*Fin - Capturar VALORES byte*/

		/* Utilitario File*/
		if (fichero.exists()) {
			System.out.println(" ");
			System.out.println("Nombre del archivo " + fichero.getName());
			System.out.println("Camino             " + fichero.getPath());
			System.out.println("Camino absoluto    " + fichero.getAbsolutePath());
			System.out.println("Se puede escribir  " + fichero.canRead());
			System.out.println("Se puede leer      " + fichero.canWrite());
			System.out.println("Tamaño             " + fichero.length());
			System.out.println("");
		}
		File fichero2 = new File("D:/software/test/");
		String[] listaArchivos = fichero2.list();
		for (int i = 0; i < listaArchivos.length; i++) {
			System.out.println(listaArchivos[i]);
		}
		System.out.println("");

		listaArchivos = fichero2.list(new tciTest(".docx"));
		for (int i = 0; i < listaArchivos.length; i++) {
			System.out.println(listaArchivos[i]);
		}
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}
	/*Fin - Utilitario File*/
}
