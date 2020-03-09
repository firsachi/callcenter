package callcenter.filter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapColumnsTest {
	
	private Map<DefaultNameColumn, NameColumn> expected;
	
	@BeforeEach
    void init() {
		expected = new HashMap<DefaultNameColumn, NameColumn>();
		NameColumn nameColumn = new NameColumn();
		nameColumn.setNameColumn(DefaultNameColumn.NUMBER);
		nameColumn.setNumberColumn(1);
		expected.put(nameColumn.getNameColumn(), nameColumn);
		nameColumn = new NameColumn();
		nameColumn.setNameColumn(DefaultNameColumn.DATEDUE);
		nameColumn.setNumberColumn(2);
		expected.put(nameColumn.getNameColumn(), nameColumn);
		nameColumn = new NameColumn();
		nameColumn.setNameColumn(DefaultNameColumn.DATECORRESPONDENT);
		nameColumn.setNumberColumn(3);
		expected.put(nameColumn.getNameColumn(), nameColumn);
		nameColumn = new NameColumn();
		nameColumn.setNameColumn(DefaultNameColumn.CORRESPONDENT);
		nameColumn.setNumberColumn(4);
		expected.put(nameColumn.getNameColumn(), nameColumn);
		nameColumn = new NameColumn();
		nameColumn.setNameColumn(DefaultNameColumn.SUMMARY);
		nameColumn.setNumberColumn(5);
		expected.put(nameColumn.getNameColumn(), nameColumn);
    }

	@Test
	void testMapColumn() throws Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/test_filter.docx");
		XWPFDocument document = new XWPFDocument(OPCPackage.open(fis));
		XWPFTable table = document.getTables().get(0);
		MapColumns mapColumns = new MapColumns();
		Map<DefaultNameColumn, NameColumn> actual = mapColumns.mapColumn(table.getRow(0));
		assertEquals(expected, actual);
		document.close();
		fis.close();
	}
	
	@Test
	void testNumberColumn() throws Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/test_filter.docx");
		XWPFDocument document = new XWPFDocument(OPCPackage.open(fis));
		XWPFTable table = document.getTables().get(0);
		table.getRow(0).removeCell(0);
		table.getRow(0).removeCell(0);
		table.getRow(0).removeCell(0);
		table.getRow(0).removeCell(0);
		MapColumns mapColumns = new MapColumns();
		assertThrows( Exception.class, () ->  mapColumns.mapColumn(table.getRow(0)));
		document.close();
		fis.close();
	}

	@Test
	void testSizeFilter() throws Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/test_filter.docx");
		XWPFDocument document = new XWPFDocument(OPCPackage.open(fis));
		XWPFTable table = document.getTables().get(1);
		MapColumns mapColumns = new MapColumns();
		assertThrows( Exception.class, () ->  mapColumns.mapColumn(table.getRow(0)));
		document.close();
		fis.close();
	}
}