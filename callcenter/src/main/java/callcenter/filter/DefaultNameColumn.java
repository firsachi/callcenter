/**
 * 
 */
package callcenter.filter;

/**
 * @author firsachi
 *
 */
public enum DefaultNameColumn {
	
	NUMBER("№ кореспондента") ,
	DATEDUE("дата надходження"),
	DATECORRESPONDENT("дата кореспондента"),
	CORRESPONDENT("кореспондент"),
	SUMMARY("короткий зміст");
	
	private String name;
	
	 DefaultNameColumn(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
