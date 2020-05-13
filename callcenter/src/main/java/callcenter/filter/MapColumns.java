/**
 * 
 */
package callcenter.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * @author firsachi
 *
 */
public class MapColumns {

	private Map<DefaultNameColumn, NameColumn> resultMap;

	public MapColumns() {
		super();
		this.resultMap = new HashMap<>();
	}

	public Map<DefaultNameColumn, NameColumn> mapColumn(XWPFTableRow row) throws Exception {
		List<XWPFTableCell> cells = row.getTableCells();
		if (DefaultNameColumn.values().length <= cells.size()) {
			cells.stream()
					.forEach(cell -> Stream.of(DefaultNameColumn.values())
							.filter(nameCell -> cell.getText().trim().toLowerCase().equals(nameCell.getName()))
							.findAny().map(name -> resultMap.put(name, new NameColumn(cells.indexOf(cell), name))));
		} else {
			// TO DO log
			throw new Exception();
		}
		if (DefaultNameColumn.values().length != resultMap.size()) {
			// TO DO log
			throw new Exception();
		}
		return resultMap;
	}

}
