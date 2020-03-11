import java.awt.Point;
import java.io.File;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Yijian Hu
 */
public class FileManager {
	
	public void save(File file, Hashtable<Integer, JButton> shapes) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("shapes");
			doc.appendChild(rootElement);
			for(int key:shapes.keySet()) {
				Element shape = doc.createElement("shape");
				rootElement.appendChild(shape);
				shape.setAttribute("id",Integer.toString(key));
				JButton theShape = shapes.get(key);
				Element type = doc.createElement("type");
				/*
				if(theShape instanceof RoundButton) {
					type.appendChild(doc.createTextNode("round"));
				}
				else if(theShape instanceof RectangleButton) {
					type.appendChild(doc.createTextNode("rectangle"));
				}
				else { //TriangleButton
					type.appendChild(doc.createTextNode("triangle"));
				}
				Element position = doc.createElement("position");
				position.appendChild(doc.createTextNode(theShape.getLocation().x + ","+theShape.getLocation().y));
				shape.appendChild(type);
				shape.appendChild(position);*/
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ShapeInfo[] open(File file) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			doc.getDocumentElement().normalize();   
			NodeList nodeList = doc.getElementsByTagName("shape");
			ShapeInfo[] shapes = new ShapeInfo[nodeList.getLength()];
			for(int i = 0;i < nodeList.getLength();i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {  
					Element shapeElement = (Element) node;
					int id = Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue());
					String points[] = shapeElement.getElementsByTagName("position").item(0).getTextContent().split(",");
					Point position = new Point(Integer.parseInt(points[0]),Integer.parseInt(points[1]));
					String type = shapeElement.getElementsByTagName("type").item(0).getTextContent();
					shapes[i]=new ShapeInfo(id,type,position);
				}
			}
			return shapes;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
