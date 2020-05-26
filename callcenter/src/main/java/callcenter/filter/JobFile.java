/**
 * 
 */
package callcenter.filter;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * @author firsov
 *
 */
public class JobFile {
	
	private Integer firstTable = 0;
	
	private Map<DefaultNameColumn, NameColumn> nameColumn;
	
	public List<File> findFileDocxFolder(String pachFile) {
		File folder = new File(pachFile);
		String endsWith = ".docx";
	 	return	Stream.of(folder.listFiles()).filter(file -> file.getName().endsWith(endsWith)).collect(Collectors.toList());
	}
	
	public List<CallcenterEntity> parseFile(File file) {
		Integer firstRow = 0;
		try ( 
				XWPFDocument document = new XWPFDocument(OPCPackage.open(file));
				)
		{
			XWPFTable table = document.getTables().get(firstTable);
			MapColumns mapColumns = new MapColumns();
			try {
				nameColumn = mapColumns.mapColumn(table.getRow(firstRow));
				table.removeRow(firstRow);
				return table.getRows().stream().map(row -> parseRow(row)).collect(Collectors.toList());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	private CallcenterEntity parseRow(XWPFTableRow row) {
		List<XWPFTableCell> cells = row.getTableCells();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return new CallcenterEntity().newBuilder()
					.withNumber(cells.get(nameColumn.get(DefaultNameColumn.NUMBER).getNumberColumn()).getText())
					.withCorrespondent(cells.get(nameColumn.get(DefaultNameColumn.CORRESPONDENT).getNumberColumn()).getText())
					.withSummary(cells.get(nameColumn.get(DefaultNameColumn.SUMMARY).getNumberColumn()).getText())
					.withDateDue(new Date(format.parse(cells.get(nameColumn.get(DefaultNameColumn.DATEDUE).getNumberColumn()).getText()).getTime()))
					.withDateCorrespondent(new Date(format.parse(cells.get(nameColumn.get(DefaultNameColumn.DATECORRESPONDENT).getNumberColumn()).getText()).getTime()))
					.build();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
}
