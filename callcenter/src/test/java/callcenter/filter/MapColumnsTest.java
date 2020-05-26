package callcenter.filter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapColumnsTest {
	
	private Map<DefaultNameColumn, NameColumn> expected;
	
	private FileInputStream fis;
	
	private XWPFDocument document;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
    void init() throws Exception {
		fis = new FileInputStream("src/test/resources/test_filter.docx");
		document = new XWPFDocument(OPCPackage.open(fis));
		expected = new HashMap<DefaultNameColumn, NameColumn>();
		expected.put(DefaultNameColumn.NUMBER, new NameColumn(1, DefaultNameColumn.NUMBER));
		expected.put(DefaultNameColumn.DATEDUE, new NameColumn(2, DefaultNameColumn.DATEDUE));
		expected.put(DefaultNameColumn.DATECORRESPONDENT, new NameColumn(3, DefaultNameColumn.DATECORRESPONDENT));
		expected.put(DefaultNameColumn.CORRESPONDENT, new NameColumn(4, DefaultNameColumn.CORRESPONDENT));
		expected.put(DefaultNameColumn.SUMMARY, new NameColumn(5, DefaultNameColumn.SUMMARY));
    }
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		document.close();
		fis.close();
	}

	@Test
	void testMapColumn() throws Exception {
		XWPFTable table = document.getTables().get(0);
		MapColumns mapColumns = new MapColumns();
		Map<DefaultNameColumn, NameColumn> actual = mapColumns.mapColumn(table.getRow(0));
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testMapColumnDublicateName() throws Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/test_filter.docx");
		XWPFDocument document = new XWPFDocument(OPCPackage.open(fis));
		XWPFTable table = document.getTables().get(1);
		MapColumns mapColumns = new MapColumns();
		assertThrows(Exception.class, () -> mapColumns.mapColumn(table.getRow(0)));
	}
	
	@Test
	void testNumberColumnsTable() throws Exception {
		XWPFTable table = document.getTables().get(0);
		table.getRow(0).removeCell(0);
		table.getRow(0).removeCell(0);
		table.getRow(0).removeCell(0);
		table.getRow(0).removeCell(0);
		table.getRow(0).removeCell(0);
		MapColumns mapColumns = new MapColumns();
		assertThrows( Exception.class, () ->  mapColumns.mapColumn(table.getRow(0)));
	}

	@Test
	void testCheckSize() throws Exception {
		XWPFTable table = document.getTables().get(0);
		MapColumns mapColumns = new MapColumns();
		assertEquals(DefaultNameColumn.values().length, mapColumns.mapColumn(table.getRow(0)).size());
	}
	
	@Test
	void testCheckSizeIncorrect() throws Exception {
		XWPFTable table = document.getTables().get(0);
		table.getRow(0).removeCell(0);
		table.getRow(0).removeCell(0);
		table.getRow(0).removeCell(0);
		MapColumns mapColumns = new MapColumns();
		assertThrows( Exception.class, () ->  mapColumns.mapColumn(table.getRow(0)));
	}
}