/**
 * 
 */
package callcenter.filter;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * @author firsachi
 *
 */
public class MapColumns {
	
	private final Map<DefaultNameColumn, NameColumn> filter;
	

	public MapColumns() {
		super();
		this.filter = new HashMap<DefaultNameColumn, NameColumn>();
	}


	public Map<DefaultNameColumn, NameColumn> mapColumn(XWPFTableRow row) {
		return filter;
	}

}
