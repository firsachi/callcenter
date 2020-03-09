/**
 * 
 */
package callcenter.filter;

/**
 * @author firsachi
 *
 */
public class NameColumn {

	private DefaultNameColumn nameColumn;
	
	private int numberColumn;
	
	public NameColumn() {
		super();
	}

	public DefaultNameColumn getNameColumn() {
		return nameColumn;
	}

	public void setNameColumn(DefaultNameColumn nameColumn) {
		this.nameColumn = nameColumn;
	}

	public int getNumberColumn() {
		return numberColumn;
	}

	public void setNumberColumn(int numberColumn) {
		this.numberColumn = numberColumn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameColumn == null) ? 0 : nameColumn.hashCode());
		result = prime * result + numberColumn;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NameColumn other = (NameColumn) obj;
		if (nameColumn != other.nameColumn)
			return false;
		if (numberColumn != other.numberColumn)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "СaseFilter [nameColumn=" + nameColumn + ", numberColumn=" + numberColumn + "]";
	}
	
}
