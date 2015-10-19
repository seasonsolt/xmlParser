
public class XmlParseTest {
	
	public static void main(String[] args){
		String XmlBuf = new String(
				"<root>" +
					"<element1>1</element1>" +
					"<element2>2</element2>" +
					"<element3>" +
						"<element4> 4 </element4>" +
					"</element3>" +
				"</root>");
	
		XmlTree xmlTree = new XmlTree();
		
		xmlTree.XmlInit("root");
		xmlTree.XmlAddNode("root", "ele1", "");
		xmlTree.XmlAddNode("root", "ele2", "");
		xmlTree.XmlAddNode("root", "ele3", "");
		xmlTree.XmlAddNode("ele1", "ele4", "4");
		xmlTree.XmlAddNode("ele2", "ele5", "5");
		xmlTree.XmlAddNode("ele2", "ele6", "6");
		xmlTree.XmlAddNode("ele3", "ele7", "7");
		
		System.out.println(xmlTree.toString());
	}
}

