package leitorLivros;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class leitorLivros {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		int totalEstq = 0;
		float totalValor = 0;
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder construtor = fabrica.newDocumentBuilder();
		Document documento = construtor.parse("livros.xml");

		System.out.println("Estoque de livros disponíveis");
				
		NodeList livros = documento.getElementsByTagName("livro");
		
		for(int i = 0; i < livros.getLength(); i++) {
			
			Element item = (Element) livros.item(i);
			NamedNodeMap atributos = item.getAttributes();
			
			String editora = atributos.item(0).getNodeValue();
			String titulo = item.getElementsByTagName("titulo").item(0).getTextContent();
			String autor = item.getElementsByTagName("autor").item(0).getTextContent();
			String genero = item.getElementsByTagName("genero").item(0).getTextContent();
			String preco = item.getElementsByTagName("preco").item(0).getTextContent();
			String estoque = item.getElementsByTagName("estoque").item(0).getTextContent();
			System.out.println("\nEditora: " + editora + "\nTítulo:" + titulo + "\nAutor: " + autor + "\nGênero: " + genero + "\nPreço: " + preco + "\nEstoque: " + estoque);
			
			totalEstq = totalEstq + Integer.parseInt(estoque);
			totalValor = totalValor + Float.parseFloat(preco);
		}
		
		System.out.println("\nTotal de livros em estoque: " + totalEstq);
		System.out.println("\nValor total dos livros em estoque: " + totalValor);
	}

}
