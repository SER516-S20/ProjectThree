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

public class FileManager {
	
	private RightPanel rightPanel;
	private JFrame parentFrame;
	JFileChooser fileChooser;
	Hashtable<Integer, JButton> shapes;
	
	FileManager(){
		
	}
	
	FileManager(RightPanel rightPanel){
		this.rightPanel = rightPanel;
	}
	
	public void save() {
		parentFrame = new JFrame();
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save file");
		int selection = fileChooser.showSaveDialog(parentFrame);
		if(selection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			System.out.println(fileToSave.toString());
			
			saver(fileToSave);
		}
	}
	
	public void open() {
		parentFrame = new JFrame();
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open file");
		int selection = fileChooser.showOpenDialog(parentFrame);
		if(selection == JFileChooser.APPROVE_OPTION) {
			File fileToOpen = fileChooser.getSelectedFile();
			opener(fileToOpen);
		}
	}
	
	private void saver(File file) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("shapes");
			doc.appendChild(rootElement);
			shapes = rightPanel.getShapes();
			for(int key:shapes.keySet()) {
				Element shape = doc.createElement("shape");
				rootElement.appendChild(shape);
				shape.setAttribute("id",Integer.toString(key));
				JButton theShape = shapes.get(key);
				Element type = doc.createElement("type");
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
				shape.appendChild(position);
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
	
	private void opener(File file) {
		rightPanel.clear();
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			doc.getDocumentElement().normalize();   
			NodeList nodeList = doc.getElementsByTagName("shape");
			for(int i = 0;i < nodeList.getLength();i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {  
					Element eElement = (Element) node;
					int ID = Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue());
					String position[] = eElement.getElementsByTagName("position").item(0).getTextContent().split(",");
					Point point = new Point(Integer.parseInt(position[0]),Integer.parseInt(position[1]));
					switch(eElement.getElementsByTagName("type").item(0).getTextContent()) {
						case "round":
							rightPanel.addRound(ID,point);
							break;
						case "rectangle":
							rightPanel.addRectangle(ID,point);
							break;
						default:
							rightPanel.addTriangle(ID,point);
							break;
					}
				}
			}
			rightPanel.updateHashCode();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
